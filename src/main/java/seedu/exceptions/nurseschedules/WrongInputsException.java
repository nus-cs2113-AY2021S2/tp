package seedu.exceptions.nurseschedules;

import seedu.exceptions.HealthVaultException;

public class WrongInputsException extends HealthVaultException {
    public String getMessage() {
        return "OOPS! Please check to see if your command is properly formatted!";
    }
}
