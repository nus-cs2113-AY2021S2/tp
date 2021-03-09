package seedu.duke;

public class Assignment extends Task {
    protected String by;

    public Assignment(String module, String description, String message, String by) {
        super(module, description, message);
        this.by = by;
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + by + ")";
    }

}
