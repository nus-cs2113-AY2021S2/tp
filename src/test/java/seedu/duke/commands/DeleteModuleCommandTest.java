package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.CommandException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DeleteModuleCommandTest {

    @Test
    void execute_validModuleNumbersInput_expectSuccess() throws CommandException {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayInputStream inContent = new ByteArrayInputStream("1 3".getBytes());
        System.setOut(new PrintStream(outContent));
        System.setIn(inContent);

        ModuleList modules = new ModuleList(
                new ArrayList<>(Arrays.asList("CS2113T", "CS2101", "CS2105", "CS2106"))
                );

        Command command = new DeleteModuleCommand();
        command.execute(modules, new UI());

        StringBuilder sb = new StringBuilder();
        sb.append(DeleteModuleCommand.MESSAGE_PROMPT1);
        sb.append(String.format(Messages.FORMAT_LIST_ITEMS, 1, "CS2113T") + "\n");
        sb.append(String.format(Messages.FORMAT_LIST_ITEMS, 2, "CS2101") + "\n");
        sb.append(String.format(Messages.FORMAT_LIST_ITEMS, 3, "CS2105") + "\n");
        sb.append(String.format(Messages.FORMAT_LIST_ITEMS, 4, "CS2106") + "\n");
        sb.append("\n");
        sb.append(DeleteModuleCommand.MESSAGE_PROMPT2);
        sb.append(System.lineSeparator());
        sb.append(String.format(DeleteModuleCommand.MESSAGE_SUCCESS, "CS2113T") + "\n");
        sb.append(String.format(DeleteModuleCommand.MESSAGE_SUCCESS, "CS2105") + "\n");

        String output = sb.toString();

        assertEquals(output + System.lineSeparator(), outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    void isExit_emptyInput_expectFalse() {
        assertFalse(new DeleteModuleCommand().isExit());
    }
}