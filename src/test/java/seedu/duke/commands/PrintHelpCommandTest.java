package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.CommandException;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PrintHelpCommandTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    void execute_noInput_expectAllCommandsWithDescription() throws CommandException {
        System.setOut(new PrintStream(outContent));

        ModuleList modules = new ModuleList();
        modules.addModule("CS2105");
        modules.addModule("CS2106");

        // no module selected
        ModuleList.selectedModule = null;

        // execute command
        Command command1 = new PrintHelpCommand();
        command1.execute(modules, new UI());

        String output = PrintHelpCommand.HELP_MESSAGE;
        assertEquals(output + System.lineSeparator(), outContent.toString());

        // module selected
        ModuleList.selectedModule = new Module("CS2105");
        Command command2 = new PrintHelpCommand();
        command2.execute(modules, new UI());

        System.setOut(originalOut);
    }

    @Test
    void isExit_noInput_expectFalse() {
        assertFalse(new PrintHelpCommand().isExit());
    }
}