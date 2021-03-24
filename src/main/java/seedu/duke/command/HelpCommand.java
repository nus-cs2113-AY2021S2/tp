package seedu.duke.command;

import seedu.duke.DailyRoute;
import seedu.duke.History;
import seedu.duke.UiManager;
import seedu.duke.routing.Router;

public class HelpCommand extends Command {
    public HelpCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Router router, UiManager ui, History history,
                        DailyRoute dailyRoute) {
        ui.showHelpMessage();
    }
}
