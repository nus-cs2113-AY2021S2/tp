package seedu.logic.command.inventory;

import seedu.logic.command.Command;
import seedu.ui.InventoryUI;

public class InventoryList extends Command {

    @Override
    public void execute(seedu.model.inventory.InventoryList inventory, InventoryUI ui) {
        inventory.listDrugs();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
