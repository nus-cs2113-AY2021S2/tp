package seedu.duke.commands;

import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static seedu.duke.common.CommonMethods.getSpecifiedTasks;
import static seedu.duke.common.Messages.COMMAND_VERB_DELETE;
import static seedu.duke.common.Messages.MESSAGE_REMOVED_TASK;
import static seedu.duke.common.Messages.MESSAGE_NO_TASK_MODIFIED;
import static seedu.duke.common.Messages.MESSAGE_TASKS_TO_DELETE;
import static seedu.duke.common.Messages.MESSAGE_TASK_LIST_EMPTY;
import static seedu.duke.common.Messages.MESSAGE_TASK_SELECT_INFO;

public class DeleteTaskCommand extends Command {

    //@@author aliciatay-zls
    /**
     * Displays list of all tasks, asks user for a string of space-separated  
     * indices and deletes all corresponding tasks.
     *
     * @param ui Instance of UI.
     */
    @Override
    public void execute(UI ui) {
        Module module = ModuleList.getSelectedModule();
        ArrayList<Task> taskList = module.getTaskList();
        if (taskList.isEmpty()) {
            ui.printMessage(String.format(MESSAGE_TASK_LIST_EMPTY, COMMAND_VERB_DELETE));
            return;
        }
        printPrompt(ui, taskList);
        ArrayList<Task> selectedTasks = getSpecifiedTasks(ui, taskList);
        if (selectedTasks.isEmpty()) {
            ui.printMessage(MESSAGE_NO_TASK_MODIFIED);
            return;
        }
        for (Task task : selectedTasks) {
            String description = task.getDescription();
            ui.printMessage(String.format(MESSAGE_REMOVED_TASK, description));
            module.removeTask(task);
        }
        ModuleList.writeModule();
        ModuleList.sortTasks();
    }

    /**
     * Prints prompt for indices of tasks to remove from the list.
     *
     * @param ui Instance of UI.
     * @param taskList Array list of tasks.
     */
    private void printPrompt(UI ui, ArrayList<Task> taskList) {
        ui.printMessage(MESSAGE_TASKS_TO_DELETE);
        ui.printSummarisedTasks(taskList);
        ui.printMessage(String.format(MESSAGE_TASK_SELECT_INFO, COMMAND_VERB_DELETE));
    }
}
