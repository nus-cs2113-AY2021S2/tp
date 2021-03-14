package seedu.duke.exception;

/**
 * Main class for all exceptions within the program.
 */
public class DukeException extends Exception {

    /**
     * Sole constructor for DukeException. Requires all exceptions to have an error message.
     * @param message error message of the exception
     */
    public DukeException(String message) {
        super(message);
    }
}
