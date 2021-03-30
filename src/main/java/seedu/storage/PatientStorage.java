package seedu.storage;

import seedu.exceptions.HealthVaultException;
import seedu.logic.errorchecker.PatientChecker;
import seedu.model.Patient;
import seedu.logic.command.PatientActions;
import seedu.ui.PatientUI;
import seedu.ui.UI;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PatientStorage {

    static File saveFile;
    static ArrayList<Patient> patients = new ArrayList<>();
    static String filePath;
    static PatientUI ui;
    static PatientChecker checker;

    public PatientStorage(String filepath) {
        filePath = filepath;
        saveFile = new File(filepath);
        ui = new PatientUI();
    }

    /**
     * Instantiates a storage handler by taking in the filepath
     *
     * @param filePath the filepath where the file will be created
     */

    /**
     * Checks if the file exists and initializes one if there is not.
     */
    public void fileInit() {
        try {
            //makes file directory if it doesnt exist in the system.
            if (!(saveFile.exists())) {
                saveFile.getParentFile().mkdirs();
                saveFile.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("OOPS! I can't create the directory or file!");
        }
    }

    /**
     * Loads the saved list of patients from save location
     *
     * @return Populated patients arraylist
     * @throws HealthVaultException if there is an error in loading
     */
    public ArrayList<Patient> loadPatients() throws HealthVaultException {
        fileInit();
        try {
            // initializing file scanner to scan the file
            Scanner fileScanner = new Scanner(saveFile);

            while (fileScanner.hasNext()) {
                String currentScan = fileScanner.nextLine();
                //splits the string into sections for storing in the ArrayList
                String[] taskSave = currentScan.trim().split(" \\| ");
                int numberOfTokens = taskSave.length;
                ArrayList<String> cleanString = new ArrayList<>();
                for (int i = 0; i < numberOfTokens; i++) {
                    cleanString.add(ui.cleanseInput(taskSave[i]));
                }
                checker = new PatientChecker(patients, cleanString, numberOfTokens);
                checker.checkStorage();
                Patient tempPatient = new Patient(taskSave[0], taskSave[1], Integer.parseInt(taskSave[2]),
                        taskSave[3], taskSave[4], taskSave[5]);
                patients.add(tempPatient);
            }
        } catch (FileNotFoundException e) {
            throw new HealthVaultException();
        } catch (HealthVaultException e) {
            System.out.println(e.getMessage());
        }
        return patients;
    }

    /**
     * Saves all tasks to text file
     *
     * @param saveInput current files to be stored
     */
    public void storePatients(PatientActions saveInput) {
        fileInit();
        try {
            //creates a new file writer to write to text file

            FileWriter fileWriter = new FileWriter(filePath);
            for (int i = 0; i < saveInput.getSize(); i++) {
                fileWriter.write(saveInput.toSaveFile(i) + "\n");
            }
            fileWriter.close();
        } catch (java.io.IOException e) {
            System.out.println("☹ OOPS!!! The file can't be saved :-(");
        }
    }
}
