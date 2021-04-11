package seedu.duke.ui;

import seedu.duke.data.History;
import seedu.duke.exception.EmptyHistoryException;
import seedu.duke.exception.InvalidIndexException;

public class HistoryUi extends UiManager {


    /**
     * Displays all available entries stored in history to the user, in the form of an indexed list.
     * If there are no stored entries, the EmptyHistoryException will be thrown.
     * When this method is called from "Repeat History" command, the user will also be prompted to enter
     * the index of stored entries, by calling the getRepeatIndex() method.
     *
     * @param history
     * @throws InvalidIndexException
     * @throws EmptyHistoryException
     */
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

    /**
     * This method prompts the user to enter an index of a stored entry in history.
     * If an invalid input is provided, the InvalidIndexException is thrown.
     *
     * @return the index of the stored search to repeat.
     * @throws InvalidIndexException
     */
    public int getRepeatIndex() throws InvalidIndexException {
        try {
            showMessage("Select Entry to Repeat:");
            int repeatIndex = Integer.parseInt(getUserInput());
            showMessage(CommonMessage.DIVIDER);
            return repeatIndex;
        } catch (NumberFormatException e) {
            throw new InvalidIndexException();
        }
    }
}
