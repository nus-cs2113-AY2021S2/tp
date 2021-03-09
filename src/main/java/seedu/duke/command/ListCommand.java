package seedu.duke.command;

import seedu.duke.common.RecordType;
import seedu.duke.exception.CommandException;
import seedu.duke.record.RecordList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import static seedu.duke.command.Utils.checkInvalidOptions;
import static seedu.duke.command.Utils.checkOptionConflict;
import static seedu.duke.command.Utils.hasOption;
import static seedu.duke.common.Constant.OPTION_EXPENSE;
import static seedu.duke.common.Constant.OPTION_LOAN;
import static seedu.duke.common.Constant.OPTION_SAVINGS;

import java.util.ArrayList;

public class ListCommand extends Command {
    protected static final String COMMAND_LIST = "list";

    private RecordType recordType;

    public ListCommand(ArrayList<String> arguments) throws CommandException {
        checkInvalidOptions(arguments, COMMAND_LIST, OPTION_EXPENSE, OPTION_LOAN, OPTION_SAVINGS);
        checkOptionConflict(arguments, COMMAND_LIST, OPTION_EXPENSE, OPTION_LOAN, OPTION_SAVINGS);
        if (hasOption(arguments, OPTION_EXPENSE)) {
            recordType = RecordType.EXPENSE;
        } else if (hasOption(arguments, OPTION_LOAN)) {
            recordType = RecordType.LOAN;
        } else if (hasOption(arguments, OPTION_SAVINGS)) {
            recordType = RecordType.SAVING;
        } else {
            throw new CommandException("missing option: [-e | -l | -s]", COMMAND_LIST);
        }
    }

    @Override
    public void execute(RecordList records, Ui ui, Storage storage) {
        switch (recordType) {
        case EXPENSE:
            records.listExpenses(ui);
            break;
        case LOAN:
            records.listLoans(ui);
            break;
        case SAVING:
            records.listSavings(ui);
            break;
        default:
            ui.printMessage("Unable to list records.");
        }
    }
}
