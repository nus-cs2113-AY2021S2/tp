package seedu.logic.instance;

import seedu.exceptions.HealthVaultException;
import seedu.logic.command.Command;
import seedu.logic.parser.PatientParser;
import seedu.logic.command.PatientActions;
import seedu.storage.PatientStorage;
import seedu.ui.PatientUI;
import seedu.ui.UI;

public class PatientCommandInstance {

    private PatientUI ui;
    private PatientActions patients;
    private PatientStorage patientStorage;
    private PatientParser parser;

    public PatientCommandInstance(String filepath) {
        ui = new PatientUI();
        patientStorage = new PatientStorage(filepath);
        parser = new PatientParser();
    }

    public void run() {
        try {
            patients = new PatientActions(patientStorage.loadPatients());
        } catch (HealthVaultException e) {
            System.out.println(e.getMessage());
            ui.corruptedFileErrorMessage();
            patients = new PatientActions();
            return;
        } catch (NumberFormatException e) {
            System.out.println("It seems like your age input is invalid!");
            ui.corruptedFileErrorMessage();
            patients = new PatientActions();
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
                UI.showLine();
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
