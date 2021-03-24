package seedu.duke.notecommandexceptions;

import java.io.IOException;

import static seedu.duke.NotesCommandParser.location;
import static seedu.duke.routing.Map.map;

public class WrongInputFormatException extends NotesException {
    @Override
    public String getMessage() {

        return "Please include a '/' in between the location and the note " +
                "or between the location and the notes index.";
    }
}
