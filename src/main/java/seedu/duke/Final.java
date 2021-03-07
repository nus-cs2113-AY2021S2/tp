package seedu.duke;

public class Final extends Task {
    protected String on;

    public Final(String module, String description, String on) {
        super(module, description);
        this.on = on;
    }

    @Override
    public String toString() {
        return super.toString() + " (on: " + on + ")";
    }
}
