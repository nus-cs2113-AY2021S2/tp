package seedu.duke;

public class Module {
    protected String description;
    protected String review;
    protected String name;

    public Module(String name, String description, String review) {
        this.name = name;
        this.description = description;
        this.review = review;
    }
    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }

    public String getReview() {
        return this.description;
    }

    public String toString() {
        return getName() + "\n" + getDescription() + "\n" + getReview() + "\n";
    }
}
