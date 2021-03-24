package seedu.duke.exception;

public class InvalidAliasException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid alias! Please enter a valid alias name!";
    }
}
