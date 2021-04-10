package seedu.exceptions.doctorappointment;

import seedu.exceptions.HealthVaultException;

/**
 * Exception to handle invalid gender input.
 */
public class InvalidGenderException extends HealthVaultException {

    /**
     * Returns the error message.
     *
     * @return Error Message.
     */
    public String getMessage() {
        return "Sorry please type in M or F for gender.";
    }
}