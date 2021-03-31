package seedu.duke.exception;

public class EmptyNoteException extends NusMazeException {
    @Override
    public String getMessage() {
        return "There are no notes tagged to %s";
    }
}
