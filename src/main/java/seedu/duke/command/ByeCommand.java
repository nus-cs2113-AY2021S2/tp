package seedu.duke.command;

import seedu.duke.Map;
import seedu.duke.ui.UiManager;
import seedu.duke.History;
import seedu.duke.DailyRoute;
import seedu.duke.BlockAlias;
import seedu.duke.FavouriteLocation;

public class ByeCommand extends Command {
    public ByeCommand(String userInput) {
        super(userInput);
    }

    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public void execute(Map nusMap, UiManager ui, History history, DailyRoute dailyRoute,
                        BlockAlias blockAlias, FavouriteLocation favouriteLocation) {
        ui.showByeMessage();
    }
}
