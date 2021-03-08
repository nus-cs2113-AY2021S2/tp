package seedu.duke;

public class FinalExam extends Task {
    protected String on;

    public FinalExam(String module, String description, String on) {
        super(module, description);
        this.on = on;
    }

    @Override
    public String toString() {
        return super.toString() + " (on: " + on + ")";
    }
}
