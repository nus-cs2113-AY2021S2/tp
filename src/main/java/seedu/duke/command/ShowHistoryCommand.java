package seedu.duke.command;

import seedu.duke.*;
import seedu.duke.routing.Router;

public class ShowHistoryCommand extends Command {
    public ShowHistoryCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Router router, UiManager ui, History history, NotesManager notesManager) {
        history.displayRecords();
    }
}
