package seedu.duke.commands;

import seedu.duke.exception.DukeException;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.parser.ParserUtil;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import static seedu.duke.common.CommonMethods.isTaskGraded;
import static seedu.duke.common.Constants.EDIT;
import static seedu.duke.common.Constants.FORMAT_DATE_IO;
import static seedu.duke.common.Constants.TASK_FIELD_DEADLINE;
import static seedu.duke.common.Constants.TASK_FIELD_DESCRIPTION;
import static seedu.duke.common.Constants.TASK_FIELD_GRADED_STATUS;
import static seedu.duke.common.Constants.TASK_FIELD_REMARKS;
import static seedu.duke.common.Messages.FORMAT_INDEX_ITEM;
import static seedu.duke.common.Messages.MESSAGE_EDITED_FIELD;
import static seedu.duke.common.Messages.MESSAGE_FIELDS_TO_EDIT;
import static seedu.duke.common.Messages.MESSAGE_FIELD_BEING_EDITED;
import static seedu.duke.common.Messages.MESSAGE_INVALID_TASK_DEADLINE;
import static seedu.duke.common.Messages.MESSAGE_NOT_UPDATED;
import static seedu.duke.common.Messages.MESSAGE_NO_TASK_MODIFIED;
import static seedu.duke.common.Messages.MESSAGE_SEPARATE_INDICES;
import static seedu.duke.common.Messages.MESSAGE_TASK_LIST_EMPTY;
import static seedu.duke.common.Messages.MESSAGE_TASK_TO_EDIT;
import static seedu.duke.common.Messages.PROMPT_ENTER_FIELD_DETAILS;

public class EditTaskCommand extends Command {
    
    private final String[] fields = {TASK_FIELD_DESCRIPTION, TASK_FIELD_DEADLINE, 
        TASK_FIELD_REMARKS, TASK_FIELD_GRADED_STATUS};
    private Task selectedTask;

    //@@author aliciatay-zls
    /**
     * Asks user for index of a task to edit, then index/indices of field(s) of
     * that task to be edited. Finally, updates each field with the new value given.
     * @param ui Instance of UI, used for displaying prompts and confirmation messages
     */
    @Override
    public void execute(UI ui) {
        Module module = ModuleList.getSelectedModule();
        ArrayList<Task> taskList = module.getTaskList();
        if (taskList.isEmpty()) {
            ui.printMessage(String.format(MESSAGE_TASK_LIST_EMPTY, EDIT));
            return;
        }
        
        printPromptForTask(ui, taskList);
        selectedTask = getTaskToEdit(ui, taskList);
        // getTaskToEdit() will have displayed error message
        if (selectedTask == null) {
            return;
        }
        
        printPromptForFields(ui);
        ArrayList<Integer> selectedIndices = ui.getIndicesFromUser(fields.length);
        if (selectedIndices.isEmpty()) {
            ui.printMessage(MESSAGE_NO_TASK_MODIFIED);
            return;
        }
        
        for (int index : selectedIndices) {
            editTaskField(ui, index);
        }
        ModuleList.writeModule();
        ModuleList.sortTasks();
    }
    
    private void printPromptForTask(UI ui, ArrayList<Task> taskList) {
        ui.printMessage(MESSAGE_TASK_TO_EDIT);
        int tasksCount = 0;
        for (Task task : taskList) {
            tasksCount++;
            ui.printMessage(String.format(FORMAT_INDEX_ITEM, tasksCount, task.getFullTaskString()));
        }
    }
    
    private Task getTaskToEdit(UI ui, ArrayList<Task> taskList) {
        String line = ui.readUserInput();
        try {
            int index = ParserUtil.checkIndex(line, taskList.size());
            return taskList.get(index - 1);
        } catch (DukeException e) {
            ui.printError(e);
            return null;
        }
    }
    
    private void printPromptForFields(UI ui) {
        ui.printMessage(String.format(MESSAGE_FIELD_BEING_EDITED, selectedTask.getDescription()));
        ui.printMessage(MESSAGE_FIELDS_TO_EDIT);
        printTaskFields(ui);
        ui.printMessage(MESSAGE_SEPARATE_INDICES);
    }
    
    private void printTaskFields(UI ui) {
        for (int i = 0; i < fields.length; i++) {
            ui.printMessage(String.format(FORMAT_INDEX_ITEM, i + 1, fields[i]));
        }
    }

    private void editTaskField(UI ui, int fieldIndex) {
        //assumption: invalid indices should have been filtered out (1-based indexing)
        assert fieldIndex >= 1 && fieldIndex <= 4 : fieldIndex;
        
        ui.printMessage(String.format(PROMPT_ENTER_FIELD_DETAILS, fields[fieldIndex - 1].toLowerCase()));
        switch (fieldIndex) {
        case 1:
            selectedTask.editDescription(ui.readUserInput());
            break;
        case 2:
            LocalDate newDeadline = getNewTaskDeadline(ui, ui.readUserInput());
            if (newDeadline == null) {
                return;
            }
            selectedTask.editDeadline(newDeadline);
            break;
        case 3:
            selectedTask.editRemarks(ui.readUserInput());
            break;
        case 4:
            selectedTask.editGraded(isTaskGraded(ui));
            break;
        default:
        }
        ui.printMessage(String.format(MESSAGE_EDITED_FIELD, fields[fieldIndex - 1].toLowerCase()));
    }

    private LocalDate getNewTaskDeadline(UI ui, String newValue) {
        DateTimeFormatter parseFormat = DateTimeFormatter.ofPattern(FORMAT_DATE_IO);
        try {
            return LocalDate.parse(newValue, parseFormat);
        } catch (DateTimeParseException e) {
            ui.printMessage(MESSAGE_INVALID_TASK_DEADLINE);
            ui.printMessage(MESSAGE_NOT_UPDATED);
            return null;
        }
    }
}
