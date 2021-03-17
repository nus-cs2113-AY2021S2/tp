package seedu.connoisseur.exceptions;

public class InvalidReviewDescriptionException extends ConnoisseurException {
    /**
     * Creates connoisseur for methods to throw.
     */
    public InvalidReviewDescriptionException() {
        super("Please input valid description!\n"
                + "\tTo view an example, type 'help'!\n");
    }
}
