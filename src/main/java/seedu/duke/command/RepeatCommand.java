package seedu.duke.command;

import seedu.duke.*;
import seedu.duke.routing.Router;

public class RepeatCommand extends Command {
    public RepeatCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Router router, UiManager ui, History history, NotesManager notesManager) {
        router.repeatExecution(history);
    }
}
