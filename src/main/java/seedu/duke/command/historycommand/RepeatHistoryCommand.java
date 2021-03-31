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
