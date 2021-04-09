package seedu.nurseschedules;

import org.junit.jupiter.api.Test;
import seedu.exceptions.NoInputException;
import seedu.exceptions.nurseschedules.InvalidiDTypeException;
import seedu.logic.errorchecker.NurseScheduleChecker;

import static org.junit.jupiter.api.Assertions.*;

class NurseScheduleCheckerTest {

    NurseScheduleChecker checker = new NurseScheduleChecker();

    @Test
    void testValidDate() {
        String datetime = "30012020";
        assertDoesNotThrow(() -> checker.isValidDate(datetime));
    }

    @Test
    void testInvalidDate() {
        String datetime = "091283109823092830";
        String message = "The date format is invalid!";
        try {
            checker.isValidDate(datetime);
            fail();
        } catch (Exception e) {
            assertEquals(message, e.getMessage());
        }
    }

    @Test
    void testCheckNonEmptyInput() {
        String input = "add/test/input";
        assertDoesNotThrow(() -> NurseScheduleChecker.checkEmptyInput(input));
    }

    @Test
    void testCheckEmptyInput() {
        String input = "";
        assertThrows(NoInputException.class,
                () ->NurseScheduleChecker.checkEmptyInput(input));
    }

    @Test
    void testValidNurseID() {
        String userID = "N12345";
        assertDoesNotThrow(() -> NurseScheduleChecker.checkValidNurseID(userID));
    }

    @Test
    void testInvalidNurseID_WrongLength() {
        String userID = "N123456789";
        assertThrows(InvalidiDTypeException.class,
                () -> NurseScheduleChecker.checkValidNurseID(userID));
    }

    @Test
    void testInvalidNurseID_WrongIdentifier() {
        String userID = "A12345";
        assertThrows(InvalidiDTypeException.class,
                () -> NurseScheduleChecker.checkValidNurseID(userID));
    }

    @Test
    void testInvalidNurseID_WrongData() {
        String userID = "NABCDE";
        assertThrows(InvalidiDTypeException.class,
                () -> NurseScheduleChecker.checkValidNurseID(userID));
    }

    @Test
    void testInvalidPatientID_WrongLength() {
        String userID = "P123456789";
        assertThrows(InvalidiDTypeException.class,
                () -> NurseScheduleChecker.checkValidNurseID(userID));
    }

    @Test
    void testInvalidPatientID_WrongIdentifier() {
        String userID = "A12345";
        assertThrows(InvalidiDTypeException.class,
                () -> NurseScheduleChecker.checkValidNurseID(userID));
    }

    @Test
    void testInvalidPatientID_WrongData() {
        String userID = "PABCDE";
        assertThrows(InvalidiDTypeException.class,
                () -> NurseScheduleChecker.checkValidNurseID(userID));
    }
}