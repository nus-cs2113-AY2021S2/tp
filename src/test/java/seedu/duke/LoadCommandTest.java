package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;

import seedu.duke.command.LoadCommand;
import seedu.duke.exception.DataException;
import seedu.duke.model.Patient;

public class LoadCommandTest {
    @Test
    public void executeLoadCommand() {
        Data data = new Data();
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "load");
        arguments.put("payload", "S7654321F");

        data.setPatient(new Patient("S1234567D"));
        data.setPatient(new Patient("S7654321F"));
        LoadCommand loadCommand = new LoadCommand(new Ui(), data, arguments);
        assertDoesNotThrow(() -> {
            loadCommand.execute();
        });
    }

    @Test
    public void executeLoadCommand_unknownParient_exceptionThrown() {
        Data data = new Data();
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "load");
        arguments.put("payload", "S7654321F");

        data.setPatient(new Patient("S1234567D"));

        LoadCommand loadCommand = new LoadCommand(new Ui(), data, arguments);
        DataException dataException = assertThrows(DataException.class, () -> {
            loadCommand.execute();
        });

        assertEquals(Constants.DATA_PATIENT_NOT_FOUND, dataException.getMessage());
    }
}
