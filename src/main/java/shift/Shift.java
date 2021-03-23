package shift;

import employee.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Shift {
    private ArrayList<Employee> employees;
    private LocalDate shiftDate;
    private int vacancy;
    private int shiftIndex;

    public Shift(ArrayList<Employee> employees, LocalDate shiftDate, int shiftIndex, int vacancy) {
        this.employees = employees;
        this.shiftDate = shiftDate;
        this.vacancy = vacancy;
        if (shiftIndex < 1 || shiftIndex > 6) {
            System.out.println("Shift Index value not accepted. Values should be 1 to 6.");
        }
        else {
            this.shiftIndex = shiftIndex;
        }
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void assignEmployee(Employee e) {
        if (this.vacancy > 0) {
            employees.add(e);
            this.vacancy--;
            System.out.println("Employee " + e.getName() + " assigned.");
        }
        else {
            System.out.println("Shift is full!");
        }
    }

    public void unassignEmployee(Employee e) {
        employees.remove(e);
        this.vacancy++;
        System.out.println("Employee " + e.getName() + " unassigned.");
    }

    public LocalDate getShiftDate() {
        return shiftDate;
    }

    public String getShiftDateToString() {
        return shiftDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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
        }
        else {
            this.shiftIndex = shiftIndex;
        }
    }

    public int getVacancy() {
        return vacancy;
    }

    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }
}
