package seedu.logic.instance;


import seedu.exceptions.DukeException;
import seedu.exceptions.doctorappointment.FileCreatingErrorException;
import seedu.logic.parser.DoctorAppointmentParser;
import seedu.logic.command.AppointmentActions;
import seedu.storage.DoctorAppointmentStorage;
import seedu.ui.DoctorAppointmentUI;
import seedu.ui.UI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Doctor Appointment Instance where the functionality of Doctor Appointment Menu Starts Running
 *
 */

public class DoctorAppointmentInstance {

    private UI ui;
    private AppointmentActions details;
    private DoctorAppointmentStorage doctorAppointmentStorage;
    static final String PATIENT_FILE_PATH = "data/DoctorAppointmentList.txt";

    public DoctorAppointmentInstance(String filepath) {
        ui = new UI();
        doctorAppointmentStorage = new DoctorAppointmentStorage(PATIENT_FILE_PATH);
        try {
            details = doctorAppointmentStorage.loadFile();
        } catch (FileNotFoundException e) {
            try {
                doctorAppointmentStorage.createFile();
                details = doctorAppointmentStorage.loadFile();
            } catch (IOException e1) {
                e1.getMessage();

            }
        }
    }

    public void run() {
        DoctorAppointmentUI.doctorAppointmentsWelcome();
        UI.showLine();
        boolean isReturnToStartMenu = false;
        Scanner userInput = new Scanner(System.in);
        while (!isReturnToStartMenu) {
            try {
                DoctorAppointmentUI.printAppointmentMenuPrompt();
                String input = userInput.nextLine();
                ui.showLine(); // show the divider line ("_______")
                isReturnToStartMenu = DoctorAppointmentParser.parse(input);
                if (isReturnToStartMenu) {
                    ui.returningToStartMenuMessage();
                }
                ui.showLine();
            } catch (NullPointerException e) {
                //Command C can return as null if an error is triggered in parser
                //Null Pointer Exception may hence occur, the catch statement is to ensure it does not exit the loop.
            } catch (Exception e) {
                System.out.println("OOPS something went wrong :0");
            }
        }
    }
}
