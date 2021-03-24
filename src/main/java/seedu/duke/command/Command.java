package seedu.duke.command;

import seedu.duke.BlockAlias;
import seedu.duke.DailyRoute;
import seedu.duke.History;
import seedu.duke.NotesManager;
import seedu.duke.Map;
import seedu.duke.UiManager;

public class Command {
    protected String userInput;

    public Command(String userInput) {
        this.userInput = userInput;
    }

    public boolean isExit() {
        return false;
    }

    public void execute(Map nusMap, UiManager ui, History history,
                        NotesManager notesManager, DailyRoute dailyRoute, BlockAlias blockAlias) {
    }
}
