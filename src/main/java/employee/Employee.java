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

    public void addSchedule(String schedule){
        schedules.add(schedule);
    }

    public void dropSchedule(String schedule){
        schedules.remove(schedule);
    }

    public ArrayList<String> getSchedules(){
        return schedules;
    }
}
