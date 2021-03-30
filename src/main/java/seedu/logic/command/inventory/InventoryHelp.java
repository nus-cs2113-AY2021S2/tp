package seedu.logic.command.inventory;

import seedu.logic.command.Command;
import seedu.logic.command.InventoryActions;
import seedu.ui.InventoryUI;

public class InventoryHelp extends Command {

    @Override
    public void execute(InventoryActions drugs, InventoryUI ui) {
        ui.printDrugHelpList();
    }
    @Override
    public boolean isExit() {
        return false;
    }
}
