package seedu.duke.exception;

public class InvalidNoteException extends NusMazeException {
    @Override
    public String getMessage() {
        return "Your note description cannot be empty or contain \"/\". Please try the command again :)";
    }
}
