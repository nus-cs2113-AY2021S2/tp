package seedu.duke.command.favouritecommand;

import seedu.duke.command.Command;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.ui.FavouriteUi;

public class AddFavouriteCommand extends Command {

    protected FavouriteUi ui;
    private static final String MESSAGE_SUCCESS = "Got it! Successfully added favourite route!";

    public AddFavouriteCommand() {
        this.ui = new FavouriteUi();
    }

    @Override
    public void execute() {
        try {
            String[] startAndDestination = ui.getFavouriteInfo();
            favourite.addFavourite(startAndDestination[0], startAndDestination[1]);
            ui.showMessageWithDivider(MESSAGE_SUCCESS);
        } catch (InvalidBlockException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}
