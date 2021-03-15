package seedu.duke.command;

public class InvalidCommand extends Command {
    public InvalidCommand() {
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(feedback);
    }
}
