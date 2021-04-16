package seedu.duke.command.generalcommand;

import seedu.duke.command.Command;
import seedu.duke.ui.UiManager;

/**
 * Terminates the program.
 */
public class ByeCommand extends Command {

    protected UiManager ui;
    private static final String MESSAGE_SUCCESS = "Bye. Hope to see you again soon!";

    public ByeCommand() {
        this.ui = new UiManager();
    }

    /**
     * Overrides the {@link Command#isExit()} method to terminate the program.
     */
    @Override
    public boolean isExit() {
        return true;
    }

    /** Prints out the ending message. */
    @Override
    public void execute() {
        ui.showMessageWithDivider(MESSAGE_SUCCESS);
    }
}
