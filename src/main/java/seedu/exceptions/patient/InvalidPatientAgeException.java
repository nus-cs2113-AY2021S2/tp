package seedu.exceptions.patient;

import seedu.exceptions.HealthVaultException;

public class InvalidPatientAgeException extends HealthVaultException {

    public String getMessage() {
        return "Your age input is invalid! \n" +
                "Please ensure that the age is an integer between 0 and 150 inclusive!";
    }
}
