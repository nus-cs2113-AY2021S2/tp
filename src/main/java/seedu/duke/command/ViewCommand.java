package seedu.duke.command;

import seedu.duke.common.RecordType;
import seedu.duke.exception.CommandException;
import seedu.duke.record.RecordList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

import static seedu.duke.command.Utils.checkInvalidOptions;
import static seedu.duke.command.Utils.checkOptionConflict;
import static seedu.duke.command.Utils.hasOption;
import static seedu.duke.common.Constant.OPTION_EXPENSE;
import static seedu.duke.common.Constant.OPTION_LOAN;
import static seedu.duke.common.Constant.OPTION_SAVINGS;

public class ViewCommand extends Command {
    protected static final String COMMAND_VIEW = "view";

    private RecordType recordType;

    public ViewCommand(ArrayList<String> arguments) throws CommandException {
        checkInvalidOptions(arguments, COMMAND_VIEW, OPTION_EXPENSE, OPTION_LOAN, OPTION_SAVINGS);
        checkOptionConflict(arguments, COMMAND_VIEW, OPTION_EXPENSE, OPTION_LOAN, OPTION_SAVINGS);
        if (hasOption(arguments, OPTION_EXPENSE)) {
            recordType = RecordType.EXPENSE;
        } else if (hasOption(arguments, OPTION_LOAN)) {
            recordType = RecordType.LOAN;
        } else if (hasOption(arguments, OPTION_SAVINGS)) {
            recordType = RecordType.SAVING;
        } else {
            throw new CommandException("missing option: [-e | -l | -s]", COMMAND_VIEW);
        }
    }

    @Override
    public void execute(RecordList records, Ui ui, Storage storage) {

    }
}
