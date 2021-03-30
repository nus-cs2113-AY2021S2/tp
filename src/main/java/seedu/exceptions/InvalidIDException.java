package seedu.exceptions;

public class InvalidIDException extends HealthVaultException{
    public String getMessage() {
        return "OOPS! Looks like your ID value is incorrect! \n";
    }
}