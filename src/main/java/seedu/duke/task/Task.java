package seedu.duke.task;

import java.time.LocalDateTime;

public class Task {

    private String description = "";
    private String remarks = "";
    private LocalDateTime deadline;
    private Boolean isDone = false;
    private Boolean isGraded = false;

    public Task(String description, String remarks, LocalDateTime deadline, Boolean isDone, Boolean isGraded) {
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

    public LocalDateTime getDeadline() {
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

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public void setGraded(Boolean graded) {
        isGraded = graded;
    }
}
