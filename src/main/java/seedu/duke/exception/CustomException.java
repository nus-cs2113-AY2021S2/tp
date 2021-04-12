package seedu.duke.exception;

/**
 * Signals the caller that there was something wrong, allowing the caller to extract
 * the message to raise a more meaningful/higher-level exception.
 */
public class CustomException extends Exception {
    /**
     * @param message should contain relevant information on the failed constraint(s).
     */
    public CustomException(String message) {
        super(message);
    }
}
