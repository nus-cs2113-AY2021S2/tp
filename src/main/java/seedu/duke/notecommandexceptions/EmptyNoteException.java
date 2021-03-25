package seedu.duke.notecommandexceptions;

public class EmptyNoteException extends NotesException {
    @Override
    public String getMessage() {
        return "Please add a note behind. :))";
    }
}
