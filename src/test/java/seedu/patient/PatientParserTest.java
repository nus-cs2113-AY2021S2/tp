package seedu.patient;

import org.junit.jupiter.api.Test;
import seedu.exceptions.HealthVaultException;
import seedu.logic.command.Command;
import seedu.logic.command.PatientActions;
import seedu.logic.parser.PatientParser;

public class PatientParserTest {

    private PatientParser parser;
    private PatientActions patients;

    @Test
    public void testReturnCommand() throws HealthVaultException {
        Command output = parser.patientParse("return", patients);
    }

    @Test
    public void testAddPatientNegative() throws HealthVaultException {
        String input = "add X12345 Johnny 30 M Covid19 Paracetamol";
        String expected = "OOPS! Looks like your ID type is incorrect! \n" +
                "Please ensure that the ID starts with \"P\"!";
        Command output = parser.patientParse(input, patients);
    }

}