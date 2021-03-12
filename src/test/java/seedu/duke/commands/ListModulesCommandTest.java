package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.TestUtilAndConstants;
import seedu.duke.common.Messages;
import seedu.duke.exception.CommandException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.duke.TestUtilAndConstants.MODULE_CODE_1;
import static seedu.duke.TestUtilAndConstants.MODULE_CODE_2;
import static seedu.duke.TestUtilAndConstants.MODULE_CODE_3;
import static seedu.duke.common.Messages.MESSAGE_MODULE_TO_LIST;
import static seedu.duke.common.Messages.NEWLINE;

class ListModulesCommandTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    void execute_noInput_expectListAllModulesAdded() throws CommandException {
        System.setOut(new PrintStream(outContent));

        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleNames();
        ModuleList.addModule(MODULE_CODE_1);
        ModuleList.addModule(MODULE_CODE_3);
        ModuleList.addModule(MODULE_CODE_2);

        Command command = new ListModulesCommand();
        command.execute(new UI());

        StringBuilder sb = new StringBuilder();
        sb.append(MESSAGE_MODULE_TO_LIST);
        sb.append(String.format(Messages.FORMAT_LIST_ITEMS, 1, MODULE_CODE_1)).append(NEWLINE);
        sb.append(String.format(Messages.FORMAT_LIST_ITEMS, 2, MODULE_CODE_3)).append(NEWLINE);
        sb.append(String.format(Messages.FORMAT_LIST_ITEMS, 3, MODULE_CODE_2)).append(NEWLINE);

        assertEquals(sb.toString() + System.lineSeparator(), outContent.toString());

        System.setOut(originalOut);
    }
}