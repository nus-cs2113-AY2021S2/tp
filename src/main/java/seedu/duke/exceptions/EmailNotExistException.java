package seedu.duke.exceptions;

public class EmailNotExistException extends Exception {
    public EmailNotExistException(String email) {
        super(email + " is not in our system.");
    }
}
