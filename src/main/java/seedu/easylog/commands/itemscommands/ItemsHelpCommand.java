package seedu.easylog.commands.itemscommands;

import seedu.easylog.commands.Command;

public class ItemsHelpCommand extends Command {

    /**
     * Prints out the list of available items-related commands in the program.
     */
    public void execute() {
        ui.showItemsHelp();
    }
}
