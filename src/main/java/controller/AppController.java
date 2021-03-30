package controller;

import employee.Employee;
import io.FileManager;
import shift.Shift;
import shift.ShiftController;
import ui.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AppController {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static ArrayList<Shift> shifts = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);
    FileManager fileManager = new FileManager();

    public void run() throws IOException {
        try {
            employees = fileManager.loadEmployees();
            shifts = fileManager.loadShifts();
            System.out.println("Save data loaded!");
            for (Shift shift : shifts) {
                if (shift.getEmployeeList() != null) {
                    for (String employee : shift.getEmployeeList()) {
                        shift.assignEmployee(getEmployeeObjectByName(employee));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("No save files found.");
        }

        String input;
        while (true) {
            System.out.println("Enter command: ");
            input = sc.nextLine();
            switch (input.toLowerCase()) {
            case "add employee":
                addEmployee();
                break;
            /*case "drop employee":
                dropEmployee();
                break;*/
            case "add schedule":
                addSchedule();
                break;
            case "drop schedule":
                dropSchedule();
                break;
            case "add shift":
                ShiftController.addShift(employees, shifts);
                break;
            case "assign employee":
                ShiftController.assignEmployee(employees, shifts);
                break;
            case "unassign employee":
                ShiftController.unassignEmployee(employees, shifts);
                break;
            case "view employee schedule":
                viewEmployeeSchedule();
                break;
            case "view shift status":
                ShiftController.viewAllShifts(shifts);
                break;
            case "view one shift":
                ShiftController.viewOneShift(shifts);
                break;
            case "list":
                listAllEmployees();
                break;
            case "help":
                ui.printHelpMessage();
                break;
            case "quit":
                System.out.println("bye");
                fileManager.saveEmployees(employees);
                fileManager.saveShifts(shifts);
                return;
            default:
                System.out.println("invalid command");
            }
        }
    }

    private void addEmployee() {
        System.out.println("enter Employee name");
        String name = sc.nextLine();
        Employee newEmployee = new Employee(name);
        employees.add(newEmployee);
        System.out.println("Employee added");
    }

    private void dropEmployee(){
        System.out.println("enter Employee name");
        String name = sc.nextLine();
        for (Employee person : employees)
            if (person.getName().equals(name)) {
                employees.remove(person);
                System.out.print(person.getName() + " removed\n");
                return;
            }
        System.out.println("The name is not found");
    }

    private void listAllEmployees() {
        int i;

        System.out.println("Here is the employee list:");
        for (i = 0; i < employees.size(); i++) {
            System.out.println(i+1 + ") " + employees.get(i).getName());
        }
    }

    private void addSchedule() {
        System.out.println("enter Employee name");
        String name = sc.nextLine();
        for (Employee person : employees)
            if (person.getName().equals(name)) {
                System.out.println("enter Employee schedule");
                String schedule = sc.nextLine();
                boolean isScheduleValid = person.addSchedule(schedule);
                if(isScheduleValid) {
                    System.out.println("schedule added");
                }else{
                    System.out.println("Please enter a valid schedule in this format: dd/mm/yyyy");
                }
                return;
            }
        System.out.println("Employee not found");
    }

    private void dropSchedule() {
        System.out.println("enter Employee name");
        String name = sc.nextLine();
        for (Employee person : employees)
            if (person.getName().equals(name)) {
                System.out.println("enter Employee schedule");
                String scheduleToDrop = sc.nextLine();
                ArrayList<String> schedules = person.getSchedules();
                for (String schedule : schedules) {
                    if (schedule.equals(scheduleToDrop)) {
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

    private void viewEmployeeSchedule() {
        System.out.println("enter Employee name");
        String name = sc.nextLine();
        for (Employee person : employees)
            if (person.getName().equals(name)) {
                System.out.println(person.getSchedules());
                return;
            }
        System.out.println("Employee not found");
    }

    public boolean isEmployeeFound(String name) {
        for (Employee person : employees) {
            if (person.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Employee getEmployeeObjectByName(String name) {
        for (Employee person: employees) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }
}

