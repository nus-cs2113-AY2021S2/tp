package seedu.duke;

import org.junit.jupiter.api.Test;

import seedu.duke.command.Command;
import seedu.duke.exception.InvalidCommandException;
import seedu.duke.notecommandexceptions.EmptyNoteException;
import seedu.duke.notecommandexceptions.InvalidNoteIndexException;
import seedu.duke.notecommandexceptions.NoLocationForNotesCommandException;
import seedu.duke.notecommandexceptions.NoNoteIndexException;
import seedu.duke.notecommandexceptions.NonExistentLocationForNotesCommandException;
import seedu.duke.notecommandexceptions.WrongInputFormatException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class NotesParserTest {

    private Map nusMap;
    private UiManager ui;
    private History history;
    private DailyRoute dailyroute;
    private FavouriteLocation favouriteLocation;
    private BlockAlias blockAlias;

    private void initializeDuke() {
        this.nusMap = new Map();
        this.ui = new UiManager();
        this.history = new History();
        this.dailyroute = new DailyRoute();
        this.blockAlias = new BlockAlias();
        this.favouriteLocation = new FavouriteLocation();
    }

    @Test
    public void parseTest() {

        parseAddNotesCommandSuccessfully("add note E4/Bring Origami for GET lesson.", "E4",
                "Bring Origami for GET lesson.");
        parseAddNotesCommandSuccessfully("add note TECHNO EDGE/Try out the new western stall. :))",
                "TECHNO EDGE", "Try out the new western stall. :))");

        parseAddNotesCommandUnsuccessfully("add note ",
                "Please include a '/' in between the location and the notes.");
        parseAddNotesCommandUnsuccessfully("add note /Group Project Meeting",
                "Please add a location to the command before the notes. :))");
        parseAddNotesCommandUnsuccessfully("add note e/", "Location does not exists. :(( "
                + "Please key in a valid location.");
        parseAddNotesCommandUnsuccessfully("add note e2/", "Please add a note behind. :))");

        parseDeleteNotesCommandSuccessfully("delete note E4/1", "E4", 0);
        parseDeleteNotesCommandUnsuccessfully("delete note E4/2",
                "Please enter a number that is positive and not more than");

        parseListNotesCommandSuccessfully("list notes techno edge", "TECHNO EDGE");
        parseListNotesUnsuccessfully("list notes ", "Please add a location after the command. :))");
        parseListNotesUnsuccessfully("list notes e0", "Location does not exists. :(( Please key in a valid location.");

    }

    public void parseAddNotesCommandSuccessfully(String input, String location, String notes) {
        try {
            initializeDuke();
            Command command = Parser.prepareForCommandExecution(input);
            command.execute(nusMap, ui, history, dailyroute, blockAlias, favouriteLocation);
        } catch (InvalidCommandException e) {
            ui.showToUser(e.getMessage());
        } finally {
            assertEquals(NotesCommandParser.location, location);
            assertEquals(NotesCommandParser.note, notes);
        }
    }

    public void parseAddNotesCommandUnsuccessfully(String input, String error) {
        try {
            NotesCommandParser.parseAddNotesCommand(input, nusMap);
        } catch (WrongInputFormatException e) {
            assertEquals("Please include a '/' in between the location and the notes.", error);
        } catch (NoLocationForNotesCommandException e) {
            assertEquals("Please add a location to the command before the notes. :))", error);
        } catch (NonExistentLocationForNotesCommandException e) {
            assertEquals("Location does not exists. :(( Please key in a valid location.", error);
        } catch (EmptyNoteException e) {
            assertEquals("Please add a note behind. :))", error);
        }
    }

    public void parseDeleteNotesCommandSuccessfully(String input, String location, int index) {
        try {
            initializeDuke();
            Command command = Parser.prepareForCommandExecution(input);
            command.execute(nusMap, ui, history, dailyroute, blockAlias, favouriteLocation);
        } catch (InvalidCommandException e) {
            ui.showToUser(e.getMessage());
        } finally {
            assertEquals(NotesCommandParser.location, location);
            assertEquals(NotesCommandParser.noteIndexInList, index);
        }
    }

    public void parseDeleteNotesCommandUnsuccessfully(String input, String error) {
        try {
            NotesCommandParser.parseDeleteNotesCommand(input, nusMap);
        } catch (InvalidNoteIndexException e) {
            assertEquals("Please enter a number that is positive and not more than", error);
        } catch (NoNoteIndexException e) {
            assertEquals("Please add a note index behind. :))", error);
        } catch (NonExistentLocationForNotesCommandException e) {
            assertEquals("Location does not exists. :(( Please key in a valid location.", error);
        } catch (WrongInputFormatException e) {
            assertEquals("Please include a '/' in between the location and the note index.", error);
        } catch (NoLocationForNotesCommandException e) {
            assertEquals("Please add a location to the command before the note index. :))", error);
        }
    }

    public void parseListNotesCommandSuccessfully(String input, String location) {
        try {
            initializeDuke();
            Command command = Parser.prepareForCommandExecution(input);
            command.execute(nusMap, ui, history, dailyroute, blockAlias, favouriteLocation);
        } catch (InvalidCommandException e) {
            ui.showToUser(e.getMessage());
        } finally {
            assertEquals(NotesCommandParser.location, location);
        }
    }

    public void parseListNotesUnsuccessfully(String input, String error) {
        try {
            NotesCommandParser.parseListNotesCommand(input, nusMap);
        } catch (NoLocationForNotesCommandException e) {
            assertEquals("Please add a location after the command. :))", error);
        } catch (NonExistentLocationForNotesCommandException e) {
            assertEquals("Location does not exists. :(( Please key in a valid location.", error);
        }
    }
}
