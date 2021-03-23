package seedu.duke.exceptions.patient;

import seedu.duke.exceptions.HealthVaultException;

public class NonexistentIDException extends HealthVaultException {

    public NonexistentIDException(String error) {
        this.error = error;
    }

    @Override
    public void getError(String input) {
        super.getError(input);
    }
}
