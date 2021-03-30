package seedu.ui;

import seedu.exceptions.staff.AbortException;
import seedu.exceptions.staff.WrongStaffIdException;
import seedu.model.staff.Staff;

import static seedu.duke.Constants.*;
import static seedu.logic.errorchecker.StaffChecker.checkStaffID;

public class StaffUI extends UI{


    public static Staff inputToCreateStaff() throws WrongStaffIdException, AbortException {

        String[] staffInput = new String[4];
        System.out.print("Staff ID: ");
        staffInput[0] = abortEnabledScanInput();
        checkStaffID(staffInput[0]);
        System.out.print("Name: ");
        staffInput[1] = abortEnabledScanInput();
        System.out.print("Age: ");
        staffInput[2] = abortEnabledScanInput();
        System.out.print("Specialisation: ");
        staffInput[3] = abortEnabledScanInput();

        staffHiredOutput(staffInput[0], staffInput[1]);
        return new Staff(staffInput);
    }


    public static void staffHiredOutput(String id, String name) {
        if (id.charAt(0) == 'D') {
            try {
                System.out.println("Doctor " + name + " hired!");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Unknown Doctor hired!");
            }
        } else if (id.charAt(0) == 'N') {
            try {
                System.out.println("Nurse " + name + " hired!");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Unknown Doctor hired!");
            }
        }
    }

    public static void staffFiredOutput(String line) {
        System.out.println(line.split("/")[1] + " has been fired.");
    }

    public static void emptyListOutput() {
        System.out.println("OOPS! It seems like you have no staff in the list now!");
    }



    public static void staffDoesNotExist(String line) {
        System.out.println("Staff with ID: " + line.split("/")[1] + " does not exist");
    }

    public static void staffListHeader() {
        System.out.println(
                UI.prettyPrint("ID", 10) + " | " + UI.prettyPrint("Name", 10) + " | "
                        + UI.prettyPrint("Age", 5) + " | " + UI.prettyPrint("Specialisation", 20));
    }

    public static void printStaffHelpList() {

        UI.printEmptyLine();
        System.out.println("Here is a list of Staff commands: ");

        UI.printEmptyLine();
        int[] lengthpara = {10,60,50};
        printer(new String[]{HELP_HEADER_COMMAND, HELP_HEADER_DESCRIPTION, HELP_HEADER_FORMAT}, lengthpara);
        UI.showLongLine();
        printer(new String[]{HELP_COMMAND, STAFF_HELP_DESCRIPTION, BLANK}, lengthpara);
        printer(new String[]{ADD_COMMAND, STAFF_ADD_DESCRIPTION, STAFF_ADD_FORMAT}, lengthpara);
        printer(new String[]{LIST_COMMAND, STAFF_LIST_DESCRIPTION, STAFF_LIST_FORMAT}, lengthpara);
        printer(new String[]{DELETE_COMMAND, STAFF_DELETE_DESCRIPTION, STAFF_DELETE_FORMAT}, lengthpara);
        printer(new String[]{FIND_COMMAND, STAFF_FIND_DESCRIPTION, STAFF_FIND_FORMAT}, lengthpara);
        printer(new String[]{RETURN_COMMAND, RETURN_DESCRIPTION, BLANK}, lengthpara);
        UI.printEmptyLine();

    }

    public static void corruptedFileErrorMessage() {
        System.out.println("File (data/Staff.txt) is corrupted. Please delete the file before running the Staff Menu.");
    }
    public static void wrongStaffIDErrorMessage() {
        System.out.println("Error in Staff ID input\nPlease input with the following format [D/N][5 digit ID number]");
    }

    public static void wrongStaffListInputErrorMessage() {
        System.out.println("Invalid List command parameter\nPlease input with the following format:\n\tlist\n\tlist nurses\n\tlist doctors");
    }

    public static void blankInputErrorMessage() {
        System.out.println("OOPS! Input field cannot be blank. Please change your input!");
    }

    public static void invalidNumericErrorMessage() {
        System.out.println("OOPS! Input field expects a positive numeric. Please change your input!");
    }

    public static void staffMenuPrompt() {
        System.out.print("Staff --> ");
    }

    public static void staffMenuHeader() {
        UI.showLine();
        System.out.print("Welcome to Staff Menu!\nType \"help\" for staff menu commands\n\n");
    }
}
