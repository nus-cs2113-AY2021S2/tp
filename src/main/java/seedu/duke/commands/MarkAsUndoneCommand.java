package seedu.duke.commands;

import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static seedu.duke.common.CommonMethods.getSpecifiedTasks;
import static seedu.duke.common.Constants.TYPE_TASK;
import static seedu.duke.common.Constants.UNMARK;
import static seedu.duke.common.Messages.MESSAGE_ENTER_INDICES;
import static seedu.duke.common.Messages.MESSAGE_MARKED_AS_UNDONE;
import static seedu.duke.common.Messages.MESSAGE_NO_TASK_MODIFIED;
import static seedu.duke.common.Messages.MESSAGE_TASKS_TO_UNMARK;
import static seedu.duke.common.Messages.MESSAGE_TASK_LIST_EMPTY;

public class MarkAsUndoneCommand extends Command {

    //@@author aliciatay-zls
    /**
     * Displays list of done tasks, asks user for a string of space-separated  
     * indices and marks all corresponding tasks as undone.
     *
     * @param ui Instance of UI.
     */
    @Override
    public void execute(UI ui) {
        Module module = ModuleList.getSelectedModule();
        ArrayList<Task> doneTasks = module.getDoneOrUndoneTasks(true);
        if (doneTasks.isEmpty()) {
            ui.printMessage(String.format(MESSAGE_TASK_LIST_EMPTY, UNMARK));
            return;
        }
        printPrompt(ui, doneTasks);
        ArrayList<Task> selectedTasks = getSpecifiedTasks(ui, doneTasks);
        if (selectedTasks.isEmpty()) {
            ui.printMessage(MESSAGE_NO_TASK_MODIFIED);
            return;
        }
        for (Task task : selectedTasks) {
            String description = task.getDescription();
            ui.printMessage(String.format(MESSAGE_MARKED_AS_UNDONE,description));
            task.setDone(false);
        }
        ModuleList.writeModule();
    }

    /**
     * Prints prompt for indices of tasks to mark as undone.
     *
     * @param ui Instance of UI.
     * @param doneTasks Array list of done tasks.
     */
    private void printPrompt(UI ui, ArrayList<Task> doneTasks) {
        ui.printMessage(MESSAGE_TASKS_TO_UNMARK);
        ui.printTasks(doneTasks, true);
        ui.printMessage(String.format(MESSAGE_ENTER_INDICES, TYPE_TASK, UNMARK));
    }
}
