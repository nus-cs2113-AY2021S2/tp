package seedu.exceptions.patient;

import seedu.exceptions.DukeException;

public class InvalidIDTypeException extends DukeException {

    public InvalidIDTypeException(String error) {
        this.error = error;
    }

    @Override
    public void getError(String input) {
        super.getError(input);
    }
}
