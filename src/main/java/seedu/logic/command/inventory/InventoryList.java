package seedu.logic.command.inventory;

import seedu.logic.command.Command;
import seedu.ui.InventoryUI;

/**
 * InventoryList Command executes the necessary action for displaying relevant Inventory objects.
 */
public class InventoryList extends Command {

    /**
     * Lists all relevant Inventory object from the Inventory list.
     *
     * @param inventory Instance of Inventory list used.
     * @param ui Instance of InventoryUI used.
     */
    @Override
    public void execute(seedu.model.inventory.InventoryList inventory, InventoryUI ui) {
        inventory.listDrugs();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
