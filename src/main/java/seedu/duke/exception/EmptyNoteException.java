package seedu.duke.exception;

import java.io.IOException;

public class EmptyNoteException extends NusMazeException {
    @Override
    public String getMessage() {
        return "There are no notes tagged to %d";
    }
}
