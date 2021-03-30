package seedu.duke.command.historycommand;

import seedu.duke.router.Router;
import seedu.duke.command.Command;
import seedu.duke.exception.EmptyHistoryException;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.ui.HistoryUi;

public class RepeatHistoryCommand extends Command {
    protected HistoryUi ui;

    public RepeatHistoryCommand() {
        this.ui = new HistoryUi();
    }

    @Override
    public void execute()  {
        try {
            ui.showHistory(history);
            int entry = ui.getRepeatEntry();
            entry--;
            String[] routeInfo = history.getSpecificEntry(entry);
            String route = new Router().execute(nusMap, blockAlias, routeInfo[0], routeInfo[1]);
            ui.showMessageWithDivider(route);
            history.addHistory(routeInfo[0], routeInfo[1]);
        } catch (InvalidBlockException | InvalidIndexException | EmptyHistoryException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}
