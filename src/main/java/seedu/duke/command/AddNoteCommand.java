package seedu.duke.command;

import seedu.duke.DailyRoute;
import seedu.duke.NotesCommandParser;
import seedu.duke.History;
import seedu.duke.UiManager;
import seedu.duke.routing.Router;

import seedu.duke.notecommandexceptions.EmptyNoteException;
import seedu.duke.notecommandexceptions.NoLocationForNotesCommandException;
import seedu.duke.notecommandexceptions.NonExistentLocationForNotesCommandException;
import seedu.duke.notecommandexceptions.WrongInputFormatException;

import static seedu.duke.NotesCommandParser.location;
import static seedu.duke.routing.Map.map;

public class AddNoteCommand extends Command {

    public AddNoteCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Router router, UiManager ui, History history,
                        DailyRoute dailyRoute) {
        try {
            NotesCommandParser.parseAddNotesCommand(userInput);
            map.get(location).addNotes(); //add notes to block given by user
        } catch (WrongInputFormatException | NoLocationForNotesCommandException | NonExistentLocationForNotesCommandException | EmptyNoteException e) {
            ui.showToUser(e.getMessage());
        }
    }
}
