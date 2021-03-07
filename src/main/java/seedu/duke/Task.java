package seedu.duke;

//@@author hazelhedmine-reused
//Reused from https://github.com/hazelhedmine/ip/blob/master/src/main/java/duke/task/Task.java
//with modifications
public class Task {
    protected String description;
    protected String module;

    public Task(String module, String description) {
        this.description = description;
        this.module = module;
    }

    public String getDescription() {
        return description;
    }

    public String getModule() {
        return module;
    }

    @Override
    public String toString() {
        return "[" + this.getModule() + "] " + description;
    }

}
