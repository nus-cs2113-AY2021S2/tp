package seedu.fridgefriend.command;

/**
 * Represents a command to exit the application.
 */
public class ByeCommand extends Command {

    public ByeCommand() {
        super();
    }

    public boolean isExit() {
        return isExit;
    }

    public void setExit(boolean isExit) {
        this.isExit = isExit;
    }

    @Override
    public void execute() {
        setExit(true);
    }
    
}
