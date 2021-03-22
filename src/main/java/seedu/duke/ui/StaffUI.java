package seedu.duke.ui;

import seedu.duke.exceptions.staffexceptions.AbortException;
import seedu.duke.exceptions.staffexceptions.WrongStaffIdException;
import seedu.staff.Staff;

import static seedu.duke.ui.UI.abortEnabledScanInput;
import static seedu.staff.Parser.checkID;

public class StaffUI {


    public static Staff inputToCreateStaff() throws WrongStaffIdException, AbortException {

        String[] staffInput = new String[4];
        System.out.print("Staff ID: ");
        staffInput[0] = abortEnabledScanInput();
        checkID(staffInput[0]);
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
        System.out.println(line.split(" ")[1] + " has been fired.");
    }

    public static void staffDoesNotExist(String line) {
        System.out.println("Staff with ID: " + line.split(" ")[1] + " does not exist");
    }

    public static void staffListHeader() {
        System.out.println(
                UI.prettyPrint("ID", 10) + " | " + UI.prettyPrint("Name", 10) + " | "
                        + UI.prettyPrint("Age", 5) + " | " + UI.prettyPrint("Specialisation", 20));
    }

    public static void printStaffHelpList() {
        System.out.println("Here is a list of Staff commands: ");
        System.out.println("\"help\" brings up this list of commands!");
        System.out.println("\"add [Staff ID] [Name] [Age] [Specialisation]\" adds a Staff to the staff list!");
        System.out.println("\"list\" brings up the list of all current staff!");
        System.out.println("\"delete [Staff ID]\" deletes the staff with the specified ID from the list!");
        System.out.println("\"find [keyword or phrase]\" finds a keyword or phrase and shows its corresponding staff!");
        System.out.println("\"return\" returns you to the Start Menu!");
    }

    public static void wrongStaffIDErrorMessage() {
        System.out.println("Error in Staff ID input\nPlease input with the following format [D/N][5 digit ID number]");
    }

    public static void wrongStaffListInputErrorMessage() {
        System.out.println("Invalid List command parameter\nPlease input with the following format:\n\tlist\n\tlist nurses\n\tlist doctors");
    }

    public static void staffMenuPrompt() {
        System.out.print("Staff --> ");
    }

    public static void staffMenuHeader() {
        System.out.print("Welcome to Staff Menu!\nType \"help\" for staff menu commands\n\n");
    }
}
