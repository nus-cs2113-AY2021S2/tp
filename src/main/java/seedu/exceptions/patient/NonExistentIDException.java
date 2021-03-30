package seedu.exceptions.patient;

import seedu.exceptions.HealthVaultException;

public class NonExistentIDException extends HealthVaultException {

    public NonExistentIDException(String error) {
        this.error = error;
    }

    @Override
    public void getError(String input) {
        super.getError(input);
    }
}
