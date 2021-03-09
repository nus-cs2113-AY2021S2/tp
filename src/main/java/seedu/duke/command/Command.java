package seedu.duke.command;

import seedu.duke.record.RecordHandler;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

public abstract class Command {
    protected boolean isExit;

    public abstract void execute(RecordHandler records, Ui ui, Storage storage);

    public Command() {
        isExit = false;
    }

    protected void setExit(boolean isExit) {
        this.isExit = isExit;
    }

    public boolean isExit() {
        return isExit;
    }
}
