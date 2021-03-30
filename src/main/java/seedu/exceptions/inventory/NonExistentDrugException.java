package seedu.exceptions.inventory;

import seedu.exceptions.HealthVaultException;

public class NonExistentDrugException extends HealthVaultException {
    public NonExistentDrugException(String error) {
        this.error = error;
    }
    public void getError(String input) {
        System.out.println("NonExistentDrugException!");;
    }
}
