package seedu.duke.commands;

import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

public abstract class Command {

    public abstract void execute(ModuleList moduleList, UI ui);

}
