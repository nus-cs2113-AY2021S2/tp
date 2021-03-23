package seedu.duke.exceptions.patient;

import seedu.duke.exceptions.HealthVaultException;

public class InvalidIDTypeException extends HealthVaultException {

    public InvalidIDTypeException(String error) {
        this.error = error;
    }

    @Override
    public void getError(String input) {
        super.getError(input);
    }
}
