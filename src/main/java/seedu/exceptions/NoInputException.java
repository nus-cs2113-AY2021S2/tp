package seedu.exceptions;

/**
 * Exception to handle empty input fields (Whitespace).
 */
public class NoInputException extends HealthVaultException {

    /**
     * Returns blank input error message.
     *
     * @return Error Message.
     */
    public String getMessage() {
        return "There is an empty field in the input! All fields must be filled!";
    }
}
