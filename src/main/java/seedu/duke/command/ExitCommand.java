package seedu.duke.command;

import seedu.duke.record.RecordList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

public class ExitCommand extends Command {
    protected static final String COMMAND_EXIT = "exit";

    /**
     * Executes the exit function.
     *
     * @param records is the recordList
     * @param ui      is the Ui object that interacts with the user
     * @param storage is the Storage object that reads and writes to the save file
     */
    @Override
    public void execute(RecordList records, Ui ui, Storage storage) {
        ui.printGoodByeMessage();
    }

    public static boolean isExit(Command command) {
        return command instanceof ExitCommand;
    }
}
