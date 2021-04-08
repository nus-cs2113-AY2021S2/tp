package seedu.exceptions.staff;
import seedu.exceptions.HealthVaultException;

public class WrongStaffIDException extends HealthVaultException {
    public String getMessage() {
        return "Error in Staff ID input\nPlease input with the following format [D/N][5 digit ID number]";
    }
}
