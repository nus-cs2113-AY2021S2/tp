package seedu.exceptions.inventory;

import seedu.exceptions.HealthVaultException;

public class InvalidPriceException extends HealthVaultException {
    public InvalidPriceException() {
    }
    public void getError(String input) {
        System.out.println("Please input a valid price. Eg 3 or 3.00");
    }
}
