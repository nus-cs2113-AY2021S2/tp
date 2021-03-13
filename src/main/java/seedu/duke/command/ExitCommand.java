package seedu.duke.command;

import seedu.duke.common.ArgumentType;
import seedu.duke.exception.CommandException;
import seedu.duke.record.RecordList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

import static seedu.duke.command.Utils.validateArguments;

public class ExitCommand extends Command {
    private static final ArgumentType[] ARGUMENT_TYPE_ORDER = { ArgumentType.COMMAND };
    protected static final String COMMAND_EXIT = "exit";
    private static final String MESSAGE_EXITING = "You are exiting FINUX now...";

    public ExitCommand(ArrayList<String> arguments) throws CommandException {
        validateArguments(arguments, ARGUMENT_TYPE_ORDER, COMMAND_EXIT);
    }

    /**
     * Executes the exit function.
     *
     * @param records is the recordList
     * @param ui      is the Ui object that interacts with the user
     * @param storage is the Storage object that reads and writes to the save file
     */
    @Override
    public void execute(RecordList records, Ui ui, Storage storage) {
        System.out.println(MESSAGE_EXITING);
    }

    public static boolean isExit(Command command) {
        return command instanceof ExitCommand;
    }
}
