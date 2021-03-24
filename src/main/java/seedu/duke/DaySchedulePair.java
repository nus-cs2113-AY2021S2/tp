package seedu.duke;

import java.util.ArrayList;

public class DaySchedulePair {
    public String day;
    public ArrayList<String> schedule;

    public DaySchedulePair(String day, ArrayList<String> schedule) {
        this.day = day;
        this.schedule = schedule;
    }

    public String getDay() {
        return day;
    }

    public ArrayList<String> getSchedule() {
        return schedule;
    }
}
