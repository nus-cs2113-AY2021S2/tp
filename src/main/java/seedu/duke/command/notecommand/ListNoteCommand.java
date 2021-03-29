package seedu.duke.command.notecommand;

import seedu.duke.command.Command;
import seedu.duke.data.NusMap;
import seedu.duke.ui.UiManager;
import seedu.duke.data.History;
import seedu.duke.data.DailyRoute;
import seedu.duke.data.BlockAlias;
import seedu.duke.data.Favourite;
import seedu.duke.NotesCommandParser;

import seedu.duke.exception.NoLocationForNotesCommandException;
import seedu.duke.exception.NonExistentLocationForNotesCommandException;

import static seedu.duke.NotesCommandParser.location;

public class ListNoteCommand extends Command {

    public ListNoteCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(NusMap nusMap, UiManager ui, History history, DailyRoute dailyRoute,
                        BlockAlias blockAlias, Favourite favourite) {
        try {
            NotesCommandParser.parseListNotesCommand(userInput, nusMap);
            nusMap.map.get(location).listNotes();
        } catch (NoLocationForNotesCommandException | NonExistentLocationForNotesCommandException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }

}
