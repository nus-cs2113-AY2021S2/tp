package controller;

import java.util.ArrayList;
import java.util.Scanner;
import employee.*;

public class AppController {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public void run(){
        String input;
        while (true){
            System.out.println("Enter command: ");
            input = sc.nextLine();
            switch (input){
            case "add Employee":
                addEmployee();
                break;
            case "add schedule" :
                addSchedule();
                break;
            case "drop schedule" :
                dropSchedule();
                break;
            case "view Employee schedule":
                viewEmployeeSchedule();
                break;
            case "view shift status":

            case "quit":
                System.out.println("bye");
                return;
            default:
                System.out.println("invalid command");
            }
        }
    }

    private void addEmployee(){
        System.out.println("enter Employee name");
        String name = sc.nextLine();
        Employee newEmployee = new Employee(name);
        employees.add(newEmployee);
        System.out.println("Employee added");
    }

    private void addSchedule(){
        System.out.println("enter Employee name");
        String name = sc.nextLine();
        for(Employee person:employees)
            if(person.getName().equals(name)) {
                System.out.println("enter Employee schedule");
                String schedule = sc.nextLine();
                person.addSchedule(schedule);
                System.out.println("schedule added");
                return;
            }
        System.out.println("Employee not found");
    }

    private void dropSchedule(){
        System.out.println("enter Employee name");
        String name = sc.nextLine();
        for(Employee person:employees)
            if(person.getName().equals(name)) {
                System.out.println("enter Employee schedule");
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
        System.out.println("Employee not found");
    }

    private void viewEmployeeSchedule(){
        System.out.println("enter Employee name");
        String name = sc.nextLine();
        for(Employee person:employees)
            if(person.getName().equals(name)) {
                System.out.println(person.getSchedules());
                return;
            }
        System.out.println("Employee not found");
    }

}
