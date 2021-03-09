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

class AddModuleCommandTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    void execute_uniqueModuleCode_expectPrintSuccess() throws CommandException {
        System.setOut(new PrintStream(outContent));

        ModuleList modules = new ModuleList(new ArrayList<>(Arrays.asList("CS2105", "CS2106")));

        String moduleCode = "CS2113T";
        Command command = new AddModuleCommand(moduleCode);
        command.execute(modules, new UI());

        String output = String.format(AddModuleCommand.MESSAGE_SUCCESS, moduleCode);
        assertEquals(output + System.lineSeparator(), outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    void execute_duplicateModuleCode_expectDuplicateModuleException() {
        ModuleList modules = new ModuleList(new ArrayList<>(Arrays.asList("CS2113T")));

        Command command = new AddModuleCommand("CS2113T");
        assertThrows(CommandException.class, () -> command.execute(modules, new UI()));

    }

    @Test
    void isExit_singleInput_expectReturnFalse() {
        assertFalse(new AddModuleCommand("CS2113T").isExit());
    }
}