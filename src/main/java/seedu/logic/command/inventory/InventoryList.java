package seedu.logic.command.inventory;

import seedu.logic.command.Command;

public class InventoryList extends Command {

    @Override
    public boolean isExit() {
        return false;
    }
}
