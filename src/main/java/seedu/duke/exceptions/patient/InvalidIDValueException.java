package seedu.duke.exceptions.patient;

import seedu.duke.exceptions.HealthVaultException;

public class InvalidIDValueException extends HealthVaultException {

    public InvalidIDValueException(String error) {
        this.error = error;
    }
    @Override
    public void getError(String input) {
        super.getError(input);
    }
}
