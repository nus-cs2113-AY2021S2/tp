package io;

import employee.Employee;
import parser.DataParser;
import shift.Shift;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

    private static DataParser dataParser;

    public FileManager() {
        dataParser = new DataParser();
    }

    public void saveEmployees(ArrayList<Employee> employees) throws IOException {
        File path = new File("employees.txt");
        if (!path.exists()) {
            if (!path.createNewFile()) {
                throw new IOException();
            }
        }
        FileWriter fileWriter = new FileWriter(path);
        for (Employee employee : employees) {
            fileWriter.write(employee.formatData());
        }
        fileWriter.flush();
        fileWriter.close();
    }

    public void saveShifts(ArrayList<Shift> shifts) throws IOException {
        File path = new File("shifts.txt");
        if (!path.exists()) {
            if (!path.createNewFile()) {
                throw new IOException();
            }
        }
        FileWriter fileWriter = new FileWriter(path);
        for (Shift shift : shifts) {
            fileWriter.write(shift.formatData());
        }
        fileWriter.flush();
        fileWriter.close();
    }

    public ArrayList<Employee> loadEmployees() throws FileNotFoundException {
        ArrayList<Employee> employees = new ArrayList<>();

        File path = new File("employees.txt");
        if (!path.exists()) {
            throw new FileNotFoundException();
        }
        Scanner scanner = new Scanner(path);
        try {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                Employee employee = dataParser.parseData(line);
                if (employee != null) {
                    employees.add(employee);
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to load employees!");
        }
        return employees;
    }

    public ArrayList<Shift> loadShifts() throws FileNotFoundException {
        ArrayList<Shift> shifts = new ArrayList<>();

        File path = new File("shifts.txt");
        if (!path.exists()) {
            throw new FileNotFoundException();
        }
        Scanner scanner = new Scanner(path);
        try {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                Shift shift = dataParser.parseShift(line);
                if (shift != null) {
                    shifts.add(shift);
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to load shifts!");
        }
        return shifts;
    }
}
