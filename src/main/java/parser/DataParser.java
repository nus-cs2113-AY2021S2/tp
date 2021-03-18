
package parser;

import employee.Employee;

import java.text.ParseException;

public class DataParser {
    public Employee parseData(String line) throws ParseException {
        String[] splitByHex = line.split("#");
        Employee parsedEmployee = null;

        parsedEmployee.setName(splitByHex[0]);
        for (int scheduleIndex=1; scheduleIndex<splitByHex.length; scheduleIndex++) {
            parsedEmployee.addSchedule(splitByHex[scheduleIndex]);
        }

        return parsedEmployee;
    }
}
