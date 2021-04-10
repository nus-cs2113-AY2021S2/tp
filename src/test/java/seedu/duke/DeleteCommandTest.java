package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.command.DeleteCommand;
import seedu.duke.model.Patient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteCommandTest {
    @Test
    public void executeDeleteCommand_patientDeleted() {
        Data data = new Data();
        Patient patient = new Patient("S1234567D");
        data.setPatient(patient);
        data.loadCurrentPatient(patient.getID());
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "delete");
        arguments.put("p", "S1234567D");
        Ui ui = new Ui();
        DeleteCommand deleteCommand = new DeleteCommand(ui, data, arguments);

        final PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        assertDoesNotThrow(() -> {
            deleteCommand.execute();
        });

        assertEquals("Patient S1234567D has been deleted!" + System.lineSeparator(), bos.toString());
        System.setOut(originalOut);
    }

    @Test
    public void executeDeleteCommand_recordDeleted() {
        Data data = new Data();
        Patient patient = new Patient("S1234567D");
        data.setPatient(patient);
        data.loadCurrentPatient(patient.getID());
        String date = "29/03/2021";
        LocalDate parseDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(Constants.DATE_PATTERN));
        patient.addRecord(parseDate, "coughing", "", "");
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "delete");
        arguments.put("r", "29/03/2021");
        Ui ui = new Ui();
        DeleteCommand deleteCommand = new DeleteCommand(ui, data, arguments);

        final PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        assertDoesNotThrow(() -> {
            deleteCommand.execute();
        });

        assertEquals("Record for 29/03/2021 has been deleted!" + System.lineSeparator(), bos.toString());
        System.setOut(originalOut);
    }

    @Test
    public void executeDeleteCommand_invalidInput() {
        Data data = new Data();
        Ui ui = new Ui();
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "delete");
        DeleteCommand deleteCommand = new DeleteCommand(ui, data, arguments);

        Exception exception = assertThrows(Exception.class, () -> {
            deleteCommand.execute();
        });
        assertEquals(Constants.INVALID_INPUT_UNKNOWN_DELETE_ARGUMENT, exception.getMessage());
    }

    @Test
    public void executeDeleteCommand_patientDoesNotExist() {
        Data data = new Data();
        Ui ui = new Ui();
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "delete");
        arguments.put("p", "S1234567D");
        DeleteCommand deleteCommand = new DeleteCommand(ui, data, arguments);

        Exception exception = assertThrows(Exception.class, () -> {
            deleteCommand.execute();
        });
        assertEquals(Constants.INVALID_INPUT_PATIENT_NOT_FOUND, exception.getMessage());
    }

    @Test
    public void executeDeleteCommand_recordDoesNotExist() {
        Data data = new Data();
        Patient patient = new Patient("S1234567D");
        data.setPatient(patient);
        data.loadCurrentPatient(patient.getID());
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "delete");
        arguments.put("r", "29/03/2021");
        Ui ui = new Ui();
        DeleteCommand deleteCommand = new DeleteCommand(ui, data, arguments);

        final PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        assertDoesNotThrow(() -> {
            deleteCommand.execute();
        });

        assertEquals("Record for 29/03/2021 does not exist!" + System.lineSeparator(), bos.toString());
        System.setOut(originalOut);
    }
}
