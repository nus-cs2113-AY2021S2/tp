package seedu.duke.commands;

import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static seedu.duke.common.Constants.EMPTY_STRING;
import static seedu.duke.common.Messages.MESSAGE_TASKS_DONE;
import static seedu.duke.common.Messages.MESSAGE_TASKS_EMPTY;
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
        printFilteredTasks(ui, module, false, false);
        ui.printMessage(EMPTY_STRING);
        printFilteredTasks(ui, module, true, false);
    }

    /**
     * Prints either all done or all undone tasks.
     */
    public static void printFilteredTasks(UI ui, Module module, boolean isDone, boolean isOverview) {
        ui.printTaskListHeader(isDone, isOverview);
        ArrayList<Task> filteredTasks = module.getDoneOrUndoneTasks(isDone);
        if (filteredTasks.isEmpty()) {
            printEmpty(ui, isDone);
            return;
        }
        ui.printTasks(filteredTasks, false);
    }

    /**
     * Prints message to indicate task list is empty.
     * @param isDone Status of tasks in taskList.
     */
    private static void printEmpty(UI ui, boolean isDone) {
        if (isDone) {
            ui.printMessage(MESSAGE_TASKS_EMPTY);
        } else {
            ui.printMessage(MESSAGE_TASKS_DONE);
        }
    }
}
