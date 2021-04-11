package seedu.duke.command;

import seedu.duke.common.RecordType;
import seedu.duke.exception.CommandException;
import seedu.duke.exception.CustomException;
import seedu.duke.record.Expense;
import seedu.duke.record.Loan;
import seedu.duke.record.Record;
import seedu.duke.record.RecordList;
import seedu.duke.record.Saving;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import static seedu.duke.command.Utils.getOptionValue;
import static seedu.duke.command.Utils.hasOption;
import static seedu.duke.command.Utils.validateOptions;
import static seedu.duke.common.Constant.OPTION_AMOUNT;
import static seedu.duke.common.Constant.OPTION_DATE;
import static seedu.duke.common.Constant.OPTION_EXPENSE;
import static seedu.duke.common.Constant.OPTION_LOAN;
import static seedu.duke.common.Constant.OPTION_PERSON;
import static seedu.duke.common.Constant.OPTION_SAVING;
import static seedu.duke.common.Constant.FILE_DELIMITER_CHAR;
import static seedu.duke.common.Messages.ERROR_FUTURE_ISSUE_DATE;
import static seedu.duke.common.Messages.ERROR_INVALID_BORROWER_NAME;
import static seedu.duke.common.Messages.ERROR_INVALID_OPTION_P;
import static seedu.duke.common.Messages.ERROR_MISSING_RECORD_OPTIONS;
import static seedu.duke.common.Messages.ERROR_NON_NUM_AMOUNT;
import static seedu.duke.common.Validators.validateAmount;
import static seedu.duke.common.Validators.validateDate;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Handles all operations related to the add command.
 */
public class AddCommand extends Command {
    protected static final String COMMAND_ADD = "add";
    private static final String[] VALID_OPTIONS = {
        OPTION_EXPENSE, OPTION_LOAN, OPTION_SAVING, OPTION_AMOUNT, OPTION_DATE, OPTION_PERSON
    };
    private static final String[] CONFLICT_OPTIONS = {OPTION_EXPENSE, OPTION_LOAN, OPTION_SAVING};

    private BigDecimal amount;
    private LocalDate issueDate;
    private String description;
    private String borrowerName;
    private RecordType recordType;

    /**
     * Constructor to validate the format for add command.
     *
     * @param arguments parsed input containing options and arguments.
     * @throws CommandException contains the error messages when a incorrect format is detected.
     */
    public AddCommand(ArrayList<String> arguments) throws CommandException {
        validateOptions(arguments, COMMAND_ADD, VALID_OPTIONS, CONFLICT_OPTIONS);
        setDescription(arguments);
        setAmount(arguments);
        setDate(arguments);
        setPerson(arguments);
    }

    /**
     * Sets the description field.
     *
     * @param arguments parsed input containing options and arguments.
     * @throws CommandException contains the error messages when a incorrect format is detected.
     */
    private void setDescription(ArrayList<String> arguments) throws CommandException {
        description = getOptionValue(arguments, COMMAND_ADD, checkRecordType(arguments));
    }

    /**
     * Sets the amount field.
     *
     * @param arguments parsed input containing options and arguments.
     * @throws CommandException contains the error messages when a incorrect format is detected.
     */
    private void setAmount(ArrayList<String> arguments) throws CommandException {
        try {
            amount = validateAmount(getOptionValue(arguments, COMMAND_ADD, OPTION_AMOUNT));
        } catch (NumberFormatException e) {
            throw new CommandException(ERROR_NON_NUM_AMOUNT, COMMAND_ADD);
        } catch (CustomException e) {
            throw new CommandException(e.getMessage(), COMMAND_ADD);
        }
    }

    /**
     * Sets the date field.
     *
     * @param arguments parsed input containing options and arguments.
     * @throws CommandException contains the error messages when a incorrect format is detected.
     */
    private void setDate(ArrayList<String> arguments) throws CommandException {
        try {
            LocalDate issueDate = validateDate(getOptionValue(arguments, COMMAND_ADD, OPTION_DATE));
            if (issueDate.compareTo(LocalDate.now()) > 0) {
                throw new CommandException(ERROR_FUTURE_ISSUE_DATE, COMMAND_ADD);
            }
            this.issueDate = issueDate;
        } catch (DateTimeException e) {
            throw new CommandException(e.getMessage(), COMMAND_ADD);
        }
    }

    /**
     * Sets the person field.
     *
     * @param arguments parsed input containing the options and arguments.
     * @throws CommandException if {@code recordType} is not a loan but arguments contains the person option,
     *                          or if the option value of person is empty.
     */
    private void setPerson(ArrayList<String> arguments) throws CommandException {
        if (recordType == RecordType.LOAN) {
            String borrowerName = getOptionValue(arguments, COMMAND_ADD, OPTION_PERSON);
            if (borrowerName.contains(FILE_DELIMITER_CHAR)) {
                throw new CommandException(ERROR_INVALID_BORROWER_NAME, COMMAND_ADD);
            }
            this.borrowerName = borrowerName;
        } else if (hasOption(arguments, OPTION_PERSON)) {
            throw new CommandException(ERROR_INVALID_OPTION_P, COMMAND_ADD);
        }
    }

    /**
     * Checks if the input contains the correct record type and options.
     *
     * @param arguments parsed input containing the options and arguments.
     * @throws CommandException contains the error messages when a incorrect format is detected.
     */
    private String checkRecordType(ArrayList<String> arguments) throws CommandException {
        if (hasOption(arguments, OPTION_EXPENSE)) {
            recordType = RecordType.EXPENSE;
            return OPTION_EXPENSE;
        } else if (hasOption(arguments, OPTION_LOAN)) {
            recordType = RecordType.LOAN;
            return OPTION_LOAN;
        } else if (hasOption(arguments, OPTION_SAVING)) {
            recordType = RecordType.SAVING;
            return OPTION_SAVING;
        } else {
            throw new CommandException(ERROR_MISSING_RECORD_OPTIONS, COMMAND_ADD);
        }
    }

    private Record createRecord() {
        switch (recordType) {
        case EXPENSE:
            return new Expense(amount, issueDate, description);
        case LOAN:
            return new Loan(amount, issueDate, description, borrowerName);
        case SAVING:
            // Fallthrough
        default:
            return new Saving(amount, issueDate, description);
        }
    }

    /**
     * Executes the add function.
     *
     * @param recordList is the recordList.
     * @param ui      is the Ui object that interacts with the user.
     * @param storage is the Storage object that reads and writes to the save file.
     */
    @Override
    public void execute(RecordList recordList, Ui ui, Storage storage, CreditScoreReturnedLoansMap
            creditScoreReturnedLoansMap) {
        Record record = createRecord();
        recordList.addRecord(record);
        storage.saveData(recordList, creditScoreReturnedLoansMap);
        ui.printSuccessfulAdd(record, recordList.getRecordCount());
    }
}
