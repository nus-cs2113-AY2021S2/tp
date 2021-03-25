package seedu.exceptions.patient;

import seedu.exceptions.DukeException;

public class DuplicateIDException extends DukeException {

    public DuplicateIDException(String error) {
        this.error = error;
    }

    @Override
    public void getError(String input) {
        super.getError(input);
    }
}
