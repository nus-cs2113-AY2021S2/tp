package seedu.duke.exception;

public class SameBlockException extends NusMazeException {
    @Override
    public String getMessage() {
        return "Invalid Blocks! Your start and destination block is the same!";
    }
}
