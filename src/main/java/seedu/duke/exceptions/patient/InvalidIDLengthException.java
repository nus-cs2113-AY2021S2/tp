package seedu.duke.exceptions.patient;

import seedu.duke.exceptions.DukeException;

public class InvalidIDLengthException extends DukeException {

    public InvalidIDLengthException(String error) {
        this.error = error;
    }

    @Override
    public void getError(String input) {
        super.getError(input);
    }
}
