package seedu.duke.command;

import seedu.duke.common.RecordType;
import seedu.duke.exception.CommandException;
import seedu.duke.record.Expense;
import seedu.duke.record.Loan;
import seedu.duke.record.RecordList;
import seedu.duke.record.Saving;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import static seedu.duke.command.Utils.checkInvalidOptions;
import static seedu.duke.command.Utils.checkOptionConflict;
import static seedu.duke.command.Utils.getOptionValue;
import static seedu.duke.command.Utils.hasOption;
import static seedu.duke.common.Constant.OPTION_AMOUNT;
import static seedu.duke.common.Constant.OPTION_DATE;
import static seedu.duke.common.Constant.OPTION_EXPENSE;
import static seedu.duke.common.Constant.OPTION_LOAN;
import static seedu.duke.common.Constant.OPTION_SAVING;
import static seedu.duke.common.Validators.validateAmount;
import static seedu.duke.common.Validators.validateDate;

import java.util.ArrayList;

public class AddCommand extends Command {
    protected static final String COMMAND_ADD = "add";
    private final double amount;
    private final String issueDate;
    private final String description;

    private RecordType recordType;

    public AddCommand(ArrayList<String> arguments) throws CommandException {
        checkInvalidOptions(arguments, COMMAND_ADD,
                OPTION_EXPENSE, OPTION_LOAN, OPTION_SAVING, OPTION_AMOUNT, OPTION_DATE);
        checkOptionConflict(arguments, COMMAND_ADD, OPTION_EXPENSE, OPTION_LOAN, OPTION_SAVING);

        if (hasOption(arguments, OPTION_EXPENSE)) {
            recordType = RecordType.EXPENSE;
            description = Utils.getOptionValue(arguments, COMMAND_ADD, OPTION_EXPENSE);
        } else if (hasOption(arguments, OPTION_LOAN)) {
            recordType = RecordType.LOAN;
            description = Utils.getOptionValue(arguments, COMMAND_ADD, OPTION_LOAN);
        } else if (hasOption(arguments, OPTION_SAVING)) {
            recordType = RecordType.SAVING;
            description = Utils.getOptionValue(arguments, COMMAND_ADD, OPTION_SAVING);
        } else {
            throw new CommandException("missing option: [-e | -l | -s]", COMMAND_ADD);
        }

        try {
            amount = validateAmount(getOptionValue(arguments, COMMAND_ADD, OPTION_AMOUNT));
            issueDate = validateDate(getOptionValue(arguments, COMMAND_ADD, OPTION_DATE));
        } catch (NumberFormatException e) {
            throw new CommandException("amount contains a non numeric value", COMMAND_ADD);
        } catch (CommandException e) {
            throw new CommandException("date error format", COMMAND_ADD);
        }
    }

    @Override
    public void execute(RecordList records, Ui ui, Storage storage) {
        switch (recordType) {
        case EXPENSE:
            records.addRecord(new Expense(amount, issueDate, description), ui, storage);
            break;
        case LOAN:
            records.addRecord(new Loan(amount, issueDate, description), ui, storage);
            break;
        case SAVING:
            // Fallthrough
        default:
            records.addRecord(new Saving(amount, issueDate, description), ui, storage);
        }
    }
}
