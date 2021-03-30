package seedu.logic.command.inventory;

import seedu.logic.command.InventoryActions;
import seedu.ui.InventoryUI;
import seedu.logic.command.Command;

public class InventoryDelete extends Command {

    private String args;

    public InventoryDelete(String args) {
        this.args = args;
    }

    public void execute(InventoryActions drugs, InventoryUI ui) {
        drugs.deleteDrugs(args);
    }
    @Override
    public boolean isExit() {
        return false;
    }
}
