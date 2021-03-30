package seedu.exceptions.patient;

import seedu.exceptions.HealthVaultException;

public class InvalidIDLengthException extends HealthVaultException {

    public InvalidIDLengthException(String error) {
        this.error = error;
    }

    public String getMessage() {
        return "Looks like your ID length is incorrect! \n" +
                "Please ensure that the ID has 6 characters!";
    }

}
