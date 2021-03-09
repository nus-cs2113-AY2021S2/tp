package seedu.duke;

//@@author hazelhedmine-reused
//Reused from https://github.com/hazelhedmine/ip/blob/master/src/main/java/duke/task/Task.java
//with modifications
public class Task {
    protected String description;
    protected String module;
    protected String message;

    public Task(String module, String description, String message) {
        this.description = description;
        this.module = module;
        this.message = message;
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

    @Override
    public String toString() {
        return "[" + this.getModule() + "] " + description;
    }

}
