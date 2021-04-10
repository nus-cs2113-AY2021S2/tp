package seedu.storage;

import seedu.exceptions.InvalidDateException;
import seedu.exceptions.nurseschedules.InvalidiDTypeException;
import seedu.exceptions.nurseschedules.NurseCrossValidationError;
import seedu.exceptions.nurseschedules.NurseIdNotFound;
import seedu.exceptions.nurseschedules.PatientCrossValidationError;
import seedu.exceptions.nurseschedules.PatientIdNotFound;
import seedu.logger.HealthVaultLogger;
import seedu.model.nurseschedule.NurseScheduleList;
import seedu.logic.errorchecker.NurseScheduleChecker;
import seedu.model.nurseschedule.NurseSchedule;
import seedu.model.patient.Patient;
import seedu.ui.NurseScheduleUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static seedu.duke.Constants.PATIENT_FILE_PATH;
import static seedu.duke.Constants.SCHEDULES_FILE_PATH;


public class NurseScheduleStorage {

    private static final String FILE_PATH = SCHEDULES_FILE_PATH;
    static ArrayList<NurseSchedule> nurseSchedules = new ArrayList<>();
    public Logger logger = HealthVaultLogger.getLogger();

    /**
     * Creates new file.
     */
    private static void createFile() {
        try {
            File file = new File(FILE_PATH);
            file.createNewFile();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads NurseSchedule.txt.
     *
     * @return arraylist populated with valid data
     * @throws NurseIdNotFound if nurseID does not exist
     * @throws InvalidiDTypeException if ID is invalid
     * @throws FileNotFoundException if file does not exist
     * @throws NurseCrossValidationError if Staff.txt cannot be loaded
     * @throws PatientIdNotFound if patientID does not exit
     * @throws PatientCrossValidationError if Patients.txt cannot be loaded
     * @throws InvalidDateException if date is invalid
     */
    private ArrayList<NurseSchedule> readFile() throws NurseIdNotFound, InvalidiDTypeException,
            FileNotFoundException, NurseCrossValidationError, PatientIdNotFound,
            PatientCrossValidationError, InvalidDateException {
        FileInputStream file = new FileInputStream(FILE_PATH);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String[] details = sc.nextLine().split("\\|", 0);
            NurseScheduleChecker.checkNurseiDExist(details[0]);
            NurseScheduleChecker.checkPatientiDExist(details[1]);
            NurseScheduleChecker.checkValidNurseID(details[0]);
            NurseScheduleChecker.checkValidPatientID(details[1]);
            NurseScheduleChecker.isValidDate(details[2]);
            nurseSchedules.add(new NurseSchedule(details[0], details[1], details[2]));
        }
        logger.log(Level.INFO,"Nurse Schedule file loaded");
        return nurseSchedules;
    }

    /**
     * Writes objects in nurseSchedules to NurseSchedule.txt.
     *
     * @param nurseSchedules arraylist of objects
     */
    public void writeToFile(NurseScheduleList nurseSchedules) {
        try {
            File file = new File(FILE_PATH);
            FileWriter writer = new FileWriter(file);
            for (int i = 0; i < nurseSchedules.getSize(); i++) {
                writer.write(nurseSchedules.toSaveFile(i));
                writer.write("\r\n");
            }
            writer.close();
        } catch (IOException e) {
            logger.log(Level.WARNING,"Error writing to NurseSchedule.txt");
        }
        logger.log(Level.INFO, "Nurse Schedule file saved");
    }

    /**
     * Function creates, read and loads NurseSchedule.txt.
     *
     * @return populated arraylist
     * @throws NurseIdNotFound if nurseID does not exist
     * @throws InvalidiDTypeException if ID is invalid
     * @throws FileNotFoundException if file does not exist
     * @throws NurseCrossValidationError if Staff.txt cannot be loaded
     * @throws PatientIdNotFound if patientID does not exit
     * @throws PatientCrossValidationError if Patients.txt cannot be loaded
     * @throws InvalidDateException if date is invalid
     */
    public ArrayList<NurseSchedule> load() throws FileNotFoundException, InvalidiDTypeException,
            NurseIdNotFound, NurseCrossValidationError, PatientIdNotFound,
            PatientCrossValidationError, InvalidDateException {
        createFile();
        nurseSchedules = readFile();
        return nurseSchedules;
    }

    /**
     * Loads patientFile for cross-validation function.
     *
     * @return populated patientlist
     * @throws FileNotFoundException if file not found
     */
    public static ArrayList<Patient> loadPatientFile() throws FileNotFoundException {
        ArrayList<Patient> patientList = new ArrayList<>();

        File fileName = new File(PATIENT_FILE_PATH);
        Scanner fileReader = new Scanner(fileName);

        while (fileReader.hasNextLine()) {
            String input = fileReader.nextLine();
            String[] data = input.trim().split("\\|");
            int numberOfTokens = data.length;
            ArrayList<String> cleanString = new ArrayList<>();
            for (int i = 0; i < numberOfTokens; i++) {
                cleanString.add(NurseScheduleUI.cleanseInput(data[i]).trim());
            }
            Patient tempPatient = new Patient(data[0].trim(), data[1].trim(),
                    Integer.parseInt(data[2].trim()), data[3], data[4], data[5]);
            patientList.add(tempPatient);
        }
        fileReader.close();
        return patientList;
    }
}
