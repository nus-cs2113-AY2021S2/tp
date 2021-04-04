package seedu.duke.ui;

import seedu.duke.data.Favourite;
import seedu.duke.exception.EmptyFavouriteException;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.exception.SameBlockException;

public class FavouriteUi extends UiManager {

    public String[] getFavouriteInfo() throws SameBlockException {
        return new RouterUi().getRoutingInfo();
    }

    public void showFavourites(Favourite favourite) throws EmptyFavouriteException, InvalidIndexException {
        if (favourite.isEmpty()) {
            throw new EmptyFavouriteException();
        } else {
            showMessage("Here are your favourite routes:");
            for (int i = 0; i < favourite.getFavouriteSize(); i++) {
                String[] routeInfo = favourite.getSpecificEntry(i);
                showMessage((i + 1) + ". " + routeInfo[0] + " -> " + routeInfo[1]);
            }
            showMessage(CommonMessage.DIVIDER);
        }
    }

    public int getDeleteIndex() throws InvalidIndexException {
        return new NoteUi().getDeleteIndex();
    }

    public int getRepeatIndex() throws InvalidIndexException {
        return new HistoryUi().getRepeatIndex();
    }
}
