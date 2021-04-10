package seedu.exceptions.nurseschedules;

import seedu.exceptions.HealthVaultException;

public class WrongInputsException extends HealthVaultException {

    /**
     * Returns the error message.
     *
     * @return error message
     */
    public String getMessage() {
        return "OOPS! Please check to see if your command is properly formatted!";
    }
}
