package seedu.logic.command.inventory;

import seedu.exceptions.inventory.InvalidQuantityException;
import seedu.model.inventory.InventoryList;
import seedu.ui.InventoryUI;
import seedu.logic.command.Command;

/**
 * InventoryDelete Command executes the necessary action for deleting quantity of an Inventory object.
 */
public class InventoryDelete extends Command {

    private String[] argArr;

    /**
     * Constructor for InventoryDelete command.
     *
     * @param args Array of inputs for Inventory object.
     */
    public InventoryDelete(String[] args) {
        this.argArr = args;
    }

    /**
     * Deletes quantity of Inventory object from the Inventory list.
     *
     * @param drugs Inventory objects in Inventory list.
     * @param ui Instance of InventoryUI used.
     * @throws InvalidQuantityException If input quantity is invalid.
     */
    public void execute(InventoryList drugs, InventoryUI ui) throws InvalidQuantityException {
        drugs.deleteDrugs(argArr);
        ui.deleteDrugMessage(argArr[1], argArr[2]);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}