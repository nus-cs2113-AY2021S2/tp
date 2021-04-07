package seedu.fridgefriend.exception;

//@@author kwokyto
/**
 * Signal that the input format of the date field is incorrect.
 */
public class InvalidDateException extends Exception {
    public InvalidDateException(String message) {
        super(message);
    }
}
