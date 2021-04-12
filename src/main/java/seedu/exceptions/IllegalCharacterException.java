package seedu.exceptions;

/**
 * Exception to handle any non alphanumeric character foynd in input fields.
 */
public class IllegalCharacterException extends HealthVaultException {

    private String errorField;

    /**
     * Constructor for IllegalCharacterException class.
     *
     * @param errorField Field that has illegal characters.
     */
    public IllegalCharacterException(String errorField) {
        this.errorField = errorField;
    }

    /**
     * Returns the Illegal Characters error message with the given input field.
     *
     * @return Error Message.
     */
    public String getMessage() {
        return "You have an illegal character in your: " + errorField;
    }
}
