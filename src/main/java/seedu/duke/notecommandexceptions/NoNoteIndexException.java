package seedu.duke.notecommandexceptions;

import java.io.IOException;

import static seedu.duke.UiManager.getListOfLocations;

public class NoNoteIndexException extends NotesException {

    @Override
    public String getMessage() {
        return "Please add a note index behind. :))";
    }
}
