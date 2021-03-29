package seedu.exceptions.patient;

import seedu.exceptions.DukeException;

public class NonExistentIDException extends DukeException {

    public NonExistentIDException(String error) {
        this.error = error;
    }

    @Override
    public void getError(String input) {
        super.getError(input);
    }
}
