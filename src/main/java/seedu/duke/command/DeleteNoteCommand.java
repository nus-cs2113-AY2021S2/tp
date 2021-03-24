package seedu.duke.command;

import seedu.duke.*;
import seedu.duke.routing.Router;

public class DeleteNoteCommand extends Command {
    public DeleteNoteCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Router router, UiManager ui, History history,
                        NotesManager notesManager, DailyRoute dailyRoute, FavouriteLocation favouriteLocation) {
        notesManager.parseDeleteNotesCommandAndDeleteNotes(userInput);
    }
}
