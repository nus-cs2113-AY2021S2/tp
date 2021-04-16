package seedu.duke.exception;

public class NoAliasNameException extends NusMazeException {
    @Override
    public String getMessage() {
        return "Invalid alias! Please enter an alias name that exists!";
    }
}
