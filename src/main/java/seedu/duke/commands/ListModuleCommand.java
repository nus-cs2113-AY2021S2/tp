package seedu.duke.commands;

import seedu.duke.common.Messages;
import seedu.duke.exceptions.CommandException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import static java.util.Objects.requireNonNull;

public class ListModuleCommand extends Command {

    public static final String MESSAGE_INFO = "Modules in your list:\n";

    @Override
    public void execute(ModuleList modules, UI ui) throws CommandException {
        requireNonNull(modules);

        StringBuilder sb = new StringBuilder(MESSAGE_INFO);
        for (String moduleCode : modules.getModules()) {
            int moduleNumber = modules.getModules().indexOf(moduleCode) + 1;
            sb.append(String.format(Messages.FORMAT_LIST_ITEMS, moduleNumber, moduleCode));
            sb.append("\n");
        }
        String listMessage = sb.toString();
        ui.printMessage(listMessage);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
