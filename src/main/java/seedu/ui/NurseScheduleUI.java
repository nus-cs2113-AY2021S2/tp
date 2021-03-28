package seedu.ui;

import seedu.exceptions.staffexceptions.AbortException;
import seedu.logic.parser.NurseSchedulesParser;

import java.text.ParseException;

public class NurseScheduleUI extends UI {

    public static void nurseSchedulePrompt() {
        System.out.print("NSchedule --> ");
    }

//    public static String[] inputToCreateSchedule() throws AbortException, ParseException {
//
//        String[] scheduleInput = new String[3];
//        System.out.print("Nurse ID: ");
//        scheduleInput[0] = abortEnabledScanInput();
//        System.out.print("Patient ID: ");
//        scheduleInput[1] = abortEnabledScanInput();
//        System.out.print("Date: ");
//        scheduleInput[2] = abortEnabledScanInput();
//
//        printAddedSchedule(scheduleInput[0], NurseSchedulesParser.formatDate(scheduleInput[2]));
//
//        return scheduleInput;
//    }

    public static void printNurseScheduleWelcomeMessage() {
        System.out.println("Welcome to Nurse Schedules!");
        System.out.println("Type \"help\" to for nurse schedules commands");
        showLine();
    }

    public static void printNurseScheduleHelpList() {
        System.out.println("Here is a list of Nurse Schedules commands: ");
        System.out.println("\"help\" brings up this list of commands!");
        System.out.println("\"add\" [NurseID] [Patient ID] [Date (DDMMYYYY)] adds a schedule to the schedule list!");
        System.out.println("\"list [NurseID/all]\" brings up the list of either all or specified nurse schedules!");
        System.out.println("\"delete [NurseID] [Date (DDMMYYYY)]\" deletes the schedule with the specified nurse ID!");
        System.out.println("\"return\" returns you to the Start Menu!");
        showLine();
    }

    public static void printDeletedSchedule(String id, String datetime) {
        System.out.println("Trip to " + id
                + " on " + datetime + " has been cancelled!");
        showLine();
    }

    public static void printAddedSchedule(String id, String datetime) throws ParseException {
        System.out.println("Trip to " + id + " on " + NurseSchedulesParser.formatDate(datetime) + " added!");
        showLine();
    }

    public static void invalidCommandMessage() {
        System.out.println("OOPS! Please check to see if your command is properly formatted!");
        showLine();
    }

    public static void invalidInputsMessage() {
        System.out.println("Invalid inputs!");
    }

    public static void addHelpMessage() {
        System.out.println("Format: add [NurseID] [Patient ID] [Date (DDMMYYYY)]");
        showLine();
    }

    public static void listHelpMessage() {
        System.out.println("Format: list [NurseID/all]");
        showLine();
    }

    public static void deleteHelpMessage() {
        System.out.println("Format: delete [NurseID] [Date (DDMMYYYY)]");
        showLine();
    }
}
