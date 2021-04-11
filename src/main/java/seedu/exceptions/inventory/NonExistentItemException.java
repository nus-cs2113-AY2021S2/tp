package seedu.exceptions.inventory;

import seedu.exceptions.HealthVaultException;

/**
 * Gives an error when item does not exist in Inventory list.
 */
public class NonExistentItemException extends HealthVaultException {
    public NonExistentItemException(String error) {
        this.error = error;
    }

    /**
     * Displays error message.
     *
     * @param input error type
     */
    public void getError(String input) {
        System.out.println("OOPS! This item does not exist in the Inventory!");;
    }
}
