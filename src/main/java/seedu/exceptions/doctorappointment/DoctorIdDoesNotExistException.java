package seedu.exceptions.doctorappointment;

import seedu.exceptions.HealthVaultException;

/**
 * Exception to handle invalid gender input.
 */
public class DoctorIdDoesNotExistException extends HealthVaultException {

    /**
     * Returns the error message.
     *
     * @return Error Message.
     */
    public String getMessage() {
        return "The doctor ID does not exist in the appointments database!";
    }
}