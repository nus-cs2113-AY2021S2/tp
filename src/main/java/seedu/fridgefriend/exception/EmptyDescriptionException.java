package seedu.fridgefriend.exception;

/**
 * Signal that the input format given does not fulfill the criteria.
 */
public class EmptyDescriptionException extends Exception {
    private static final String errorMessage = "Sorry my friend, the description cannot be empty.\n";

    public EmptyDescriptionException() {
        super(errorMessage);
    }
}
