package seedu.duke.Command;

public abstract class Command {
    protected String feedback;

    public abstract CommandResult execute();
}
