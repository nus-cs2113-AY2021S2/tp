package seedu.exceptions.inventory;

import seedu.exceptions.HealthVaultException;

/**
 * Gives array when the item already exist in Inventory list.
 */
public class DuplicateItemException extends HealthVaultException {
    public DuplicateItemException() {
    }

    /**
     * Displays error message.
     *
     * @param input error type
     */
    public void getError(String input) {
        System.out.println("OOPS! This item already exists in the Inventory!");
    }

}
