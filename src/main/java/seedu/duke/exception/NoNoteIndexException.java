package seedu.duke.exception;

public class NoNoteIndexException extends NotesException {

    @Override
    public String getMessage() {
        return "Please add a note index behind. :))";
    }
}
