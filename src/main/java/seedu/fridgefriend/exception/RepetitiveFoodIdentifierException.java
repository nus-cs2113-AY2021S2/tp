package seedu.fridgefriend.exception;

/**
 * Signal that the new foodname user wants to add cannot be used.
 */
public class RepetitiveFoodIdentifierException extends Exception {
    private static final String errorMessage = "Sorry my friend, you have added this food before "
            + "but in a different location or have different expiry dates. "
            + "Please specify another foodname.";

    public RepetitiveFoodIdentifierException() {
        super(errorMessage);
    }
}