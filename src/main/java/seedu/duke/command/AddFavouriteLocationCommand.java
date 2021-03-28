package seedu.duke.command;

import seedu.duke.BlockAlias;
import seedu.duke.DailyRoute;
import seedu.duke.FavouriteLocation;
import seedu.duke.History;
import seedu.duke.Map;
import seedu.duke.ui.UiManager;

public class AddFavouriteLocationCommand extends Command {

    public AddFavouriteLocationCommand(String userInput) {
        super(userInput);
    }

    public void execute(Map nusMap, UiManager ui, History history, DailyRoute dailyRoute,
                        BlockAlias blockAlias, FavouriteLocation favouriteLocation) {
        System.out.println("Enter block to be added to favourites: ");
        String location = ui.getUserInput();
        ui.addFavoriteLocations(favouriteLocation, location, nusMap);
        System.out.println(ui.divider);
    }
}
