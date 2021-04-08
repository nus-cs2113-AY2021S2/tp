package seedu.exceptions.staff;
import seedu.exceptions.HealthVaultException;

public class InvalidStaffAgeException extends HealthVaultException {
    public String getMessage() {
        return "Your age input is invalid! \n" +
                "Please ensure that the age is an integer between 18 and 150 inclusive!";
    }
}
