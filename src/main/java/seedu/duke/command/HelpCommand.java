package seedu.duke.command;

import seedu.duke.History;
import seedu.duke.NotesManager;
import seedu.duke.routing.Router;
import seedu.duke.UiManager;

public class HelpCommand extends Command {
    public HelpCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Router router, UiManager ui, History history, NotesManager notesManager) {
        ui.showHelpMessage();
    }
}
