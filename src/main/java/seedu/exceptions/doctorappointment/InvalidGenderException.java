package seedu.exceptions.doctorappointment;

import seedu.exceptions.HealthVaultException;

public class InvalidGenderException extends HealthVaultException {
    public String getMessage() {
        return "Sorry please type in M or F for gender.";
    }
}