package seedu.duke.commands;

import seedu.duke.common.Messages;
import seedu.duke.module.ModuleList;
import seedu.duke.parser.Parser;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static seedu.duke.common.Messages.MESSAGE_DELETE_MODULE_INFO;
import static seedu.duke.common.Messages.MESSAGE_INVALID_INDICES;
import static seedu.duke.common.Messages.MESSAGE_MODULE_TO_DELETE;
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
        ui.printMessage(getDeleteInfo());
        ArrayList<Integer> indices = getIndices(ui);
        ArrayList<String> deletedModulesCodes = ModuleList.deleteModules(indices);
        ui.printMessage(getDeletedModuleCodes(deletedModulesCodes));
    }

    @Override
    public boolean isExit() {
        return false;
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
        stringBuilder.append(NEWLINE).append(MESSAGE_DELETE_MODULE_INFO);
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
        for (String moduleCode : deletedModuleCodes) {
            stringBuilder.append(String.format(MESSAGE_REMOVED_MODULE, moduleCode));
            stringBuilder.append(NEWLINE);
        }
        return stringBuilder.toString();
    }

    /**
     * Reads user input and returns valid indices of modules to be deleted.
     * @param ui user interface object
     * @return ArrayList of integers
     */
    private ArrayList<Integer> getIndices(UI ui) {
        boolean isValidInput = false;
        ArrayList<Integer> indices = null;

        do {
            String userInput = ui.readCommand();
            try {
                indices = Parser.checkIndices(userInput, ModuleList.getModules().size());
            } catch (NumberFormatException e) {
                // keep reading input until given valid
                ui.printMessage(MESSAGE_INVALID_INDICES);
                continue;
            }
            isValidInput = true;
        } while (!isValidInput);

        return indices;
    }
}
