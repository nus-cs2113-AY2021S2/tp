package seedu.duke;

public class Module {
    protected String description;
    protected String review;

    public Module(String description, String review) {
        this.description = description;
        this.review = review;
    }

    public String getDescription() {
        return this.description;
    }

    public String getReview() {
        return this.description;
    }
}
