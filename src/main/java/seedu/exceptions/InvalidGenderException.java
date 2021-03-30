package seedu.exceptions;

public class InvalidGenderException extends HealthVaultException{
    public String getMessage() {
        return "The gender is invalid!";
    }
}
