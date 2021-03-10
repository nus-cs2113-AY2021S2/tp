package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.CommandException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EnterModuleCommandTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    void execute_validModuleCodeInput_expectSuccess() throws CommandException {
        System.setOut(new PrintStream(outContent));

        ModuleList modules = new ModuleList();
        modules.addModule("CS2113T");
        modules.addModule("CS2102");
        modules.addModule("CS2106");
        modules.addModule("CS2105");

        Command command = new EnterModuleCommand("CS2106");
        command.execute(modules, new UI());

        String output = String.format(EnterModuleCommand.MESSAGE_INFO, "CS2106") + System.lineSeparator();
        output += EnterModuleCommand.MESSAGE_OVERVIEW;
        assertEquals(output + System.lineSeparator(), outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    void execute_invalidModuleCodeInput_expectException() {
        System.setOut(new PrintStream(outContent));

        ModuleList modules = new ModuleList();
        modules.addModule("CS2113T");
        modules.addModule("CS2102");
        modules.addModule("CS2106");
        modules.addModule("CS2105");

        Command command = new EnterModuleCommand("CS3235");

        assertThrows(CommandException.class, () -> command.execute(modules, new UI()));

        System.setOut(originalOut);
    }
}