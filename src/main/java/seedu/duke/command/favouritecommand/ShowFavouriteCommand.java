//@@author Rye98
package seedu.duke.command.favouritecommand;

import seedu.duke.command.Command;
import seedu.duke.exception.EmptyFavouriteException;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.ui.FavouriteUi;

public class ShowFavouriteCommand extends Command {

    protected FavouriteUi ui;

    public ShowFavouriteCommand() {
        this.ui = new FavouriteUi();
    }

    public void execute() {
        try {
            ui.showFavourites(favourite);
        } catch (EmptyFavouriteException | InvalidIndexException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}