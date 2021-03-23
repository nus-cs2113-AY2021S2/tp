package seedu.duke;

import seedu.duke.task.Task;

import java.util.ArrayList;
import java.util.Hashtable;

public class Module {

    protected String description;
    protected String review;
    protected String name;
    protected Hashtable<String, Integer> components;
    protected String zoomLink;
    protected ArrayList<Task> tasks;

    public Module(String name, String description) {
        this.name = name;
        this.description = description;
        this.review = "You have not reviewed this module yet.";
        this.components = new Hashtable<>();
        this.tasks = new ArrayList<>();
        zoomLink = "No zoom link found!";
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

    public void setZoomLink(String zoomLink) {
        this.zoomLink = zoomLink;
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

    public void removeZoomLink() {
        this.zoomLink = "No zoom links found!";
    }

    public void removeReview() {
        this.review = "You have not reviewed this module yet.";
    }
}
