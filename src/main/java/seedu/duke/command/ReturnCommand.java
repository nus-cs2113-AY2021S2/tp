package seedu.duke.command;

import seedu.duke.exception.CommandException;
import seedu.duke.record.Loan;
import seedu.duke.record.Record;
import seedu.duke.record.RecordList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

import static seedu.duke.command.Utils.getOptionValue;
import static seedu.duke.command.Utils.hasOption;
import static seedu.duke.command.Utils.validateOptions;
import static seedu.duke.common.Constant.OPTION_DATE;
import static seedu.duke.common.Constant.OPTION_INDEX;
import static seedu.duke.common.Messages.ERROR_INCORRECT_ID_DATA_TYPE;
import static seedu.duke.common.Messages.ERROR_INCORRECT_ID_FRONT;
import static seedu.duke.common.Messages.ERROR_INCORRECT_ID_FRONT2;
import static seedu.duke.common.Messages.ERROR_INCORRECT_ID_NON_INTEGER;
import static seedu.duke.common.Messages.ERROR_INCORRECT_ID_OUT_OF_BOUNDS;
import static seedu.duke.common.Messages.ERROR_MISSING_ID_OPTION;
import static seedu.duke.common.Messages.ERROR_RETURN_DATE_BEFORE_ISSUE_DATE;
import static seedu.duke.common.Messages.ERROR_RETURN_DATE_FUTURE_DATE;
import static seedu.duke.common.Messages.MESSAGE_RETURN_SUCCESS;
import static seedu.duke.common.Validators.validateDate;
import static seedu.duke.common.Validators.validateId;
import static seedu.duke.command.Utils.getDaysDifference;
import static seedu.duke.command.Utils.computeCreditScore;

/**
 * Handles all operations related to the return command.
 */
public class ReturnCommand extends Command {
    private static final String[] VALID_OPTIONS = {OPTION_INDEX, OPTION_DATE};
    private static final String[] CONFLICT_OPTIONS = {};
    protected static final String COMMAND_RETURN = "return";
    private String recordNumberStr;
    private int recordNumberInt;
    private LocalDate returnDate;

    /**
     * Constructor to validate the format for return command.
     *
     * @param arguments  parsed input containing options and arguments.
     * @param recordList is the recordList.
     * @throws CommandException contains the error messages when a incorrect format is detected.
     */
    public ReturnCommand(ArrayList<String> arguments, RecordList recordList) throws CommandException {
        validateOptions(arguments, COMMAND_RETURN, VALID_OPTIONS, CONFLICT_OPTIONS);
        setRecordNumberToString(arguments);
        setRecordNumberToInteger(arguments, recordList);
        setReturnDate(arguments, recordList);
    }

    private void setReturnDate(ArrayList<String> arguments, RecordList recordList) throws CommandException {
        returnDate = getDate(arguments, recordList.getRecordAt(recordNumberInt));
    }

    private void setRecordNumberToInteger(ArrayList<String> arguments, RecordList recordList) throws CommandException {
        recordNumberInt = getIndexInInteger(arguments, recordList);
    }

    private void setRecordNumberToString(ArrayList<String> arguments) throws CommandException {
        recordNumberStr = getIndexInString(arguments);
    }

    /**
     * Gets the index field in String.
     *
     * @param arguments parsed input containing options and arguments.
     * @return a String containing the index of the record.
     * @throws CommandException contains the error messages when a incorrect format is detected.
     */
    private String getIndexInString(ArrayList<String> arguments) throws CommandException {
        if (!hasOption(arguments, OPTION_INDEX)) {
            throw new CommandException(ERROR_MISSING_ID_OPTION, COMMAND_RETURN);
        }
        return getOptionValue(arguments, COMMAND_RETURN, OPTION_INDEX);
    }

    /**
     * Gets the index field in Integer.
     *
     * @param arguments  parsed input containing options and arguments.
     * @param recordList is the recordList.
     * @return a Integer containing the index of the record.
     * @throws CommandException contains the error messages when a incorrect format is detected.
     */
    private int getIndexInInteger(ArrayList<String> arguments, RecordList recordList) throws CommandException {
        try {
            int index = validateId(getOptionValue(arguments, COMMAND_RETURN, OPTION_INDEX), recordList);
            Record currentRecord = recordList.getRecordAt(index);
            if (!(currentRecord instanceof Loan)) {
                throw new CommandException(ERROR_INCORRECT_ID_FRONT + recordNumberStr + ERROR_INCORRECT_ID_DATA_TYPE,
                        COMMAND_RETURN);
            }
            return index;
        } catch (NumberFormatException e) {
            throw new CommandException(ERROR_INCORRECT_ID_FRONT2 + recordNumberStr
                    + ERROR_INCORRECT_ID_NON_INTEGER, COMMAND_RETURN);
        } catch (IndexOutOfBoundsException e) {
            throw new CommandException(ERROR_INCORRECT_ID_FRONT + recordNumberStr
                    + ERROR_INCORRECT_ID_OUT_OF_BOUNDS, COMMAND_RETURN);
        }
    }

    /**
     * Gets the date field.
     *
     * @param arguments parsed input containing options and arguments.
     * @return a LocalDate object containing the date of the record.
     * @throws CommandException contains the error messages when a incorrect format is detected.
     */
    private LocalDate getDate(ArrayList<String> arguments, Record currentRecord) throws CommandException {
        try {
            LocalDate returnDate = validateDate(getOptionValue(arguments, COMMAND_RETURN, OPTION_DATE));
            if (currentRecord.getIssueDate().compareTo(returnDate) > 0) {
                throw new CommandException(ERROR_RETURN_DATE_BEFORE_ISSUE_DATE, COMMAND_RETURN);
            }
            if (returnDate.compareTo(LocalDate.now()) > 0) {
                throw new CommandException(ERROR_RETURN_DATE_FUTURE_DATE, COMMAND_RETURN);
            }

            return returnDate;
        } catch (DateTimeException e) {
            throw new CommandException(e.getMessage(), COMMAND_RETURN);
        }
    }

    /**
     * Executes the return function.
     * Prints a message containing the loan that will be marked as returned.
     *
     * @param recordList is the recordList.
     * @param ui         is the Ui object that interacts with the user.
     * @param storage    is the Storage object that reads and writes to the save file.
     */
    @Override
    public void execute(RecordList recordList, Ui ui, Storage storage, CreditScoreReturnedLoansMap
            creditScoreReturnedLoansMap) {
        Record currentRecord = recordList.getRecordAt(recordNumberInt);
        Loan currentLoan = (Loan) currentRecord;
        if (!currentLoan.isReturn()) {
            currentLoan.markAsReturned(returnDate);
            String borrowerNameInLowerCase = currentLoan.getBorrowerName().toLowerCase();
            int creditScore = creditScoreReturnedLoansMap.getCreditScoreOf(borrowerNameInLowerCase);
            long daysDifference = getDaysDifference(currentLoan.getIssueDate(), currentLoan.getReturnDate());
            creditScore = computeCreditScore(daysDifference, creditScore, currentLoan.isReturn());
            creditScoreReturnedLoansMap.insertCreditScoreOf(borrowerNameInLowerCase, creditScore);
        }
        ui.printMessage(System.lineSeparator() + MESSAGE_RETURN_SUCCESS
                + System.lineSeparator() + System.lineSeparator()
                + ui.getId(recordNumberInt) + currentLoan + System.lineSeparator());
        storage.saveData(recordList, creditScoreReturnedLoansMap);
    }
}
