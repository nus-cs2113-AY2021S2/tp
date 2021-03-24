package seedu.duke.command;

import seedu.duke.DailyRoute;
import seedu.duke.NotesCommandParser;
import seedu.duke.History;
import seedu.duke.UiManager;
import seedu.duke.routing.Router;

import seedu.duke.notecommandexceptions.InvalidNoteIndexException;
import seedu.duke.notecommandexceptions.NoLocationForNotesCommandException;
import seedu.duke.notecommandexceptions.NoNoteIndexException;
import seedu.duke.notecommandexceptions.NonExistentLocationForNotesCommandException;
import seedu.duke.notecommandexceptions.WrongInputFormatException;

import static seedu.duke.NotesCommandParser.location;
import static seedu.duke.routing.Map.map;

public class DeleteNoteCommand extends Command {

    public DeleteNoteCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Router router, UiManager ui, History history,
                        DailyRoute dailyRoute) {
        try {
            NotesCommandParser.parseDeleteNotesCommand(userInput);
            map.get(location).deleteNotes();
        } catch (WrongInputFormatException | NoLocationForNotesCommandException | NonExistentLocationForNotesCommandException | NoNoteIndexException | InvalidNoteIndexException e) {
            ui.showToUser(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number for note index.");
        }
    }
}
