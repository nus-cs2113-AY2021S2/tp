package seedu.exceptions.patient;

import seedu.exceptions.DukeException;

public class nonexistentIDException extends DukeException {

    public nonexistentIDException(String error) {
        this.error = error;
    }

    @Override
    public void getError(String input) {
        super.getError(input);
    }
}
