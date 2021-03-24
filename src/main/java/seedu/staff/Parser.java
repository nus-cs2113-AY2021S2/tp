package seedu.staff;

import seedu.duke.exceptions.NoInputException;
import seedu.duke.exceptions.staffexceptions.AbortException;
import seedu.duke.exceptions.staffexceptions.WrongListInputException;
import seedu.duke.exceptions.staffexceptions.WrongStaffIdException;
import seedu.duke.storage.StaffStorage;
import seedu.duke.ui.StaffUI;
import seedu.duke.ui.UI;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static seedu.duke.ui.StaffUI.inputToCreateStaff;
import static seedu.duke.ui.UI.*;
import static seedu.staff.StaffList.addStaff;

public class Parser {
    static final String[] COMMANDS = {"add", "delete", "list", "addline", "find", "return", "help"};

    public static void run() throws IOException {
        StaffStorage.fileHandling();
        StaffUI.staffMenuHeader();
        Scanner in = new Scanner(System.in);
        while (true) {
            StaffUI.staffMenuPrompt();
            String line;
            line = in.nextLine();
            try {
                if (commandHandler(line) == 0) {
                    System.out.println("Returning to start Menu!\n");
                    break;
                }
            } catch (WrongStaffIdException e) {
                StaffUI.wrongStaffIDErrorMessage();
            } catch (WrongListInputException e) {
                StaffUI.wrongStaffListInputErrorMessage();
            } catch (NoInputException e) {
                UI.noInputErrorMessage();
            } catch (AbortException e) {
                UI.abortInputErrorMessage();
            }
        }
    }

    public static void checkID(String id) throws WrongStaffIdException {
        try {
            Integer.parseInt(id.substring(1));
        } catch (NumberFormatException e) {
            throw new WrongStaffIdException();
        }
        if (!(id.charAt(0) == 'D' || id.charAt(0) == 'N')) {
            throw new WrongStaffIdException();
        }
    }

    public static void checkEmptyInput(String line) throws NoInputException {
        if (line.split(" ").length < 2) {
            throw new NoInputException();
        }
    }

    public static void checkListCommand(String line) throws WrongListInputException {

        if ((line.split(" ").length > 1) &&
                !((line.split(" ")[1].equals("nurses") || line.split(" ")[1].equals("doctors")))) {
            throw new WrongListInputException();
        }
    }

    public static int commandHandler(String line) throws IOException, WrongStaffIdException,
            WrongListInputException, NoInputException, AbortException {
        if (line.equals(" ")) {
            UI.noCommandErrorMessage();
            return 1;
        }

        switch (smartCommandRecognition(COMMANDS, line.split(" ")[0])) {
        case ("add"):
            addStaff(inputToCreateStaff());
            StaffStorage.writeToFile();
            break;

        case ("addline"):
            checkEmptyInput(line);
            checkID(line.split(" ")[1]);
            StaffList.add(line);
            StaffStorage.writeToFile();
            break;

        case ("list"):
            UI.printEmptyLine();
            checkListCommand(line);
            StaffUI.staffListHeader();
            UI.showLine();
            String[] string = Arrays.copyOfRange(line.split(" "), 1, 2);
            StaffList.list(string);
            UI.printEmptyLine();
            break;

        case ("delete"):
            checkEmptyInput(line);
            checkID(line.split(" ")[1]);
            StaffList.delete(line);
            StaffStorage.writeToFile();
            break;

        case ("help"):
            StaffUI.printStaffHelpList();
            break;

        case ("find"):
            UI.printEmptyLine();
            checkEmptyInput(line);
            StaffUI.staffListHeader();
            UI.showLine();
            StaffList.find(line.split(" ")[1]);
            UI.printEmptyLine();
            break;

        case ("return"):
            StaffStorage.writeToFile();
            StaffList.resetList();
            return 0;

        default:
            UI.invalidCommandErrorMessage();
        }
        return 1;
    }

    protected static String[] addFunctionParser(String line) {
        int length = line.split(" ").length;
        String[] input = new String[4];
        String[] array = line.split(" ");

        for (int i = 1; i < length; i++) {
            try {
                if (i <= 4) {
                    input[i - 1] = array[i];
                } else {
                    input[3] = input[3] + " " + array[i];
                }
            } catch (IndexOutOfBoundsException e) {
                input[i - 1] = " ";
            }
        }
        return input;
    }
}
