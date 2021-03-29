package seedu.duke.commands;

import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import static seedu.duke.common.Constants.EMPTY_STRING;
import static seedu.duke.common.Messages.MESSAGE_TASKS_TO_LIST;
import static seedu.duke.common.Messages.NEWLINE;

public class ListTasksCommand extends Command {

    //@@author aliciatay-zls
    /**
     * Prints all tasks in selected module's task list.
     *
     * @param ui Instance of UI.
     */
    @Override
    public void execute(UI ui) {
        Module module = ModuleList.getSelectedModule();
        ui.printMessage(String.format(MESSAGE_TASKS_TO_LIST, module.getModuleCode()) + NEWLINE);
        ui.printTasks(module.getTaskList(), false, false);
        ui.printMessage(EMPTY_STRING);
        ui.printTasks(module.getTaskList(), true, false);
    }
}
