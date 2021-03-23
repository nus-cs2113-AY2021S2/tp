package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.duke.TestUtilAndConstants.initialiseModuleList;
import static seedu.duke.TestUtilAndConstants.initialiseTaskList;
import static seedu.duke.common.Messages.COMMAND_VERB_UNMARK;
import static seedu.duke.common.Messages.MESSAGE_TASKS_TO_UNMARK;
import static seedu.duke.common.Messages.MESSAGE_TASK_SELECT_INFO;
import static seedu.duke.common.Messages.NEWLINE;

class MarkAsUndoneCommandTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    //@@author aliciatay-zls
    @Test
    void execute_twoValidTaskIndices_expectSuccess() {
        String input = "1" + NEWLINE;
        ByteArrayInputStream bis = new ByteArrayInputStream(input.getBytes());
        System.setIn(bis);
        System.setOut(new PrintStream(bos));

        initialiseModuleList();

        ArrayList<Task> taskList = initialiseTaskList();

        MarkAsUndoneCommand markAsUndoneCommand = new MarkAsUndoneCommand();
        markAsUndoneCommand.execute(new UI());

        String output = MESSAGE_TASKS_TO_UNMARK + NEWLINE
                + "1. watch video snippets" + NEWLINE
                + "2. iP submission" + NEWLINE
                + String.format(MESSAGE_TASK_SELECT_INFO, COMMAND_VERB_UNMARK) + NEWLINE
                + "Marked watch video snippets as undone." + NEWLINE;

        // checks displayed output to user
        assertEquals(output, bos.toString());

        StringBuilder actualDone = new StringBuilder();
        for (Task task : taskList) {
            actualDone.append(task.getDone()).append(NEWLINE);
        }
        String expectedDone = "false" + NEWLINE
                + "false" + NEWLINE
                + "false" + NEWLINE
                + "false" + NEWLINE
                + "true" + NEWLINE;

        // checks if tasks were correctly unmarked in task list
        assertEquals(expectedDone, actualDone.toString());

        System.setIn(originalIn);
        System.setOut(originalOut);
    }
}
