package seedu.exceptions;

/**
 * Exception to handle invalid date format.
 */
public class InvalidDateException extends HealthVaultException{

    /**
     * Returns date format error message.
     *
     * @return Error Message.
     */
    public String getMessage() {
        return "The date format is invalid!";
    }
}
