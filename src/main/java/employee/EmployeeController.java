package employee;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeController {

    private static final Scanner sc = new Scanner(System.in);

    public static void addEmployee(ArrayList<Employee> employees) {
        System.out.println("enter Employee name");
        String name = sc.nextLine();
        Employee newEmployee = new Employee(name);
        employees.add(newEmployee);
        System.out.println("Employee added");
    }

    public static void addSchedule(ArrayList<Employee> employees){
        System.out.println("enter Employee name");
        String name = sc.nextLine();
        for (Employee person : employees) {
            if (person.getName().equals(name)) {
                System.out.println("enter Employee schedule");
                String schedule = sc.nextLine();
                boolean isScheduleValid = person.addSchedule(schedule);
                if (isScheduleValid) {
                    System.out.println("schedule added");
                } else {
                    System.out.println("Please enter a valid schedule in this format: dd/mm/yyyy");
                }
                return;
            }
        }
        System.out.println("Employee not found");
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
                        assert originalScheduleLength == person.getSchedules().size() + 1: "1 schedule " +
                                "is supposed to be dropped.";
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
            System.out.println(i+1 + ") " + employees.get(i).getName());
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
        for (Employee person : employees)
            if (person.getName().equals(name)) {
                System.out.println(person.getSchedules());
                return;
            }
        System.out.println("Employee not found");
    }

    public static Employee getEmployeeObjectByName(String name, ArrayList<Employee> employees) {
        for (Employee person: employees) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

}
