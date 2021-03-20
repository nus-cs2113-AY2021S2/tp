package seedu.duke.command;

import seedu.duke.common.RecordType;
import seedu.duke.exception.CommandException;
import seedu.duke.exception.CustomException;
import seedu.duke.record.Expense;
import seedu.duke.record.Loan;
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
    private final BigDecimal amount;
    private final LocalDate issueDate;
    private final String description;
    private final String borrowerName;

    private RecordType recordType;

    /**
     * Constructor to validate the format for add command.
     *
     * @param arguments parsed input containing options and arguments.
     * @throws CommandException contains the error messages when a incorrect format is detected.
     */
    public AddCommand(ArrayList<String> arguments) throws CommandException {
        validateOptions(arguments, COMMAND_ADD, VALID_OPTIONS, CONFLICT_OPTIONS);

        description = getDescription(arguments);
        amount = getAmount(arguments);
        issueDate = getDate(arguments);
        borrowerName = getPerson(arguments);
        System.out.println("borrower is: " + borrowerName);
    }

    /**
     * Gets the description field.
     *
     * @param arguments parsed input containing options and arguments.
     * @return a String containing the description of the record.
     * @throws CommandException contains the error messages when a incorrect format is detected.
     */
    private String getDescription(ArrayList<String> arguments) throws CommandException {
        return getOptionValue(arguments, COMMAND_ADD, checkRecordType(arguments));
    }

    /**
     * Gets the amount field.
     *
     * @param arguments parsed input containing options and arguments.
     * @return a BigDecimal object containing the amount of the record.
     * @throws CommandException contains the error messages when a incorrect format is detected.
     */
    private BigDecimal getAmount(ArrayList<String> arguments) throws CommandException {
        try {
            return validateAmount(getOptionValue(arguments, COMMAND_ADD, OPTION_AMOUNT));
        } catch (NumberFormatException e) {
            throw new CommandException("amount contains a non numeric value.", COMMAND_ADD);
        } catch (CustomException e) {
            throw new CommandException(e.getMessage(), COMMAND_ADD);
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
            return validateDate(getOptionValue(arguments, COMMAND_ADD, OPTION_DATE));
        } catch (DateTimeException e) {
            throw new CommandException(e.getMessage(), COMMAND_ADD);
        }
    }

    /**
     * Gets the person field.
     *
     * @param arguments parsed input containing the options and arguments.
     * @return the option value of person, or {@code null} if {@code recordType} is not a loan.
     * @throws CommandException if {@code recordType} is not a loan but arguments contains the person option,
     *                          or if the option value of person is empty.
     */
    private String getPerson(ArrayList<String> arguments) throws CommandException {
        if (recordType == RecordType.LOAN) {
            return getOptionValue(arguments, COMMAND_ADD, OPTION_PERSON);
        } else if (hasOption(arguments, OPTION_PERSON)) {
            throw new CommandException("option -p not valid for this record type.", COMMAND_ADD);
        } else {
            return null;
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
            throw new CommandException("missing option: [-e | -l | -s]", COMMAND_ADD);
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
    public void execute(RecordList recordList, Ui ui, Storage storage) {
        switch (recordType) {
        case EXPENSE:
            Expense expenseObj = new Expense(amount, issueDate, description);
            recordList.addRecord(expenseObj);
            storage.saveRecordListData(recordList);
            ui.printSuccessfulAdd(expenseObj, recordList.getRecordCount());
            break;
        case LOAN:
            Loan loanObj = new Loan(amount, issueDate, description, borrowerName);
            recordList.addRecord(loanObj);
            storage.saveRecordListData(recordList);
            ui.printSuccessfulAdd(loanObj, recordList.getRecordCount());
            break;
        case SAVING:
            // Fallthrough
        default:
            Saving savingObj = new Saving(amount, issueDate, description);
            recordList.addRecord(savingObj);
            storage.saveRecordListData(recordList);
            ui.printSuccessfulAdd(savingObj, recordList.getRecordCount());
        }
    }
}
