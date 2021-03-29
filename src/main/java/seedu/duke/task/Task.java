package seedu.duke.task;

import seedu.duke.ui.UI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static seedu.duke.common.Constants.FORMAT_DATE_NORMAL;
import static seedu.duke.common.Constants.WHITESPACE;
import static seedu.duke.common.Messages.FORMAT_ITEM;
import static seedu.duke.common.Messages.FORMAT_ITEM_TIME;
import static seedu.duke.common.Messages.INDENTATION;
import static seedu.duke.common.Messages.MESSAGE_GRADED;
import static seedu.duke.common.Messages.MESSAGE_GRADED_STATUS;
import static seedu.duke.common.Messages.MESSAGE_UNGRADED_STATUS;
import static seedu.duke.common.Messages.NEWLINE;

public class Task {
    
    //@@author 8kdesign
    private String description;
    private LocalDate deadline;
    private String remarks;
    private Boolean isDone;
    private Boolean isGraded;

    /**
     * Class constructor for a new task.
     * This is the default.
     */
    public Task(String description, LocalDate deadline, String remarks) {
        this.description = description;
        this.deadline = deadline;
        this.remarks = remarks;
        this.isDone = false;
        this.isGraded = false;
    }

    /**
     * Class constructor for an existing task.
     * Used by Loader and WriterTest.
     */
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
    /**
     * Concatenates details of the task into a single, two-line, formatted string.
     * @return String giving an overview of the task
     */
    public StringBuilder getTaskString() {
        StringBuilder taskString = new StringBuilder(getDescription());
        taskString.append(getGraded() ? MESSAGE_GRADED : WHITESPACE);
        taskString.append(String.format(FORMAT_ITEM, getFormattedDeadline()));
        if (!isDone) {
            taskString.append(new UI().getDaysRemainingMessage(getDeadline()));
        }
        if (!getRemarks().isEmpty()) {
            taskString.append(NEWLINE).append(INDENTATION).append(getRemarks());
        }
        return taskString;
    }

    /**
     * Concatenates all details of the task into a single, multi-line, indented string.
     * @return String containing all non-empty fields of the task
     */
    public StringBuilder getFullTaskString() {
        StringBuilder taskString = new StringBuilder(String.format(FORMAT_ITEM_TIME, 
                getDescription(), getFormattedDeadline()));
        taskString.append(NEWLINE);
        if (!getRemarks().isEmpty()) {
            taskString.append(INDENTATION).append(getRemarks()).append(NEWLINE);
        }
        taskString.append(INDENTATION).append(getGradedStatus());
        return taskString;
    }

    /**
     * Returns the task's deadline, for displaying to the user.
     */
    public String getFormattedDeadline() {
        return deadline.format(DateTimeFormatter.ofPattern(FORMAT_DATE_NORMAL));
    }

    /**
     * Returns whether the task is graded or not, for displaying to the user.
     */
    public String getGradedStatus() {
        return getGraded() ? MESSAGE_GRADED_STATUS : MESSAGE_UNGRADED_STATUS;
    }
}
