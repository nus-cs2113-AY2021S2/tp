package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.command.AddCommand;
import seedu.duke.exception.InvalidInputException;

import java.util.HashMap;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AddCommandTest {
    @Test
    public void executeAddCommand_patientAdded() {
        Data data = new Data();
        Ui ui = new Ui();
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "add");
        arguments.put("payload", "S1234567D");
        AddCommand addCommand = new AddCommand(ui, data, arguments);

        final PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        assertDoesNotThrow(() -> {
            addCommand.execute();
        });

        assertEquals("Patient S1234567D has been added!" + System.lineSeparator(), bos.toString());
        System.setOut(originalOut);
    }

    @Test
    public void executeAddCommand_invalidID_exceptionThrown() {
        Data data = new Data();
        Ui ui = new Ui();
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "add");
        arguments.put("payload", "S12345677A");
        AddCommand addCommand = new AddCommand(ui, data, arguments);

        InvalidInputException invalidInputException = assertThrows(InvalidInputException.class, () -> {
            addCommand.execute();
        });
        assertEquals(Constants.INVALID_INPUT_INVALID_NRIC, invalidInputException.getMessage());
    }

    @Test
    public void executeAddCommand_invalidFirstLetter_exceptionThrown() {
        Data data = new Data();
        Ui ui = new Ui();
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "add");
        arguments.put("payload", "P1234567A");
        AddCommand addCommand = new AddCommand(ui, data, arguments);

        InvalidInputException invalidInputException = assertThrows(InvalidInputException.class, () -> {
            addCommand.execute();
        });
        assertEquals(Constants.INVALID_INPUT_INVALID_NRIC_FIRST_LETTER, invalidInputException.getMessage());
    }

    @Test
    public void executeAddCommand_invalidChecksum_exceptionThrown() {
        Data data = new Data();
        Ui ui = new Ui();
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "add");
        arguments.put("payload", "S1234567A");
        AddCommand addCommand = new AddCommand(ui, data, arguments);

        InvalidInputException invalidInputException = assertThrows(InvalidInputException.class, () -> {
            addCommand.execute();
        });
        assertEquals(Constants.INVALID_INPUT_INVALID_NRIC_CHECKSUM, invalidInputException.getMessage());
    }

    @Test
    public void executeAddCommand_patientAlreadyExists_exceptionThrown() {
        Data data = new Data();
        Ui ui = new Ui();
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "add");
        arguments.put("payload", "S1234567D");
        AddCommand addCommand = new AddCommand(ui, data, arguments);

        assertDoesNotThrow(() -> {
            addCommand.execute();
        });

        InvalidInputException invalidInputException = assertThrows(InvalidInputException.class, () -> {
            addCommand.execute();
        });
        assertEquals(Constants.INVALID_INPUT_PATIENT_EXISTED, invalidInputException.getMessage());
    }
}
