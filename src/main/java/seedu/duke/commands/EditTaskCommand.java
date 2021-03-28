package seedu.duke.commands;

import seedu.duke.exception.DukeException;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.parser.Parser;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import static seedu.duke.common.CommonMethods.getIsTaskGraded;
import static seedu.duke.common.Constants.FORMAT_DATE_IO;
import static seedu.duke.common.Constants.TASK_FIELD_DEADLINE;
import static seedu.duke.common.Constants.TASK_FIELD_DESCRIPTION;
import static seedu.duke.common.Constants.TASK_FIELD_GRADED_STATUS;
import static seedu.duke.common.Constants.TASK_FIELD_REMARKS;
import static seedu.duke.common.Messages.COMMAND_VERB_EDIT;
import static seedu.duke.common.Messages.FORMAT_FIELD;
import static seedu.duke.common.Messages.FORMAT_INDEX_ITEM;
import static seedu.duke.common.Messages.FORMAT_TASK_DEADLINE;
import static seedu.duke.common.Messages.MESSAGE_EDITED_FIELD;
import static seedu.duke.common.Messages.MESSAGE_INVALID_TASK_DEADLINE;
import static seedu.duke.common.Messages.MESSAGE_NOT_UPDATED;
import static seedu.duke.common.Messages.MESSAGE_NO_TASK_MODIFIED;
import static seedu.duke.common.Messages.MESSAGE_TASK_BEING_EDITED;
import static seedu.duke.common.Messages.MESSAGE_TASK_DEADLINE_TO_EDIT;
import static seedu.duke.common.Messages.MESSAGE_TASK_DESCRIPTION_TO_EDIT;
import static seedu.duke.common.Messages.MESSAGE_TASK_FIELDS_SELECT_INFO;
import static seedu.duke.common.Messages.MESSAGE_TASK_FIELDS_TO_EDIT;
import static seedu.duke.common.Messages.MESSAGE_TASK_LIST_EMPTY;
import static seedu.duke.common.Messages.MESSAGE_TASK_REMARKS_TO_EDIT;
import static seedu.duke.common.Messages.MESSAGE_TASK_TO_EDIT;
import static seedu.duke.common.Messages.NEWLINE;

public class EditTaskCommand extends Command {
    
    private final String[] fields = {TASK_FIELD_DESCRIPTION, TASK_FIELD_DEADLINE, 
        TASK_FIELD_REMARKS, TASK_FIELD_GRADED_STATUS};
    private Task selectedTask;

    @Override
    public void execute(UI ui) {
        Module module = ModuleList.getSelectedModule();
        ArrayList<Task> taskList = module.getTaskList();
        if (taskList.isEmpty()) {
            ui.printMessage(String.format(MESSAGE_TASK_LIST_EMPTY, COMMAND_VERB_EDIT));
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
    
    private void editTaskField(UI ui, int fieldIndex) {
        switch (fieldIndex) { 
        case 1:
            selectedTask.setDescription(getNewTaskDescription(ui));
            break;
        case 2:
            LocalDate newDeadline = getNewTaskDeadline(ui);
            if (newDeadline == null) {
                return;
            }
            selectedTask.setDeadline(newDeadline);
            break;
        case 3:
            selectedTask.setRemarks(getNewTaskRemarks(ui));
            break;
        case 4:
             ui.printMessage("");
             selectedTask.setGraded(getIsTaskGraded(ui));
             break;
        default:
        }
        ui.printMessage(String.format(MESSAGE_EDITED_FIELD, fields[fieldIndex - 1].toLowerCase()));
    }

    private void printPromptForTask(UI ui, ArrayList<Task> taskList) {
        ui.printMessage(MESSAGE_TASK_TO_EDIT);
        for (int i = 0; i < taskList.size(); i++) {
            ui.printMessage(String.format(FORMAT_INDEX_ITEM, i + 1, getTaskToPrint(taskList.get(i))));
        }
    }
    
    private static StringBuilder getTaskToPrint(Task task) {
        StringBuilder taskString = new StringBuilder();
        taskString.append(String.format(FORMAT_TASK_DEADLINE, task.getDescription(),
                task.getFormattedDeadline()));
        taskString.append(NEWLINE);
        if (!task.getRemarks().isEmpty()) {
            taskString.append(String.format(FORMAT_FIELD, task.getRemarks()));
            taskString.append(NEWLINE);
        }
        taskString.append(String.format(FORMAT_FIELD, task.getGradedStatus()));
        return taskString;
    }

    private Task getTaskToEdit(UI ui, ArrayList<Task> taskList) {
        String line = ui.readCommand();
        try {
            int index = Parser.checkIndex(line, taskList.size());
            return taskList.get(index - 1);
        } catch (DukeException e) {
            ui.printError(e);
            return null;
        }
    }
    
    private void printPromptForFields(UI ui) {
        ui.printMessage(String.format(MESSAGE_TASK_BEING_EDITED, selectedTask.getDescription()));
        ui.printMessage(MESSAGE_TASK_FIELDS_TO_EDIT);
        printTaskFields(ui);
        ui.printMessage(MESSAGE_TASK_FIELDS_SELECT_INFO);
    }
    
    private void printTaskFields(UI ui) {
        for (int i = 0; i < fields.length; i++) {
            ui.printMessage(String.format(FORMAT_INDEX_ITEM, i + 1, fields[i]));
        }
    }
    
    private String getNewTaskDescription(UI ui) {
        ui.printMessage(MESSAGE_TASK_DESCRIPTION_TO_EDIT);
        return ui.readCommand();
    }
    
    private LocalDate getNewTaskDeadline(UI ui) {
        ui.printMessage(MESSAGE_TASK_DEADLINE_TO_EDIT);
        String input = ui.readCommand();
        DateTimeFormatter parseFormat = DateTimeFormatter.ofPattern(FORMAT_DATE_IO);
        try {
            return LocalDate.parse(input, parseFormat);
        } catch (DateTimeParseException e) {
            ui.printMessage(MESSAGE_INVALID_TASK_DEADLINE);
            ui.printMessage(MESSAGE_NOT_UPDATED);
            return null;
        }
    }

    private String getNewTaskRemarks(UI ui) {
        ui.printMessage(MESSAGE_TASK_REMARKS_TO_EDIT);
        return ui.readCommand();
    }
}
