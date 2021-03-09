package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.duke.commands.CommandTestUtil.NEWLINE;
import static seedu.duke.commands.CommandTestUtil.initialiseModule;
import static seedu.duke.commands.CommandTestUtil.initialiseTaskList;

class MarkAsUndoneCommandTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    private final ModuleList modules = new ModuleList();

    @Test
    void execute_unmarkTwo_unmarkedTwoSuccessfully() {
        String input = "1 3" + NEWLINE;
        ByteArrayInputStream bis = new ByteArrayInputStream(input.getBytes());
        System.setIn(bis);
        System.setOut(new PrintStream(bos));
        UI ui = new UI();

        Module module = initialiseModule(modules);

        ArrayList<Task> taskList = initialiseTaskList(module);

        MarkAsUndoneCommand markAsUndoneCommand = new MarkAsUndoneCommand();
        markAsUndoneCommand.execute(modules, ui);

        String output = "Which done tasks would you like to undo?" + NEWLINE
                + "1. iP increments" + NEWLINE
                + "2. tP milestone" + NEWLINE
                + "3. watch video snippets" + NEWLINE + NEWLINE
                + "Please enter the indices of the tasks you would like to mark as undone." + NEWLINE
                + "Separate indices with a blank space." + NEWLINE + NEWLINE
                + "Marked iP increments as undone." + NEWLINE
                + "Marked watch video snippets as undone." + NEWLINE;

        // checks displayed output to user
        assertEquals(output, bos.toString());

        String actualDone = "";
        for (Task task : taskList) {
            actualDone += task.getDone() + NEWLINE;
        }
        String expectedDone = "false" + NEWLINE
                + "false" + NEWLINE
                + "false" + NEWLINE
                + "false" + NEWLINE
                + "true" + NEWLINE
                + "false" + NEWLINE;

        // checks if tasks were correctly unmarked in task list
        assertEquals(expectedDone, actualDone);

        System.setIn(originalIn);
        System.setOut(originalOut);

        System.setIn(originalIn);
        System.setOut(originalOut);
    }
}
