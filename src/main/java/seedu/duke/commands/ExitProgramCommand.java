package seedu.duke.commands;

import seedu.duke.ui.UI;

public class ExitProgramCommand extends Command {

    @Override
    public void execute(UI ui) {
        ui.printBye();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
