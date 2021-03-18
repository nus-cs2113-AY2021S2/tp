package employee;

import java.util.ArrayList;

public class employee {
    private String name;
    private ArrayList<String> schedules = new ArrayList<>();

    public employee(String name){
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
