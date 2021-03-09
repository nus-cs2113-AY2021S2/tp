package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.common.Messages;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ExitProgramCommandTest {

    @Test
    void execute_noInput_expectMessageExit() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
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
    void isExit() {
        assertEquals(true, new ExitProgramCommand().isExit());
    }
}