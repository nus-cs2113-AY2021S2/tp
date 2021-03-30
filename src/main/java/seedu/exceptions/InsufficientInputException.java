package seedu.exceptions;

public class InsufficientInputException extends HealthVaultException{
    public String getMessage() {
        return "OOPS! There is too little input for this command";
    }
}
