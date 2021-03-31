package seedu.exceptions.inventory;

import seedu.exceptions.HealthVaultException;

public class InvalidPriceException extends HealthVaultException {
    public InvalidPriceException() {
    }
    public void getError(String input) {
        System.out.println("InvalidPriceException!");
    }
}
