package seedu.duke.command;

import seedu.duke.DailyRoute;
import seedu.duke.History;
import seedu.duke.UiManager;
import seedu.duke.routing.Router;

import seedu.duke.exception.InvalidBlockException;

public class GoCommand extends Command {
    public GoCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Router router, UiManager ui, History history,
                        DailyRoute dailyRoute) {
        try {
            String[] startAndDestination = ui.getRoutingInfo();
            String route = router.execute(startAndDestination[0], startAndDestination[1]);
            history.addHistory(startAndDestination[0], startAndDestination[1]);
            ui.showToUser(route);
        } catch (InvalidBlockException e) {
            ui.showToUser(e.getMessage());
        }
    }
}
