package seedu.duke.task;

public class FinalExam extends Task {
    protected String on;

    public FinalExam(String module, String description, String message, String on) {
        super(module, description, message);
        this.on = on;
    }

    @Override
    public String toString() {
        return super.toString() + " (on: " + on + ")";
    }
}
