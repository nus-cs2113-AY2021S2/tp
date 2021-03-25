package seedu.duke.notecommandexceptions;

import seedu.duke.Map;

import static seedu.duke.NotesCommandParser.location;

public class InvalidNoteIndexException extends NotesException {

    //@Override
    public String getMessage(Map nusMap) {

        return "Please enter a number that is positive and not more than "
                + nusMap.map.get(location).getNotesCount();
    }
}
