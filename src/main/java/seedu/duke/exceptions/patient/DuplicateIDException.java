package seedu.duke.exceptions.patient;

import seedu.duke.exceptions.HealthVaultException;

public class DuplicateIDException extends HealthVaultException {

    public DuplicateIDException(String error) {
        this.error = error;
    }

    @Override
    public void getError(String input) {
        super.getError(input);
    }
}
