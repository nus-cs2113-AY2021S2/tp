package seedu.duke.command;

import seedu.duke.Map;
import seedu.duke.UiManager;
import seedu.duke.History;
import seedu.duke.DailyRoute;
import seedu.duke.BlockAlias;
import seedu.duke.FavouriteLocation;

public class ShowCustomAliasCommand extends Command {
    public ShowCustomAliasCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Map map, UiManager ui, History history, DailyRoute dailyRoute,
                        BlockAlias blockAlias, FavouriteLocation favouriteLocation) {
        ui.showCustomAliases(blockAlias.getAliasMap());
    }
}
