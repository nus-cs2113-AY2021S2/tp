package seedu.duke.commands;

import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static seedu.duke.common.CommonMethods.getSpecifiedTasks;
import static seedu.duke.common.Constants.MARK;
import static seedu.duke.common.Constants.TYPE_TASK;
import static seedu.duke.common.Messages.MESSAGE_ENTER_INDICES;
import static seedu.duke.common.Messages.MESSAGE_MARKED_AS_DONE;
import static seedu.duke.common.Messages.MESSAGE_NO_TASK_MODIFIED;
import static seedu.duke.common.Messages.MESSAGE_TASKS_TO_MARK;
import static seedu.duke.common.Messages.MESSAGE_TASK_LIST_EMPTY;

public class MarkAsDoneCommand extends Command {

    //@@author aliciatay-zls
    /**
     * Displays list of undone tasks, asks user for a string of space-separated  
     * indices and marks all corresponding tasks as done.
     *
     * @param ui Instance of UI.
     */
    @Override
    public void execute(UI ui) {
        Module module = ModuleList.getSelectedModule();
        ArrayList<Task> undoneTasks = module.getDoneOrUndoneTasks(false);
        if (undoneTasks.isEmpty()) {
            ui.printMessage(String.format(MESSAGE_TASK_LIST_EMPTY, MARK));
            return;
        }
        printPrompt(ui, undoneTasks);
        ArrayList<Task> selectedTasks = getSpecifiedTasks(ui, undoneTasks);
        if (selectedTasks.isEmpty()) {
            ui.printMessage(MESSAGE_NO_TASK_MODIFIED);
            return;
        }
        for (Task task : selectedTasks) {
            String description = task.getDescription();
            ui.printMessage(String.format(MESSAGE_MARKED_AS_DONE, description));
            task.setDone(true);
        }
        ModuleList.writeModule();
    }

    /**
     * Prints prompt for indices of tasks to mark as done.
     *
     * @param ui Instance of UI.
     * @param undoneTasks Array list of undone tasks.
     */
    private void printPrompt(UI ui, ArrayList<Task> undoneTasks) {
        ui.printMessage(MESSAGE_TASKS_TO_MARK);
        ui.printTasks(undoneTasks, true);
        ui.printMessage(String.format(MESSAGE_ENTER_INDICES, TYPE_TASK, MARK));
    }
}
