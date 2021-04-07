package seedu.logic.command.inventory;

import seedu.model.inventory.InventoryList;
import seedu.ui.InventoryUI;
import seedu.logic.command.Command;

public class InventoryDelete extends Command {

    private String args;

    public InventoryDelete(String args) {
        this.args = args;
    }

    public void execute(InventoryList drugs, InventoryUI ui) {
        drugs.deleteDrugs(args);
    }
    @Override
    public boolean isExit() {
        return false;
    }
}
