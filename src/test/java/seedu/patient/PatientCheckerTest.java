package seedu.patient;

import org.junit.jupiter.api.Test;
import seedu.exceptions.NoInputException;
import seedu.logic.errorchecker.patientchecker.PatientChecker;
import seedu.model.patient.PatientList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PatientCheckerTest {

    PatientChecker patientCheck;
    PatientList patients = new PatientList();
    String[] stringTokens = {"help"};
    int numberOfTokens = 1;
    String command = "help";

    @Test
    void testValidPatientId() {
        patientCheck = new PatientChecker(patients, stringTokens, command, numberOfTokens);
        String id = "P12345";
        assertDoesNotThrow(() -> patientCheck.checkValidId(id));
    }

    @Test
    void testValidPatientAge() {
        patientCheck = new PatientChecker(patients, stringTokens, command, numberOfTokens);
        String age = "100";
        assertDoesNotThrow(() -> patientCheck.checkAgeRange(age));
    }

    @Test
    void testCheckEmptyInput() {
        String[] stringTokens = new String[] {"delete", ""};
        int numberOfTokens = 2;
        String command = "delete";
        patientCheck = new PatientChecker(patients, stringTokens, command, numberOfTokens);
        assertThrows(NoInputException.class, () -> patientCheck.emptySpaceCheck());
    }
}
