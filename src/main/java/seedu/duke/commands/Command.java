package seedu.duke.commands;

/**
 * Represents an executable command.
 */
public abstract class Command {

    protected Command() {
    }

    /**
     * Executes the command.
     */
    protected CommandOutput execute() {
        return null;
    }

}
