package shift;

import asserts.Asserter;
import employee.Employee;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Shift {
    private ArrayList<Employee> employees;
    private ArrayList<String> employeeList = null;
    private LocalDate shiftDate;
    private int vacancy;
    private int shiftIndex;

    public Shift(ArrayList<Employee> employees, LocalDate shiftDate, int shiftIndex, int vacancy) {
        Asserter.assertNonNullEmployees(employees);
        this.employees = employees;
        this.shiftDate = shiftDate;
        this.vacancy = vacancy;
        this.shiftIndex = shiftIndex;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<String> getEmployeeList() {
        return employeeList;
    }

    public void setEmployees(ArrayList<String> employees) {
        this.employeeList = employees;
    }

    public void assignEmployee(Employee e) {
        if (this.vacancy > 0) {
            employees.add(e);
            this.vacancy--;
            Asserter.assertPositiveVacancies(this.vacancy);
            System.out.println("Employee " + e.getName() + " is successfully assigned to this shift.");
        } else {
            System.out.println("Shift is full. Employee " + e.getName() + " is not assigned to this shift.");
        }
    }

    public void unassignEmployee(Employee e) {
        employees.remove(e);
        this.vacancy++;
        System.out.println("Employee " + e.getName() + " is successfully unassigned from this shift.");
    }

    public LocalDate getShiftDate() {
        return shiftDate;
    }

    public void setShiftDate(LocalDate shiftDate) {
        this.shiftDate = shiftDate;
    }

    public int getShiftIndex() {
        return shiftIndex;
    }

    public void setShiftIndex(int shiftIndex) {
        if (shiftIndex < 1 || shiftIndex > 6) {
            System.out.println("Shift Index value not accepted. Values should be 1 to 6.");
        } else {
            this.shiftIndex = shiftIndex;
        }
    }

    public int getVacancy() {
        return vacancy;
    }

    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }

    public String getShiftDateToString() {
        return shiftDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String formatData() {
        StringBuilder formattedString = new StringBuilder(getShiftDateToString());
        formattedString.append("#");
        formattedString.append(vacancy);
        formattedString.append("#");
        formattedString.append(shiftIndex);

        for (Employee employee : employees) {
            formattedString.append("#");
            formattedString.append(employee.getName());
        }
        return formattedString + "\n";
    }
}
