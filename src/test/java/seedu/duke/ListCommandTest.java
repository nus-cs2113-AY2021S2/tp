package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.command.ListCommand;
import seedu.duke.model.Patient;

import java.util.HashMap;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListCommandTest {
    @Test
    public void executeListCommand_listEmpty_exceptionThrown() {
        Data data = new Data();
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "list");
        ListCommand listCommand = new ListCommand(null, data, arguments);

        Exception exception = assertThrows(Exception.class, () -> {
            listCommand.execute();
        });
        assertEquals("List is currently empty!", exception.getMessage());
    }

    @Test
    public void executeListCommand() {
        Data data = new Data();
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "list");

        Patient patient = new Patient("S1234567A");
        data.setPatient(patient);
        patient = new Patient("S7654321B");
        data.setPatient(patient);
        ListCommand listCommand = new ListCommand(null, data, arguments);

        final PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            listCommand.execute();
        } catch (Exception exception) {
            System.out.println("An error occurred while running tests");
        }
        assertEquals("List of patients:\n" + "1. S7654321B\n" + "2. S1234567A\n", bos.toString());

        System.setOut(originalOut);
    }
}
