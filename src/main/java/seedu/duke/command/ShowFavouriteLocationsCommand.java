package seedu.duke.command;

import seedu.duke.BlockAlias;
import seedu.duke.DailyRoute;
import seedu.duke.History;
import seedu.duke.NotesManager;
import seedu.duke.Map;
import seedu.duke.UiManager;
import seedu.duke.FavouriteLocation;

public class ShowFavouriteLocationsCommand extends Command {
    public ShowFavouriteLocationsCommand(String userInput) {
        super(userInput);
    }

    public void execute(Map nusMap, UiManager ui, History history,
                        NotesManager notesManager, DailyRoute dailyRoute,
                        BlockAlias blockAlias, FavouriteLocation favouriteLocation) {
        ui.showFavouriteLocations(favouriteLocation);
    }
}
