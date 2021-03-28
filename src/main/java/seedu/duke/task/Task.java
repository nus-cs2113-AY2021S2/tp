package seedu.duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static seedu.duke.common.Constants.FORMAT_DATE_NORMAL;
import static seedu.duke.common.Messages.FORMAT_TASK_FIELDS;
import static seedu.duke.common.Messages.MESSAGE_GRADED_STATUS;
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

    public void editTaskDescription(String newDescription) {
        this.setDescription(newDescription);
    }

    public void editTaskDeadline(LocalDate newDeadline) {
        if (newDeadline == null) {
            return;
        }
        this.setDeadline(newDeadline);
    }

    public void editTaskRemarks(String newRemarks) {
        this.setRemarks(newRemarks);
    }

    public void editTaskGradedStatus(boolean isGraded) {
        this.setGraded(isGraded);
    }
}
