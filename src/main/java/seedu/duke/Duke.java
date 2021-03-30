package seedu.duke;

import seedu.logic.command.Command;
import seedu.logic.parser.StartMenuParser;
import seedu.ui.UI;

public class Duke {
    private UI ui;
    private StartMenuParser parser;

    private Duke() {
        ui = new UI();
        parser = new StartMenuParser();
    }

    /**
     * Calls for the running of a new Duke instance
     *
     * @param args Runtime arguments are unused
     */
    public static void main(String[] args) {
        new Duke().run();
    }

    public void run() {
        UI.printWelcome();
        UI.printStartMenu();
        boolean isExit = false;
        while (!isExit) {
            try {
                String userInput = ui.getInput("Start Menu");
                Command c = parser.startMenuParse(userInput);
                c.execute();
                isExit = c.isExit();
                if (isExit) {
                    ui.printGoodbye();
                }
                /*switch (c) {
                case "staff":
                    UI.showLine();
                    System.out.println("Staff Instance!");
                    StaffInstance staff = new StaffInstance(STAFF_FILE_PATH);
                    staff.run();
                    break;
                case "patient":
                    UI.showLine();
                    System.out.println("Patient Instance!");
                    PatientCommandInstance patients = new PatientCommandInstance(PATIENT_FILE_PATH);
                    patients.run();
                    break;
                case "appointments":
                    UI.showLine();
                    System.out.println("Doctor's Appointment Instance!");
                    DoctorAppointmentInstance appointments = new DoctorAppointmentInstance(APPOINTMENT_FILE_PATH);
                    appointments.run();
                    break;
                case "schedules":
                    UI.showLine();
                    NurseScheduleInstance.main();
                    break;
                case "inventory":
                    UI.showLine();
                    System.out.println("Inventory Viewer Instance!");
                    DrugInstance addict = new DrugInstance(INVENTORY_FILE_PATH);
                    addict.run();
                    break;
                case "help":
                    UI.showLine();
                    System.out.println("Here is the list of Start Menu commands!");
                    UI.printStartMenu();
                    break;
                case "bye":
                    UI.showLine();
                    isExit = true;
                    UI.printGoodbye();
                    break;


                default:
                    UI.showLine();
                    System.out.println("OOPS! That is not a registered command! Please type \"help\" to see the list of commands");
                    UI.showLine();
                    break;
                }*/
            } catch (NullPointerException e) {
                e.printStackTrace();
                //Command C can return as null if an error is triggered in parser
                //Null Pointer Exception may hence occur, the catch statement is to ensure it does not exit the loop.
            }
        }
    }
}