package seedu.duke.notecommandexceptions;

import java.io.IOException;

import static seedu.duke.UiManager.getListOfLocations;

public class NonExistentLocationForNotesCommandException extends NotesException {
    @Override
    public String getMessage() {
        return "Location does not exists. :(( Please key in a valid location." +
                System.lineSeparator() +
                "\"List of locations: \"" +
                System.lineSeparator() +
                getListOfLocations();
    }
}
