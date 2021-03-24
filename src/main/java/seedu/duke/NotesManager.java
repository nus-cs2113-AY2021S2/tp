package seedu.duke;

import seedu.duke.notecommandexceptions.EmptyNoteException;
import seedu.duke.notecommandexceptions.InvalidNoteIndexException;
import seedu.duke.notecommandexceptions.NoLocationForNotesCommandException;
import seedu.duke.notecommandexceptions.NoNoteIndexException;
import seedu.duke.notecommandexceptions.NonExistentLocationForNotesCommandException;
import seedu.duke.notecommandexceptions.WrongInputFormatException;

import static seedu.duke.NotesCommandParser.parseAddNotesCommand;
import static seedu.duke.NotesCommandParser.parseDeleteNotesCommand;
import static seedu.duke.NotesCommandParser.parseListNotesCommand;

import java.util.ArrayList;
import java.util.List;

import static seedu.duke.NotesCommandParser.location;
import static seedu.duke.NotesCommandParser.note;
import static seedu.duke.NotesCommandParser.noteIndexInList;

public class NotesManager {

    public static final int LOCATIONS_COUNT = 25; //useless
    public static ArrayList<String> locationsList = new ArrayList<>(LOCATIONS_COUNT); //useless
    public static List<List<String>> locationNotesList = new ArrayList<>(LOCATIONS_COUNT); //scaled - useless
    public static int[] locationNotesCountList = new int[LOCATIONS_COUNT]; //scaled - useless

    //useless
    public NotesManager() {
        setLocationsList();
        instantiateLocationsNotesList();
        initialiseLocationNotesCountList();
    }
    //useless
    public static void setLocationsList() {
        locationsList.add("E1");
        locationsList.add("E1A");
        locationsList.add("E2");
        locationsList.add("E2A");
        locationsList.add("E3");
        locationsList.add("E3A");
        locationsList.add("E4");
        locationsList.add("E4A");
        locationsList.add("E5");
        locationsList.add("E6");
        locationsList.add("E7");
        locationsList.add("EA");
        locationsList.add("EW1");
        locationsList.add("EW1A");
        locationsList.add("EW2");
        locationsList.add("LT1");
        locationsList.add("LT2");
        locationsList.add("LT5");
        locationsList.add("LT6");
        locationsList.add("LT7");
        locationsList.add("LT7A");
        locationsList.add("IT");
        locationsList.add("T-LAB");
        locationsList.add("TECHNO EDGE");
        locationsList.add("AS1");
    }
    //useless
    public static void instantiateLocationsNotesList() {
        for (int i = 0; i < LOCATIONS_COUNT; i++)  {
            locationNotesList.add(new ArrayList<>());
        }
    }

    //useless
    public static void initialiseLocationNotesCountList() {
        for (int i = 0; i < LOCATIONS_COUNT; i++) {
            locationNotesCountList[i] = 0;
        }
    }

    public static void printListOfLocations() {
        for (int i = 0; i < LOCATIONS_COUNT; i++) {
            System.out.println(locationsList.get(i));
        }
    }

    //d
    public static void parseAddNotesCommandAndAddNotes(String input) {
        try {
            parseAddNotesCommand(input);
            addNotes();
        } catch (WrongInputFormatException e) {
            System.out.println("Please include a '/' in between the location and the notes.");
        } catch (NoLocationForNotesCommandException e) {
            System.out.println("Please add a location to the command before the notes. :))");
            System.out.println();
            System.out.println("List of locations: ");
            printListOfLocations();
        } catch (NonExistentLocationForNotesCommandException e) {
            System.out.println("Location does not exists. :(( Please key in a valid location.");
            System.out.println();
            System.out.println("List of locations: ");
            printListOfLocations();
        } catch (EmptyNoteException e) {
            System.out.println("Please add a note behind. :))");
        }
    }

    //revamp - useless
    public static void addNotes() {
        int locationIndex = locationsList.indexOf(location);

        locationNotesList.get(locationIndex).add(note); //add notes to list for that location
        locationNotesCountList[locationIndex]++; //add to count for number of notes made for that location
        System.out.println("This note has been added and tagged to " + location + ":");
        System.out.println("\t" + note);
    }
    //d
    public static void parseDeleteNotesCommandAndDeleteNotes(String input) {
        try {
            parseDeleteNotesCommand(input);
            deleteNotes();
        } catch (WrongInputFormatException e) {
            System.out.println("Please include a '/' in between the location and the note index.");
        } catch (NoLocationForNotesCommandException e) {
            System.out.println("Please add a location to the command before the note index. :))");
            System.out.println();
            System.out.println("List of locations: ");
            printListOfLocations();
        } catch (NonExistentLocationForNotesCommandException e) {
            System.out.println("Location does not exists. :(( Please key in a valid location.");
            System.out.println();
            System.out.println("List of locations: ");
            printListOfLocations();
        } catch (NoNoteIndexException e) {
            System.out.println("Please add a note index behind. :))");
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number for note index.");
        } catch (InvalidNoteIndexException e) {
            System.out.print("Please enter a number that is positive and not more than ");
            System.out.println(locationNotesCountList[locationsList.indexOf(location)]);
        }
    }

    //revamp - useless
    public static void deleteNotes() {
        int locationIndex = locationsList.indexOf(location);

        final String deletedNote = locationNotesList.get(locationIndex).get(noteIndexInList); //record down deleted note

        locationNotesList.get(locationIndex).remove(noteIndexInList); //remove note using given Note Index from list
        locationNotesCountList[locationIndex]--; //reduce count for number of notes made for that location
        System.out.println("This note tagged to " + location + " has been deleted:");
        System.out.println("\t" + deletedNote);
    }
    //to be edit
    public static void parseListNotesCommandAndListNotes(String input) {
        try {
            parseListNotesCommand(input);
            listNotes();
        } catch (NoLocationForNotesCommandException e) {
            System.out.println("Please add a location after the command. :))");
            System.out.println();
            System.out.println("List of locations: ");
            printListOfLocations();
        } catch (NonExistentLocationForNotesCommandException e) {
            System.out.println("Location does not exists. :(( Please key in a valid location.");
            System.out.println();
            System.out.println("List of locations: ");
            printListOfLocations();
        }
    }
    //revamp - useless
    public static void listNotes() {
        for (int i = 1; i <= locationNotesCountList[locationsList.indexOf(location)]; i++) {
            int currentNoteIndex = i;
            System.out.print("\t");
            System.out.print(currentNoteIndex + ". ");
            System.out.println(locationNotesList.get(locationsList.indexOf(location)).get(currentNoteIndex - 1));
        }
    }

}

