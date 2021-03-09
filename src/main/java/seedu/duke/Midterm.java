package seedu.duke;

public class Midterm extends Task {
    protected String on;

    public Midterm(String module, String description, String message, String on) {
        super(module, description, message);
        this.on = on;
    }

    @Override
    public String toString() {
        return super.toString() + " (on: " + on + ")";
    }
}
