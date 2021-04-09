package seedu.exceptions.patient;

import seedu.exceptions.HealthVaultException;

public class InvalidIdLengthException extends HealthVaultException {

    public InvalidIdLengthException(String error) {
        this.error = error;
    }

    public String getMessage() {
        return "Looks like your ID length is incorrect! \n"
                + "Please ensure that the ID has 6 characters!";
    }

}
