package seedu.duke.command;

import seedu.duke.*;
import seedu.duke.routing.Router;

public class GoCommand extends Command {
    public GoCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Router router, UiManager ui, History history, NotesManager notesManager) {
        router.execute(history);
    }
}
