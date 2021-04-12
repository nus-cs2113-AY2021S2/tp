package seedu.logic.command.inventory;

import seedu.logic.command.Command;

/**
 * InventoryReturn Command exits the InventoryInstance and returns to the Staff Menu.
 */
public class InventoryReturn extends Command {

    @Override
    public boolean isExit() {
        return true;
    }
}
