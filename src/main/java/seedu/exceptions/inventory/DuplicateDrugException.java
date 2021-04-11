package seedu.exceptions.inventory;

import seedu.exceptions.HealthVaultException;

/**
 * Gives array when the drug already exist in Inventory list.
 */
public class DuplicateDrugException extends HealthVaultException {
    public DuplicateDrugException() {
    }

    /**
     * Displays error message.
     *
     * @param input error type
     */
    public void getError(String input) {
        System.out.println("OOPS! This drug already exists in the Inventory!");
    }

}
