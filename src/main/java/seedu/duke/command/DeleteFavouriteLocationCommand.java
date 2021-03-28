package seedu.duke.command;

import seedu.duke.BlockAlias;
import seedu.duke.DailyRoute;
import seedu.duke.FavouriteLocation;
import seedu.duke.History;
import seedu.duke.Map;
import seedu.duke.ui.UiManager;

public class DeleteFavouriteLocationCommand extends Command {

    public DeleteFavouriteLocationCommand(String userInput) {
        super(userInput);
    }

    public void execute(Map nusMap, UiManager ui, History history, DailyRoute dailyRoute,
                        BlockAlias blockAlias, FavouriteLocation favouriteLocation) {
        System.out.println("Enter the index of the block which you wish to delete: ");
        int index = Integer.parseInt(ui.getUserInput());
        ui.deleteFavouriteLocation(favouriteLocation, index);
        System.out.println(ui.divider);
    }
}
