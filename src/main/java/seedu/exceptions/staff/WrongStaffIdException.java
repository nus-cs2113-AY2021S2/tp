package seedu.exceptions.staff;

import seedu.exceptions.HealthVaultException;

/**
 * Exception to handle invalid Staff ID input when adding Staff.
 */
public class WrongStaffIdException extends HealthVaultException {

    /**
     * Returns the invalid Staff ID error message.
     *
     * @return Error Message.
     */
    public String getMessage() {
        return "Error in Staff ID input\nPlease input with the following format [D/N][5 digit ID number]";
    }
}
