package seedu.duke.command;

import seedu.duke.DailyRoute;
import seedu.duke.History;
import seedu.duke.UiManager;
import seedu.duke.routing.Router;

public class Command {
    protected String userInput;

    public Command(String userInput) {
        this.userInput = userInput;
    }

    public boolean isExit() {
        return false;
    }

    public void execute(Router router, UiManager ui, History history,
                        DailyRoute dailyRoute) {
    }
}
