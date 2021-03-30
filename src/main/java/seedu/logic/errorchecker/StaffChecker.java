package seedu.logic.errorchecker;

import seedu.exceptions.NoInputException;
import seedu.exceptions.staff.*;

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
            WrongStaffIdException, PositiveNumberOnlyException,
            ExcessInputException, InsufficientInputException, BlankInputException {

        checkNumInput(line,5,5);
        checkID(line.split("/")[1]);
        checkNumericInput(line);
        checkBlankInput(line);
    }

    public static void checkID(String id) throws WrongStaffIdException {
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

    public static void checkNumInput(String line, int max, int min) throws InsufficientInputException, ExcessInputException{
        if (line.split("/").length < min) {
            throw new InsufficientInputException();
        }
        if (line.split("/").length > max) {
            throw new ExcessInputException();
        }
    }

    public static void checkBlankInput(String line) throws BlankInputException {
       String[] array = line.split("/");
        for (String s : array) {
            if (s.trim().equals("")) {
                throw new BlankInputException();
            }
        }
    }

    public static void checkNumericInput(String line) throws NumberFormatException, PositiveNumberOnlyException {
        String[] array = line.split("/");
        try {
            Integer.parseInt(array[3]);     // Check age is numeric
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        if (Integer.parseInt(array[3]) < 0) {
            throw new PositiveNumberOnlyException();
        }
    }

    public static void checkListCommand(String line) throws WrongListInputException {

        if ((line.split("/").length > 1) &&
                !((line.split("/")[1].equals("nurses") || line.split("/")[1].equals("doctors")))) {
            throw new WrongListInputException();
        }
    }
}
