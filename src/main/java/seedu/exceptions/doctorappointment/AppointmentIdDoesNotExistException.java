package seedu.exceptions.doctorappointment;

import seedu.exceptions.HealthVaultException;

/**
 * Exception to handle invalid gender input.
 */
public class AppointmentIdDoesNotExistException extends HealthVaultException {

    /**
     * Returns the error message.
     *
     * @return Error Message.
     */
    public String getMessage() {
        return "The appointment ID does not exist in the appointments database!";
    }
}