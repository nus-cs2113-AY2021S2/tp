package seedu.logic.command.inventory;

import seedu.logic.command.Command;
import seedu.model.inventory.InventoryList;
import seedu.ui.InventoryUI;

/**
 * InventoryHelp Command executes the necessary action for displaying the help message.
 */
public class InventoryHelp extends Command {

    /**
     * Displays the help message for Inventory Menu.
     *
     * @param drugs Inventory objects in Inventory list.
     * @param ui Instance of InventoryUI used.
     */
    @Override
    public void execute(InventoryList drugs, InventoryUI ui) {
        ui.printInventoryHelpMessage();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
