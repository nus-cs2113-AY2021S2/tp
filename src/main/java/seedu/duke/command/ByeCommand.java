package seedu.duke.command;

import seedu.duke.ui.UiManager;

public class ByeCommand extends Command {

    protected UiManager ui;
    private static final String MESSAGE_SUCCESS = "Bye. Hope to see you again soon!";

    public ByeCommand() {
        this.ui = new UiManager();
    }

    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public void execute() {
        ui.showMessageWithDivider(MESSAGE_SUCCESS);
    }
}
