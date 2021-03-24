package seedu.duke.command;

import seedu.duke.DailyRoute;
import seedu.duke.NotesCommandParser;
import seedu.duke.History;
import seedu.duke.UiManager;
import seedu.duke.routing.Router;

import seedu.duke.notecommandexceptions.NoLocationForNotesCommandException;
import seedu.duke.notecommandexceptions.NonExistentLocationForNotesCommandException;

import static seedu.duke.NotesCommandParser.location;
import static seedu.duke.routing.Map.map;

public class ListNoteCommand extends Command {

    public ListNoteCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Router router, UiManager ui, History history,
                        DailyRoute dailyRoute) {
        try {
            NotesCommandParser.parseListNotesCommand(userInput);
            map.get(location).listNotes();
        } catch (NoLocationForNotesCommandException | NonExistentLocationForNotesCommandException e) {
            ui.showToUser(e.getMessage());
        }
    }

}
