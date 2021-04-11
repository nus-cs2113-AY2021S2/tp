package seedu.exceptions.inventory;

import seedu.exceptions.HealthVaultException;

/**
 * Gives an error when numeric input is invalid.
 */
public class WrongNumberException extends HealthVaultException {
    protected String errorField;

    public WrongNumberException(String errorField) {
        this.errorField = errorField;
    }

    /**
     * Displays error message.
     */
    public void getError() {
        System.out.println("Please enter a valid " + this.errorField + "!");
    }
}
