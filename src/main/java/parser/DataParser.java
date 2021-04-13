package parser;

import employee.Employee;
import shift.Shift;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DataParser {
    public Employee parseData(String line) {
        String[] splitByHex = line.split("#");
        Employee parsedEmployee = new Employee(null);

        parsedEmployee.setName(splitByHex[0]);
        for (int scheduleIndex = 1; scheduleIndex < splitByHex.length; scheduleIndex++) {
            parsedEmployee.addSchedule(splitByHex[scheduleIndex]);
        }

        return parsedEmployee;
    }

    public Shift parseShift(String line) {
        String[] splitByHex = line.split("#");
        ArrayList<Employee> employees = new ArrayList<>();
        Shift parsedShift = new Shift(employees, null, 1, 0);

        parsedShift.setShiftDate(LocalDate.parse(splitByHex[0], DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        parsedShift.setVacancy(Integer.parseInt(splitByHex[1]));
        parsedShift.setShiftIndex(Integer.parseInt(splitByHex[2]));

        ArrayList<String> employeeNames = new ArrayList<>();
        for (int shiftIndex = 3; shiftIndex < splitByHex.length; shiftIndex++) {
            employeeNames.add(splitByHex[shiftIndex]);
        }
        parsedShift.setEmployees(employeeNames);

        return parsedShift;
    }
}
