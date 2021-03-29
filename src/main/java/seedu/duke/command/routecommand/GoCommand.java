package seedu.duke.command.routecommand;

import seedu.duke.data.EateryList;
import seedu.duke.Router;
import seedu.duke.command.Command;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.ui.RouterUi;

public class GoCommand extends Command {
    protected RouterUi ui;

    public GoCommand() {
        this.ui = new RouterUi();
    }

    @Override
    public void execute() {
        try {
            String[] startAndDestination = ui.getRoutingInfo();
            if (startAndDestination[1].equals("EATERY")) {
                EateryList eateryList = new EateryList(nusMap, blockAlias, startAndDestination[0]);
                eateryList.sortEateriesByDistance();
                int eateryEntry = ui.getEateryEntry(eateryList.getEateries());
                assert (eateryEntry > 0 & eateryEntry < 6) : "Entry must be within bound";
                startAndDestination[1] = eateryList.getSpecificEatery(eateryEntry - 1).getName();
            }
            String route = new Router().execute(nusMap, blockAlias, startAndDestination[0], startAndDestination[1]);
            history.addHistory(startAndDestination[0], startAndDestination[1]);
            ui.showMessageWithDivider(route);
        } catch (InvalidBlockException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}
