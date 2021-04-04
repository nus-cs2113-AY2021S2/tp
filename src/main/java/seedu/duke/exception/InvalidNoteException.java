package seedu.duke.exception;

public class InvalidNoteException extends NusMazeException {
    @Override
    public String getMessage() {
        return "Your note description cannot be empty! Please try the command again :)";
    }
}
