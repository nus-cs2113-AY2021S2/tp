package seedu.patient;

import org.junit.jupiter.api.Test;

import seedu.exceptions.DukeException;
import seedu.logic.parser.PatientParser;
import seedu.model.objectList.PatientList;

import static org.junit.jupiter.api.Assertions.*;

public class PatientParserTest {

    private PatientParser parser;
    private PatientList patients;

    @Test
    public void testReturnCommand() throws DukeException {
        boolean output = parser.patientParse("return", patients);
        assertTrue(output);
    }

    @Test
    public void testAddPatientNegative() throws DukeException {
        String input = "add X12345 Johnny 30 M Covid19 Paracetamol";
        String expected = "OOPS! Looks like your ID type is incorrect! \n" +
                "Please ensure that the ID starts with \"P\"!";
        boolean output = parser.patientParse(input, patients);
        assertFalse(output);
    }

}
