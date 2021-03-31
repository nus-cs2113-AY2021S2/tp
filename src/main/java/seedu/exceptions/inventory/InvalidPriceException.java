package seedu.exceptions.inventory;

import seedu.exceptions.HealthVaultException;

public class InvalidPriceException extends HealthVaultException {
    public InvalidPriceException() {
    }
    @Override
    public void getError(String input) {
        super.getError(input);
    }
}
