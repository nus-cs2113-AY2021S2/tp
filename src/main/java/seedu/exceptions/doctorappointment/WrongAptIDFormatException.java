package seedu.exceptions.doctorappointment;

import seedu.exceptions.HealthVaultException;

/**
 * Exception to handle invalid Appointment Id Format.
 */
public class WrongAptIDFormatException extends HealthVaultException {
    /**
     * Returns the error message.
     *
     * @return Error Message.
     */
    public String getMessage() {
        return "Error in Appointment ID input\nPlease input with the following format [A][5 digit ID number]";
    }
}
