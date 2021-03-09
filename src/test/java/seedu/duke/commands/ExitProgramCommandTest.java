package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.CommandException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ExitProgramCommandTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    void execute_noInput_expectMessageExit() throws CommandException {
        System.setOut(new PrintStream(outContent));

        ModuleList modules = new ModuleList();
        modules.addModule("CS2105");
        modules.addModule("CS2106");

        Command command = new ExitProgramCommand();
        command.execute(modules, new UI());

        String output = Messages.MESSAGE_EXIT;
        assertEquals(output + System.lineSeparator(), outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    void isExit_noInput_expectReturnsTrue() {
        assertTrue(new ExitProgramCommand().isExit());
    }
}