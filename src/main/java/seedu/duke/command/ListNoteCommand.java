package seedu.duke.command;

import seedu.duke.Map;
import seedu.duke.ui.UiManager;
import seedu.duke.History;
import seedu.duke.DailyRoute;
import seedu.duke.BlockAlias;
import seedu.duke.FavouriteLocation;
import seedu.duke.NotesCommandParser;

import seedu.duke.notecommandexceptions.NoLocationForNotesCommandException;
import seedu.duke.notecommandexceptions.NonExistentLocationForNotesCommandException;

import static seedu.duke.NotesCommandParser.location;

public class ListNoteCommand extends Command {

    public ListNoteCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Map nusMap, UiManager ui, History history, DailyRoute dailyRoute,
                        BlockAlias blockAlias, FavouriteLocation favouriteLocation) {
        try {
            NotesCommandParser.parseListNotesCommand(userInput, nusMap);
            nusMap.map.get(location).listNotes();
        } catch (NoLocationForNotesCommandException | NonExistentLocationForNotesCommandException e) {
            ui.showToUser(e.getMessage(), ui.divider);
        }
    }

}
