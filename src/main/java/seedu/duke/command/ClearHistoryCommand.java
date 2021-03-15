package seedu.duke.command;

import seedu.duke.*;
import seedu.duke.routing.Router;

public class ClearHistoryCommand extends Command {
    public ClearHistoryCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Router router, UiManager ui, History history, NotesManager notesManager) {
        history.emptyRecords();
    }
}
