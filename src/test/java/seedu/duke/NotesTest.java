package seedu.duke;

import org.junit.jupiter.api.Test;

import seedu.duke.data.Block;
import seedu.duke.data.NusMap;
import seedu.duke.exception.EmptyNoteException;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.InvalidIndexException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotesTest {

    public void addNoteTest(String location) throws InvalidBlockException {
        NusMap nusMap = new NusMap();
        nusMap.checkIfValidBlock(location);
        Block block = nusMap.getBlock(location);
        block.addNote("@gmail");
        block.addNote("password: Newbie");
        ArrayList<String> notes = new ArrayList<>();
        notes.add("@gmail");
        notes.add("password: Newbie");
        assertEquals(nusMap.getBlock(location).getNotes(), notes);
    }

    @Test
    public void addNoteCommandExecute_validLocation_success() {
        try {
            addNoteTest("COM1");
            addNoteTest("STARBUCKS");
        } catch (InvalidBlockException e) {
            assertEquals("Invalid block! Please enter the command again to retry!", e.getMessage());
        }
    }

    @Test
    public void addNoteCommandExecute_invalidLocation_exceptionThrown() {
        try {
            addNoteTest("TESCO SUPER-MART");
            addNoteTest("GRAND HALL");
        } catch (InvalidBlockException e) {
            assertEquals("Invalid block! Please check your start and destination block again :(",
                    e.getMessage());
        }
    }

    public void deleteNotesTest(int index) throws InvalidIndexException {
        NusMap nusMap = new NusMap();
        Block block = nusMap.getBlock("MAXX COFFEE");
        block.addNote("Special event today at 12 noon :))");
        block.addNote("Girl's gathering @ 5pm today. :D");
        block.addNote("Get the latest Pistachio Latte.");
        block.deleteNote(index);
        ArrayList<String> notes = new ArrayList<>();
        switch (index) {
        case 0:
            notes.add("Girl's gathering @ 5pm today. :D");
            notes.add("Get the latest Pistachio Latte.");
            break;
        case 1:
            notes.add("Special event today at 12 noon :))");
            notes.add("Get the latest Pistachio Latte.");
            break;
        case 2:
            notes.add("Special event today at 12 noon :))");
            notes.add("Girl's gathering @ 5pm today. :D");
            break;
        default:
            break;
        }
        assertEquals(block.getNotes(), notes);
    }

    @Test
    public void deleteNotes_indexWithinRange_success() {
        try {
            deleteNotesTest(0);
            deleteNotesTest(1);
            deleteNotesTest(2);
        } catch (InvalidIndexException e) {
            assertEquals("Oops! You must enter an Integer that is within the bounds :(", e.getMessage());
        }
    }

    @Test
    public void deleteNotesCommandExecution_indexOutOfRange_exceptionThrown() {
        try {
            deleteNotesTest(-1);
            deleteNotesTest(7);
        } catch (InvalidIndexException e) {
            assertEquals("Oops! You must enter an Integer that is within the bounds :(", e.getMessage());
        }
    }

    public void showNotesTest(NusMap nusMap) throws EmptyNoteException {
        ArrayList<String> notes = nusMap.getBlock("CENTRAL LIBRARY").getNotes();
        if (notes.isEmpty()) {
            throw new EmptyNoteException();
        }
        ArrayList<String> notesDuplicate = new ArrayList<>();
        notesDuplicate.add("Orbital project meeting at 2 :))");
        assertEquals(notes, notesDuplicate);
    }

    @Test
    public void showNotesCommand_nonEmptyList_success() {
        try {
            NusMap nusMap = new NusMap();
            nusMap.getBlock("CENTRAL LIBRARY").addNote("Orbital project meeting at 2 :))");
            showNotesTest(nusMap);
        } catch (EmptyNoteException e) {
            assertEquals("Oops! There are no notes tagged to CENTRAL LIBRARY",
                    String.format(e.getMessage(), "CENTRAL LIBRARY")); //should not reach here
        }
    }

    @Test
    public void showNotesCommand_emptyList_exceptionThrown() {
        try {
            NusMap nusMap = new NusMap();
            showNotesTest(nusMap);
        } catch (EmptyNoteException e) {
            assertEquals("Oops! There are no notes tagged to CENTRAL LIBRARY",
                    String.format(e.getMessage(), "CENTRAL LIBRARY"));
        }
    }
}
