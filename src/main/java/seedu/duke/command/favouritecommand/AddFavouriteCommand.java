//@@author Rye98

package seedu.duke.command.favouritecommand;

import seedu.duke.command.Command;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.SameBlockException;
import seedu.duke.ui.FavouriteUi;

public class AddFavouriteCommand extends Command {

    protected FavouriteUi ui;
    private static final String MESSAGE_SUCCESS = "Got it! Successfully added new favourite route!";

    public AddFavouriteCommand() {
        this.ui = new FavouriteUi();
    }

    @Override
    /**
     * This method adds a new favourite route to the list of favourite routes,
     * by prompting the user for the starting and destination blocks.
     * This method calls the checkIfValidBlock() method under NusMap class.
     */
    public void execute() {
        try {
            String[] startAndDestination = ui.getFavouriteInfo();
            nusMap.checkIfValidBlock(startAndDestination[0]);
            nusMap.checkIfValidBlock(startAndDestination[1]);
            favourite.addFavourite(startAndDestination[0], startAndDestination[1]);
            ui.showMessageWithDivider(MESSAGE_SUCCESS);
        } catch (InvalidBlockException | SameBlockException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}
