package seedu.duke.exception;

public class InvalidBlockException extends NusMazeException {
    @Override
    public String getMessage() {
        return "Invalid block! Please try again with a block that exists :(";
    }
}
