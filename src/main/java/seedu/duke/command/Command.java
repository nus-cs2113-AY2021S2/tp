package seedu.duke.command;

public abstract class Command {
    protected String feedback;
    //protected FitCenter fitCenter;

    public abstract CommandResult execute();
}
