package seedu.logic.command.inventory;

import seedu.exceptions.inventory.InvalidQuantityException;
import seedu.logic.command.InventoryActions;
import seedu.ui.InventoryUI;
import seedu.logic.command.Command;

public class InventoryDelete extends Command {

    private String[] argArr;

    public InventoryDelete(String[] args) {
        this.argArr = args;
    }

    public void execute(InventoryActions drugs, InventoryUI ui) throws InvalidQuantityException {
        drugs.deleteDrugs(argArr);
        ui.deleteDrugMessage(argArr[1], argArr[2]);
    }
    @Override
    public boolean isExit() {
        return false;
    }
}
