package seedu.duke.command;

import seedu.duke.*;
import seedu.duke.routing.Router;

public class ByeCommand extends Command {
    public ByeCommand(String userInput) {
        super(userInput);
    }

    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public void execute(Router router, UiManager ui, History history,
                        NotesManager notesManager, DailyRoute dailyRoute, FavouriteLocation favouriteLocation) {
        ui.showByeMessage();
    }
}
