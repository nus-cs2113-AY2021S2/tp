package seedu.exceptions.staff;
import seedu.exceptions.HealthVaultException;

/**
 * Exception to handle invalid Staff List input when listing Staff.
 */
public class WrongListInputException extends HealthVaultException {

    /**
     * Returns the list error message.
     *
     * @return Error Message.
     */
    public String getMessage() {
        return "Invalid List command parameter\nPlease input with the either of the following format:\n\tlist\n\tlist/nurses\n\tlist/doctors";
    }
}
