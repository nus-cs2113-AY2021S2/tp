package seedu.duke.command;

import seedu.duke.Map;
import seedu.duke.UiManager;
import seedu.duke.History;
import seedu.duke.DailyRoute;
import seedu.duke.BlockAlias;
import seedu.duke.FavouriteLocation;

public class Command {
    protected String userInput;

    public Command(String userInput) {
        this.userInput = userInput;
    }

    public boolean isExit() {
        return false;
    }

    public void execute(Map nusMap, UiManager ui, History history, DailyRoute dailyRoute,
                        BlockAlias blockAlias, FavouriteLocation favouriteLocation) {
    }
}
