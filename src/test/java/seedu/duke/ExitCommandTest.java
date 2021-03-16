package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.command.ExitCommand;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

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

        try {
            exitCommand.execute();
        } catch (Exception e) {
            System.out.println("An error occurred while running tests");
        }

        assertEquals("Goodbye, we hope to see you again!" + System.lineSeparator(), bos.toString());

        System.setOut(originalOut);
    }
}
