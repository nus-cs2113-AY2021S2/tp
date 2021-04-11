package seedu.exceptions.patient;

import seedu.exceptions.HealthVaultException;

/**
 * Exception to handle invalid patient ID.
 */
public class InvalidPatientIdException extends HealthVaultException {

    public String getMessage() {
        return "Error in Patient ID input\nPlease input with the following format [P][5 digit ID number]";
    }
}
