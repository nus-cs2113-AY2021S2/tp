package seedu.exceptions;

/**
 * Exception to handle any insufficient inputs given to commands.
 */
public class InsufficientInputException extends HealthVaultException {

    /**
     * Returns the insufficient input error message.
     *
     * @return Error Message.
     */
    public String getMessage() {
        return "OOPS! There are too few inputs for this command";
    }
}
