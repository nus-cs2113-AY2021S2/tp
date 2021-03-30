package seedu.exceptions;

public class InvalidIntegerException extends HealthVaultException{
    public String getMessage() {
        return "The numeric input is invalid!";
    }
}
