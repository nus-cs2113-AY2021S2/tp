package seedu.duke;

import java.util.Hashtable;

public class Module {
    protected String description;
    protected String review;
    protected String name;
    protected Hashtable<String, Integer> components;

    public Module(String name, String description, String review) {
        this.name = name;
        this.description = description;
        this.review = review;
        this.components = new Hashtable<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setComponents(Hashtable<String, Integer> components) {
        this.components = components;
    }

    public Hashtable<String, Integer> getComponents() {
        return components;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getReview() {
        return this.review;
    }

    public String toString() {
        return getName() + "\n" + getDescription() + "\n" + getReview() + "\n";
    }

}
