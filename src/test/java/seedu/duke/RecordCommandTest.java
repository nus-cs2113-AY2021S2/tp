package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.command.RecordCommand;
import seedu.duke.exception.InvalidInputException;
import seedu.duke.model.Patient;
import seedu.duke.model.Record;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RecordCommandTest {
    @Test
    public void executeRecordCommand_noPatientLoaded_exceptionThrown() {
        Data data = new Data();
        Patient patient = new Patient("S1234567D");
        data.setPatient(patient);
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "record");
        arguments.put("payload", "2021-03-31");
        arguments.put("s", "coughing");
        Ui ui = new Ui();
        RecordCommand recordCommand = new RecordCommand(ui, data, arguments);
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            recordCommand.execute();
        });
        assertEquals("No patient loaded!", exception.getMessage());
    }

    @Test
    public void executeRecordCommand_noDetailsSpecified_exceptionThrown() {
        Data data = new Data();
        Patient patient = new Patient("S1234567D");
        data.setPatient(patient);
        data.loadCurrentPatient(patient.getID());
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "record");
        arguments.put("payload", "");
        Ui ui = new Ui();
        RecordCommand recordCommand = new RecordCommand(ui, data, arguments);
        InvalidInputException invalidInputException = assertThrows(InvalidInputException.class, () -> {
            recordCommand.execute();
        });
        assertEquals(Constants.INVALID_INPUT_EMPTY_DESCRIPTION, invalidInputException.getMessage());
    }

    @Test
    public void executeRecordCommand_onlySymptom_recordAdded() {
        Data data = new Data();
        Patient patient = new Patient("S1234567D");
        data.setPatient(patient);
        data.loadCurrentPatient(patient.getID());
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "record");
        arguments.put("payload", "31/03/2021");
        arguments.put("s", "coughing");
        Ui ui = new Ui();
        RecordCommand recordCommand = new RecordCommand(ui, data, arguments);
        assertDoesNotThrow(() -> {
            recordCommand.execute();
        });
        TreeMap<LocalDate, Record> records = patient.getRecords();
        assertEquals(1, records.size());
    }

    @Test
    public void executeRecordCommand_onlyDiagnosis_recordAdded() {
        Data data = new Data();
        Patient patient = new Patient("S1234567D");
        data.setPatient(patient);
        data.loadCurrentPatient(patient.getID());
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "record");
        arguments.put("payload", "31/03/2021");
        arguments.put("d", "cold");
        Ui ui = new Ui();
        RecordCommand recordCommand = new RecordCommand(ui, data, arguments);
        assertDoesNotThrow(() -> {
            recordCommand.execute();
        });
        TreeMap<LocalDate, Record> records = patient.getRecords();
        assertEquals(1, records.size());
    }

    @Test
    public void executeRecordCommand_onlyPrescription_recordAdded() {
        Data data = new Data();
        Patient patient = new Patient("S1234567D");
        data.setPatient(patient);
        data.loadCurrentPatient(patient.getID());
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "record");
        arguments.put("payload", "31/03/2021");
        arguments.put("p", "dextromethorphan 1 bottle 1 spoonful after each meal");
        Ui ui = new Ui();
        RecordCommand recordCommand = new RecordCommand(ui, data, arguments);
        assertDoesNotThrow(() -> {
            recordCommand.execute();
        });
        TreeMap<LocalDate, Record> records = patient.getRecords();
        assertEquals(1, records.size());
    }

    @Test
    public void executeRecordCommand_symptomAndDiagnosis_recordAdded() {
        Data data = new Data();
        Patient patient = new Patient("S1234567D");
        data.setPatient(patient);
        data.loadCurrentPatient(patient.getID());
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "record");
        arguments.put("payload", "31/03/2021");
        arguments.put("s", "runny nose, high fever");
        arguments.put("d", "flu");
        Ui ui = new Ui();
        RecordCommand recordCommand = new RecordCommand(ui, data, arguments);
        assertDoesNotThrow(() -> {
            recordCommand.execute();
        });
        TreeMap<LocalDate, Record> records = patient.getRecords();
        assertEquals(1, records.size());
    }

    @Test
    public void executeRecordCommand_symptomAndPrescription_recordAdded() {
        Data data = new Data();
        Patient patient = new Patient("S1234567D");
        data.setPatient(patient);
        data.loadCurrentPatient(patient.getID());
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "record");
        arguments.put("payload", "31/03/2021");
        arguments.put("s", "runny nose, high fever");
        arguments.put("p", "paracetamol 200mg 2 tabs daily and cetrizine 1 tab daily");
        Ui ui = new Ui();
        RecordCommand recordCommand = new RecordCommand(ui, data, arguments);
        assertDoesNotThrow(() -> {
            recordCommand.execute();
        });
        TreeMap<LocalDate, Record> records = patient.getRecords();
        assertEquals(1, records.size());
    }

    @Test
    public void executeRecordCommand_emptyStringAsInputs_exceptionThrown() {
        Data data = new Data();
        Patient patient = new Patient("S1234567D");
        data.setPatient(patient);
        data.loadCurrentPatient(patient.getID());
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "record");
        arguments.put("payload", "31/03/2021");
        arguments.put("s", "");
        arguments.put("p", "");
        Ui ui = new Ui();
        RecordCommand recordCommand = new RecordCommand(ui, data, arguments);
        InvalidInputException invalidInputException = assertThrows(InvalidInputException.class, () -> {
            recordCommand.execute();
        });
        assertEquals(Constants.INVALID_INPUT_EMPTY_DESCRIPTION, invalidInputException.getMessage());
    }

}
