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
import static seedu.duke.common.Messages.COMMAND_VERB_MARK;
import static seedu.duke.common.Messages.MESSAGE_TASKS_TO_MARK;
import static seedu.duke.common.Messages.MESSAGE_TASK_SELECT_INFO;
import static seedu.duke.common.Messages.NEWLINE;

class MarkAsDoneCommandTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    //@@author aliciatay-zls
    @Test
    void execute_twoValidTaskIndices_expectSuccess() {
        String input = "1 2" + NEWLINE;
        ByteArrayInputStream bis = new ByteArrayInputStream(input.getBytes());
        System.setIn(bis);
        System.setOut(new PrintStream(bos));

        initialiseModuleList();

        ArrayList<Task> taskList = initialiseTaskList();

        MarkAsDoneCommand markAsDoneCommand = new MarkAsDoneCommand();
        markAsDoneCommand.execute(new UI());
        
        String output = MESSAGE_TASKS_TO_MARK + NEWLINE
                + "1. weekly exercise" + NEWLINE
                + "2. lecture quiz" + NEWLINE
                + "3. read up notes" + NEWLINE
                + String.format(MESSAGE_TASK_SELECT_INFO, COMMAND_VERB_MARK) + NEWLINE
                + "Marked weekly exercise as done." + NEWLINE
                + "Marked lecture quiz as done." + NEWLINE;

        // checks displayed output to user
        assertEquals(output, bos.toString());

        String expectedDone = "true" + NEWLINE
                + "true" + NEWLINE
                + "true" + NEWLINE
                + "false" + NEWLINE
                + "true" + NEWLINE;

        StringBuilder actualDone = new StringBuilder();
        for (Task task : taskList) {
            actualDone.append(task.getDone()).append(NEWLINE);
        }
        
        // checks if tasks were correctly marked in task list
        assertEquals(expectedDone, actualDone.toString());

        System.setIn(originalIn);
        System.setOut(originalOut);
    }
}
