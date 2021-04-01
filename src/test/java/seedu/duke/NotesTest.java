package seedu.duke;

import org.junit.jupiter.api.Test;

import seedu.duke.data.NusMap;
import seedu.duke.ui.NoteUi;
import seedu.duke.exception.InvalidIndexException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class NotesTest {

    NoteUi ui = new NoteUi();

    @Test
    public void test() throws InvalidIndexException {
        //add notes:
        addNotes_successfully();

        addNotes_unsuccessfully();

        //delete notes:
        try {
            deleteNotes_successfully();
        } catch (InvalidIndexException e) {
            ui.showMessageWithDivider(e.getMessage());
        }

        try {
            deleteNotes_unsuccessfully();
        } catch (InvalidIndexException e) {
            ui.showMessageWithDivider(e.getMessage());
        }

    }

    public void addNotes_successfully() {
        NusMap nusMap = new NusMap();
        nusMap.getBlock("LT7").addNote("@gmail");
        nusMap.getBlock("LT7").addNote("Newbie");
        ArrayList<String> notes = new ArrayList<>();
        notes.add("@gmail");
        notes.add("Newbie");
        assertEquals(nusMap.getBlock("LT7").getNotes(), notes);
    }

    public void addNotes_unsuccessfully() {
        NusMap nusMap = new NusMap();
        nusMap.getBlock("LT7").addNote("@gmail");
        ArrayList<String> notes = new ArrayList<>();
        notes.add("@gmail");
        notes.add("Newbie");
        assertNotEquals(nusMap.getBlock("LT7").getNotes(), notes);
    }

    public void deleteNotes_successfully() throws InvalidIndexException {
        NusMap nusMap = new NusMap();
        nusMap.getBlock("E4").addNote("Hi");
        nusMap.getBlock("E4").addNote("Party");
        nusMap.getBlock("E4").deleteNote(0); //1
        ArrayList<String> notes = new ArrayList<>();
        notes.add("Party");
        assertEquals(nusMap.getBlock("E4").getNotes(), notes);
    }

    public void deleteNotes_unsuccessfully() throws InvalidIndexException {
        NusMap nusMap = new NusMap();
        nusMap.getBlock("E4").addNote("Hi");
        nusMap.getBlock("E4").addNote("Party");
        nusMap.getBlock("E4").deleteNote(1);
        ArrayList<String> notes = new ArrayList<>();
        notes.add("Hi");
        assertNotEquals(nusMap.getBlock("E4").getNotes(), notes);
    }
}
