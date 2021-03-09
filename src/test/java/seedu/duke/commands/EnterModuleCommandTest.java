package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.CommandException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EnterModuleCommandTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    void execute_validModuleCodeInput_expectSuccess() throws CommandException {
        System.setOut(new PrintStream(outContent));

        ModuleList modules = new ModuleList(new ArrayList<>(Arrays.asList("CS2113T", "CS2102", "CS2105", "CS2106")));

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

        ModuleList modules = new ModuleList(new ArrayList<>(Arrays.asList("CS2113T", "CS2102", "CS2105", "CS2106")));

        Command command = new EnterModuleCommand("CS3235");

        assertThrows(CommandException.class, () -> command.execute(modules, new UI()));

        System.setOut(originalOut);
    }

    @Test
    void isExit_singleInput_expectFalse() {
        assertFalse(new EnterModuleCommand("CS2106").isExit());
    }
}