package seedu.fridgefriend.command;

import seedu.fridgefriend.exception.InvalidInputException;

/**
 * Represent an executable command.
 */
public abstract class Command {

    protected boolean isExit;

    public Command() {
        isExit = false;
    }
    
    public boolean isExit() {
        return isExit;
    }

    public abstract void execute() throws InvalidInputException;

}
