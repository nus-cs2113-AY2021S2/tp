package seedu.easylog.commands.orderscommands;

import seedu.easylog.commands.Command;

public class OrdersHelpCommand extends Command {

    /**
     * Prints out the list of available orders-related commands in the program.
     */
    public void execute() {
        ui.showOrdersHelp();
    }
}
