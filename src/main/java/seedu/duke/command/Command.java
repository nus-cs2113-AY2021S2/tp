package seedu.duke.command;

import seedu.duke.ui.Ui;

public abstract class Command {
    protected boolean isExit;
    public abstract void execute(Ui ui);

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
