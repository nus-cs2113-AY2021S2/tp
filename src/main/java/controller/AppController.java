package controller;

import employee.Employee;
import io.FileManager;
import shift.Shift;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class AppController {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);
    FileManager fileManager = new FileManager();
    private static final ArrayList<Shift> shifts = new ArrayList<Shift>();


    public void run() throws IOException {
        try {
            employees = fileManager.loadFile();
            System.out.println("Save data loaded!");
        } catch (Exception e) {
            System.out.println("No save files found.");
        }

        String input;
        while (true) {
            System.out.println("Enter command: ");
            input = sc.nextLine();
            switch (input) {
            case "add Employee":
                addEmployee();
                break;
            case "add schedule":
                addSchedule();
                break;
            case "drop schedule":
                dropSchedule();
                break;
            case "add Shift":
                addShift();
                break;
            case "assign Employee":
                assignEmployee();
            case "unassign Employee":
                unassignEmployee();
            case "view Employee schedule":
                viewEmployeeSchedule();
                break;
            case "view shift status":
                break;
            case "quit":
                System.out.println("bye");
                fileManager.saveFile(employees);
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

    private void addSchedule() {
        System.out.println("enter Employee name");
        String name = sc.nextLine();
        for (Employee person : employees)
            if (person.getName().equals(name)) {
                System.out.println("enter Employee schedule");
                String schedule = sc.nextLine();
                person.addSchedule(schedule);
                System.out.println("schedule added");
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

    private void addShift() {
        System.out.println("Enter Shift date (in DDMMYYYY):");
        String date = sc.nextLine();
        LocalDate shiftDate = LocalDate.parse(date);
        System.out.println("Enter Shift index:");
        int shiftIndex = Integer.parseInt(sc.nextLine());
        System.out.println("Enter vacancy for this shift:");
        int vacancy = Integer.parseInt(sc.nextLine());
        ArrayList<Employee> employeesOnShift = new ArrayList<Employee>();
        boolean runLoop = true;
        do {
            System.out.println("Enter employees on this shift (Q to quit):");
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("Q")) {
                runLoop = false;
            } else {
                for (Employee person : employees) {
                    if (person.getName().equals(name)) {
                        employeesOnShift.add(person);
                        System.out.println("Employee " + name + " added to shift.");
                    }
                }
                System.out.println("Employee not found.");
            }
        } while (runLoop);
        Shift shift = new Shift(employeesOnShift, shiftDate, shiftIndex, vacancy);
        shifts.add(shift);
    }

    private void assignEmployee() {
        System.out.println("Enter Employee name to assign:");
        String name = sc.nextLine();
        for (Employee person : employees)
            if (person.getName().equals(name)) {
                System.out.println("Enter Shift date (in DDMMYYYY)");
                String date = sc.nextLine();
                LocalDate shiftDate = LocalDate.parse(date);
                System.out.println("Enter Shift index:");
                int shiftIndex = Integer.parseInt(sc.nextLine());
                for (Shift shift : shifts) {
                    if (shift.getShiftDate().equals(shiftDate) && shift.getShiftIndex() == shiftIndex) {
                        shift.assignEmployee(person);
                    }
                }
            }
        System.out.println("Employee not found");
    }

    private void unassignEmployee() {
        System.out.println("Enter Employee name to unassign:");
        String name = sc.nextLine();
        for (Employee person : employees)
            if (person.getName().equals(name)) {
                System.out.println("Enter Shift date (in DDMMYYYY)");
                String date = sc.nextLine();
                LocalDate shiftDate = LocalDate.parse(date);
                System.out.println("Enter Shift index:");
                int shiftIndex = Integer.parseInt(sc.nextLine());
                for (Shift shift : shifts) {
                    if (shift.getShiftDate().equals(shiftDate) && shift.getShiftIndex() == shiftIndex) {
                        shift.unassignEmployee(person);
                    }
                }
            }
        System.out.println("Employee not found");
    }
}

