package seedu.duke;

import java.util.Scanner;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    private Ui ui;
    static final String PATIENT_FILE_PATH = "data/PatientList.txt";

    public Duke() {
    }

    /**
     * Logic for the main loop that processes information
     */
    public void run() {
        ui.printWelcome();
        String Username = ui.scanInput();
        ui.printUserName(Username);
        ui.printStartMenu();
        boolean isExit = false;
        while (!isExit) {
            try {
                String startMenuCommand = ui.scanInput();
                String c = startMenuCommand.trim();
                switch (c) {
                case "1":
                    System.out.println("Staff Instance!");
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
                    ui.printStartMenu();
                    break;
                case "bye":
                    isExit = true;
                    ui.printGoodbye();
                    break;
                default:
                    System.out.println("OOPS! That is not a registered command! Please type \"help\" to see the list of commands");
                    break;
                }
            } catch (NullPointerException e) {
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
