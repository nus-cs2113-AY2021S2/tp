//@@author Rye98

package seedu.duke.command.favouritecommand;

import seedu.duke.exception.EmptyFavouriteException;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.router.Router;
import seedu.duke.command.Command;
import seedu.duke.ui.FavouriteUi;

public class RepeatFavouriteCommand extends Command {
    protected FavouriteUi ui;

    public RepeatFavouriteCommand() {
        this.ui = new FavouriteUi();
    }

    @Override
    /**
     * This method will run the "go" command by using the stored starting block and destination block in favourites.
     * The user would first be shown the current list of favourite routes,
     * and then be prompted to enter the index of the route to repeat.
     *
     * This method further calls the execute() command from the Router class.
     */
    public void execute() {
        try {
            ui.showFavourites(favourite);
            int repeatIndex = ui.getRepeatIndex();
            String[] routeInfo = favourite.getSpecificEntry(repeatIndex - 1);
            String route = new Router().execute(nusMap, routeInfo[0], routeInfo[1]);
            history.addHistory(routeInfo[0], routeInfo[1]);
            ui.showMessageWithDivider(route);
        } catch (EmptyFavouriteException | InvalidIndexException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}
