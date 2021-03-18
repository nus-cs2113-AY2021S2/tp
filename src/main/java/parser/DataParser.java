package parser;

import employee.Employee;

public class DataParser {
    public Employee parseData(String line) {
        String[] splitByHex = line.split("#");
        Employee parsedEmployee = new Employee(null);

        parsedEmployee.setName(splitByHex[0]);
        for (int scheduleIndex=1; scheduleIndex<splitByHex.length; scheduleIndex++) {
            parsedEmployee.addSchedule(splitByHex[scheduleIndex]);
        }

        return parsedEmployee;
    }
}
