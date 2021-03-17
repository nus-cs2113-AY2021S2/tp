package seedu.duke.command;

import seedu.duke.account.FitCenter;

public abstract class Command {
    protected String feedback;

    public abstract CommandResult execute(FitCenter fitCenter);
}
