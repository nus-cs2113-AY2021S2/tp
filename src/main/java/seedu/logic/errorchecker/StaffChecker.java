package seedu.logic.errorchecker;

import seedu.exceptions.ExcessInputException;
import seedu.exceptions.InsufficientInputException;
import seedu.exceptions.InvalidIntegerException;
import seedu.exceptions.NoInputException;
import seedu.exceptions.staff.WrongListInputException;
import seedu.exceptions.staff.WrongStaffIdException;

public class StaffChecker extends MainChecker {
    public static boolean isSameInt(int a, String b) {
        try {
            int temp = Integer.parseInt(b);
            return a==temp;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public static void checkValidDataForAdd(String line) throws NoInputException,
            WrongStaffIdException, InvalidIntegerException,
            ExcessInputException, InsufficientInputException {
        checkNumInput(line,5,5);
        checkStaffID(line.split("/")[1]);
        checkNumericInput(line.split("/")[3]);
        checkBlankInput(line);
    }
    public static void checkValidDataForStorage(String line) throws NoInputException,
            WrongStaffIdException, InvalidIntegerException,
            ExcessInputException, InsufficientInputException {
        checkDataNumInput(line,4,4);
        checkStaffID(line.split("\\|")[0]);
        checkNumericInput(line.split("\\|")[2]);
        checkBlankInputForStorage(line);
    }

    public static void checkStaffID(String id) throws WrongStaffIdException {
        try {
            Integer.parseInt(id.substring(1));
        } catch (NumberFormatException e) {
            throw new WrongStaffIdException();
        }
        if (!(id.charAt(0) == 'D' || id.charAt(0) == 'N') || (id.length()) != 6) {
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
}
