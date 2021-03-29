package seedu.duke.command.historycommand;

import seedu.duke.command.Command;
import seedu.duke.exception.EmptyHistoryException;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.ui.HistoryUi;

public class ShowHistoryCommand extends Command {
    protected HistoryUi ui;
    public ShowHistoryCommand() {
        this.ui = new HistoryUi();
    }

    @Override
    public void execute() {
        try {
            ui.showHistory(history);
        } catch (InvalidIndexException | EmptyHistoryException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}
