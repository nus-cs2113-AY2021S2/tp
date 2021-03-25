package seedu.storage;

import seedu.logic.command.AppointmentActions;
import seedu.model.object.DoctorAppointment;

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
    private final String filePath;
    private final File file;

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
            String[] data = input.split("\\s\\|\\s", 4);
            loadAppointments.add(new DoctorAppointment(data[0], data[1], data[2], data[3]));
        }
        fileReader.close();
        return new AppointmentActions(loadAppointments);
    }

    public void writeToFile(ArrayList<DoctorAppointment> taskList) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath, false);
        fileWriter.write("");
        for (DoctorAppointment task : taskList) {
            fileWriter.write(task.saveTask() + "\n");
        }
        fileWriter.close();
    }

}
