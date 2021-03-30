package seedu.exceptions.inventory;

import seedu.exceptions.DukeException;

public class InvalidPriceException extends DukeException {
    public InvalidPriceException(String error) {
        this.error = error;
    }
    @Override
    public void getError(String input) {
        super.getError(input);
    }
}
