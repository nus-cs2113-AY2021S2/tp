package seedu.duke.command;

import seedu.duke.DailyRoute;
import seedu.duke.History;
import seedu.duke.NotesManager;
import seedu.duke.routing.Map;
import seedu.duke.UiManager;

public class DeleteNoteCommand extends Command {
    public DeleteNoteCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Map nusMap, UiManager ui, History history,
                        NotesManager notesManager, DailyRoute dailyRoute) {
        notesManager.parseDeleteNotesCommandAndDeleteNotes(userInput);
    }
}
