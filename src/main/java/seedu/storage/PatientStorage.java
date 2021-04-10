package seedu.storage;

import seedu.exceptions.CorruptedFileException;
import seedu.exceptions.HealthVaultException;
import seedu.logger.HealthVaultLogger;
import seedu.logic.errorchecker.PatientChecker;
import seedu.model.patient.Patient;
import seedu.model.patient.PatientList;
import seedu.ui.PatientUI;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Accesses patient details from storage and stores patient details to storage.
 */
public class PatientStorage {

    static File saveFile;
    static ArrayList<Patient> patients;
    static String filePath;
    static PatientUI ui;
    static PatientChecker checker;
    public Logger logger = HealthVaultLogger.getLogger();

    public PatientStorage(String filepath) {
        filePath = filepath;
        saveFile = new File(filepath);
        ui = new PatientUI();
        patients = new ArrayList<>();
    }

    /**
     * Checks if the file exists and initializes one if there is not.
     */
    public void fileInit() {
        try {
            //makes file directory if it doesnt exist in the system.
            if (!(saveFile.exists())) {
                saveFile.getParentFile().mkdirs();
                saveFile.createNewFile();
                logger.log(Level.INFO, "New Patient file and directory created");
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, "Unable to create file");
            System.out.println("OOPS! I can't create the directory or file!");
        }
    }

    /**
     * Loads the saved list of patients from save location.
     *
     * @return Populated patients arraylist.
     * @throws HealthVaultException if there is an error in loading.
     */
    public ArrayList<Patient> loadPatients() throws HealthVaultException {
        fileInit();
        // initializing file scanner to scan the file
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(saveFile);
        } catch (FileNotFoundException e) {
            logger.log(Level.WARNING, "Unable to find file");
            ui.showLoadingError();
        }
        while (fileScanner.hasNext()) {
            String currentScan = fileScanner.nextLine();
            //splits the string into sections for storing in the ArrayList
            String[] taskSave = currentScan.trim().split("\\|");
            int numberOfTokens = taskSave.length;
            if (numberOfTokens == 0) {
                logger.log(Level.WARNING, "patient file unable to open due to wrong number of tokens");
                throw new CorruptedFileException("Patient");
            }
            for (int i = 0; i < numberOfTokens; i++) {
                taskSave[i] = taskSave[i].trim().replaceAll("\\s{2,}", " ");
            }
            checker = new PatientChecker(patients, taskSave, numberOfTokens);
            checker.checkStorage();
            Patient tempPatient = new Patient(taskSave[0], taskSave[1], Integer.parseInt(taskSave[2]),
                    taskSave[3], taskSave[4], taskSave[5]);
            patients.add(tempPatient);
        }
        fileScanner.close();
        return patients;
    }

    /**
     * Saves all patients to text file.
     *
     * @param saveInput current patient details to be stored.
     */
    public void storePatients(PatientList saveInput) {
        fileInit();
        try {
            //creates a new file writer to write to text file
            FileWriter fileWriter = new FileWriter(filePath);
            for (int i = 0; i < saveInput.getSize(); i++) {
                fileWriter.write(saveInput.toSaveFile(i) + "\n");
            }
            fileWriter.flush();
            fileWriter.close();
            logger.log(Level.INFO, "Patient file save successful");
        } catch (IOException e) {
            logger.log(Level.WARNING, "Unable to save file due to IOException");
            System.out.println("☹ OOPS!!! The file can't be saved :-(");
        }
    }
}
