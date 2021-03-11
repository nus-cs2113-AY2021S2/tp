package seedu.duke.commands;

import seedu.duke.common.Messages;
import seedu.duke.exception.CommandException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static seedu.duke.common.Messages.MESSAGE_DELETE_MODULE_INFO;
import static seedu.duke.common.Messages.MESSAGE_MODULE_TO_DELETE;
import static seedu.duke.common.Messages.MESSAGE_REMOVED_MODULE;
import static seedu.duke.common.Messages.NEWLINE;

public class DeleteModuleCommand extends Command {



    private String firstStage() {
        StringBuilder sb = new StringBuilder(MESSAGE_MODULE_TO_DELETE);
        for (String moduleCode : ModuleList.getModules()) {
            int moduleNumber = ModuleList.getModules().indexOf(moduleCode) + 1;
            sb.append(String.format(Messages.FORMAT_LIST_ITEMS, moduleNumber, moduleCode));
            sb.append(NEWLINE);
        }
        sb.append(NEWLINE).append(MESSAGE_DELETE_MODULE_INFO);
        return sb.toString();
    }

    private String secondStage(ArrayList<String> deletedModules) {
        StringBuilder sb = new StringBuilder();
        for (String deletedModule : deletedModules) {
            sb.append(String.format(MESSAGE_REMOVED_MODULE, deletedModule));
            sb.append(NEWLINE);
        }
        return sb.toString();
    }

    @Override
    public void execute(UI ui) throws CommandException {

        String firstStageMessage = firstStage();
        ui.printMessage(firstStageMessage);

        // TODO validate list of integers. Assume input is valid for now.
        ArrayList<Integer> integers = ui.readIntegers();
        ArrayList<String> deletedModules = ModuleList.deleteModules(integers);

        String secondStageMessage = secondStage(deletedModules);
        ui.printMessage(secondStageMessage);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
