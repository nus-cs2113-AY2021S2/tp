package seedu.exceptions.staff;

import seedu.exceptions.HealthVaultException;

/**
 * Exception to handle invalid Staff Age input when adding Staff.
 */
public class InvalidStaffAgeException extends HealthVaultException {

    /**
     * Returns the error message.
     *
     * @return Error Message.
     */
    public String getMessage() {
        return "Your age input is invalid! \n"
                + "Please ensure that the age is an integer between 18 and 150 inclusive!";
    }
}
