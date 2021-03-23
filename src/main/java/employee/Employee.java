package employee;

import java.util.ArrayList;

public class Employee {
    private String name;
    private ArrayList<String> schedules = new ArrayList<>();

    public Employee(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void addSchedule(String schedule){
        schedules.add(schedule);
    }

    public void dropSchedule(String schedule){
        schedules.remove(schedule);
    }

    public ArrayList<String> getSchedules(){
        return schedules;
    }

    public String formatData() {
        StringBuilder formattedString = new StringBuilder(getName());

        for (String schedule : getSchedules()) {
            formattedString.append("#");
            formattedString.append(schedule);
        }
        return formattedString +"\n";
    }

    @Override
    public String toString(){
        return name;
    }

}
