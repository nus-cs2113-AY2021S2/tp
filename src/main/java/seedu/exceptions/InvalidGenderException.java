package seedu.exceptions;

/**
 * Exception to handle invalid gender input.
 */
public class InvalidGenderException extends HealthVaultException{

    /**
     * Returns invalid gender input error message.
     *
     * @return Error Message.
     */
    public String getMessage() {
        return "The gender is invalid!";
    }
}
