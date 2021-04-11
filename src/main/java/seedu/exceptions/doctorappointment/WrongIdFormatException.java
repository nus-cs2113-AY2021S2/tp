package seedu.exceptions.doctorappointment;

import seedu.exceptions.HealthVaultException;

/**
 * Exception to handle invalid Appointment Id Format.
 */
public class WrongIdFormatException extends HealthVaultException {
    /**
     * Returns the error message.
     *
     * @return Error Message.
     */
    public String getMessage() {
        return "Error in ID input\nPlease input with the following format [D]/[A] followed by [5 digit ID number]";
    }
}
