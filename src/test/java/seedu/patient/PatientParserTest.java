package seedu.patient;

import org.junit.jupiter.api.Test;
import seedu.exceptions.HealthVaultException;
import seedu.logic.command.Command;
import seedu.logic.command.patient.PatientHelpCommand;
import seedu.logic.command.patient.PatientListCommand;
import seedu.model.patient.PatientList;
import seedu.logic.parser.PatientParser;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PatientParserTest {

    private PatientParser parser = new PatientParser();
    private PatientList patients = new PatientList();

    @Test
    public void patientParse_validHelpCommand_patientHelpCommandReturned() throws HealthVaultException {
        Command c;
        c = this.parser.patientParse("help", patients);
        assertTrue(c instanceof PatientHelpCommand);
    }

    @Test
    public void patientParse_validListCommand_patientListCommandReturned() throws HealthVaultException {
        Command c;
        c = this.parser.patientParse("list", patients);
        assertTrue(c instanceof PatientListCommand);
    }

}