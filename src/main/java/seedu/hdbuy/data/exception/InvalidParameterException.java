package seedu.hdbuy.data.exception;

public class InvalidParameterException extends Exception {
    public InvalidParameterException() {
        super("You must enter at least 1 more parameter.");
    }
}
