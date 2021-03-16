package seedu.connoisseur.exceptions;

public class InvalidReviewCommandException extends ConnoisseurException{
    /**
     * Creates connoisseur for methods to throw.
     */
    public InvalidReviewCommandException() {
        super("Please enter a valid command!\n"
                + "\tTo view an example, type 'help'!\n");
    }
}
