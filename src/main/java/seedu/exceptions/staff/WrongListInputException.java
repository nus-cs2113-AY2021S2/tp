package seedu.exceptions.staff;

import seedu.exceptions.HealthVaultException;
import seedu.ui.UI;

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
        UI.printEmptyLine();
        return "Invalid List command parameter\n"
                + "Please input with the either of the following format:\n\tlist\n\tlist/nurses\n\tlist/doctors";
    }
}
