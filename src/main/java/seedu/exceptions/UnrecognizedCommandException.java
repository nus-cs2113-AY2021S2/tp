package seedu.exceptions;

/**
 * Exception to handle unrecognised command input.
 */
public class UnrecognizedCommandException extends HealthVaultException {

    /**
     * Returns invalid command error message.
     *
     * @return Error Message.
     */
    public String getMessage() {
        return "OOPS! Your command may not be valid! \n" +
                "Please check the list of available commands using \"help\"";
    }
}
