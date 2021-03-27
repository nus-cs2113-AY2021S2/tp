package seedu.duke.commands;

import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static seedu.duke.common.CommonMethods.getSpecifiedIndices;
import static seedu.duke.common.CommonMethods.getTaskToEdit;
import static seedu.duke.common.Constants.TASK_FIELD_DEADLINE;
import static seedu.duke.common.Constants.TASK_FIELD_DESCRIPTION;
import static seedu.duke.common.Constants.TASK_FIELD_GRADED_STATUS;
import static seedu.duke.common.Constants.TASK_FIELD_REMARKS;
import static seedu.duke.common.Messages.COMMAND_VERB_EDIT;
import static seedu.duke.common.Messages.FORMAT_INDEX_ITEM;
import static seedu.duke.common.Messages.MESSAGE_EDITED_TASK;
import static seedu.duke.common.Messages.MESSAGE_NO_TASK_MODIFIED;
import static seedu.duke.common.Messages.MESSAGE_TASK_BEING_EDITED;
import static seedu.duke.common.Messages.MESSAGE_TASK_FIELDS_SELECT_INFO;
import static seedu.duke.common.Messages.MESSAGE_TASK_FIELDS_TO_EDIT;
import static seedu.duke.common.Messages.MESSAGE_TASK_LIST_EMPTY;
import static seedu.duke.common.Messages.MESSAGE_TASK_TO_EDIT;

public class EditTaskCommand extends Command {
    private final String[] fields = {TASK_FIELD_DESCRIPTION, TASK_FIELD_DEADLINE, 
        TASK_FIELD_REMARKS, TASK_FIELD_GRADED_STATUS};

    @Override
    public void execute(UI ui) {
        Module module = ModuleList.getSelectedModule();
        ArrayList<Task> taskList = module.getTaskList();
        if (taskList.isEmpty()) {
            ui.printMessage(String.format(MESSAGE_TASK_LIST_EMPTY, COMMAND_VERB_EDIT));
            return;
        }
        printPromptForTask(ui, taskList);
        Task selectedTask = getTaskToEdit(ui, taskList);
        // getTaskToEdit() will have displayed error message
        if (selectedTask == null) {
            return;
        }
        printPromptForFields(ui, selectedTask);
        ArrayList<Integer> selectedIndices = getSpecifiedIndices(ui, fields.length);
        if (selectedIndices.isEmpty()) {
            ui.printMessage(MESSAGE_NO_TASK_MODIFIED);
            return;
        }
        for (int index : selectedIndices) {
            selectedTask.editTask(ui, index);
        }
        ui.printMessage(String.format(MESSAGE_EDITED_TASK, selectedTask.toString()));
        ModuleList.writeModule();
        ModuleList.sortTasks();
    }

    private void printPromptForTask(UI ui, ArrayList<Task> taskList) {
        ui.printMessage(MESSAGE_TASK_TO_EDIT);
        ui.printSummarisedTasks(taskList);
    }
    
    private void printPromptForFields(UI ui, Task task) {
        ui.printMessage(String.format(MESSAGE_TASK_BEING_EDITED, task.toString()));
        ui.printMessage(MESSAGE_TASK_FIELDS_TO_EDIT);
        printTaskFields(ui);
        ui.printMessage(MESSAGE_TASK_FIELDS_SELECT_INFO);
    }
    
    private void printTaskFields(UI ui) {
        for (int i = 0; i < fields.length; i++) {
            ui.printMessage(String.format(FORMAT_INDEX_ITEM, i + 1, fields[i]));
        }
    }
}
