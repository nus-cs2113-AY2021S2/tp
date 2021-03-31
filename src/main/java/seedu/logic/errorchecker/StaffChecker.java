package seedu.logic.errorchecker;

import seedu.exceptions.*;
import seedu.exceptions.patient.IllegalCharacterException;
import seedu.exceptions.staff.WrongListInputException;
import seedu.exceptions.staff.WrongStaffIdException;
import seedu.logic.command.StaffAggregation;
import seedu.model.staff.Staff;

import java.util.ArrayList;
import java.util.Arrays;

public class StaffChecker extends MainChecker {

    public boolean isSameInt(int a, String b) {
        try {
            int temp = Integer.parseInt(b);
            return a==temp;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public void checkValidDataForAdd(String line, StaffAggregation staffAggregation) throws
            NoInputException, WrongStaffIdException, InvalidIntegerException,
            ExcessInputException, InsufficientInputException, DuplicateIDException {
        checkNumInput(line,5,5);
        checkStaffID(line.split("/")[1]);
        checkDuplicateStaffID(line.split("/")[1],staffAggregation.getList());
        checkNumericInput(line.split("/")[3]);
        checkBlankInput(line);
    }
    public void checkValidDataFromStorage(String line, ArrayList<Staff> list) throws NoInputException,
            WrongStaffIdException, InvalidIntegerException,
            ExcessInputException, InsufficientInputException, DuplicateIDException {
        checkDataNumInput(line,4,4);
        checkStaffID(line.split("\\|")[0]);
        checkDuplicateStaffID(line.split("\\|")[0], list);
        checkNumericInput(line.split("\\|")[2]);
        checkBlankInputForStorage(line);
    }
    public void checkDuplicateStaffID(String id, ArrayList<Staff> list) throws DuplicateIDException {
        for (Staff staff : list) {
            if (staff.getId().equals(id)) {
                throw new DuplicateIDException("Staff");
            }
        }
    }

    public void checkStaffID(String id) throws WrongStaffIdException {
        try {
            Integer.parseInt(id.substring(1));
        } catch (NumberFormatException e) {
            throw new WrongStaffIdException();
        }
        if (!(id.charAt(0) == 'D' || id.charAt(0) == 'N') || (id.length()) != 6) {
            throw new WrongStaffIdException();
        }
    }
    public String[] invalidCharactersStaffChecker(String line) throws IllegalCharacterException {
        String [] cleanArray = Arrays.copyOfRange(line.split("/"), 1, 5);
        String[] field = {"ID", "name", "age", "specialisation"};
        for (int i=0; i< cleanArray.length; i++) {
            illegalCharacterChecker(cleanArray[i], field[i]);
        }
        return cleanArray;
    }

    public String[] invalidCharactersStaffCheckerForStorage(String line) throws IllegalCharacterException {
        String [] cleanArray = line.split("\\|");
        String[] field = {"ID", "name", "age", "specialisation"};
        for (int i=0; i < (cleanArray.length); i++) {
            illegalCharacterChecker(cleanArray[i], field[i]);
        }
        return cleanArray;
    }

    public void checkListCommand(String line) throws WrongListInputException {

        if ((line.split("/").length > 1) &&
                !((line.split("/")[1].equals("nurses") || line.split("/")[1].equals("doctors")))) {
            throw new WrongListInputException();
        }
    }
}
