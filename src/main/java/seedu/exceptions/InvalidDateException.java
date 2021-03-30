package seedu.exceptions;

public class InvalidDateException extends HealthVaultException{
    public String getMessage() {
        return "The date format is invalid!";
    }
}
