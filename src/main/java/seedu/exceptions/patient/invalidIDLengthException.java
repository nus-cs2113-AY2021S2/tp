package seedu.exceptions.patient;

import seedu.exceptions.DukeException;

public class invalidIDLengthException extends DukeException {

    public invalidIDLengthException(String error) {
        this.error = error;
    }

    @Override
    public void getError(String input) {
        super.getError(input);
    }
}
