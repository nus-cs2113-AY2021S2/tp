package seedu.duke.command;

import seedu.duke.DailyRoute;
import seedu.duke.History;
import seedu.duke.NotesManager;
import seedu.duke.Map;
import seedu.duke.UiManager;

public class ByeCommand extends Command {
    public ByeCommand(String userInput) {
        super(userInput);
    }

    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public void execute(Map nusMap, UiManager ui, History history,
                        NotesManager notesManager, DailyRoute dailyRoute) {
        ui.showByeMessage();
    }
}
