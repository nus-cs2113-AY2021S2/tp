package shift;

import employee.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ShiftController {

    public static void addShift(ArrayList<Employee> employees, ArrayList<Shift> shifts) {
        System.out.println("Enter Shift date (in dd/MM/yyyy):");
        Scanner sc = new Scanner(System.in);
        String date = sc.nextLine();
        LocalDate shiftDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Enter Shift index:");
        int shiftIndex = Integer.parseInt(sc.nextLine());
        System.out.println("Enter vacancy for this shift:");
        int vacancy = Integer.parseInt(sc.nextLine());
        ArrayList<Employee> employeesOnShift = new ArrayList<>();
        boolean runLoop = true;
        do {
            System.out.println("Enter employees on this shift (Q to quit):");
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("Q")) {
                runLoop = false;
            } else {
                boolean employeeFound = false;
                for (Employee person : employees) {
                    if (person.getName().equals(name)) {
                        employeesOnShift.add(person);
                        System.out.println("Employee " + name + " added to shift.");
                        employeeFound = true;
                    }
                }
                if (!employeeFound) {
                    System.out.println("Employee not found.");
                }
            }
        } while (runLoop);
        Shift shift = new Shift(employeesOnShift, shiftDate, shiftIndex, vacancy);
        shifts.add(shift);
    }

    public static void assignEmployee(ArrayList<Employee> employees, ArrayList<Shift> shifts) {
        System.out.println("Enter Employee name to assign:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        for (Employee person : employees) {
            if (person.getName().equals(name)) {
                System.out.println("Enter Shift date (in dd/MM/yyyy)");
                String date = sc.nextLine();
                LocalDate shiftDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                System.out.println("Enter Shift index:");
                int shiftIndex = Integer.parseInt(sc.nextLine());
                for (Shift shift : shifts) {
                    if (shift.getShiftDate().equals(shiftDate) && shift.getShiftIndex() == shiftIndex) {
                        shift.assignEmployee(person);
                        return;
                    }
                }
                System.out.println("Shift not found");
                return;
            }
        }
        System.out.println("Employee not found");
    }

    public static void unassignEmployee(ArrayList<Employee> employees, ArrayList<Shift> shifts) {
        System.out.println("Enter Employee name to unassign:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        for (Employee person : employees) {
            if (person.getName().equals(name)) {
                System.out.println("Enter Shift date (in dd/MM/yyyy)");
                String date = sc.nextLine();
                LocalDate shiftDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                System.out.println("Enter Shift index:");
                int shiftIndex = Integer.parseInt(sc.nextLine());
                for (Shift shift : shifts) {
                    if (shift.getShiftDate().equals(shiftDate) && shift.getShiftIndex() == shiftIndex) {
                        shift.unassignEmployee(person);
                        return;
                    }
                }
                System.out.println("Shift not found");
                return;
            }
        }
        System.out.println("Employee not found");
    }

    @@justinaquak
    public static void viewAllShifts(ArrayList<Shift> shifts){
        for (Shift item : shifts){
            System.out.println("On " + item.getShiftDate() + ", the employees scheduled are: " + item.getEmployees());
        }
    }

    public static void viewOneShift(ArrayList<Shift> shifts) {
        System.out.println("Enter Shift date (in dd/MM/yyyy):");
        Scanner sc = new Scanner(System.in);
        String date = sc.nextLine();
        LocalDate shiftDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        boolean dateFound = false;
        for (Shift item : shifts) {
            if (item.getShiftDate().equals(shiftDate)) {
                System.out.println("Enter Shift index:");
                int shiftIndex = Integer.parseInt(sc.nextLine());
                if (item.getShiftIndex() == shiftIndex) {
                    System.out.println("The people assigned to the shift are:" + item.getEmployees());
                }
                else {System.out.println("Shift Index selected is not available");}
                dateFound = true;
            }
        }
        if (!dateFound){
            System.out.println("Date chosen has no shifts");
        }
    }
}
