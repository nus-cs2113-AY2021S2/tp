//@@author Rizavur

package seedu.duke.exception;

public class InvalidAliasException extends NusMazeException {
    @Override
    public String getMessage() {
        return "Invalid alias! Please enter a valid alias name!";
    }
}
