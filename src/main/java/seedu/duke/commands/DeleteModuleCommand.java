package seedu.duke.commands;

import seedu.duke.common.Messages;
import seedu.duke.module.ModuleList;
import seedu.duke.parser.ParserUtil;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static seedu.duke.common.Constants.DELETE;
import static seedu.duke.common.Constants.INDEX_FIRST;
import static seedu.duke.common.Constants.TYPE_MODULE;
import static seedu.duke.common.Messages.MESSAGE_ENTER_INDICES;
import static seedu.duke.common.Messages.MESSAGE_MODULE_TO_DELETE;
import static seedu.duke.common.Messages.MESSAGE_NO_MODULES_TO_DELETE;
import static seedu.duke.common.Messages.MESSAGE_REMOVED_MODULE;
import static seedu.duke.common.Messages.NEWLINE;

public class DeleteModuleCommand extends Command {

    //@@author isaharon
    /**
     * Requests for list of indices to delete.
     * Deletes all modules corresponding to specified indices.
     *
     * @param ui Instance of UI.
     */
    @Override
    public void execute(UI ui) {
        if (ModuleList.getModules().isEmpty()) {
            ui.printMessage(MESSAGE_NO_MODULES_TO_DELETE);
            return;
        }
        ui.printMessage(getDeleteInfo());

        String userInput = ui.readUserInput();
        ArrayList<Integer> indices = ParserUtil.checkIndices(userInput, ModuleList.getSize());
        if (indices.isEmpty()) {
            return;
        }

        ArrayList<String> deletedModulesCodes = ModuleList.deleteModules(indices);
        String deletedMessage = getDeletedModuleCodes(deletedModulesCodes);
        ui.printMessage(deletedMessage);
    }

    /**
     * Returns string containing instructions and module list.
     *
     * @return Message to print.
     */
    private String getDeleteInfo() {
        StringBuilder stringBuilder = new StringBuilder(MESSAGE_MODULE_TO_DELETE);
        ArrayList<String> modules = ModuleList.getModules();
        for (String moduleCode : modules) {
            int counter = modules.indexOf(moduleCode) + 1;
            stringBuilder.append(String.format(Messages.FORMAT_LIST_ITEMS, counter, moduleCode));
            stringBuilder.append(NEWLINE);
        }
        stringBuilder.append(String.format(MESSAGE_ENTER_INDICES, TYPE_MODULE, DELETE));
        return stringBuilder.toString();
    }

    /**
     * Returns string containing list of deleted modules.
     *
     * @param deletedModuleCodes Arraylist of module codes.
     * @return Message to print.
     */
    private String getDeletedModuleCodes(ArrayList<String> deletedModuleCodes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < deletedModuleCodes.size(); i++) {
            if (i != INDEX_FIRST) {
                stringBuilder.append(NEWLINE);
            }
            stringBuilder.append(String.format(MESSAGE_REMOVED_MODULE, deletedModuleCodes.get(i)));
        }
        return stringBuilder.toString();
    }
}
