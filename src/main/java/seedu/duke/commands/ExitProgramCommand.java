package seedu.duke.commands;

import seedu.duke.ui.UI;

import static seedu.duke.common.Messages.MESSAGE_EXIT;

public class ExitProgramCommand extends Command {

    //@@author isaharon
    /**
     * Prints exit message.
     *
     * @param ui Instance of UI.
     */
    @Override
    public void execute(UI ui) {
        ui.printMessage(MESSAGE_EXIT);
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
