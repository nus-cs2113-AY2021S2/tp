package seedu.logic.command.inventory;

import seedu.logic.command.Command;
import seedu.logic.command.InventoryActions;
import seedu.ui.InventoryUI;

public class InventoryAdd extends Command {

    private String[] argArr;

    public InventoryAdd(String[] args) {
        this.argArr = args;
    }

    public void execute(InventoryActions drugs, InventoryUI ui) {
        drugs.addDrugs(argArr);
        ui.drugAddedMessage(argArr[0]);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
