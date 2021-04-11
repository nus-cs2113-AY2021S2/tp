package seedu.duke.commands;

import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import static seedu.duke.common.Messages.MESSAGE_CLOSED_MODULE;

public class ExitModuleCommand extends Command {

    //@@author 8kdesign
    /**
     * Exits from selected module.
     *
     * @param ui Instance of UI.
     */
    @Override
    public void execute(UI ui) {
        String moduleCode = ModuleList.getSelectedModuleCode();
        ModuleList.reset();
        ui.printMessage(String.format(MESSAGE_CLOSED_MODULE, moduleCode));
    }
}
