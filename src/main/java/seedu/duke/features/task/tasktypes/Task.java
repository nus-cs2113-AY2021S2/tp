package seedu.duke.features.task.tasktypes;

//@@author hazelhedmine-reused
//Reused from https://github.com/hazelhedmine/ip/blob/master/src/main/java/duke/task/Task.java
//with modifications
public class Task {
    protected String description;
    protected String module;
    protected String message;
    protected boolean isDone;

    public Task(String module, String description, String message) {
        this.description = description;
        this.module = module;
        this.message = message;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public String getModule() {
        return module;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return (isDone ? "[DONE] " : "[    ] ");
    }

    public String getTaskType() {
        return "[Task]";
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void markAsUnDone() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        return "[" + this.getModule() + "]" + this.getStatus() + description;
    }

}
