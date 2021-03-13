package seedu.duke;

import seedu.duke.notecommandexceptions.*;

import static seedu.duke.NotesManager.locationsList;
import static seedu.duke.NotesManager.locationNotesCountList;

public class NotesCommandParser {

    public static String location;
    public static String note;
    public static int noteIndexInList;

    public NotesCommandParser() {

    }

    public static void parseAddNotesCommand(String input) throws WrongInputFormatException, NoLocationForNotesCommandException, NonExistentLocationForNotesCommandException, EmptyNoteException {
        //1. Filter out location (UPPERCASE) from input:
        String lowerCaseInputWithNoSpaces = input.toLowerCase().replaceAll("\\s","");
        if (!lowerCaseInputWithNoSpaces.contains("/")) {
            throw new WrongInputFormatException();
        }
        int beforeDescriptionIndex = lowerCaseInputWithNoSpaces.indexOf("/");
        String commandWithLocation = lowerCaseInputWithNoSpaces.substring(0, beforeDescriptionIndex);
        if (commandWithLocation.startsWith("addnote")) {
            //take out location and store location as UPPERCASE:
            int indexOfLocation = 7;
            location = commandWithLocation.substring(indexOfLocation).toUpperCase();
        }
        //if there is no user input for the location, throw an exception:
        if (location.isEmpty()) {
            throw new NoLocationForNotesCommandException();
        }
        //if location does not exists in current list of locations in the program:
        if (!locationsList.contains(location)) {
            throw new NonExistentLocationForNotesCommandException();
        }

        //2. Filter out notes (original case) added by user:
        String originalInputWithNoSpaces = input.replaceAll("\\s","");
        int notesIndexForOriginalInputWithNoSpaces = originalInputWithNoSpaces.indexOf("/") + 1;
        note = originalInputWithNoSpaces.substring(notesIndexForOriginalInputWithNoSpaces);
        //if no notes added by user:
        if (note.isEmpty() || note.isBlank()) {
            throw new EmptyNoteException();
        }
        int notesIndexForOriginalInput = input.indexOf("/") + 1;;
        note = input.substring(notesIndexForOriginalInput).trim();
    }

    public static void parseDeleteNotesCommand(String input) throws WrongInputFormatException, NoLocationForNotesCommandException, NonExistentLocationForNotesCommandException, NoNoteIndexException, InvalidNoteIndexException {
        //1. Filter out location (UPPERCASE) from input:
        String lowerCaseInputWithNoSpaces = input.toLowerCase().replaceAll("\\s","");
        if (!lowerCaseInputWithNoSpaces.contains("/")) {
            throw new WrongInputFormatException();
        }
        int beforeNoteNumberIndex = lowerCaseInputWithNoSpaces.indexOf("/");
        String commandWithLocation = lowerCaseInputWithNoSpaces.substring(0, beforeNoteNumberIndex);
        if (commandWithLocation.startsWith("deletenote")) {
            //take out location and store location as UPPERCASE:
            int indexOfLocation = 10;
            location = commandWithLocation.substring(indexOfLocation).toUpperCase();
        }
        //if there is no user input for the location, throw an exception:
        if (location.isEmpty()) {
            throw new NoLocationForNotesCommandException();
        }
        //if location does not exists in current list of locations in the program:
        if (!locationsList.contains(location)) {
            throw new NonExistentLocationForNotesCommandException();
        }

        //2. Filter out Note Index added by user:
        int noteNumberIndex = beforeNoteNumberIndex + 1;
        String noteIndexString = lowerCaseInputWithNoSpaces.substring(noteNumberIndex);
        //if no note index provided by user:
        if (noteIndexString.isEmpty() || noteIndexString.isBlank()) {
            throw new NoNoteIndexException();
        }
        int noteIndex = Integer.parseInt(noteIndexString); //throws NumberFormatException if user did not input a proper number for the note index
        //if noteIndex is invalid (not within the total number of notes made for that location):
        if (noteIndex < 1 || noteIndex > locationNotesCountList[locationsList.indexOf(location)]) {
            throw new InvalidNoteIndexException();
        }
        noteIndexInList = noteIndex - 1;
    }

    public static void parseListNotesCommand(String input) throws NoLocationForNotesCommandException, NonExistentLocationForNotesCommandException  {
        //1. Filter out location (UPPERCASE) from input:
        String lowerCaseInputWithNoSpaces = input.toLowerCase().replaceAll("\\s","");
        String commandWithLocation = lowerCaseInputWithNoSpaces;
        if (commandWithLocation.startsWith("listnotes")) {
            //take out location and store location as UPPERCASE:
            int indexOfLocation = 9;
            location = commandWithLocation.substring(indexOfLocation).toUpperCase();
        }
        //if there is no user input for the location, throw an exception:
        if (location.isEmpty()) {
            throw new NoLocationForNotesCommandException();
        }
        //if location does not exists in current list of locations in the program:
        if (!locationsList.contains(location)) {
            throw new NonExistentLocationForNotesCommandException();
        }
    }

}

