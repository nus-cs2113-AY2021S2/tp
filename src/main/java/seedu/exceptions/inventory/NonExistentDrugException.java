package seedu.exceptions.inventory;

import seedu.exceptions.HealthVaultException;

/**
 * Gives an error when drug does not exist in Inventory list.
 */
public class NonExistentDrugException extends HealthVaultException {
    public NonExistentDrugException(String error) {
        this.error = error;
    }

    /**
     * Displays error message.
     *
     * @param input error type
     */
    public void getError(String input) {
        System.out.println("OOPS! This drug does not exist in the Inventory!");;
    }
}
