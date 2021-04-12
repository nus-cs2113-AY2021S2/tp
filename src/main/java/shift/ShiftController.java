package shift;

import employee.Employee;
import employee.EmployeeController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ShiftController {

    private static LocalDate getShiftDate() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter Shift date (in dd/MM/yyyy):");
            String date = sc.nextLine();
            LocalDate shiftDate;
            if (Employee.isScheduleValid(date)) {
                shiftDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                return shiftDate;
            }
            System.out.println("Please enter a valid date.");
        }
    }

    private static int getShiftIndex() {
        int shiftIndex = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter Shift index:");
            try {
                shiftIndex = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException | NullPointerException e ) {
                System.out.println("Shift Index value not accepted. Please input integer values from 1 to 6.");
                continue;
            }
            if (shiftIndex < 1 || shiftIndex > 6) {
                System.out.println("Shift Index value not accepted. Please input integer values from 1 to 6.");
            }
        } while (shiftIndex < 1 || shiftIndex > 6);
        return shiftIndex;
    }

    private static int getVacancy() {
        int vacancy = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter Vacancy:");
            try {
                vacancy = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException | NullPointerException e ) {
                System.out.println("Vacancy value not accepted. Please input a positive integer value (greater than 0).");
                continue;
            }
            if (vacancy < 1) {
                System.out.println("Vacancy value not accepted. Please input a positive integer value (greater than 0).");
            }
        } while (vacancy < 1);
        return vacancy;
    }

    private static Shift getShift(LocalDate shiftDate, int shiftIndex, ArrayList<Shift> shifts) {
        for (Shift shift : shifts) {
            if (shift.getShiftDate().equals(shiftDate) && shift.getShiftIndex() == shiftIndex) {
                return shift;
            }
        }
        return null;
    }

    private static Employee getEmployee(String name, ArrayList<Employee> employees) {
        for (Employee person : employees)
            if (person.getName().equals(name)) {
                return person;
            }
        return null;
    }

    // Check if shift date is available in employee's schedule
    private static boolean employeeAvailable(Employee employee, LocalDate shiftDate) {
        String date = shiftDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        for (String schedule : employee.getSchedules()) {
            if (schedule.equals(date)) {
                System.out.println("Employee " + employee.getName() + " is available to work!");
                return true;
            }
        }
        System.out.println("Employee " + employee.getName() + " is unavailable to work!");
        return false;
    }

    // Create a new shift
    public static void addShift(ArrayList<Employee> employees, ArrayList<Shift> shifts) {
        LocalDate shiftDate = getShiftDate();
        int shiftIndex = getShiftIndex();
        if (getShift(shiftDate, shiftIndex, shifts) != null) {
            System.out.println("Shift already exists. Please create another shift instead.");
            return;
        }
        int vacancy = getVacancy();
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employeesOnShift = new ArrayList<>();
        boolean runLoop = true;
        while (runLoop) {
            EmployeeController.listAllEmployees(employees);
            System.out.println("Enter an employee name to assign to this shift:");
            String name = sc.nextLine();
            boolean employeeFound = EmployeeController.isEmployeeFound(name, employees);
            Employee employee = getEmployee(name, employees);
            if (employee == null) {
                System.out.println("No employee in database. Please add an employee with a schedule first.");
                runLoop = false;
            } else if (employeeFound) {
                if (employeeAvailable(employee, shiftDate)) {
                    employeesOnShift.add(employee);
                    System.out.println("Employee "  + name + " is successfully assigned to this shift.");
                    vacancy--;
                    Shift shift = new Shift(employeesOnShift, shiftDate, shiftIndex, vacancy);
                    shifts.add(shift);
                    System.out.println("Shift created.");
                    runLoop = false;
                }
            }
            else {
                System.out.println("Employee not found.");
            }
        }
    }

    public static void assignEmployee(ArrayList<Employee> employees, ArrayList<Shift> shifts) {
        viewAllShifts(shifts);
        if (shifts.isEmpty()) {
            return;
        }
        LocalDate shiftDate = getShiftDate();
        int shiftIndex = getShiftIndex();
        if (getShift(shiftDate, shiftIndex, shifts) != null) {
            Shift shift = getShift(shiftDate, shiftIndex, shifts);
            assert shift != null;
            EmployeeController.listAllEmployees(employees);
            System.out.println("Enter Employee name to assign:");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            Employee employee = getEmployee(name, employees);
            if (employee == null) {
                System.out.println("No employee in database. Please add an employee with a schedule first.");
                return;
            }
            else if (employeeAvailable(employee, shiftDate)) {
                if (!shift.getEmployees().contains(employee)) {
                    shift.assignEmployee(employee);
                }
                else {
                    System.out.println("Employee " + name + " is already assigned to the shift. Please assign another employee.");
                }
                return;
            }
            System.out.println("Employee " + name + " is not assigned to this shift. Please assign another employee.");
            return;
        }
        System.out.println("No such shift in database. Please add shift for this index.");
    }

    public static void unassignEmployee(ArrayList<Employee> employees, ArrayList<Shift> shifts) {
        viewAllShifts(shifts);
        if (shifts.isEmpty()) {
            return;
        }
        LocalDate shiftDate = getShiftDate();
        int shiftIndex = getShiftIndex();
        if (getShift(shiftDate, shiftIndex, shifts) != null) {
            Shift shift = getShift(shiftDate, shiftIndex, shifts);
            assert shift != null;
            viewSelectedShift(shift);
            System.out.println("Enter Employee name to unassign:");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            Employee employee = getEmployee(name, employees);
            if (shift.getEmployees().contains(employee)) {
                shift.unassignEmployee(employee);
            }
            else {
                System.out.println("Employee " + name + " is not assigned to this shift. Please unassign another employee.");
            }
            return;
        }
        System.out.println("No such shift in database. Please add shift for this index.");
    }

}
