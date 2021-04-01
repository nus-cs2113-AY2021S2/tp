package seedu.duke;

import org.junit.jupiter.api.Test;

import seedu.duke.data.Block;
import seedu.duke.data.NusMap;
import seedu.duke.exception.EmptyNoteException;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.ui.NoteUi;
import seedu.duke.exception.InvalidIndexException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class NotesTest {

    NoteUi ui = new NoteUi();

    @Test
    public void test() {
        //add notes:
        addNoteCommandExecute_validLocation_success();
        addNoteCommandExecute_invalidLocation_exceptionThrown();

        //delete notes:
        deleteNotes_indexWithinRange_success();
        deleteNotesCommandExecution_indexOutOfRange_exceptionThrown();

        //show notes:
        showNotesCommand_nonEmptyList_success();
        showNotesCommand_emptyList_exceptionThrown();
    }

    @Test
    public void addNoteCommandExecute_validLocation_success() {
        try {
            NusMap nusMap = new NusMap();
            nusMap.checkIfValidBlock("COM1");
            Block block = nusMap.getBlock("COM1");
            block.addNote("@gmail");
            block.addNote("password: Newbie");
            ArrayList<String> notes = new ArrayList<>();
            notes.add("@gmail");
            notes.add("password: Newbie");
            assertEquals(nusMap.getBlock("COM1").getNotes(), notes);
        } catch (InvalidBlockException e) {
            assertEquals("Invalid block! Please enter the command again to retry!", e.getMessage());
        }
    }

    @Test
    public void addNoteCommandExecute_invalidLocation_exceptionThrown() {
        try {
            NusMap nusMap = new NusMap();
            nusMap.checkIfValidBlock("TESCO SUPER-MART"); //throws exception
            Block block = nusMap.getBlock("TESCO SUPER-MART"); //should not reach here
            block.addNote("1. buy 2 packs of cereal");
        } catch (InvalidBlockException e) {
            assertEquals("Invalid block! Please enter the command again to retry!", e.getMessage());
        }
    }

    @Test
    public void deleteNotes_indexWithinRange_success() {
        try {
            NusMap nusMap = new NusMap();
            nusMap.getBlock("E4").addNote("BBQ Party :D");
            nusMap.getBlock("E4").addNote("Badminton game with friends! :D");
            nusMap.getBlock("E4").addNote("Play Games @ Engineering Fair! :))");
            nusMap.getBlock("E4").deleteNote(1); //delete 2nd note
            ArrayList<String> notes = new ArrayList<>();
            notes.add("BBQ Party :D");
            notes.add("Play Games @ Engineering Fair! :))");
            assertEquals(nusMap.getBlock("E4").getNotes(), notes);
        } catch (InvalidIndexException e) {
            assertEquals("Oops! You must enter an Integer that is within the bounds!", e.getMessage());
        }
    }

    @Test
    public void deleteNotesCommandExecution_indexOutOfRange_exceptionThrown() {
        try {
            NusMap nusMap = new NusMap();
            nusMap.getBlock("MAXX COFFEE").addNote("Special event today at 12 noon :))");
            nusMap.getBlock("MAXX COFFEE").addNote("Get the latest Pistachio Latte.");
            nusMap.getBlock("MAXX COFFEE").deleteNote(7); //delete first note
            ArrayList<String> notes = new ArrayList<>(); //should not reach this line
            assertEquals(nusMap.getBlock("MAXX COFFEE").getNotes(), notes);
        } catch (InvalidIndexException e) {
            assertEquals("Oops! You must enter an Integer that is within the bounds!", e.getMessage());
        }
    }

    public void showNotesCommand_nonEmptyList_success() {
        try {
            NusMap nusMap = new NusMap();
            nusMap.checkIfValidBlock("CENTRAL LIBRARY");
            nusMap.getBlock("CENTRAL LIBRARY").addNote("Orbital project meeting at 2 :))");
            ArrayList<String> notes = nusMap.getBlock("CENTRAL LIBRARY").getNotes();
            if (notes.isEmpty()) {
                throw new EmptyNoteException();
            }
            ArrayList<String> notesDuplicate = new ArrayList<>();
            notesDuplicate.add("Orbital project meeting at 2 :))");
            assertEquals(notes, notesDuplicate);
        } catch (EmptyNoteException e) {
            assertEquals("Oops! There are no notes tagged to CENTRAL LIBRARY",
                    String.format(e.getMessage(), "CENTRAL LIBRARY")); //should not reach here
        } catch (InvalidBlockException e) {
            assertEquals("Invalid block! Please enter the command again to retry!", e.getMessage());
        }
    }

    public void showNotesCommand_emptyList_exceptionThrown() {
        try {
            NusMap nusMap = new NusMap();
            nusMap.checkIfValidBlock("CENTRAL LIBRARY");
            ArrayList<String> notes = nusMap.getBlock("CENTRAL LIBRARY").getNotes();
            if (notes.isEmpty()) {
                throw new EmptyNoteException(); //EmptyNoteException thrown
            }
            ArrayList<String> notesDuplicate = new ArrayList<>(); //should not reach here
            assertEquals(notes, notesDuplicate);
        } catch (EmptyNoteException e) {
            assertEquals("Oops! There are no notes tagged to CENTRAL LIBRARY",
                    String.format(e.getMessage(), "CENTRAL LIBRARY"));
        } catch (InvalidBlockException e) {
            assertEquals("Invalid block! Please enter the command again to retry!", e.getMessage());
        }
    }
}
