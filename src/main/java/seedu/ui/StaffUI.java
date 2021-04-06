package seedu.ui;

import static seedu.duke.Constants.*;

public class StaffUI extends UI {

    public static void staffHiredOutput(String id, String name) {
        if (id.charAt(0) == 'D') {
            try {
                System.out.println("Doctor " + name + " hired :)");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Unknown Doctor hired!");
            }
        } else if (id.charAt(0) == 'N') {
            try {
                System.out.println("Nurse " + name + " hired :)");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Unknown Doctor hired!");
            }
        }
    }

    public static void staffFiredOutput(String line) {
        System.out.println(line.split("/")[1] + " has been fired :(");
    }

    public static void staffListHeader() {
        System.out.println(
                UI.prettyPrint("ID", 10) + " | " + UI.prettyPrint("Name", 10) + " | "
                        + UI.prettyPrint("Age", 5) + " | " + UI.prettyPrint("Specialisation", 20));
    }

    public static void staffMenuHeader() {
        UI.showLine();
        System.out.print("Welcome to Staff Menu!\nType \"help\" for staff menu commands\n\n");
    }

    public static void printStaffHelpMessage() {

        UI.printEmptyLine();
        System.out.println("Here is a list of Staff commands: ");

        UI.printEmptyLine();
        int[] lengthPara = {10,60,50};
        printer(new String[]{HELP_HEADER_COMMAND, HELP_HEADER_DESCRIPTION, HELP_HEADER_FORMAT}, lengthPara);
        UI.showLongLine();
        printer(new String[]{HELP_COMMAND, STAFF_HELP_DESCRIPTION, MARK_BLANK}, lengthPara);
        printer(new String[]{ADD_COMMAND, STAFF_ADD_DESCRIPTION, STAFF_ADD_FORMAT}, lengthPara);
        printer(new String[]{LIST_COMMAND, STAFF_LIST_DESCRIPTION, STAFF_LIST_FORMAT}, lengthPara);
        printer(new String[]{DELETE_COMMAND, STAFF_DELETE_DESCRIPTION, STAFF_DELETE_FORMAT}, lengthPara);
        printer(new String[]{FIND_COMMAND, STAFF_FIND_DESCRIPTION, STAFF_FIND_FORMAT}, lengthPara);
        printer(new String[]{RETURN_COMMAND, RETURN_DESCRIPTION, MARK_BLANK}, lengthPara);
        UI.printEmptyLine();

    }



    public static void staffNotFoundErrorMessage() {
        System.out.println("There is no staff in the list that matches your keywords!");
    }

    public static void corruptedFileErrorMessage() {
        System.out.println("File (data/Staff.txt) is corrupted. Please delete the file before running the Staff Menu.");
    }

    public static void invalidNumericErrorMessage() {
        System.out.println("The numeric input is invalid!");
    }

    public static void staffDoesNotExistErrorMessage(String line) {
        System.out.println("Staff with ID: " + line.split("/")[1] + " does not exist");
    }

    public static void emptyListErrorMessage() {
        System.out.println("OOPS! It seems like you have no staff in the list now!");
    }
}
