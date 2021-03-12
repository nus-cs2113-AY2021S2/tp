package seedu.fridgefriend.exception;

/**
 * Signal that the input format of the date field is incorrect.
 */
public class InvalidDateException extends Exception {
    private static final String errorMessage = "Sorry my friend, the date must be in the form 'dd/mm/yy'.\n";

    public InvalidDateException(String message) {
        super(errorMessage + message);
    }
}
