package seedu.duke.ui;

import seedu.duke.History;
import seedu.duke.exception.InvalidRepeatEntryException;

public class HistoryUi extends Ui {

    public HistoryUi() {
    }

    public void showHistory(History history) {
        assert history != null : "History must be initialized before, cannot be null";
        showToUser(
                "Number of records in your history: " + history.getTotalNoOfHistory() + lineSeparator
                + history.getHistoryAsString()
        );
    }

    public void showClearHistoryResponse() {
        showToUser("Your history has been cleared.");
    }

    public int getRepeatEntry() throws InvalidRepeatEntryException {
        try {
            showToUser("SELECT ENTRY TO REPEAT:");
            return Integer.parseInt(getUserInput());
        } catch (NumberFormatException e) {
            throw new InvalidRepeatEntryException();
        }
    }
}
