package seedu.duke.command;

import seedu.duke.account.FitCenter;

/**
 * Represents the parent class of different Commands.
 */
public abstract class Command {
    protected String feedback;

    public abstract CommandResult execute(FitCenter fitCenter);
}
