package seedu.allinonenus.moduleplanner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ModulePlanner {
    protected static String moduleCode;
    protected static ArrayList<Student> students;
    protected static int totalSlots;


    public static void setModuleCode(String moduleCode) {
        ModulePlanner.moduleCode = moduleCode;
    }


    public static void setTotalSlots(int totalSlots) {
        ModulePlanner.totalSlots = totalSlots;
    }

    public ModulePlanner() {
        ModulePlanner.moduleCode = moduleCode;
        ModulePlanner.totalSlots = totalSlots;
        students = new ArrayList<>();

    }


    public static String getModuleCode() {
        return moduleCode;
    }

    public static int getTotalSlots() {
        return totalSlots;
    }

    public static void getStudent() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(i + 1 + ". " + students.get(i).toString() + "\n");
        }
    }

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static void findStudent(ArrayList<Student> students, String line) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(line)) {
                System.out.println("The number of students have higher priority than " + line + ": " + i + "\n");
                System.out.println("Chances for " + line + ": " + getChances(i + 1, getTotalSlots()) + "\n");
            }
        }
    }

    public static Priority getChances(int position, int slots) {
        if (position <= slots / 2) {
            return Priority.HIGH;
        } else if (position > slots) {
            return Priority.LOW;
        } else {
            return Priority.MEDIUM;
        }

    }

    public static void readInput() throws IOException {
        System.out.println("Please enter the module and the slots. example: module CS2113T,50\n");
        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();
        while (!line.equals("bye")) {
            if (line.startsWith("module")) {
                try {
                    line = line.replace("module", "");
                    String[] parts = line.split(",");
                    ModulePlanner t = new ModulePlanner();
                    setModuleCode(parts[0].trim());
                    setTotalSlots(Parser.parserToInteger(parts[1].trim()));
                    System.out.println("Module " + getModuleCode() + " has been added.");
                    System.out.println("Please add the student name, seniority, requirement for graduation, "
                            + "rank. example: student Alice,1,true,2");
                    Storage.createFile();
                    Storage.readFile(students);
                } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                    Ui.showFormatErrorException();
                }
            } else if (line.startsWith("student")) {
                try {
                    line = line.replace("student", "");
                    String[] parts = line.split(",");
                    Student a = new Student(parts[0].trim(),
                            Parser.parserToInteger(parts[1].trim()),
                            Parser.parserToBoolean(parts[2].trim()),
                            Parser.parserToInteger(parts[3].trim()));
                    addStudent(a);
                    System.out.println(a.getName() + " has been added.");
                } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                    Ui.showFormatErrorException();
                }
            } else if (line.equals("list")) {
                System.out.println("Here is the list:\n");
                Collections.sort(students, Collections.reverseOrder());
                getStudent();
            } else if (line.startsWith("recommendation")) {
                try {
                    line = line.replace("recommendation", "").trim();
                    findStudent(students, line);
                } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                    Ui.showFormatErrorException();
                }
            } else if (line.startsWith("delete")){
                try {
                    line = line.replace("delete", "").trim();
                    int i = Parser.parserToInteger(line);
                    System.out.println(students.get(i-1).getName() + " has been removed.");
                    students.remove(i - 1);
                } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                    Ui.showFormatErrorException();
                }
            }
            line = in.nextLine();
        }
        Storage.writeFile(students);
    }

    public void run() {
        try {
            readInput();
        } catch (IOException e) {
            Ui.showException();
        }

    }
}
