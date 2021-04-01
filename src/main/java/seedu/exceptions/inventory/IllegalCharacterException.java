package seedu.exceptions.inventory;

import seedu.exceptions.HealthVaultException;

public class IllegalCharacterException extends HealthVaultException {

    public IllegalCharacterException() {
    }
    public String getMessage() {
        return "You have an illegal character in your input";
    }
}
