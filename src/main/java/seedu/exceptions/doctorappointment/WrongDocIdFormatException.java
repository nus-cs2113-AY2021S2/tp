package seedu.exceptions.doctorappointment;

import seedu.exceptions.HealthVaultException;

/**
 * Exception to handle invalid Appointment Id Format.
 */
public class WrongDocIdFormatException extends HealthVaultException {
    /**
     * Returns the error message.
     *
     * @return Error Message.
     */
    public String getMessage() {
        return "Error in Doctor ID input\nPlease input with the following format [D][5 digit ID number]";
    }
}
