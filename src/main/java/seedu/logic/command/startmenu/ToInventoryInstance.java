package seedu.logic.command.startmenu;

import seedu.logic.command.Command;
import seedu.logic.instance.InventoryInstance;

import static seedu.duke.Constants.INVENTORY_FILE_PATH;

public class ToInventoryInstance extends Command {

    @Override
    public void execute() {
        InventoryInstance inventory = new InventoryInstance(INVENTORY_FILE_PATH);
        inventory.run();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
