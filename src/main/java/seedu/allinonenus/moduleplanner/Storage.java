package seedu.allinonenus.moduleplanner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {



    static void writeFile(ArrayList<Student> students) throws IOException {
        File file = new File("ModulePlanner.txt");
        FileWriter writer = new FileWriter(file);
        for (Student t : students) {
            writer.write(t.getName() + " | " + t.getYear() + " | "
                    + t.getGraduationRequirement() + " | " + t.getRank());
            writer.write("\r\n");
        }
        writer.close();
    }

    static void createFile() {

        try {
            File file = new File("ModulePlanner.txt");
            if (file.createNewFile()) {
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void readFile(ArrayList<Student> students) throws FileNotFoundException {
        FileInputStream data = new FileInputStream("ModulePlanner.txt");
        Scanner sc = new Scanner(data);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split("\\|");
            Student a = new Student(parts[0].trim(),
                    Parser.parserToInteger(parts[1].trim()),
                    Parser.parserToBoolean(parts[2].trim()),
                    Parser.parserToInteger(parts[3].trim()));
            students.add(a);
        }
    }
}