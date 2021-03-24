package seedu.duke.command;

import seedu.duke.common.ArgumentType;
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
import static seedu.duke.common.Validators.validateDate;
import static seedu.duke.common.Validators.validateIndex;
import static seedu.duke.command.Utils.getDaysDifference;
import static seedu.duke.command.Utils.computeCreditScore;

/**
 * Handles all operations related to the return command.
 */
public class ReturnCommand extends Command {
    private static final String[] VALID_OPTIONS = {OPTION_INDEX, OPTION_DATE};
    private static final String[] CONFLICT_OPTIONS = {};
    protected static final String COMMAND_RETURN = "return";
    private final String recordNumberStr;
    private final int recordNumberInt;
    private final LocalDate returnDate;

    /**
     * Constructor to validate the format for return command.
     *
     * @param arguments  parsed input containing options and arguments.
     * @param recordList is the recordList.
     * @throws CommandException contains the error messages when a incorrect format is detected.
     */
    public ReturnCommand(ArrayList<String> arguments, RecordList recordList) throws CommandException {
        validateOptions(arguments, COMMAND_RETURN, VALID_OPTIONS, CONFLICT_OPTIONS);
        recordNumberStr = getIndexInString(arguments);
        recordNumberInt = getIndexInInteger(arguments, recordList);
        returnDate = getDate(arguments);
    }

    /**
     * Get the index field in String.
     *
     * @param arguments parsed input containing options and arguments.
     * @return a String containing the index of the record.
     * @throws CommandException contains the error messages when a incorrect format is detected.
     */
    private String getIndexInString(ArrayList<String> arguments) throws CommandException {
        if (hasOption(arguments, OPTION_INDEX)) {
            return getOptionValue(arguments, COMMAND_RETURN, OPTION_INDEX);
        }
        throw new CommandException("missing option: -i", COMMAND_RETURN);
    }

    /**
     * Get the index field in Integer.
     *
     * @param arguments  parsed input containing options and arguments.
     * @param recordList is the recordList.
     * @return a Integer containing the index of the record.
     * @throws CommandException contains the error messages when a incorrect format is detected.
     */
    private int getIndexInInteger(ArrayList<String> arguments, RecordList recordList) throws CommandException {
        try {
            return validateIndex(getOptionValue(arguments, COMMAND_RETURN, OPTION_INDEX), recordList);
        } catch (NumberFormatException e) {
            throw new CommandException("Index \"" + recordNumberStr + "\" is not an integer!", COMMAND_RETURN);
        } catch (IndexOutOfBoundsException e) {
            throw new CommandException("Index \"" + recordNumberStr + "\" is out of bounds!", COMMAND_RETURN);
        }
    }

    /**
     * Gets the date field.
     *
     * @param arguments parsed input containing options and arguments.
     * @return a LocalDate object containing the date of the record.
     * @throws CommandException contains the error messages when a incorrect format is detected.
     */
    private LocalDate getDate(ArrayList<String> arguments) throws CommandException {
        try {
            return validateDate(getOptionValue(arguments, COMMAND_RETURN, OPTION_DATE));
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
    public void execute(RecordList recordList, Ui ui, Storage storage, BorrowersCreditScoreForReturnedLoans
            borrowersCreditScoreForReturnedLoans) {
        Record currentRecord = recordList.getRecordAt(recordNumberInt);
        if (currentRecord instanceof Loan) {
            Loan currentLoan = (Loan) currentRecord;
            if (!currentLoan.isReturn()) {
                currentLoan.markAsReturned(returnDate);
                String borrowerNameInLowerCase = currentLoan.getBorrowerName().toLowerCase();
                int creditScore = borrowersCreditScoreForReturnedLoans.getCurrentBorrowerCreditScoreForReturnedLoans(
                        borrowerNameInLowerCase);
                long daysDifference = getDaysDifference(currentLoan.getIssueDate(), currentLoan.getReturnDate());
                creditScore = computeCreditScore(daysDifference, creditScore, currentLoan.isReturn());
                borrowersCreditScoreForReturnedLoans.insertCurrentBorrowerCreditScoreForReturnedLoans(
                        borrowerNameInLowerCase, creditScore);
            }
            ui.printMessage("Loan marked as returned: " + currentLoan);
            storage.saveData(recordList, borrowersCreditScoreForReturnedLoans);
            return;
        }
        ui.printMessage("Specified record number is not a loan!");
    }
}
