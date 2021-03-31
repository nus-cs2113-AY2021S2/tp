package seedu.exceptions.doctorappointment;

import seedu.exceptions.HealthVaultException;

public class InvalidDocIDException extends HealthVaultException {
    public String getMessage(){
        return "Sorry this Doctor ID is invalid" ;
    }
}