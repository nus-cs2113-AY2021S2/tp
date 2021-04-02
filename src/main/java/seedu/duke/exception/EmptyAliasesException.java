//@@author Rizavur

package seedu.duke.exception;

public class EmptyAliasesException extends NusMazeException {
    @Override
    public String getMessage() {
        return "You haven't set any aliases yet!";
    }
}
