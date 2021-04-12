package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.command.RecordCommand;
import seedu.duke.command.RetrieveCommand;
import seedu.duke.model.Patient;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RetrieveCommandTest {
    @Test
    public void executeRetrieveCommand_noPatientLoaded_exceptionThrown() {
        Data data = new Data();
        Patient patient = new Patient("S1234567D");
        data.setPatient(patient);
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "record");
        arguments.put("payload", "31/03/2021");
        arguments.put("s", "coughing");
        Ui ui = new Ui();
        RetrieveCommand retrieveCommand = new RetrieveCommand(ui, data, arguments);
        Exception exception = assertThrows(Exception.class, () -> {
            retrieveCommand.execute();
        });
        assertEquals(Constants.DATA_NO_PATIENT_LOADED, exception.getMessage());
    }

    @Test
    public void executeRetrieveCommand_patientLoadedAndRecordsAdded_printsRecords() {
        Data data = new Data();
        Patient patient = new Patient("S1234567D");
        data.setPatient(patient);
        data.loadCurrentPatient(patient.getID());
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "record");
        arguments.put("payload", "31/03/2021");
        arguments.put("s", "coughing");
        arguments.put("d", "cold");
        arguments.put("p", "dextromethorphan 1 bottle 1 spoonful after each meal");
        Ui ui = new Ui();
        RecordCommand recordCommand = new RecordCommand(ui, data, arguments);
        assertDoesNotThrow(() -> {
            recordCommand.execute();
        });

        // Bind System.out to a ByteArrayOutputStream
        final PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        RetrieveCommand retrieveCommand = new RetrieveCommand(ui, data, arguments);
        assertDoesNotThrow(() -> {
            retrieveCommand.execute();
        });
        String expected = "Here are " + patient.getID() + "'s records:" + System.lineSeparator()
                + "31/03/2021:" + System.lineSeparator()
                + "Symptoms:" + System.lineSeparator()
                + "\tcoughing" + System.lineSeparator()
                + "Diagnoses:" + System.lineSeparator()
                + "\tcold" + System.lineSeparator()
                + "Prescriptions:" + System.lineSeparator()
                + "\tdextromethorphan 1 bottle 1 spoonful after each meal"
                + System.lineSeparator() + System.lineSeparator();
        assertEquals(expected, bos.toString());

        // Bind System.out back to standard output
        System.setOut(originalOut);
    }

    @Test
    public void executeRetrieveCommand_partialRecordAdded_printsSpecifiedFields() {
        Data data = new Data();
        Patient patient = new Patient("S1234567D");
        data.setPatient(patient);
        data.loadCurrentPatient(patient.getID());
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "record");
        arguments.put("payload", "31/03/2021");
        arguments.put("s", "runny nose, fever 38.5 deg");
        arguments.put("p", "paracetamol 200mg 2 tabs daily and cetrizine 1 tab daily");
        Ui ui = new Ui();
        RecordCommand recordCommand = new RecordCommand(ui, data, arguments);
        assertDoesNotThrow(() -> {
            recordCommand.execute();
        });

        // Bind System.out to a ByteArrayOutputStream
        final PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        RetrieveCommand retrieveCommand = new RetrieveCommand(ui, data, arguments);
        assertDoesNotThrow(() -> {
            retrieveCommand.execute();
        });
        String expected = "Here are " + patient.getID() + "'s records:" + System.lineSeparator()
                + "31/03/2021:" + System.lineSeparator()
                + "Symptoms:" + System.lineSeparator()
                + "\trunny nose, fever 38.5 deg" + System.lineSeparator()
                + "Prescriptions:" + System.lineSeparator()
                + "\tparacetamol 200mg 2 tabs daily and cetrizine 1 tab daily"
                + System.lineSeparator() + System.lineSeparator();
        assertEquals(expected, bos.toString());

        // Bind System.out back to standard output
        System.setOut(originalOut);
    }
}
