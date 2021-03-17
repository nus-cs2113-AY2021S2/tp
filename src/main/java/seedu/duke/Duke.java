package seedu.duke;

<<<<<<< HEAD
import system.staff.Nurse;
import system.staff.Parser;
import nurseschedules.NurseScheduleInstance;
import static system.staff.Parser.run;
=======
import seedu.staff.Parser;
>>>>>>> 90a8624a34faf2e3aae1eb9c788f8ac5fea8b7ae
import java.io.IOException;
import seedu.duke.ui.UI;
import seedu.patient.PatientCommandInstance;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */

    static final String PATIENT_FILE_PATH = "data/PatientList.txt";

    public Duke() {
    }

    /**
     * Logic for the main loop that processes information
     */
    public void run() {
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
<<<<<<< HEAD
                case "1":
                    System.out.println("Staff Instance!");
                    Parser.run();
                    break;
                case "2":
                    new PatientCommandInstance(PATIENT_FILE_PATH).patientInstance();
                    break;
                case "3":
                    System.out.println("Doctor's Appointment Instance!");
                    break;
                case "4":
                    System.out.println("Nurse Schedule Instance!");
                    NurseScheduleInstance.main();
                    break;
                case "5":
                    System.out.println("Drug Viewer Instance!");
                    break;
                case "help":
                    System.out.println("Here is the list of Start Menu commands!");
                    ui.printStartMenu();
                    break;
                case "bye":
                    isExit = true;
                    ui.printGoodbye();
                    break;
                default:
                    System.out.println("OOPS! That is not a registered command! Please type \"help\" to see the list of commands");
                    break;
=======
                    case "1":
                        System.out.println("Staff Instance!");
                        Parser.run();
                        break;
                    case "2":
                        new PatientCommandInstance(PATIENT_FILE_PATH).patientInstance();
                        break;
                    case "3":
                        System.out.println("Doctor's Appointment Instance!");
                        break;
                    case "4":
                        System.out.println("Nurse Schedule Instance!");
                        break;
                    case "5":
                        System.out.println("Drug Viewer Instance!");
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
>>>>>>> 90a8624a34faf2e3aae1eb9c788f8ac5fea8b7ae
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
        new Duke().run();
    }
}