package seedu.duke.command.favouritecommand;

import seedu.duke.Router;
import seedu.duke.command.Command;
import seedu.duke.exception.*;
import seedu.duke.ui.FavouriteUi;

public class RepeatFavouriteCommand extends Command {
    protected FavouriteUi ui;
    public RepeatFavouriteCommand() {
        this.ui = new FavouriteUi();
    }

    @Override
    public void execute() {
        try {
            ui.showFavourites(favourite);
            int repeatIndex = ui.getRepeatIndex();
            String[] routeInfo = favourite.getSpecificEntry(repeatIndex - 1);
            String route = new Router().execute(nusMap, blockAlias, routeInfo[0], routeInfo[1]);
            history.addHistory(routeInfo[0], routeInfo[1]);
            ui.showMessageWithDivider(route);
        } catch (InvalidBlockException | EmptyFavouriteException | InvalidIndexException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}
