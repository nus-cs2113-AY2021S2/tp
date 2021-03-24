package seedu.duke.notecommandexceptions;

import java.io.IOException;

public class EmptyNoteException extends NotesException {
    @Override
    public String getMessage() {
        return "Please add a note behind. :))";
    }
}
