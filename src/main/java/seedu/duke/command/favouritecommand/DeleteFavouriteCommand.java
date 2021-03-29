package seedu.duke.command.favouritecommand;

import seedu.duke.command.Command;
import seedu.duke.exception.EmptyFavouriteException;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.ui.FavouriteUi;

public class DeleteFavouriteCommand extends Command {

    protected FavouriteUi ui;
    public DeleteFavouriteCommand() {
        this.ui = new FavouriteUi();
    }

    public void execute() {
        try {
            ui.showFavourites(favourite);
            int deleteIndex = ui.getDeleteIndex();
            favourite.deleteFavourite(deleteIndex - 1);
        } catch (EmptyFavouriteException | InvalidIndexException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}
