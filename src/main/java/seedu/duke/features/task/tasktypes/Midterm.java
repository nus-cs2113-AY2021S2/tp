package seedu.duke.features.task.tasktypes;

public class Midterm extends Task {
    protected String on;

    public Midterm(String module, String description, String message, String on) {
        super(module, description, message);
        this.on = on;
    }

    public String getOn() {
        return on;
    }

    @Override
    public String getTaskType() {
        return "[Midterm]";
    }

    @Override
    public String toString() {
        return super.toString() + " (on: " + on + ")";
    }
}
