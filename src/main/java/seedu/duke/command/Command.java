package seedu.duke.command;

public abstract class Command {
    protected String feedback;

    public abstract CommandResult execute();
}
