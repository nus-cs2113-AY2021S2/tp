//@@author Rye98

package seedu.duke.command.favouritecommand;

import seedu.duke.command.Command;
import seedu.duke.exception.EmptyFavouriteException;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.ui.FavouriteUi;

public class DeleteFavouriteCommand extends Command {

    protected FavouriteUi ui;
    private static final String MESSAGE_SUCCESS = "Got it! Successfully deleted favourite route :)";

    public DeleteFavouriteCommand() {
        this.ui = new FavouriteUi();
    }

    /**
     * This method deletes a currently existing favourite route.
     * The user would first be shown the current list of favourites,
     * and then prompted to provide the index of the favourite route to delete.
     */
    public void execute() {
        try {
            ui.showFavourites(favourite);
            int deleteIndex = ui.getDeleteIndex();
            favourite.deleteFavourite(deleteIndex - 1);
            ui.showMessageWithDivider(MESSAGE_SUCCESS);
        } catch (EmptyFavouriteException | InvalidIndexException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}
