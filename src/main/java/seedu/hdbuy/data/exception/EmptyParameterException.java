package seedu.hdbuy.data.exception;

public class EmptyParameterException extends Exception {
    public EmptyParameterException() {
        super(" has no parameters currently.");
    }
}
