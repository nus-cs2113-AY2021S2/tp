package seedu.logic.command.inventory;

import seedu.logic.command.Command;
import seedu.model.inventory.InventoryList;
import seedu.ui.InventoryUI;

public class InventoryHelp extends Command {

    @Override
    public void execute(InventoryList drugs, InventoryUI ui) {
        ui.printInventoryHelpMessage();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
