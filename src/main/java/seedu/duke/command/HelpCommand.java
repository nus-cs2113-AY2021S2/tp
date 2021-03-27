package seedu.duke.command;

import seedu.duke.Map;
import seedu.duke.UiManager;
import seedu.duke.History;
import seedu.duke.DailyRoute;
import seedu.duke.BlockAlias;
import seedu.duke.FavouriteLocation;

public class HelpCommand extends Command {
    public HelpCommand(String userInput) {
        super(userInput);
    }

    public void execute(Map nusMap, UiManager ui, History history, DailyRoute dailyRoute,
                        BlockAlias blockAlias, FavouriteLocation favouriteLocation) {
        ui.showHelpMessage();
    }
}
