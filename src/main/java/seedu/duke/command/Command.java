package seedu.duke.command;

import seedu.duke.account.FitCenter;

public abstract class Command {
    protected String feedback;
    protected FitCenter fitCenter;

    public abstract CommandResult execute();

    public void setFitCenter(FitCenter fitCenter) {
        this.fitCenter = fitCenter;
    }
}
