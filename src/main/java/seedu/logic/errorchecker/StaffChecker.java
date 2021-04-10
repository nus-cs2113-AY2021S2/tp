package seedu.logic.errorchecker;

import seedu.exceptions.*;
import seedu.exceptions.staff.InvalidStaffAgeException;
import seedu.exceptions.staff.WrongListInputException;
import seedu.exceptions.staff.WrongStaffIDException;
import seedu.model.staff.Staff;
import seedu.model.staff.StaffList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;

public class StaffChecker extends MainChecker {

    /**
     * Compares an Integer and String to check if the numeric value is the same.
     *
     * @param a  Integer a.
     * @param b String b.
     * @return boolean If String of b is an integer with value same as a.
     */
    public boolean isSameInt(int a, String b) {
        try {
            int temp = Integer.parseInt(b);
            return a == temp;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Returns an array of inputs that were delimited by "/"
     * and removes all trailing and leading whitespaces.
     *
     * @param line  String input of entire command given.
     * @return array Array of Strings used as input fields.
     * @throws InsufficientInputException  If number of input fields is less than 5.
     * @throws ExcessInputException  If number of input fields is more than 5.
     */
    public String[] getTrimInput(String line) throws InsufficientInputException, ExcessInputException {
        String[] array = line.trim().split("/");
        checkNumInput(array, 5, 5);
        array = Arrays.copyOfRange(array, 1, 5);
        for (int i = 0; i<array.length; i++) {
            array[i] = array[i].trim();
        }
        return array;
    }

    /**
     * Calls various checker functions to determine the validity of inputs for Add command
     *
     * @param line  String input of entire command given.
     * @param staffList StaffList object that is an aggregation of all Staff Objects.
     * @return array String Array from getTrimInput()
     * @throws HealthVaultException  If any input field is invalid.
     */
    public String[] checkValidDataForAdd(String line, StaffList staffList) throws HealthVaultException {
        logger.log(Level.INFO, "Checking Staff Data before adding.");
        String[] array = getTrimInput(line);
        checkStaffID(array[0]);
        checkDuplicateStaffID(array[0], staffList.getList());
        checkStaffAge(array[2]);
        checkBlankInput(array);
        invalidCharactersStaffChecker(array);
        return array;
    }

    /**
     * Calls various checker functions to determine the validity of data
     * when loading data from text files.
     *
     * @param line  String input of entire command given.
     * @param list ArrayList that is an aggregation of all Staff Objects to be loaded.
     * @throws HealthVaultException  If any input field from sata files is corrupted.
     */
    public void checkValidDataFromStorage(String line, ArrayList<Staff> list) throws HealthVaultException {
        logger.log(Level.INFO, "Checking Staff Data before loading.");
        checkDataNumInput(line,4,4);
        checkStaffID(line.split("\\|")[0]);
        checkDuplicateStaffID(line.split("\\|")[0], list);
        checkStaffAge(line.split("\\|")[2]);
        checkBlankInputForStorage(line);
    }

    /**
     * Checks if Staff ID given is already found in the ArrayList.
     *
     * @param id  String of ID to be checked against the ArrayList.
     * @param list ArrayList containing data for Staff objects.
     * @throws DuplicateIDException  If id is found in list
     */
    public void checkDuplicateStaffID(String id, ArrayList<Staff> list) throws DuplicateIDException {
        logger.log(Level.INFO, "Checking Duplicated Staff ID.");
        for (Staff staff : list) {
            if (staff.getId().equals(id)) {
                throw new DuplicateIDException("Staff");
            }
        }
    }

    /**
     * Checks if a given String id has valid Staff ID format.
     *
     * @param id  String of Staff ID
     * @throws WrongStaffIDException  If the format of Staff ID is not valid ([D/N][5 digit integer])
     */
    public void checkStaffID(String id) throws WrongStaffIDException {
        logger.log(Level.INFO, "Checking Staff ID.");
        try {
            if (id.length() < 5) {
                throw new WrongStaffIDException();
            }
            if (!(id.charAt(0) == 'D' || id.charAt(0) == 'N') || (id.length()) != 6) {
                throw new WrongStaffIDException();
            }
            if (Integer.parseInt(id.substring(1)) < 0) {
                throw new WrongStaffIDException();
            }
        } catch (NumberFormatException e) {
            throw new WrongStaffIDException();
        }

    }

    /**
     * Checks if a given String input has is valid to be used as Staff Age.
     *
     * @param number String of age.
     * @throws NumberFormatException  If input is not numeric.
     * @throws InvalidIntegerException  If integer is < 0.
     * @throws InvalidStaffAgeException  If age does nat fall within the range of 18 <= age <= 150.
     */
    public void checkStaffAge(String number) throws NumberFormatException,
            InvalidIntegerException, InvalidStaffAgeException {
        logger.log(Level.INFO, "Checking Staff Age.");
        checkNumericInput(number);
        if (Integer.parseInt(number) < 18 || Integer.parseInt(number) > 150) {
            throw new InvalidStaffAgeException();
        }
    }

    /**
     * Checks if any input has illegal characters (Non alphanumeric and non whitespace) for Add command.
     *
     * @param array  Array of inputs.
     * @throws IllegalCharacterException  If any illegal characters is present.
     */
    public void invalidCharactersStaffChecker(String[] array) throws IllegalCharacterException {
        logger.log(Level.INFO, "Checking Illegal Characters in Staff input.");
        String[] field = {"ID", "name", "age", "specialisation"};
        for (int i = 0; i < array.length; i++) {
            illegalCharacterChecker(array[i], field[i]);
        }
    }

    /**
     * Checks if any input has illegal characters (Non alphanumeric and non whitespace)
     * from data storage before loading, to prevent corrupted data from loading.
     *
     * @param line String of data from storage.
     * @throws IllegalCharacterException  If any illegal characters is present.
     */
    public String[] invalidCharactersStaffCheckerForStorage(String line) throws IllegalCharacterException {
        String [] cleanArray = line.split("\\|");
        String[] field = {"ID", "name", "age", "specialisation"};
        for (int i = 0; i < (cleanArray.length); i++) {
            illegalCharacterChecker(cleanArray[i], field[i]);
        }
        return cleanArray;
    }

    /**
     * Checks if input is equals to "nurses" (case insensitive).
     *
     * @param input String input.
     * @return boolean If input equals "nurses" case insensitive
     */
    public boolean isEqualNurses(String input) {
        return input.trim().equalsIgnoreCase("nurses");
    }

    /**
     * Checks if input is equals to "doctors" (case insensitive).
     *
     * @param input String input.
     * @return boolean If input equals "doctors" case insensitive
     */
    public boolean isEqualDoctors(String input) {
        return input.trim().equalsIgnoreCase("doctors");
    }

    /**
     * Checks validity of the list command.
     * Returns String array that contains input fields for StaffList command.
     *
     * @param line  Entire command input.
     * @return array of inputs for StaffList command.
     * @throws WrongListInputException  If zone is <= 0.
     * @throws InsufficientInputException  If number of input fields is less than 1.
     * @throws ExcessInputException  If number of input fields is more than 2.
     */
    public String[] checkListCommand(String line) throws WrongListInputException,
            ExcessInputException, InsufficientInputException {
        String[] array = line.split("/");
        if ((array.length > 1) &&
                !(isEqualNurses(array[1]) || isEqualDoctors(array[1]) )) {
            throw new WrongListInputException();
        }
        MainChecker.checkNumInput(array,2,1);
        return array;
    }

    /**
     * Checks validity of the delete command.
     * Returns String of the Staff ID to be deleted.
     *
     * @param line  Entire delete command input.
     * @return Staff ID to be deleted.
     * @throws WrongStaffIDException  If zone is <= 0.
     * @throws InsufficientInputException  If number of input fields is less than 2.
     * @throws ExcessInputException  If number of input fields is more than 2.
     */
    public String checkDeleteCommand(String line) throws ExcessInputException,
            InsufficientInputException, WrongStaffIDException {
        checkNumInput(line.split("/"),2,2);
        String input = line.split("/")[1];
        checkStaffID(input);
        return input;
    }
}
