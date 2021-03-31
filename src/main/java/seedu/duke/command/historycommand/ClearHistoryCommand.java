//@@author Rye98
package seedu.duke.command.historycommand;

import seedu.duke.command.Command;
import seedu.duke.ui.HistoryUi;

public class ClearHistoryCommand extends Command {

    protected HistoryUi ui;
    private static final String MESSAGE_SUCCESS = "Your history has been successfully cleared";

    public ClearHistoryCommand() {
        this.ui = new HistoryUi();
    }

    @Override
    public void execute() {
        history.clearHistory();
        ui.showMessageWithDivider(MESSAGE_SUCCESS);
    }
}
