package seedu.exceptions.patient;

import seedu.exceptions.HealthVaultException;

public class InvalidIdTypeException extends HealthVaultException {

    public InvalidIdTypeException(String error) {
        this.error = error;
    }

    public String getMessage() {
        return "Looks like your ID type is incorrect! \n"
                + "Please ensure that the ID starts with \"P\"!";
    }
}
