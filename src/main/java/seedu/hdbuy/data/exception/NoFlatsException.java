package seedu.hdbuy.data.exception;

public class NoFlatsException extends Exception {
    public NoFlatsException() {
        super("Please choose another filter.");
    }
}
