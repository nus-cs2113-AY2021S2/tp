package seedu.hdbuy.command;

import seedu.hdbuy.data.UserInput;

public abstract class Command {

    public abstract void execute();

    public boolean isExit() {
        return this instanceof CloseCommand;
    }
}
