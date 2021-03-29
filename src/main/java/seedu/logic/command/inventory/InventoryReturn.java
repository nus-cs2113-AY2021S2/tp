package seedu.logic.command.inventory;

import seedu.logic.command.Command;

public class InventoryReturn extends Command {

    @Override
    public boolean isExit() {
        return true;
    }
}
