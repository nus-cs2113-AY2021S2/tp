package seedu.exceptions.inventory;

import seedu.exceptions.HealthVaultException;

public class NonExistentDrugException extends HealthVaultException {
    public NonExistentDrugException(String error) {
        this.error = error;
    }
    @Override
    public void getError(String input) {
        super.getError(input);
    }
}
