//@@author Rye98

package seedu.duke.command.historycommand;

import seedu.duke.router.Router;
import seedu.duke.command.Command;
import seedu.duke.exception.EmptyHistoryException;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.ui.HistoryUi;

public class RepeatHistoryCommand extends Command {
    protected HistoryUi ui;

    public RepeatHistoryCommand() {
        this.ui = new HistoryUi();
    }

    @Override
    /**
     * This method will attempt to repeat a "go" search using existing entries stored in history.
     * This method then prompts user for their input of the INDEX of stored history searches.
     *
     * This method further calls Router class' execute() method.
     */
    public void execute()  {
        try {
            ui.showHistory(history);
            int entry = ui.getRepeatIndex();
            String[] routeInfo = history.getSpecificEntry(entry - 1);
            String route = new Router().execute(nusMap, routeInfo[0], routeInfo[1]);
            ui.showMessageWithDivider(route);
            history.addHistory(routeInfo[0], routeInfo[1]);
        } catch (InvalidIndexException | EmptyHistoryException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}
