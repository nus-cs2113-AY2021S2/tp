package seedu.duke.exceptions.patient;

import seedu.duke.exceptions.DukeException;

public class NonexistentIDException extends DukeException {

    public NonexistentIDException(String error) {
        this.error = error;
    }

    @Override
    public void getError(String input) {
        super.getError(input);
    }
}
