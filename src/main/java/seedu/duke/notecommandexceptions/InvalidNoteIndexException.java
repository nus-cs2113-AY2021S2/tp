package seedu.duke.notecommandexceptions;

import static seedu.duke.NotesCommandParser.location;
import static seedu.duke.Map.map;

public class InvalidNoteIndexException extends NotesException {
//"Please enter a number that is positive and not more than " + block.count
    @Override
    public String getMessage() {

        return "Please enter a number that is positive and not more than "
                + map.get(location).getNotesCount();
    }
}
