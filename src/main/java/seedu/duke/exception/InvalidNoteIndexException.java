package seedu.duke.exception;

import seedu.duke.data.NusMap;

import static seedu.duke.NotesCommandParser.location;

public class InvalidNoteIndexException extends NotesException {

    //@Override
    public String getMessage(NusMap nusMap) {

        return "Please enter a number that is positive and not more than "
                + nusMap.map.get(location).getNotesCount();
    }
}
