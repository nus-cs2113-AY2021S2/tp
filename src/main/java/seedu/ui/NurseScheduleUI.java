package seedu.ui;

import seedu.logic.parser.NurseSchedulesParser;

import java.text.ParseException;

import static seedu.duke.Constants.*;

public class NurseScheduleUI extends UI {

    public void nurseSchedulePrompt() {
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

    public void printNurseScheduleWelcomeMessage() {
        showLine();
        System.out.println("Welcome to Nurse Schedules!");
        System.out.println("Type \"help\" to for nurse schedules commands");
        lineBreak();
    }

    public void printNurseScheduleHelpList() {
//        showLine();
//        System.out.println("Here is a list of Nurse Schedules commands: ");
//        System.out.println("\"help\" brings up this list of commands!");
//        System.out.println("\"add\"/[NurseID]/[Patient ID]/[Date (DDMMYYYY)] adds a schedule to the schedule list!");
//        System.out.println("\"list\"/[NurseID/all]/ brings up the list of either all or specified nurse schedules!");
//        System.out.println("\"delete\"\\[NurseID]\\[Date (DDMMYYYY)]\" deletes the schedule with the specified nurse ID!");
//        System.out.println("\"return\" returns you to the Start Menu!");

        UI.printEmptyLine();
        System.out.println("Here is a list of Nurse Schedule commands: ");

        UI.printEmptyLine();
        int[] lengthpara = {10,60,50};
        printer(new String[]{HELP_HEADER_COMMAND, HELP_HEADER_DESCRIPTION, HELP_HEADER_FORMAT}, lengthpara);
        UI.showLongLine();
        printer(new String[]{HELP_COMMAND, SCHEDULES_HELP_DESCRIPTION, BLANK}, lengthpara);
        printer(new String[]{ADD_COMMAND, SCHEDULES_ADD_DESCRIPTION, SCHEDULES_ADD_FORMAT}, lengthpara);
        printer(new String[]{LIST_COMMAND, SCHEDULES_LIST_DESCRIPTION, SCHEDULES_LIST_FORMAT}, lengthpara);
        printer(new String[]{DELETE_COMMAND, SCHEDULES_DELETE_DESCRIPTION, SCHEDULES_DELETE_FORMAT}, lengthpara);
        printer(new String[]{RETURN_COMMAND, RETURN_DESCRIPTION, BLANK}, lengthpara);
        UI.printEmptyLine();
    }

    public static void printDeletedSchedule(String id, String datetime) {
        System.out.println("Trip to " + id
                + " on " + datetime + " has been cancelled!");
    }

    public static void printAddedSchedule(String id, String datetime) throws ParseException {
        System.out.println("Trip to " + id + " on " + NurseSchedulesParser.formatDate(datetime) + " added!");
    }

    public void invalidInputsMessage() {
        System.out.println("Invalid inputs!");
        System.out.println("Type \"help\" to for nurse schedules commands");
        showLine();
    }

    public void addHelpMessage() {
        System.out.println("Please input with the following format: add/[NurseID]/[Patient ID]/[Date (DDMMYYYY)]");
        showLine();
    }

    public void listHelpMessage() {
        System.out.println("Format: list/[NurseID/all]");
        showLine();
    }

    public void deleteHelpMessage() {
        System.out.println("Please input with the following format: delete/[NurseID]/[Date (DDMMYYYY)]");
        showLine();
    }

    public void formatHelpMessage() {
        System.out.println("OOPS! Please check to see if your command is properly formatted!");
    }
}
