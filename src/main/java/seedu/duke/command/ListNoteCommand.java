package seedu.duke.command;

import seedu.duke.*;
import seedu.duke.routing.Router;

public class ListNoteCommand extends Command {
    public ListNoteCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Router router, UiManager ui, History history,
                        NotesManager notesManager, DailyRoute dailyRoute, FavouriteLocation favouriteLocation) {
        notesManager.parseListNotesCommandAndListNotes(userInput);;
    }
}
