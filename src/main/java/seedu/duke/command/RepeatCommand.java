package seedu.duke.command;

import seedu.duke.DailyRoute;
import seedu.duke.History;
import seedu.duke.UiManager;
import seedu.duke.routing.Router;

import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.InvalidRepeatEntryException;
import seedu.duke.exception.RepeatEntryOutOfBoundException;
import seedu.duke.routing.Router;

public class RepeatCommand extends Command {
    public RepeatCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Router router, UiManager ui, History history,
                        DailyRoute dailyRoute) {
        ui.showHistory(history);
        try {
            int entry = ui.getRepeatEntry();
            String[] pathDetails = history.getSpecificEntry(entry);
            String from = pathDetails[0];
            String to = pathDetails[1];
            String route = router.execute(from,to);
            history.addHistory(from, to);
            ui.showToUser(route);
        } catch (RepeatEntryOutOfBoundException | InvalidRepeatEntryException | InvalidBlockException e) {
            ui.showToUser(e.getMessage());
        }
    }
}
