package seedu.logic.command.inventory;

import seedu.logic.command.Command;
import seedu.logic.command.InventoryActions;
import seedu.ui.InventoryUI;

public class InventoryList extends Command {

    @Override
    public void execute(InventoryActions drugs, InventoryUI ui) {
        drugs.listDrugs();
    }
    @Override
    public boolean isExit() {
        return false;
    }
}
