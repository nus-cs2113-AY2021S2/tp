package seedu.fridgefriend.exception;

//@@author Vinci-Hu
/**
 * Signal that the new foodname user wants to add cannot be used.
 */
public class RepetitiveFoodIdentifierException extends Exception {
    private static final String errorMessage = "Sorry my friend, you have added this food before.\n"
            + "It is in a different category or location or have a different expiry date.\n"
            + "Please specify another foodname.";

    public RepetitiveFoodIdentifierException() {
        super(errorMessage);
    }
}