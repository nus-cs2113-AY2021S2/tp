package seedu.duke.command;

import seedu.duke.Map;
import seedu.duke.ui.UiManager;
import seedu.duke.History;
import seedu.duke.DailyRoute;
import seedu.duke.BlockAlias;
import seedu.duke.FavouriteLocation;
import seedu.duke.NotesCommandParser;

import seedu.duke.exception.InvalidNoteIndexException;
import seedu.duke.exception.NoLocationForNotesCommandException;
import seedu.duke.exception.NoNoteIndexException;
import seedu.duke.exception.NonExistentLocationForNotesCommandException;
import seedu.duke.exception.WrongInputFormatException;

import static seedu.duke.NotesCommandParser.location;

public class DeleteNoteCommand extends Command {

    public DeleteNoteCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Map nusMap, UiManager ui, History history, DailyRoute dailyRoute,
                        BlockAlias blockAlias, FavouriteLocation favouriteLocation) {
        try {
            NotesCommandParser.parseDeleteNotesCommand(userInput, nusMap);
            nusMap.map.get(location).deleteNotes();
        } catch (WrongInputFormatException | NoLocationForNotesCommandException
                | NonExistentLocationForNotesCommandException | NoNoteIndexException e) {
            ui.showToUser(e.getMessage(), ui.divider);
        } catch (InvalidNoteIndexException e) {
            ui.showToUser(e.getMessage(nusMap), ui.divider);
        } catch (NumberFormatException e) {
            ui.showToUser("Please enter a valid number for note index.", ui.divider);
        }
    }
}
