package seedu.duke.exceptions;

public class InvalidCommandException extends Exception {

    public InvalidCommandException(String errorMessage) {
        super(errorMessage);
    }

}
