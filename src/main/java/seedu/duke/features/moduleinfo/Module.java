package seedu.duke.features.moduleinfo;

import seedu.duke.features.task.tasktypes.Task;

import java.util.ArrayList;
import java.util.Hashtable;

public class Module {

    protected String name;
    protected String description;
    protected String review;
    protected Hashtable<String, Integer> components;
    protected int mc;
    protected String grade;
    protected ArrayList<Task> tasks;
    protected String zoomLink;



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

    public String getZoomLink() {
        return this.zoomLink;
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
        return "Name: " + getName() + "\n\nDescription:\n"
                + getDescription() + "\n\nComponents:\n" + getComponentsToString()
                + "\n\nReview:\n" + getReview()
                + "\n\nModular Credit:\n" + getMc() + "\n\nGrade:\n" + getGrade()
                + "\n\nZoom Link:\n" + getZoomLink();
    }

    public void removeZoomLink() {
        this.zoomLink = "No zoom links found!";
    }

    public void removeReview() {
        this.review = "You have not reviewed this module yet.";
    }

    public void setMc(int mc) {
        this.mc = mc;
    }

    public int getMc() {
        return mc;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getComponentsToString() {
        if (!components.isEmpty()) {
            return components.toString();
        } else {
            return "You have not added components yet.";
        }
    }
}