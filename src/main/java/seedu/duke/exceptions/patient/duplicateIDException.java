package seedu.duke.exceptions.patient;

import seedu.duke.exceptions.DukeException;

public class duplicateIDException extends DukeException {

    public duplicateIDException(String error) {
        this.error = error;
    }

    @Override
    public void getError(String input) {
        super.getError(input);
    }
}
