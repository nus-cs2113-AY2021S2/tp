package seedu.exceptions;

/**
 * Exception to handle any excess inputs given to commands.
 */
public class ExcessInputException extends HealthVaultException {

    /**
     * Returns the excess input error message.
     *
     * @return Error Message.
     */
    public String getMessage() {
        return "OOPS! There are too many inputs for this command";
    }
}
