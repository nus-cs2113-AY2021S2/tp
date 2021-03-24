package seedu.duke.command;

import seedu.duke.*;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.Map;
import seedu.duke.Router;

public class GoCommand extends Command {
    public GoCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Map nusMap, UiManager ui, History history,
                        NotesManager notesManager, DailyRoute dailyRoute) {
        try {
            String[] startAndDestination = ui.getRoutingInfo();
            if (startAndDestination[1].equals("EATERY")) {
                EateryList eateryList = new EateryList(nusMap, startAndDestination[0]);
                eateryList.sortEateriesByDistance();
                int eateryEntry = ui.getEateryEntry(eateryList.getEateries());
                startAndDestination[1] = eateryList.getSpecificEatery(eateryEntry - 1).getName();
            }
            String route = new Router().execute(nusMap, startAndDestination[0], startAndDestination[1]);
            history.addHistory(startAndDestination[0], startAndDestination[1]);
            ui.showToUser(route);
        } catch (InvalidBlockException e) {
            ui.showToUser(e.getMessage());
        }
    }
}
