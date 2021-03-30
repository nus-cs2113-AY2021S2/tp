package seedu.storage;

import seedu.duke.Constants;
import seedu.logic.command.AppointmentActions;
import seedu.model.DoctorAppointment;
import seedu.model.staff.Staff;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class DoctorAppointmentStorage {
    private static String staticFilePath = Constants.APPOINTMENT_FILE_PATH;
    private final String filePath;
    private final File file;
    private final static String STAFF_FILE_PATH = Constants.STAFF_FILE_PATH;

    public DoctorAppointmentStorage(String filePath) {
        this.filePath = filePath;
        this.file = new File(filePath);
    }

    public void createFile() throws IOException {
        Path pathToFile = Paths.get(filePath);
        Files.createDirectories(pathToFile.getParent());
        file.createNewFile();
    }

    public AppointmentActions loadFile() throws FileNotFoundException {
        ArrayList<DoctorAppointment> loadAppointments = new ArrayList<>();

        File fileName = new File(filePath);
        Scanner fileReader = new Scanner(fileName);
        while (fileReader.hasNextLine()) {
            String input = fileReader.nextLine();
            String[] data = input.split("\\s\\|\\s", 5);
            loadAppointments.add(new DoctorAppointment(data[0], data[1], data[2], data[3], data[4]));
        }
        fileReader.close();
        return new AppointmentActions(loadAppointments);
    }

    public static void writeToFile(ArrayList<DoctorAppointment> taskList) throws IOException {
        FileWriter fileWriter = new FileWriter(staticFilePath, false);
        fileWriter.write("");
        for (DoctorAppointment task : taskList) {
            fileWriter.write(task.saveTask() + "\n");
        }
        fileWriter.close();
    }

    public static ArrayList<Staff> loadDoctorFile() throws FileNotFoundException {
        ArrayList<Staff> loadDoctorList = new ArrayList<>();

        File fileName = new File(STAFF_FILE_PATH);
        Scanner fileReader = new Scanner(fileName);

        while (fileReader.hasNextLine()) {
            String input = fileReader.nextLine();
            String[] data = input.split("\\|");
            loadDoctorList.add(new Staff(data));
        }
        fileReader.close();
        return loadDoctorList;
    }

}
