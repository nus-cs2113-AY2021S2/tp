package seedu.duke.command;

import seedu.duke.DailyRoute;
import seedu.duke.History;
import seedu.duke.NotesManager;
import seedu.duke.UiManager;
import seedu.duke.FavouriteLocation;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.InvalidRepeatEntryException;
import seedu.duke.exception.RepeatEntryOutOfBoundException;
import seedu.duke.routing.Router;

public class ShowFavouriteLocationsCommand extends Command {
    public ShowFavouriteLocationsCommand(String userInput) {
        super(userInput);
    }

    public void execute(Router router, UiManager ui, History history,
                        NotesManager notesManager, DailyRoute dailyRoute, FavouriteLocation favouriteLocation) {
        ui.showFavouriteLocations(favouriteLocation);
    }
}
