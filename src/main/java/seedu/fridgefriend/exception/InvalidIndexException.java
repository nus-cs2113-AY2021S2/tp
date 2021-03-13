package seedu.fridgefriend.exception;

public class InvalidIndexException extends Exception {
    private static final String errorMessage = "Please enter a valid index to remove food.\n";

    public InvalidIndexException(Exception e) {
        super(errorMessage + e.getLocalizedMessage());
    }
}