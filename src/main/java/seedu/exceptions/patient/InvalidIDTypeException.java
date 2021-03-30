package seedu.exceptions.patient;

import seedu.exceptions.HealthVaultException;

public class InvalidIDTypeException extends HealthVaultException {

    public InvalidIDTypeException(String error) {
        this.error = error;
    }

    @Override
    public void getError(String input) {
        super.getError(input);
    }
}
