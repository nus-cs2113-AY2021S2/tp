package controller;

import employee.Employee;
import employee.EmployeeController;
import io.FileManager;
import shift.Shift;
import shift.ShiftController;
import ui.Ui;

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
                    for (String name : shift.getEmployeeList()) {
                        shift.assignEmployee(EmployeeController.getEmployeeObjectByName(name, employees));
                    }
                }
            }
            System.out.println("----------------------------------------------------------------------------\n");
        } catch (Exception e) {
            System.out.println("No save files found.");
            System.out.println("----------------------------------------------------------------------------\n");
        }

        String input;
        while (true) {
            System.out.println("Enter command:\t\t\t(type 'help' for all command options)");
            input = sc.nextLine();
            switch (input.toLowerCase()) {
            case "add employee":
                EmployeeController.addEmployee(employees);
                break;
            case "add schedule":
                EmployeeController.addSchedule(employees);
                break;
            case "drop schedule":
                EmployeeController.dropSchedule(employees);
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
                EmployeeController.viewEmployeeSchedule(employees);
                break;
            case "view shift status":
                ShiftController.viewAllShifts(shifts);
                break;
            case "view one shift":
                ShiftController.viewOneShift(shifts);
                break;
            case "list":
                EmployeeController.listAllEmployees(employees);
                break;
            case "help":
                Ui.printHelpMessage();
                break;
            case "quit":
                sc.close();
                fileManager.saveEmployees(employees);
                fileManager.saveShifts(shifts);
                return;
            default:
                System.out.println("invalid command");
            }
        }
    }
}

