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
import static seedu.duke.TestUtilAndConstants.initialiseTaskList;
import static seedu.duke.TestUtilAndConstants.initialiseModuleList;
import static seedu.duke.common.Messages.COMMAND_VERB_DELETE;
import static seedu.duke.common.Messages.MESSAGE_TASKS_TO_DELETE;
import static seedu.duke.common.Messages.MESSAGE_TASK_LIST_EMPTY;
import static seedu.duke.common.Messages.MESSAGE_TASK_SELECT_INFO;
import static seedu.duke.common.Messages.NEWLINE;

class DeleteTaskCommandTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    //@@author aliciatay-zls
    @Test
    void execute_twoValidTaskIndices_expectSuccess() {
        String input = "1 5" + NEWLINE;
        ByteArrayInputStream bis = new ByteArrayInputStream(input.getBytes());
        System.setIn(bis);
        System.setOut(new PrintStream(bos));

        initialiseModuleList();
        
        ArrayList<Task> taskList = initialiseTaskList();

        DeleteTaskCommand deleteTaskCommand = new DeleteTaskCommand();
        deleteTaskCommand.execute(new UI());

        String output = MESSAGE_TASKS_TO_DELETE + NEWLINE
                + "1. weekly exercise" + NEWLINE
                + "2. watch video snippets" + NEWLINE
                + "3. lecture quiz" + NEWLINE
                + "4. read up notes" + NEWLINE
                + "5. iP submission" + NEWLINE
                + String.format(MESSAGE_TASK_SELECT_INFO, COMMAND_VERB_DELETE) + NEWLINE
                + "Removed weekly exercise from the task list." + NEWLINE
                + "Removed iP submission from the task list." + NEWLINE;

        // checks displayed output to user
        assertEquals(output, bos.toString());

        String expectedRemaining = "watch video snippets" + NEWLINE
                + "lecture quiz" + NEWLINE
                + "read up notes" + NEWLINE;

        StringBuilder actualRemaining = new StringBuilder();
        for (Task task : taskList) {
            actualRemaining.append(task.getDescription()).append(NEWLINE);
        }
        
        //checks if tasks were really deleted from task list
        assertEquals(expectedRemaining, actualRemaining.toString());

        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void execute_noInputButEmptyTaskList_expectIgnore() {
        System.setOut(new PrintStream(bos));

        initialiseModuleList();

        DeleteTaskCommand deleteTaskCommand = new DeleteTaskCommand();
        deleteTaskCommand.execute(new UI());

        String output = String.format(MESSAGE_TASK_LIST_EMPTY, COMMAND_VERB_DELETE) + NEWLINE;

        // checks displayed output to user
        assertEquals(output, bos.toString());
        
        System.setOut(originalOut);
    }
}
