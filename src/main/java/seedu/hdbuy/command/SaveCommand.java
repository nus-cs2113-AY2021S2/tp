package seedu.hdbuy.command;

import seedu.hdbuy.common.Unit;
import seedu.hdbuy.data.SearchedUnits;
import seedu.hdbuy.data.ShortList;
import seedu.hdbuy.data.UserInput;
import seedu.hdbuy.ui.TextUi;

import java.util.logging.Logger;

public class SaveCommand extends Command {

    protected int index;

    public SaveCommand(int index) {
        this.index = index;
    }

    @Override public void execute(UserInput userInput) {
        Unit targetUnit = SearchedUnits.getUnit(index);
        if (targetUnit == null) {
            return;
        }
        ShortList.addToShortList(targetUnit);
        Logger.getLogger("SaveCommand").info("Saved unit to shortlist: " + targetUnit.toString());
        TextUi.showSavedShortlistUnit(targetUnit.toString());
    }
}
