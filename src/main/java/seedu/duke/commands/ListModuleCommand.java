package seedu.duke.commands;

import seedu.duke.common.Messages;
import seedu.duke.exception.CommandException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import static seedu.duke.common.Messages.MESSAGE_MODULE_TO_LIST;
import static seedu.duke.common.Messages.NEWLINE;

public class ListModuleCommand extends Command {


    @Override
    public void execute(UI ui) throws CommandException {
        StringBuilder sb = new StringBuilder(MESSAGE_MODULE_TO_LIST);
        for (String moduleCode : ModuleList.getModules()) {
            int moduleNumber = ModuleList.getModules().indexOf(moduleCode) + 1;
            sb.append(String.format(Messages.FORMAT_LIST_ITEMS, moduleNumber, moduleCode));
            sb.append(NEWLINE);
        }
        String listMessage = sb.toString();
        ui.printMessage(listMessage);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
