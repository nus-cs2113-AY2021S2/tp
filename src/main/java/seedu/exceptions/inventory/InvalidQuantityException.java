package seedu.exceptions.inventory;

import seedu.exceptions.HealthVaultException;

public class InvalidQuantityException extends HealthVaultException {
    public void getError() {
        System.out.println("Input quantity is more than that in the inventory!");
    }
}
