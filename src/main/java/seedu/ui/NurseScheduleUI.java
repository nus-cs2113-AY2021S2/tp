package seedu.ui;

import seedu.logic.parser.NurseSchedulesParser;

import java.text.ParseException;

import static seedu.duke.Constants.*;

public class NurseScheduleUI extends UI {

    public void printNurseScheduleWelcomeMessage() {
        showLine();
        System.out.println("Welcome to Nurse Schedules!");
        System.out.println("Type \"help\" to for nurse schedules commands");
        lineBreak();
    }

    public void printNurseScheduleHelpList() {
        System.out.println("Here is a list of Nurse Schedule commands: ");

<<<<<<< HEAD
        UI.printEmptyLine();
        int[] lengthPara = {10,60,50};
        printer(new String[]{HELP_HEADER_COMMAND, HELP_HEADER_DESCRIPTION, HELP_HEADER_FORMAT}, lengthPara);
        UI.showLongLine();
        printer(new String[]{HELP_COMMAND, SCHEDULES_HELP_DESCRIPTION, MARK_BLANK}, lengthPara);
        printer(new String[]{ADD_COMMAND, SCHEDULES_ADD_DESCRIPTION, SCHEDULES_ADD_FORMAT}, lengthPara);
        printer(new String[]{LIST_COMMAND, SCHEDULES_LIST_DESCRIPTION, SCHEDULES_LIST_FORMAT}, lengthPara);
        printer(new String[]{DELETE_COMMAND, SCHEDULES_DELETE_DESCRIPTION, SCHEDULES_DELETE_FORMAT}, lengthPara);
        printer(new String[]{RETURN_COMMAND, RETURN_DESCRIPTION, MARK_BLANK}, lengthPara);
        UI.printEmptyLine();
=======
        lineBreak();
        int[] lengthpara = {10,60,50};
        printer(new String[]{HELP_HEADER_COMMAND, HELP_HEADER_DESCRIPTION, HELP_HEADER_FORMAT}, lengthpara);
        UI.showLongLine();
        printer(new String[]{HELP_COMMAND, SCHEDULES_HELP_DESCRIPTION, BLANK}, lengthpara);
        printer(new String[]{ADD_COMMAND, SCHEDULES_ADD_DESCRIPTION, SCHEDULES_ADD_FORMAT}, lengthpara);
        printer(new String[]{LIST_COMMAND, SCHEDULES_LIST_DESCRIPTION, SCHEDULES_LIST_FORMAT}, lengthpara);
        printer(new String[]{DELETE_COMMAND, SCHEDULES_DELETE_DESCRIPTION, SCHEDULES_DELETE_FORMAT}, lengthpara);
        printer(new String[]{RETURN_COMMAND, RETURN_DESCRIPTION, BLANK}, lengthpara);
>>>>>>> c4330f9184f2e4edabe7a52ab14246137fa9b62e
    }

    public static void printDeletedSchedule(String id, String datetime) {
        System.out.println("Trip to " + id
                + " on " + datetime + " has been cancelled!");
    }

    public static void printAddedSchedule(String id, String datetime) throws ParseException {
        System.out.println("Trip to " + id + " on " + NurseSchedulesParser.formatDate(datetime) + " added!");
    }

    public void invalidInputsMessage() {
        showLine();
        System.out.println("Invalid inputs!");
        System.out.println("Type \"help\" to for nurse schedules commands");
    }

    public void addHelpMessage() {
        System.out.println("Please input with the following format: add/[NurseID]/[Patient ID]/[Date (DDMMYYYY)]");
    }

    public void listHelpMessage() {
        System.out.println("Please input with the following format: list/[NurseID/all]");
    }

    public void deleteHelpMessage() {
        System.out.println("Please input with the following format: delete/[NurseID]/[Date (DDMMYYYY)]");
    }

    public void formatHelpMessage() {
        lineBreak();
        System.out.println("OOPS! Please check to see if your command is properly formatted!");
    }

    public static void nurseListHeader() {
        System.out.println(
                UI.prettyPrint("Nurse ID", 10) + " | " + UI.prettyPrint("Patient ID", 10) + " | "
                        + UI.prettyPrint("Time", 10));
    }

    public static void printEmptyCell() {
        System.out.print(UI.prettyPrint(" ", 10) + " | ");
    }
}
