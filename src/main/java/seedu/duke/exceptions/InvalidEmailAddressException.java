package seedu.duke.exceptions;

public class InvalidEmailAddressException extends Exception {
    public InvalidEmailAddressException(String email) {
        super("\"" + email + "\" is not a valid email.");
    }
}
