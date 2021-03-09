package seedu.duke.command;

import seedu.duke.exception.CommandException;
import seedu.duke.record.RecordList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

import static seedu.duke.command.Utils.checkInvalidOptions;
import static seedu.duke.common.Constant.OPTION_EXPENSE;
import static seedu.duke.common.Constant.OPTION_LOAN;
import static seedu.duke.common.Constant.OPTION_SAVINGS;

public class RemoveCommand extends Command {
    protected static final String COMMAND_REMOVE = "remove";

    public RemoveCommand(ArrayList<String> arguments) throws CommandException {
        checkInvalidOptions(arguments, COMMAND_REMOVE, OPTION_EXPENSE, OPTION_LOAN, OPTION_SAVINGS);
    }

    @Override
    public void execute(RecordList records, Ui ui, Storage storage) {

    }
}
