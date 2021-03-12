package seedu.duke.commands;

import seedu.duke.exception.CommandException;
import seedu.duke.ui.UI;

public abstract class Command {

    public abstract void execute(UI ui) throws CommandException;

    public abstract boolean isExit();

}
