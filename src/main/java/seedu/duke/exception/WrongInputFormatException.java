package seedu.duke.exception;

public class WrongInputFormatException extends NotesException {
    @Override
    public String getMessage() {

        return "Please include a '/' in between the location and the note "
                + "or between the location and the notes index.";
    }
}
