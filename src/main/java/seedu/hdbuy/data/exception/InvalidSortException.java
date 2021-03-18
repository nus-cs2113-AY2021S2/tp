package seedu.hdbuy.data.exception;

public class InvalidSortException extends Exception{
    public InvalidSortException() {
        super("You must enter the correct parameters.");
    }
}
