package seedu.exceptions.patient;

import seedu.exceptions.HealthVaultException;

public class IllegalCharacterException extends HealthVaultException {

    public String getMessage() {
        return "You have an illegal character in your: " +
                "name or illness or medication fields";
    }
}
