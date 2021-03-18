package controller;

import java.util.ArrayList;
import java.util.Scanner;
import employee.*;

public class appController {
    private static ArrayList<employee> emloyees = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public void run(){
        String input;
        while (true){
            System.out.println("Enter command: ");
            input = sc.nextLine();
            switch (input){
            case "add employee":
                addEmployee();
                break;
            case "add schedule" :
                addSchedule();
                break;
            case "drop schedule" :
                dropSchedule();
                break;
            case "quit":
                System.out.println("bye");
                return;
            default:
                System.out.println("invalid command");
            }
        }
    }

    private void addEmployee(){
        System.out.println("enter employee name");
        String name = sc.nextLine();
        employee newEmployee = new employee(name);
        emloyees.add(newEmployee);
        System.out.println("employee added");
    }

    private void addSchedule(){
        System.out.println("enter employee name");
        String name = sc.nextLine();
        for(employee person:emloyees)
            if(person.getName().equals(name)) {
                System.out.println("enter employee schedule");
                String schedule = sc.nextLine();
                person.addSchedule(schedule);
                System.out.println("schedule added");
                return;
            }
        System.out.println("employee not found");
    }

    private void dropSchedule(){
        System.out.println("enter employee name");
        String name = sc.nextLine();
        for(employee person:emloyees)
            if(person.getName().equals(name)) {
                System.out.println("enter employee schedule");
                String scheduleToDrop = sc.nextLine();
                ArrayList<String> schedules = person.getSchedules();
                for(String schedule:schedules){
                    if(schedule.equals(scheduleToDrop)){
                        person.dropSchedule(scheduleToDrop);
                        System.out.println("schedule dropped");
                        return;
                    }
                }
                System.out.println("schedule not found");
                return;
            }
        System.out.println("employee not found");
    }

}
