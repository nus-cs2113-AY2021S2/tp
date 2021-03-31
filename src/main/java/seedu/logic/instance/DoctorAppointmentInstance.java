package seedu.logic.instance;


import seedu.exceptions.CorruptedFileException;
import seedu.exceptions.HealthVaultException;
import seedu.logic.command.Command;
import seedu.logic.parser.DoctorAppointmentParser;
import seedu.logic.command.AppointmentActions;
import seedu.storage.DoctorAppointmentStorage;
import seedu.ui.DoctorAppointmentUI;
import seedu.ui.UI;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Doctor Appointment Instance where the functionality of Doctor Appointment Menu Starts Running
 */

public class DoctorAppointmentInstance {

    private DoctorAppointmentUI ui;
    private AppointmentActions details;
    private DoctorAppointmentStorage doctorAppointmentStorage;

    public DoctorAppointmentInstance(String filepath) {
        ui = new DoctorAppointmentUI();
        doctorAppointmentStorage = new DoctorAppointmentStorage(filepath);
    }

    public void run() {
        try {
            details = doctorAppointmentStorage.loadFile();
        } catch (FileNotFoundException e) {
            try {
                doctorAppointmentStorage.createFile();
                details = doctorAppointmentStorage.loadFile();
            } catch (IOException | CorruptedFileException e1) {
                System.out.println(e1.getMessage());
            } catch (HealthVaultException e2) {
                e2.getMessage();
            }
        } catch (CorruptedFileException e) {
            DoctorAppointmentUI.corruptedFileErrorMessage();
            return;
        } catch (HealthVaultException e) {
            e.getMessage();
        }
        UI.showLine();
        DoctorAppointmentUI.doctorAppointmentsWelcome();
        boolean isReturnToStartMenu = false;
        while (!isReturnToStartMenu) {
            try {
                ui.printAppointmentMenuPrompt();
                String input = ui.getInput("Appointment");
                UI.showLine(); // show the divider line ("_______")
                Command c = DoctorAppointmentParser.parse(input, details);
                c.execute(details, ui);
                isReturnToStartMenu = c.isExit();
                if (isReturnToStartMenu) {
                    UI.returningToStartMenuMessage();
                }
                UI.showLine();
            } catch (NullPointerException e) {
                //Command C can return as null if an error is triggered in parser
                //Null Pointer Exception may hence occur, the catch statement is to ensure it does not exit the loop.
            } catch (HealthVaultException e) {
                //System.out.println("OOPS something went wrong :0");
                System.out.println(e.getMessage());
                UI.showLine();
            } catch (Exception e) {
                System.out.println("OOPS! Something went wrong!");
            }
        }
    }
}