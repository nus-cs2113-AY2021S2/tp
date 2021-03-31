package seedu.duke.command.routecommand;

import seedu.duke.data.EateryList;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.router.Router;
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
            String[] routeInfo = ui.getRoutingInfo();
            String[] startAndDestination = blockAlias.changeAliasToBlock(routeInfo[0], routeInfo[1]);
            nusMap.checkIfValidBlock(startAndDestination[0]);
            if (startAndDestination[1].equals("EATERY")) {
                EateryList eateryList = new EateryList(nusMap, startAndDestination[0]);
                eateryList.sortEateriesByDistance();
                int eateryIndex = ui.getEateryIndex(eateryList.getEateries());
                startAndDestination[1] = eateryList.getSpecificEatery(eateryIndex - 1).getName();
            } else {
                nusMap.checkIfValidBlock(startAndDestination[1]);
            }
            assert startAndDestination[0] != null && startAndDestination[1] != null;
            String route = new Router().execute(nusMap, startAndDestination[0], startAndDestination[1]);
            history.addHistory(startAndDestination[0], startAndDestination[1]);
            ui.showMessageWithDivider(route);
        } catch (InvalidBlockException | InvalidIndexException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}
