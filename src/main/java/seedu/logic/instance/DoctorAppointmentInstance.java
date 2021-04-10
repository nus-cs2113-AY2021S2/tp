package seedu.logic.instance;


import seedu.exceptions.CorruptedFileException;
import seedu.exceptions.HealthVaultException;
import seedu.logger.HealthVaultLogger;
import seedu.logic.command.Command;
import seedu.logic.parser.DoctorAppointmentParser;
import seedu.model.doctorappointment.AppointmentList;
import seedu.storage.DoctorAppointmentStorage;
import seedu.ui.DoctorAppointmentUI;
import seedu.ui.UI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Doctor Appointment Instance where the functionality of Doctor Appointment Menu Starts Running.
 */

public class DoctorAppointmentInstance {

    private DoctorAppointmentUI ui;
    private AppointmentList details;
    private DoctorAppointmentStorage doctorAppointmentStorage;
    public Logger logger = HealthVaultLogger.getLogger();

    /**
     * Constructor for DoctorAppointmentInstance.
     *
     * @param filepath String of the filepath for DoctorAppointmentStorage.
     */

    public DoctorAppointmentInstance(String filepath) {
        ui = new DoctorAppointmentUI();
        doctorAppointmentStorage = new DoctorAppointmentStorage(filepath);
    }

    /**
     * Executes the DoctorAppointment Menu.
     */
    public void run() {
        try {
            details = doctorAppointmentStorage.loadFile();
        } catch (FileNotFoundException e) {
            try {
                doctorAppointmentStorage.createFile();
                details = doctorAppointmentStorage.loadFile();
            } catch (IOException | CorruptedFileException e1) {
                System.out.println(e1.getMessage());
                logger.log(Level.WARNING, "DoctorAppointment.txt is corrupted.");
            } catch (HealthVaultException e2) {
                e2.getMessage();
                logger.log(Level.WARNING, "Error Creating File.");
            }
        } catch (CorruptedFileException e) {
            DoctorAppointmentUI.corruptedFileErrorMessage();
            logger.log(Level.WARNING, "DoctorAppointment.txt is corrupted.");
            return;
        } catch (HealthVaultException e) {
            logger.log(Level.WARNING, "An Error occur during storage loading");
            e.getMessage();
        }
        UI.showLine();
        DoctorAppointmentUI.doctorAppointmentsWelcome();
        ui.printAppointmentMenuPrompt();
        logger.log(Level.INFO, "Accessing Doctor Appointment Menu");
        boolean isReturnToStartMenu = false;
        while (!isReturnToStartMenu) {
            try {
                String input = ui.getInput("Appointment");
                UI.showLine(); // show the divider line ("_______")
                Command c = DoctorAppointmentParser.parse(input, details);
                c.execute(details, ui);
                isReturnToStartMenu = c.isExit();
                logger.log(Level.INFO, "Exiting Doctor Appointment Menu");
                if (isReturnToStartMenu) {
                    UI.returningToStartMenuMessage();
                }
                DoctorAppointmentUI.printNewLine();
            } catch (NullPointerException e) {
                logger.log(Level.WARNING, "Command from Parser return as NULL");
                //Command C can return as null if an error is triggered in parser
                //Null Pointer Exception may hence occur, the catch statement is to ensure it does not exit the loop.
            } catch (HealthVaultException e) {
                logger.log(Level.WARNING, "Handling HealthVault exceptions during Doctor Appointment Menu");
                System.out.println(e.getMessage());
                DoctorAppointmentUI.printNewLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                logger.log(Level.SEVERE, "Something went wrong that is not handled by Healthvault exception");
                DoctorAppointmentUI.printNewLine();
            }
        }
    }
}