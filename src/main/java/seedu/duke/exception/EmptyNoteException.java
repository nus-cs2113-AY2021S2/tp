//@@author KimIdeas8
package seedu.duke.exception;

public class EmptyNoteException extends NusMazeException {
    @Override
    public String getMessage() {
        return "Oops! There are no notes tagged to %s";
    }
}
