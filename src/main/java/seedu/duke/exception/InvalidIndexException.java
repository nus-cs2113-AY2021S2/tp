package seedu.duke.exception;

public class InvalidIndexException extends NusMazeException {
    @Override
    public String getMessage() {
        return "Oops! You must enter an Integer that is within the bounds :(";
    }
}
