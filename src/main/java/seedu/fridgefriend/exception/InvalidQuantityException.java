package seedu.fridgefriend.exception;

//@@author SimJJ96
/**
 * Signals that the format of the quantity field is incorrect.
 */
public class InvalidQuantityException extends Exception {
    private static final String errorMessage = "Sorry my friend, the quantity "
            + "must be a positive number.";

    public InvalidQuantityException() {
        super(errorMessage);
    }

    public InvalidQuantityException(String msg) {
        super(msg);
    }
}
