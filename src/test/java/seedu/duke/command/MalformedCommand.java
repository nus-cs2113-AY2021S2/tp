package seedu.duke.command;

public class MalformedCommand extends Command {

    /**
     *  This is a non-standard initializer, which should trigger UnknownException.
     */
    public MalformedCommand() {
        super(null, null, null);
    }

    @Override
    public void execute() {
        // Do nothing
    }
}
