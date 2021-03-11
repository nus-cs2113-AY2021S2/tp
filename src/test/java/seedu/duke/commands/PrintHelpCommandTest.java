package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.TestUtilAndConstants;
import seedu.duke.exception.CommandException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.duke.TestUtilAndConstants.MODULE_CODE_2;
import static seedu.duke.TestUtilAndConstants.MODULE_CODE_3;

class PrintHelpCommandTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    void execute_noInput_expectAllCommandsWithDescription() throws CommandException {
        System.setOut(new PrintStream(outContent));

        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleNames();
        ModuleList.addModule(MODULE_CODE_3);
        ModuleList.addModule(MODULE_CODE_2);

        // no module selected
        ModuleList.reset();

        // execute command
        Command command1 = new PrintHelpCommand();
        command1.execute(new UI());

        String output = PrintHelpCommand.HELP_MESSAGE;
        assertEquals(output + System.lineSeparator(), outContent.toString());

        // module selected
        ModuleList.setSelectedModule(MODULE_CODE_3);
        Command command2 = new PrintHelpCommand();
        command2.execute(new UI());

        System.setOut(originalOut);
    }
}