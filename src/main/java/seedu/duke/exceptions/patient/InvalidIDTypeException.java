package seedu.duke.exceptions.patient;

import seedu.duke.exceptions.DukeException;

public class invalidIDTypeException extends DukeException {

    public invalidIDTypeException(String error) {
        this.error = error;
    }

    @Override
    public void getError(String input) {
        super.getError(input);
    }
}
