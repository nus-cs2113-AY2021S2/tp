package seedu.fridgefriend.exception;

/**
 * Signals that the format of the quantity field is incorrect.
 */
public class InvalidQuantityException extends Exception {
    private static final String errorMessage = "Sorry my friend, the quantity "
            + "must be in the form 'digits_unit' or 'digits'.";

    public InvalidQuantityException() {
        super(errorMessage);
    }
}
