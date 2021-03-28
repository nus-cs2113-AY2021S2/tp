package seedu.duke;

import seedu.duke.notecommandexceptions.EmptyNoteException;
import seedu.duke.notecommandexceptions.InvalidNoteIndexException;
import seedu.duke.notecommandexceptions.NoLocationForNotesCommandException;
import seedu.duke.notecommandexceptions.NoNoteIndexException;
import seedu.duke.notecommandexceptions.NonExistentLocationForNotesCommandException;
import seedu.duke.notecommandexceptions.WrongInputFormatException;

public class NotesCommandParser {

    private static final int ADDNOTELENGTH = 7;
    private static final int DELETENOTELENGTH = 10;
    public static final int LISTNOTESLENGTH = 9;

    public static String location;
    public static String note;
    public static int noteIndexInList;

    public NotesCommandParser() {

    }

    public static int getLocation(String input, Map nusMap) throws WrongInputFormatException,
            NoLocationForNotesCommandException,
            NonExistentLocationForNotesCommandException {
        //1. Filter out location (UPPERCASE) from input:
        String lowerCaseInputWithNoSpaces = input.toLowerCase().replaceAll("\\s","");
        if (!lowerCaseInputWithNoSpaces.contains("/")) {
            throw new WrongInputFormatException();
        }
        int beforeNoteIndex = lowerCaseInputWithNoSpaces.indexOf("/");
        assert beforeNoteIndex >= ADDNOTELENGTH : "beforeNoteIndex should not be less than 7 after checking for format";
        String commandWithLocation = lowerCaseInputWithNoSpaces.substring(0, beforeNoteIndex);
        if (commandWithLocation.startsWith("addnote")) {
            //take out location and store location as UPPERCASE:
            int indexOfLocation = ADDNOTELENGTH;
            location = commandWithLocation.substring(indexOfLocation).toUpperCase();
        } else if (commandWithLocation.startsWith("deletenote")) {
            //take out location and store location as UPPERCASE:
            int indexOfLocation = DELETENOTELENGTH;
            location = commandWithLocation.substring(indexOfLocation).toUpperCase();
        }

        //for locations with spacing: add the spacing back
        if (location.equals("TECHNOEDGE")) {
            location = "TECHNO EDGE";
        }
        //if there is no user input for the location, throw an exception:
        if (location.isEmpty()) {
            throw new NoLocationForNotesCommandException();
        }
        //if location does not exists in current list of locations in the program:
        if (!nusMap.map.containsKey(location)) {
            throw new NonExistentLocationForNotesCommandException();
        }

        return beforeNoteIndex;
    }

    public static void getNotes(String input) throws EmptyNoteException {
        //2. Filter out notes (original case) added by user:
        String originalInputWithNoSpaces = input.replaceAll("\\s","");
        int notesIndexForOriginalInputWithNoSpaces = originalInputWithNoSpaces.indexOf("/") + 1;
        note = originalInputWithNoSpaces.substring(notesIndexForOriginalInputWithNoSpaces);
        //if no notes added by user:
        if (note.isEmpty() || note.isBlank()) {
            throw new EmptyNoteException();
        }
        int notesIndexForOriginalInput = input.indexOf("/") + 1;
        note = input.substring(notesIndexForOriginalInput).trim();
    }

    public static void getNoteIndex(String input, int beforeNoteNumberIndex, Map nusMap)
            throws NoNoteIndexException, InvalidNoteIndexException {
        //2. Filter out Note Index added by user:
        int noteNumberIndex = beforeNoteNumberIndex + 1;

        String lowerCaseInputWithNoSpaces = input.toLowerCase().replaceAll("\\s","");
        String noteIndexString = lowerCaseInputWithNoSpaces.substring(noteNumberIndex);

        //if no note index provided by user:
        if (noteIndexString.isEmpty() || noteIndexString.isBlank()) {
            throw new NoNoteIndexException();
        }
        int noteIndex = Integer.parseInt(noteIndexString); //throws NumberFormatException
        //if noteIndex is invalid (not within the total number of notes made for that location):
        if (noteIndex < 1 || noteIndex > nusMap.map.get(location).getNotesCount()) {
            throw new InvalidNoteIndexException();
        }
        noteIndexInList = noteIndex - 1;
    }

    public static void parseAddNotesCommand(String input, Map nusMap)
            throws WrongInputFormatException, NoLocationForNotesCommandException,
            NonExistentLocationForNotesCommandException, EmptyNoteException {

        //1. Filter out location (UPPERCASE) from input:
        getLocation(input, nusMap);
        //2. Filter out notes (original case) added by user:
        getNotes(input);
    }

    public static void parseDeleteNotesCommand(String input, Map nusMap)
            throws WrongInputFormatException, NoLocationForNotesCommandException,
            NonExistentLocationForNotesCommandException, NoNoteIndexException, InvalidNoteIndexException {

        //1. Filter out location (UPPERCASE) from input:
        int beforeNoteNumberIndex = getLocation(input, nusMap);
        //2. Filter out Note Index added by user:
        getNoteIndex(input, beforeNoteNumberIndex, nusMap);

    }

    public static void parseListNotesCommand(String input, Map nusMap)
            throws NoLocationForNotesCommandException, NonExistentLocationForNotesCommandException  {
        //1. Filter out location (UPPERCASE) from input:
        String lowerCaseInputWithNoSpaces = input.toLowerCase().replaceAll("\\s","");
        String commandWithLocation = lowerCaseInputWithNoSpaces;
        int indexOfLocation = LISTNOTESLENGTH;
        location = commandWithLocation.substring(indexOfLocation).toUpperCase();

        //for locations with spacing: add the spacing back
        if (location.equals("TECHNOEDGE")) {
            location = "TECHNO EDGE";
        }
        //if there is no user input for the location, throw an exception:
        if (location.isEmpty()) {
            throw new NoLocationForNotesCommandException();
        }
        //if location does not exists in current list of locations in the program:
        if (!nusMap.map.containsKey(location)) {
            throw new NonExistentLocationForNotesCommandException();
        }
    }

}

