package seedu.logic.parser;

import seedu.exceptions.NoInputException;
import seedu.exceptions.staff.AbortException;
import seedu.exceptions.staff.WrongListInputException;
import seedu.exceptions.staff.WrongStaffIdException;
import seedu.logic.command.Command;
import seedu.logic.command.staff.*;
import seedu.ui.UI;

import java.util.Arrays;

import static seedu.ui.UI.smartCommandRecognition;

public class staffparser {
    static final String[] COMMANDS = {"add", "delete", "list", "addline", "find", "return", "help"};


    public static boolean compareInt(int a, String b) {
        try {
            int temp = Integer.parseInt(b);
            return a==temp;
        } catch (NumberFormatException e){
            return false;
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
        if (line.split("/").length < 2) {
            throw new NoInputException();
        }
    }

    public static void checkListCommand(String line) throws WrongListInputException {

        if ((line.split("/").length > 1) &&
                !((line.split("/")[1].equals("nurses") || line.split("/")[1].equals("doctors")))) {
            throw new WrongListInputException();
        }
    }

    public Command commandHandler(String line) throws WrongStaffIdException,
            WrongListInputException, NoInputException, AbortException {
        Command c = null;
        if (line.equals(" ")) {
            UI.noCommandErrorMessage();
            return new StaffReturn();
        }
        switch (smartCommandRecognition(COMMANDS, line.split("/")[0])) {

        case ("add"):
            checkEmptyInput(line);
            checkID(line.split("/")[1]);
            String [] p = Arrays.copyOfRange(line.split("/"), 1, 5);
            c = new StaffAdd(p);
            break;

        case ("list"):
            checkListCommand(line);
            c = new StaffList(line);
            break;

        case ("delete"):
            checkEmptyInput(line);
            checkID(line.split("/")[1]);
            c = new StaffDelete(line);
            break;

        case ("help"):
            c = new StaffHelp();
            break;

        case ("find"):
            checkEmptyInput(line);
            c = new StaffFind(line);
            break;

        case ("return"):
            return new StaffReturn();

        default:
            UI.invalidCommandErrorMessage();
        }
        return c;
    }


/* to be deleted
    public static String[] addFunctionParser(String line) {
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
        return input;add/D55555/pop/12/asd
    }
    */

}
