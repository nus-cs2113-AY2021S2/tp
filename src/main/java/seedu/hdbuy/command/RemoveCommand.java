package seedu.hdbuy.command;

import java.util.logging.Logger;

import seedu.hdbuy.common.Unit;
import seedu.hdbuy.data.ShortList;
import seedu.hdbuy.data.UserInput;

public class RemoveCommand extends Command {

    protected int index;

    public RemoveCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(UserInput userInput) {
        Unit removedUnit = ShortList.removeFromShortList(index);
        if (removedUnit != null) {
            Logger.getLogger("RemoveCommand").info("Removed: " + removedUnit.toString());
        } else {
            Logger.getLogger("RemoveCommand").info("Unable to remove at index");
        }
    }
}
