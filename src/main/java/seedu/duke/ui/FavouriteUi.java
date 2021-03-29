package seedu.duke.ui;

import seedu.duke.data.Favourite;
import seedu.duke.exception.EmptyFavouriteException;
import seedu.duke.exception.InvalidIndexException;

public class FavouriteUi extends UiManager {

    public String[] getFavouriteInfo() {
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
            showMessageWithDivider(CommonMessage.DIVIDER);
        }
    }

    public int getDeleteIndex() throws InvalidIndexException {
        try {
            showMessage("Select Entry to Delete:");
            return Integer.parseInt(getUserInput());
        } catch (NumberFormatException e) {
            throw new InvalidIndexException();
        }
    }

    public int getRepeatIndex() throws InvalidIndexException {
        return new HistoryUi().getRepeatEntry();
    }
}
