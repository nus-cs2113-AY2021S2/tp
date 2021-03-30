package seedu.exceptions.inventory;

import seedu.exceptions.HealthVaultException;

public class InvalidPriceException extends HealthVaultException {
    public InvalidPriceException(String error) {
        this.error = error;
    }
    public void getError(String input) {
        System.out.println("InvalidPriceException!");
    }
}
