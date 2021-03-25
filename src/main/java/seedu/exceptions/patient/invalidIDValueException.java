package seedu.exceptions.patient;

import seedu.exceptions.DukeException;

public class invalidIDValueException extends DukeException {

    public invalidIDValueException(String error) {
        this.error = error;
    }
    @Override
    public void getError(String input) {
        super.getError(input);
    }
}
