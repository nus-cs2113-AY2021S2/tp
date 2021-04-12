package seedu.logic.command.startmenu;

import seedu.logic.command.Command;
import seedu.ui.UI;

public class MainHelp extends Command {

    @Override
    public void execute() {
        UI.printStartMenu();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
