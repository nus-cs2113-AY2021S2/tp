package seedu.duke.ui;

import seedu.duke.data.History;
import seedu.duke.exception.EmptyHistoryException;
import seedu.duke.exception.InvalidIndexException;

public class HistoryUi extends UiManager {

    public void showHistory(History history) throws InvalidIndexException, EmptyHistoryException {
        assert history != null : "History must be initialized before, cannot be null";
        if (history.isEmpty()) {
            throw new EmptyHistoryException();
        } else {
            showMessage("There are " + history.getHistorySize() + " records in your history: ");
            for (int i = 0; i < history.getHistorySize(); i++) {
                String[] routeInfo = history.getSpecificEntry(i);
                showMessage((i + 1) + ". " + routeInfo[0] + " -> " + routeInfo[1]);
            }
            showMessage(CommonMessage.DIVIDER);
        }
    }

    public int getRepeatEntry() throws InvalidIndexException {
        try {
            showMessage("Select Entry to Repeat:");
            return Integer.parseInt(getUserInput());
        } catch (NumberFormatException e) {
            throw new InvalidIndexException();
        }
    }
}
