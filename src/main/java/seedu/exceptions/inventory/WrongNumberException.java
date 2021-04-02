package seedu.exceptions.inventory;

import seedu.exceptions.HealthVaultException;

public class WrongNumberException extends HealthVaultException {
    protected String errorField;
    public WrongNumberException(String errorField) {
        this.errorField = errorField;
    }
    public void getError() {
        System.out.println("Please enter a valid " + this.errorField + "!");
    }
}
