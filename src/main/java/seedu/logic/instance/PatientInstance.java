package seedu.logic.instance;

import seedu.exceptions.HealthVaultException;
import seedu.logic.command.Command;
import seedu.logic.parser.PatientParser;
import seedu.model.patient.PatientList;
import seedu.storage.PatientStorage;
import seedu.ui.PatientUI;
import seedu.ui.UI;

public class PatientInstance {

    private PatientUI ui;
    private PatientList patients;
    private PatientStorage patientStorage;
    private PatientParser parser;

    public PatientInstance(String filepath) {
        ui = new PatientUI();
        patientStorage = new PatientStorage(filepath);
        parser = new PatientParser();
    }

    public void run() {
        try {
            patients = new PatientList(patientStorage.loadPatients());
        } catch (HealthVaultException | NumberFormatException e) {
            ui.corruptedFileErrorMessage();
            patients = new PatientList();
            return;
        }
        PatientUI.patientCommandWelcome();
        boolean isReturnToStartMenu = false;
        while (!isReturnToStartMenu) {
            try {
                UI.showLine(); // show the divider line ("_______")
                String fullCommand = ui.getInput("Patient");
                Command c = parser.patientParse(fullCommand, patients);
                c.execute(patients, ui);
                patientStorage.storePatients(patients);
                isReturnToStartMenu = c.isExit();
                if (isReturnToStartMenu) {
                    UI.returningToStartMenuMessage();
                }
            } catch (NullPointerException e) {
                //Command C can return as null if an error is triggered in parser
                //Null Pointer Exception may hence occur, the catch statement is to ensure it does not exit the loop.
            } catch (HealthVaultException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Your age input is not an accepted integer!");
            }
        }
    }
}
