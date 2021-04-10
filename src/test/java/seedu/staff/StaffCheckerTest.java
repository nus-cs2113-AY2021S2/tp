package seedu.staff;

import org.junit.jupiter.api.Test;
import seedu.exceptions.HealthVaultException;
import seedu.exceptions.staff.WrongStaffIdException;
import seedu.logic.errorchecker.StaffChecker;
import seedu.model.staff.Staff;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StaffCheckerTest {
    private final StaffChecker staffChecker;

    public StaffCheckerTest() {
        this.staffChecker = new StaffChecker();
    }

    @Test
    public void isSameInt_intOneAndStringOne_trueReturned() {
        assertTrue(staffChecker.isSameInt(1,"1"));
    }

    @Test
    public void isSameInt_intOneAndStringTwo_falseReturned() {
        assertFalse(staffChecker.isSameInt(1,"2"));
    }
    @Test
    public void isSameInt_intOneAndStringCharacter_falseReturned() {
        assertFalse(staffChecker.isSameInt(1,"a"));
    }

    @Test
    public void checkStaffID_negativeNumberSectionInID_WrongStaffIDExceptionReturned() {
        WrongStaffIdException exception = assertThrows(WrongStaffIdException.class, () -> {
            staffChecker.checkStaffID("D-1234");
        });

        assertEquals(exception.getMessage(), "Error in Staff ID input\nPlease input with the following format [D/N][5 digit ID number]");
    }

    @Test
    public void checkStaffDataForStorage_insufficientStaffID_HealthVaultReturned() {
        ArrayList<Staff> list = new ArrayList<>();
        HealthVaultException exception = assertThrows(HealthVaultException.class, () -> {
            staffChecker.checkValidDataFromStorage("D1234|Owen|23|Surgeon", list);
        });

        assertEquals(exception.getMessage(), "Error in Staff ID input\nPlease input with the following format [D/N][5 digit ID number]");
    }

    @Test
    public void checkStaffDataForStorage_blankInput_HealthVaultReturned() {
        ArrayList<Staff> list = new ArrayList<>();
        HealthVaultException exception = assertThrows(HealthVaultException.class, () -> {
            staffChecker.checkValidDataFromStorage("D1234| |23|Surgeon", list);
        });

        assertEquals(exception.getMessage(), "Error in Staff ID input\nPlease input with the following format [D/N][5 digit ID number]");
    }



}
