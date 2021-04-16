package seedu.duke.exception;

public class InvalidCommandException extends NusMazeException {
    @Override
    public String getMessage() {
        return "OOPS! I'm sorry but I don't understand your command :(";
    }
}
