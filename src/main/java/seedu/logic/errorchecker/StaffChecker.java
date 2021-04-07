package seedu.logic.errorchecker;

import seedu.exceptions.*;
import seedu.exceptions.patient.IllegalCharacterException;
import seedu.exceptions.staff.InvalidStaffAgeException;
import seedu.exceptions.staff.WrongListInputException;
import seedu.exceptions.staff.WrongStaffIdException;
import seedu.model.staff.StaffList;
import seedu.model.staff.Staff;

import java.util.ArrayList;
import java.util.Arrays;

public class StaffChecker extends MainChecker {

    public boolean isSameInt(int a, String b) {
        try {
            int temp = Integer.parseInt(b);
            return a == temp;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String[] getTrimInput(String line) throws InsufficientInputException, ExcessInputException {
        String[] array = line.trim().split("/");
        checkNumInput2(array, 5, 5);
        array = Arrays.copyOfRange(array, 1, 5);
        for (int i = 0; i<array.length; i++) {
            array[i] = array[i].trim();
        }
        return array;
    }


    public String[] checkValidDataForAdd(String line, StaffList staffList) throws
            NoInputException, WrongStaffIdException, InvalidIntegerException,
            ExcessInputException, InsufficientInputException, DuplicateIDException,
            InvalidStaffAgeException, IllegalCharacterException {
        String[] array = getTrimInput(line);
        checkStaffID(array[0]);
        checkDuplicateStaffID(array[0], staffList.getList());
        checkStaffAge(array[2]);
        checkBlankInput2(array);
        invalidCharactersStaffChecker(array);
        return array;
    }

    public void checkValidDataFromStorage(String line, ArrayList<Staff> list) throws NoInputException,
            WrongStaffIdException, InvalidIntegerException, ExcessInputException,
            InsufficientInputException, DuplicateIDException, InvalidStaffAgeException {

        checkDataNumInput(line,4,4);
        checkStaffID(line.split("\\|")[0]);
        checkDuplicateStaffID(line.split("\\|")[0], list);
        checkStaffAge(line.split("\\|")[2]);
        checkBlankInputForStorage(line);
    }

    public void checkDuplicateStaffID(String id, ArrayList<Staff> list) throws DuplicateIDException {
        for (Staff staff : list) {
            if (staff.getId().equals(id)) {
                throw new DuplicateIDException("Staff");
            }
        }
    }

    public void checkStaffID(String id) throws WrongStaffIdException, InvalidIntegerException {
        try {
            if (Integer.parseInt(id.substring(1)) < 0) {
                throw new InvalidIntegerException();
            }
        } catch (NumberFormatException e) {
            throw new WrongStaffIdException();
        }
        if (!(id.charAt(0) == 'D' || id.charAt(0) == 'N') || (id.length()) != 6) {
            throw new WrongStaffIdException();
        }
    }

    public static void checkStaffAge(String number) throws NumberFormatException,
            InvalidIntegerException, InvalidStaffAgeException {
        checkNumericInput(number);
        if (Integer.parseInt(number) < 18 || Integer.parseInt(number) > 150) {
            throw new InvalidStaffAgeException();
        }
    }

    public void invalidCharactersStaffChecker(String[] array) throws IllegalCharacterException {
        String[] field = {"ID", "name", "age", "specialisation"};
        for (int i = 0; i < array.length; i++) {
            illegalCharacterChecker(array[i], field[i]);
        }
    }

    public String[] invalidCharactersStaffCheckerForStorage(String line) throws IllegalCharacterException {
        String [] cleanArray = line.split("\\|");
        String[] field = {"ID", "name", "age", "specialisation"};
        for (int i = 0; i < (cleanArray.length); i++) {
            illegalCharacterChecker(cleanArray[i], field[i]);
        }
        return cleanArray;
    }

    public boolean isEqualNurses(String input) {
        return input.trim().equalsIgnoreCase("nurses");
    }

    public boolean isEqualDoctors(String input) {
        return input.trim().equalsIgnoreCase("doctors");
    }

    public String[] checkListCommand(String line) throws WrongListInputException,
            ExcessInputException, InsufficientInputException {
        String[] array = line.split("/");
        if ((array.length > 1) &&
                !(isEqualNurses(array[1]) || isEqualDoctors(array[1]) )) {
            throw new WrongListInputException();
        }
        MainChecker.checkNumInput2(array,2,1);
        return array;
    }

    public String checkDeleteCommand(String line) throws ExcessInputException,
            InsufficientInputException, InvalidIntegerException, WrongStaffIdException {
        checkNumInput2(line.split("/"),2,2);
        String input = line.split("/")[1];
        checkStaffID(input);
        return input;
    }
}
