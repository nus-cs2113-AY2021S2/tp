package seedu.exceptions;

public class HealthVaultException extends Exception {

    protected String error;

    public HealthVaultException(String error) {
        this.error = error;
    }

    public HealthVaultException() {
    }

    public String getMessage() {
        return "There seems to be an error!";
    }
}
