package seedu.duke.exception;

public class RepeatedBlockException extends NusMazeException {
    @Override
    public String getMessage() {
        return "Repeated block! Please a different block!";
    }
}
