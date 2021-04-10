package seedu.exceptions;

/**
 * Exception to handle non-numeric inputs when numeric inputs are expected.
 */
public class InvalidIntegerException extends HealthVaultException {

    /**
     * Returns invalid numeric input error message.
     *
     * @return Error Message.
     */
    public String getMessage() {
        return "The numeric input is invalid!";
    }
}
