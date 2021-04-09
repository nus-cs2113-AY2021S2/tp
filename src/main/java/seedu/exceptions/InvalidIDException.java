package seedu.exceptions;

/**
 * Exception to handle invalid ID format.
 */
public class InvalidIDException extends HealthVaultException{

    /**
     * Returns invalid ID format error message.
     *
     * @return Error Message.
     */
    public String getMessage() {
        return "OOPS! Looks like your ID value is incorrect!";
    }
}