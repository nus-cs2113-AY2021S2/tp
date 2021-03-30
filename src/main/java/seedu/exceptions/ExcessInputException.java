package seedu.exceptions;

public class ExcessInputException extends HealthVaultException{
    public String getMessage() {
        return "OOPS! There are too many inputs for this command";
    }
}
