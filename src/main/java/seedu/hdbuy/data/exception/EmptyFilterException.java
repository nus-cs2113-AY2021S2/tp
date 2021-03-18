package seedu.hdbuy.data.exception;

public class EmptyFilterException extends Exception{
    public EmptyFilterException() {
        super("The filter is currently empty.");
    }

}
