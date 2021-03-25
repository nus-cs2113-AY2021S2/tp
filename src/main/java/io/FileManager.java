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

    public void saveFile(ArrayList<Employee> employees) throws IOException {
        // TODO: OOP this
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

        File path2 = new File("shifts.txt");
        if (!path2.exists()) {
            if (!path2.createNewFile()) {
                throw new IOException();
            }
        }
        FileWriter fileWriter2 = new FileWriter(path2);
        for (Employee employee : employees) {
            fileWriter2.write(employee.formatData());
        }
        fileWriter2.flush();
        fileWriter2.close();
    }

    public ArrayList<Employee> loadFile() throws FileNotFoundException {
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
            System.out.println("Failed to load!");
        }
        return employees;
    }

    public ArrayList<Shift> loadShifts() throws FileNotFoundException {
        //TODO: Make it OOP
        ArrayList<Shift> shifts = new ArrayList<>();

        File path2 = new File("shifts.txt");
        if (!path2.exists()) {
            throw new FileNotFoundException();
        }
        Scanner scanner2 = new Scanner(path2);
        try {
            while (scanner2.hasNext()) {
                String line = scanner2.nextLine();
                Shift shift = dataParser.parseShift(line);
                if (shift != null) {
                    shifts.add(shift);
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to load!");
        }
        return shifts;
    }
}
