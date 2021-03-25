package seedu.exceptions.patient;

import seedu.exceptions.DukeException;

public class InvalidIDValueException extends DukeException {

    public InvalidIDValueException(String error) {
        this.error = error;
    }

    @Override
    public void getError(String input) {
        super.getError(input);
    }
}
