package seedu.duke.exception;

public class InvalidAliasException extends NusMazeException {
    @Override
    public String getMessage() {
        return "Invalid alias! Please enter the command again to retry!";
    }
}
