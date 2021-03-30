package seedu.exceptions.inventory;

import seedu.exceptions.DukeException;

public class NonExistentDrugException extends DukeException {
    public NonExistentDrugException(String error) {
        this.error = error;
    }
    @Override
    public void getError(String input) {
        super.getError(input);
    }
}
