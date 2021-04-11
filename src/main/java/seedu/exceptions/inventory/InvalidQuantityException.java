package seedu.exceptions.inventory;

import seedu.exceptions.HealthVaultException;

/**
 * Gives an error when input quantity is invalid.
 */
public class InvalidQuantityException extends HealthVaultException {
    /**
     * Displays error message.
     */
    public void getError() {
        System.out.println("Input quantity is more than that in the inventory!");
    }
}
