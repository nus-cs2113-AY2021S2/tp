package seedu.duke.exceptions;

import seedu.duke.utilities.Ui;

public class InvalidIndexException extends Exception {
    public InvalidIndexException() {
    }

    public void showErrorMessage(String type) {
        Ui.showInvalidIdMessage(type);
    }
}
