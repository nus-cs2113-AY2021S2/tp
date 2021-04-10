package seedu.logic.instance;

import seedu.exceptions.HealthVaultException;
import seedu.logic.command.Command;
import seedu.logic.parser.PatientParser;
import seedu.model.patient.PatientList;
import seedu.storage.PatientStorage;
import seedu.ui.PatientUI;
import seedu.ui.UI;
import seedu.logger.HealthVaultLogger;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Instance in which user can access patient related functions.
 */
public class PatientInstance {

    private PatientUI ui;
    private PatientList patients;
    private PatientStorage patientStorage;
    private PatientParser parser;
    public Logger logger = HealthVaultLogger.getLogger();

    public PatientInstance(String filepath) {
        ui = new PatientUI();
        patientStorage = new PatientStorage(filepath);
        parser = new PatientParser();
    }

    /**
     * Runs the patient instance.
     */
    public void run() {
        //tries to load patients from the storage.
        try {
            patients = new PatientList(patientStorage.loadPatients());
        } catch (HealthVaultException | NumberFormatException e) {
            logger.log(Level.WARNING, "Patient file corrupted. Access Denied");
            ui.corruptedFileErrorMessage();
            patients = new PatientList();
            return;
        }
        PatientUI.patientCommandWelcome();
        logger.log(Level.INFO, "Patient instance accessed.");
        boolean isReturnToStartMenu = false;
        //main patient instance super loop.
        while (!isReturnToStartMenu) {
            try {
                String fullCommand = ui.getInput("Patient");
                Command c = parser.patientParse(fullCommand, patients);
                ui.lineBreak();
                c.execute(patients, ui);
                patientStorage.storePatients(patients);
                logger.log(Level.INFO, "Patient file saved.");
                isReturnToStartMenu = c.isExit();
                if (isReturnToStartMenu) {
                    UI.returningToStartMenuMessage();
                    logger.log(Level.INFO, "Exiting patient instance");
                }
                ui.lineBreak();
            } catch (NullPointerException e) {
                logger.log(Level.WARNING, "Command Returned as null.");
                //Command C can return as null if an error is triggered in parser.
                //Null Pointer Exception may hence occur, the catch statement is to ensure it does not exit the loop.
            } catch (HealthVaultException e) {
                System.out.println(e.getMessage());
                ui.lineBreak();
                logger.log(Level.WARNING, "Handling HealthVaultException in patient instance.");
            } catch (NumberFormatException e) {
                System.out.println("Your age input is not an accepted integer!");
                ui.lineBreak();
                logger.log(Level.WARNING, "Handling NumberFormatException.");
            }
        }
    }
}
