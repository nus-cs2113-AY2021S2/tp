package seedu.exceptions.staff;
import seedu.exceptions.HealthVaultException;

public class WrongListInputException extends HealthVaultException {
    public String getMessage() {
        return "Invalid List command parameter\nPlease input with the either of the following format:\n\tlist\n\tlist/nurses\n\tlist/doctors";
    }
}
