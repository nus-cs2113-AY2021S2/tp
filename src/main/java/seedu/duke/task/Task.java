package seedu.duke.task;

import seedu.duke.ui.UI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static seedu.duke.common.Constants.FORMAT_DATE_IO;
import static seedu.duke.common.Constants.FORMAT_DATE_NORMAL;
import static seedu.duke.common.Constants.NO_STRING;
import static seedu.duke.common.Constants.YES_STRING;
import static seedu.duke.common.Messages.FORMAT_TASK_FIELDS;
import static seedu.duke.common.Messages.MESSAGE_GRADED_STATUS;
import static seedu.duke.common.Messages.MESSAGE_INVALID_TASK_DEADLINE;
import static seedu.duke.common.Messages.MESSAGE_TASK_CHECK_GRADED;
import static seedu.duke.common.Messages.MESSAGE_TASK_CHECK_GRADED_INFO;
import static seedu.duke.common.Messages.MESSAGE_TASK_DEADLINE_TO_EDIT;
import static seedu.duke.common.Messages.MESSAGE_TASK_DESCRIPTION_TO_EDIT;
import static seedu.duke.common.Messages.MESSAGE_TASK_REMARKS_TO_EDIT;
import static seedu.duke.common.Messages.MESSAGE_UNGRADED_STATUS;

public class Task {
    
    //@@author 8kdesign
    private String description;
    private LocalDate deadline;
    private String remarks;
    private Boolean isDone;
    private Boolean isGraded;
    
    public Task(String description, LocalDate deadline, String remarks) {
        this.description = description;
        this.deadline = deadline;
        this.remarks = remarks;
        this.isDone = false;
        this.isGraded = false;
    }

    public Task(String description, LocalDate deadline, String remarks, 
                Boolean isDone, Boolean isGraded) {
        this.description = description;
        this.deadline = deadline;
        this.remarks = remarks;
        this.isDone = isDone;
        this.isGraded = isGraded;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public String getRemarks() {
        return remarks;
    }

    public Boolean getDone() {
        return isDone;
    }

    public Boolean getGraded() {
        return isGraded;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public void setGraded(Boolean graded) {
        isGraded = graded;
    }

    //@@author aliciatay-zls
    @Override
    public String toString() {
        String formattedDeadline = this.deadline.format(DateTimeFormatter.ofPattern(FORMAT_DATE_NORMAL));
        String gradedStatus = this.getGraded() ? MESSAGE_GRADED_STATUS : MESSAGE_UNGRADED_STATUS;
        //to improve formatting when printing: when field(s) are empty, indentation
        return String.format(FORMAT_TASK_FIELDS, this.getDescription(),
                formattedDeadline, this.getRemarks(), gradedStatus);
    }

    public void markDone() {
        this.setDone(true);
    }

    public void markUndone() {
        this.setDone(false);
    }

    public void editTask(UI ui, int fieldIndex) {
        switch (fieldIndex) {
        case 1:
            editTaskDescription(ui);
            break;
        case 2:
            editTaskDeadline(ui);
            break;
        case 3:
            editTaskRemarks(ui);
            break;
        case 4:
            editTaskGradedStatus(ui);
            break;
        default:
        }
    }

    public void editTaskDescription(UI ui) {
        ui.printMessage(MESSAGE_TASK_DESCRIPTION_TO_EDIT);
        String newDescription = ui.readCommand();
        this.setDescription(newDescription);
    }

    public void editTaskDeadline(UI ui) {
        ui.printMessage(MESSAGE_TASK_DEADLINE_TO_EDIT);
        String input = ui.readCommand();
        DateTimeFormatter parseFormat = DateTimeFormatter.ofPattern(FORMAT_DATE_IO);
        try {
            LocalDate newDeadline = LocalDate.parse(input, parseFormat);
            this.setDeadline(newDeadline);
        } catch (DateTimeParseException e) {
            ui.printMessage(MESSAGE_INVALID_TASK_DEADLINE);
            editTask(ui, 2);
        }
    }

    public void editTaskRemarks(UI ui) {
        ui.printMessage(MESSAGE_TASK_REMARKS_TO_EDIT);
        String newRemarks = ui.readCommand();
        this.setRemarks(newRemarks);
    }

    public void editTaskGradedStatus(UI ui) {
        boolean isGraded = this.getIsTaskGraded(ui);
        this.setGraded(isGraded);
    }

    /**
     * Asks user if the task to be added is a graded one.
     *
     * @param ui Instance of UI.
     * @return Boolean of whether new task is graded.
     */
    public boolean getIsTaskGraded(UI ui) {
        ui.printMessage(MESSAGE_TASK_CHECK_GRADED);
        String userInput = ui.readCommand();
        while (!userInput.equalsIgnoreCase(YES_STRING) 
                && !userInput.equalsIgnoreCase(NO_STRING)) {
            ui.printMessage(MESSAGE_TASK_CHECK_GRADED_INFO);
            userInput = ui.readCommand();
        }
        return userInput.equalsIgnoreCase(YES_STRING);
    }
}
