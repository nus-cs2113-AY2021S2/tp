package seedu.duke.command;

import seedu.duke.Map;
import seedu.duke.UiManager;
import seedu.duke.History;
import seedu.duke.DailyRoute;
import seedu.duke.BlockAlias;
import seedu.duke.FavouriteLocation;
import seedu.duke.NotesCommandParser;


import seedu.duke.notecommandexceptions.EmptyNoteException;
import seedu.duke.notecommandexceptions.NoLocationForNotesCommandException;
import seedu.duke.notecommandexceptions.NonExistentLocationForNotesCommandException;
import seedu.duke.notecommandexceptions.WrongInputFormatException;

import static seedu.duke.Map.map;
import static seedu.duke.NotesCommandParser.location;

public class AddNoteCommand extends Command {

    public AddNoteCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Map nusMap, UiManager ui, History history, DailyRoute dailyRoute,
                        BlockAlias blockAlias, FavouriteLocation favouriteLocation) {
        try {
            NotesCommandParser.parseAddNotesCommand(userInput);
            map.get(location).addNotes(); //add notes to block given by user
        } catch (WrongInputFormatException | NoLocationForNotesCommandException
                | NonExistentLocationForNotesCommandException | EmptyNoteException e) {
            ui.showToUser(e.getMessage());
        }
    }
}
