package seedu.duke;

import seedu.drugs.DrugInstance;
<<<<<<< HEAD
=======
import seedu.nurseschedules.NurseScheduleInstance;
import seedu.doctorappointments.DoctorAppointmentInstance;
import seedu.drugs.DrugInstance;
>>>>>>> 4f44db098d4f71ce447decd3d3d0e58002bdb46d
import seedu.staff.Parser;
import java.io.IOException;
import seedu.duke.ui.UI;
import seedu.patient.PatientCommandInstance;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */

    static final String PATIENT_FILE_PATH = "data/PatientList.txt";
    static final String APPOINTMENT_FILE_PATH = "data/DoctorAppointmentList.txt";


    /**
     * Logic for the main loop that processes information
     */
    public static void run(){
        UI.printWelcome();
        String Username = UI.scanInput();
        UI.printUserName(Username);
        UI.printStartMenu();
        boolean isExit = false;
        while (!isExit) {
            try {
                String startMenuCommand = UI.scanInput();
                String c = startMenuCommand.trim();
                switch (c) {
                    case "1":
                        UI.showLine();
                        Parser.run();
                        break;
                    case "2":
                        System.out.println("Patient Instance!");
                        new PatientCommandInstance(PATIENT_FILE_PATH).patientInstance();
                        break;
                    case "3":
                        System.out.println("Doctor's Appointment Instance!");
                        DoctorAppointmentInstance appointments = new DoctorAppointmentInstance(APPOINTMENT_FILE_PATH);
                        appointments.run();
                        break;
                    case "4":
                        NurseScheduleInstance.main();
                        break;
                    case "5":
                        System.out.println("Drug Viewer Instance!");
                        DrugInstance addict = new DrugInstance(PATIENT_FILE_PATH);
                        addict.run();
                        break;
                    case "help":
                        System.out.println("Here is the list of Start Menu commands!");
                        UI.printStartMenu();
                        break;
                    case "bye":
                        isExit = true;
                        UI.printGoodbye();
                        break;
                    default:
                        System.out.println("OOPS! That is not a registered command! Please type \"help\" to see the list of commands");
                        break;
                }
            } catch (NullPointerException | IOException e) {
                //Command C can return as null if an error is triggered in parser
                //Null Pointer Exception may hence occur, the catch statement is to ensure it does not exit the loop.
            }
        }
    }

    /**
     * Calls for the running of a new Duke instance
     *
     * @param args Runtime arguments are unused
     */
    public static void main(String[] args) {
        Duke.run();
    }
}