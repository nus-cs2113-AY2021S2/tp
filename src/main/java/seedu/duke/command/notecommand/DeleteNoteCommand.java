package seedu.duke.command.notecommand;

import seedu.duke.command.Command;
import seedu.duke.data.NusMap;
import seedu.duke.ui.UiManager;
import seedu.duke.data.History;
import seedu.duke.data.DailyRoute;
import seedu.duke.data.BlockAlias;
import seedu.duke.data.Favourite;
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
    public void execute(NusMap nusMap, UiManager ui, History history, DailyRoute dailyRoute,
                        BlockAlias blockAlias, Favourite favourite) {
        try {
            NotesCommandParser.parseDeleteNotesCommand(userInput, nusMap);
            nusMap.map.get(location).deleteNotes();
        } catch (WrongInputFormatException | NoLocationForNotesCommandException
                | NonExistentLocationForNotesCommandException | NoNoteIndexException e) {
            ui.showMessageWithDivider(e.getMessage());
        } catch (InvalidNoteIndexException e) {
            ui.showMessageWithDivider(e.getMessage(nusMap));
        } catch (NumberFormatException e) {
            ui.showMessageWithDivider("Please enter a valid number for note index.");
        }
    }
}
