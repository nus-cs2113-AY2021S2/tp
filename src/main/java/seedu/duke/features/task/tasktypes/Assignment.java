package seedu.duke.features.task.tasktypes;

public class Assignment extends Task {
    protected String by;

    public Assignment(String module, String description, String message, String by) {
        super(module, description, message);
        this.by = by;
    }

    public String getBy() {
        return by;
    }

    @Override
    public String getTaskType() {
        return "[Assignment]";
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + by + ")";
    }

}
