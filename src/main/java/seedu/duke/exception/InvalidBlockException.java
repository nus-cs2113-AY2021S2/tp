package seedu.duke.exception;

public class InvalidBlockException extends NusMazeException {
    @Override
    public String getMessage() {
        return "Invalid block! Please enter the command again to retry!";
    }
}
