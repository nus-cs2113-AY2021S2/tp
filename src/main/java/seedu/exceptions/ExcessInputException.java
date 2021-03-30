package seedu.exceptions;

public class ExcessInputException extends HealthVaultException{
    public String getMessage() {
        return "OOPS! There is too many input for this command";
    }
}
