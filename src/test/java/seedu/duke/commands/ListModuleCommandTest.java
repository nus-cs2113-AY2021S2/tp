package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.CommandException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ListModuleCommandTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    void execute_noInput_expectListAllModulesAdded() throws CommandException {
        System.setOut(new PrintStream(outContent));

        ModuleList modules = new ModuleList(
                new ArrayList<>(Arrays.asList("CS2113T", "CS2105", "CS2106"))
        );

        Command command = new ListModuleCommand();
        command.execute(modules, new UI());

        StringBuilder sb = new StringBuilder();
        sb.append(ListModuleCommand.MESSAGE_INFO);
        sb.append(String.format(Messages.FORMAT_LIST_ITEMS, 1, "CS2113T") + "\n");
        sb.append(String.format(Messages.FORMAT_LIST_ITEMS, 2, "CS2105") + "\n");
        sb.append(String.format(Messages.FORMAT_LIST_ITEMS, 3, "CS2106") + "\n");
        String output = sb.toString();

        assertEquals(output + System.lineSeparator(), outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    void isExit_noInput_expectFalse() {
        assertFalse(new ListModuleCommand().isExit());
    }
}