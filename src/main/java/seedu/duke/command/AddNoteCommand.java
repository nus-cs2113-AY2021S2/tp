package seedu.duke.command;

import seedu.duke.DailyRoute;
import seedu.duke.History;
import seedu.duke.NotesManager;
import seedu.duke.routing.Router;
import seedu.duke.UiManager;
import seedu.duke.FavouriteLocation;
import seedu.duke.routing.Router;

public class AddNoteCommand extends Command {
    public AddNoteCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Router router, UiManager ui, History history,
                        NotesManager notesManager, DailyRoute dailyRoute, FavouriteLocation favouriteLocation) {
        notesManager.parseAddNotesCommandAndAddNotes(userInput);
    }
}
