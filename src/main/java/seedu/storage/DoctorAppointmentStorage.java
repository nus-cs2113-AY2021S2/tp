package seedu.storage;

import seedu.duke.Constants;
import seedu.exceptions.CorruptedFileException;
import seedu.exceptions.HealthVaultException;
import seedu.logger.HealthVaultLogger;
import seedu.model.doctorappointment.AppointmentList;
import seedu.logic.errorchecker.DoctorAppointmentChecker;
import seedu.model.doctorappointment.DoctorAppointment;
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
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoctorAppointmentStorage {
    private final static String staticFilePath = Constants.APPOINTMENT_FILE_PATH;
    private final String filePath;
    private final File file;
    private final static String STAFF_FILE_PATH = Constants.STAFF_FILE_PATH;
    public static Logger logger = HealthVaultLogger.getLogger();


    public DoctorAppointmentStorage(String filePath) {
        this.filePath = filePath;
        this.file = new File(filePath);
    }

    public void createFile() throws IOException {
        Path pathToFile = Paths.get(filePath);
        Files.createDirectories(pathToFile.getParent());
        file.createNewFile();
        logger.log(Level.INFO, "Creating new file");
    }

    public AppointmentList loadFile() throws FileNotFoundException, HealthVaultException {
        ArrayList<DoctorAppointment> loadAppointments = new ArrayList<>();
        ArrayList<String> checkStorage = new ArrayList<>();

        File fileName = new File(filePath);
        Scanner fileReader = new Scanner(fileName);
        while (fileReader.hasNextLine()) {
            try {
                String input = fileReader.nextLine();
                if (input.equals("")) {
                    logger.log(Level.WARNING, "Corrupted File Detected during loadFile");
                    throw new CorruptedFileException(Constants.APPOINTMENT_FILE_PATH);
                }
                String[] data = input.split("\\s\\|\\s", 5);
                DoctorAppointmentChecker.checkDataFromStorage(input, checkStorage);
                checkStorage.add(data[1]);
                loadAppointments.add(new DoctorAppointment(data[0], data[1], data[2], data[3], data[4]));
            } catch (Exception e) {
                logger.log(Level.WARNING, "Corrupted File Detected during loadFile");
                throw new CorruptedFileException(Constants.APPOINTMENT_FILE_PATH);
            }
        }
        fileReader.close();
        logger.log(Level.INFO, "File Successfully loaded into program");
        return new AppointmentList(loadAppointments);
    }

    public static void writeToFile(ArrayList<DoctorAppointment> taskList) throws IOException {
        FileWriter fileWriter = new FileWriter(staticFilePath, false);
        fileWriter.write("");
        for (DoctorAppointment task : taskList) {
            fileWriter.write(task.saveTask() + "\n");
        }
        fileWriter.close();
        logger.log(Level.INFO, "Successfully written data to file ");

    }

    public static ArrayList<Staff> loadDoctorFile() throws FileNotFoundException {
        ArrayList<Staff> loadDoctorList = new ArrayList<>();

        File fileName = new File(STAFF_FILE_PATH);
        Scanner fileReader = new Scanner(fileName);
        logger.log(Level.INFO, "Loading Staff data into doctor appointment Menu for cross validation ");
        while (fileReader.hasNextLine()) {
            String input = fileReader.nextLine();
            String[] data = input.split("\\|");
            loadDoctorList.add(new Staff(data));
        }
        fileReader.close();
        return loadDoctorList;
    }

}
