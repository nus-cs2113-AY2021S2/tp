package seedu.duke.command;

import seedu.duke.*;
import seedu.duke.routing.Router;

public class ShowFavouriteLocationsCommand extends Command{
    public ShowFavouriteLocationsCommand(String userInput) {
        super(userInput);
    }

    public void execute(Router router, UiManager ui, History history,
                        NotesManager notesManager, DailyRoute dailyRoute, FavouriteLocation favouriteLocation) {
        ui.showFavouriteLocations(favouriteLocation);
    }
}
