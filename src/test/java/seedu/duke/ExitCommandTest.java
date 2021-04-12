package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.command.ExitCommand;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExitCommandTest {
    @Test
    public void executeExitCommand_extraArguments_exitSuccess() {
        Ui ui = new Ui();
        Data data = new Data();
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("command", "exit");
        arguments.put("payload", "now");
        ExitCommand exitCommand = new ExitCommand(ui, data, arguments);

        final PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        assertDoesNotThrow(() -> {
            exitCommand.execute();
        });

        assertEquals(Constants.EXIT_MESSAGE + System.lineSeparator(), bos.toString());

        System.setOut(originalOut);
    }
}
