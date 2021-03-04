package seedu.duke.task;

import java.time.LocalDate;

public class Task {

    private String description;
    private String remarks;
    private LocalDate deadline;
    private Boolean isDone;
    private Boolean isGraded;

    public Task(String description, String remarks, LocalDate deadline, Boolean isDone, Boolean isGraded) {
        this.description = description;
        this.remarks = remarks;
        this.deadline = deadline;
        this.isDone = isDone;
        this.isGraded = isGraded;
    }

    public String getDescription() {
        return description;
    }

    public String getRemarks() {
        return remarks;
    }

    public LocalDate getDeadline() {
        return deadline;
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

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public void setGraded(Boolean graded) {
        isGraded = graded;
    }
}
