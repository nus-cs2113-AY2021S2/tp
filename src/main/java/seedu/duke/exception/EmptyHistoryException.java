//@@author Rye98
package seedu.duke.exception;

public class EmptyHistoryException extends NusMazeException {
    @Override
    public String getMessage() {
        return "Oops! You have no past history!";
    }
}
