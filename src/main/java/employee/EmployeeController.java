package employee;

import asserts.Asserter;
import ui.Ui;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeController {

    private static final Scanner sc = new Scanner(System.in);

    public static void addEmployee(ArrayList<Employee> employees) {
        System.out.println("enter Employee name");
        String name = sc.nextLine();
        if (isEmployeeDuplicate(employees, name)) {
            System.out.println("This employee already exist in the database");
        } else {
            Employee newEmployee = new Employee(name);
            employees.add(newEmployee);
            System.out.println("Employee added");
        }
    }

    private static boolean isEmployeeDuplicate(ArrayList<Employee> employees, String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void addSchedule(ArrayList<Employee> employees) {
        System.out.println("enter Employee name");
        String name = sc.nextLine();
        for (Employee person : employees) {
            if (person.getName().equals(name)) {
                System.out.println("enter Employee schedule");
                String schedule = sc.nextLine();
                if (isScheduleDuplicate(person, schedule)) {
                    System.out.println("This schedule already exist in the database");
                    return;
                }
                boolean isScheduleValid = person.addSchedule(schedule);
                if (isScheduleValid) {
                    System.out.println("schedule added");
                } else {
                    System.out.println("The schedule is invalid");
                    Ui.printInvalidScheduleFeedbackMessage();
                }
                return;
            }
        }
        System.out.println("Employee not found");
    }

    private static boolean isScheduleDuplicate(Employee employee, String newSchedule) {
        ArrayList<String> employeeSchedules = employee.getSchedules();
        for (String schedule : employeeSchedules) {
            if (schedule.equals(newSchedule)) {
                return true;
            }
        }
        return false;
    }

    public static void dropSchedule(ArrayList<Employee> employees) {
        System.out.println("enter Employee name");
        String name = sc.nextLine();
        for (Employee person : employees) {
            if (person.getName().equals(name)) {
                System.out.println("enter Employee schedule");
                String scheduleToDrop = sc.nextLine();
                ArrayList<String> schedules = person.getSchedules();
                int originalScheduleLength = schedules.size();
                for (String schedule : schedules) {
                    if (schedule.equals(scheduleToDrop)) {
                        person.dropSchedule(scheduleToDrop);
                        Asserter.assertIncrementScheduleSize(originalScheduleLength, person);
                        System.out.println("schedule dropped");
                        return;
                    }
                }
                System.out.println("schedule not found");
                return;
            }
        }
        System.out.println("Employee not found");
    }

    public static void listAllEmployees(ArrayList<Employee> employees) {
        int i;
        System.out.println("Here is the employee list:");
        for (i = 0; i < employees.size(); i++) {
            System.out.println(i + 1 + ") " + employees.get(i).getName());
        }
    }

    public boolean isEmployeeFound(String name, ArrayList<Employee> employees) {
        for (Employee person : employees) {
            if (person.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void viewEmployeeSchedule(ArrayList<Employee> employees) {
        System.out.println("enter Employee name");
        String name = sc.nextLine();
        for (Employee person : employees) {
            if (person.getName().equals(name)) {
                System.out.println(person.getSchedules());
                return;
            }
        }
        System.out.println("Employee not found");
    }

    public static Employee getEmployeeObjectByName(String name, ArrayList<Employee> employees) {
        for (Employee person : employees) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }
}
