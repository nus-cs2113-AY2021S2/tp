package seedu.duke.command;

import seedu.duke.BlockAlias;
import seedu.duke.DailyRoute;
import seedu.duke.History;
import seedu.duke.UiManager;
import seedu.duke.NotesManager;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.InvalidRepeatEntryException;
import seedu.duke.exception.RepeatEntryOutOfBoundException;
import seedu.duke.Map;
import seedu.duke.Router;

public class RepeatCommand extends Command {
    public RepeatCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Map nusMap, UiManager ui, History history,
                        NotesManager notesManager, DailyRoute dailyRoute, BlockAlias blockAlias) {
        ui.showHistory(history);
        try {
            int entry = ui.getRepeatEntry();
            String[] pathDetails = history.getSpecificEntry(entry);
            String from = pathDetails[0];
            String to = pathDetails[1];
            String route = new Router().execute(nusMap, blockAlias, from, to);
            history.addHistory(from, to);
            ui.showToUser(route);
        } catch (RepeatEntryOutOfBoundException | InvalidRepeatEntryException | InvalidBlockException e) {
            ui.showToUser(e.getMessage());
        }
    }
}
