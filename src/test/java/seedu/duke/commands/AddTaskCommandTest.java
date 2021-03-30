package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.TestUtilAndConstants.EXPECTED_ADD_TASK;
import static seedu.duke.TestUtilAndConstants.FORMATTER;
import static seedu.duke.TestUtilAndConstants.INPUT_ADD_TASK_DESCRIPTION;
import static seedu.duke.TestUtilAndConstants.INPUT_ADD_TASK_REMARKS;
import static seedu.duke.TestUtilAndConstants.INPUT_INVALID_IS_GRADED;
import static seedu.duke.TestUtilAndConstants.initialiseModuleList;
import static seedu.duke.common.Constants.EMPTY_STRING;
import static seedu.duke.common.Constants.NO_STRING;
import static seedu.duke.common.Constants.YES_STRING;
import static seedu.duke.common.Messages.MESSAGE_DUPLICATE_TASK;
import static seedu.duke.common.Messages.MESSAGE_SAME_DESCRIPTION_TASK;
import static seedu.duke.common.Messages.MESSAGE_TASK_CHECK_GRADED;
import static seedu.duke.common.Messages.MESSAGE_TASK_CHECK_GRADED_INFO;
import static seedu.duke.common.Messages.NEWLINE;

public class AddTaskCommandTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private static final LocalDate FORMATTED_DEADLINE_1 = LocalDate.parse("3-3-2021", FORMATTER);
    private static final LocalDate FORMATTED_DEADLINE_2 = LocalDate.parse("5-3-2021", FORMATTER);

    //@@author aliciatay-zls
    @Test
    void execute_fullTaskInput_expectSuccess() {
        String isGradedInput = YES_STRING + NEWLINE;
        ByteArrayInputStream bis = new ByteArrayInputStream(isGradedInput.getBytes());
        System.setIn(bis);
        System.setOut(new PrintStream(bos));

        initialiseModuleList();

        Task task = new Task(INPUT_ADD_TASK_DESCRIPTION, FORMATTED_DEADLINE_1, INPUT_ADD_TASK_REMARKS);
        AddTaskCommand addTaskCommand = new AddTaskCommand(task);

        addTaskCommand.execute(new UI());
        
        String output = MESSAGE_TASK_CHECK_GRADED + NEWLINE
                + EXPECTED_ADD_TASK + NEWLINE;

        // checks displayed output to user
        assertEquals(output, bos.toString());

        // checks if new task was really added to task list
        assertTrue(ModuleList.getSelectedModule().getTaskList().contains(task));

        // checks if new task's graded status and 
        // done status (default false) were set correctly
        assertEquals(true, ModuleList.getSelectedModule().getTaskList().get(0).getGraded());
        assertEquals(false, ModuleList.getSelectedModule().getTaskList().get(0).getDone());

        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void execute_taskInputWithNoRemarks_expectSuccess() {
        String isGradedInput = YES_STRING + NEWLINE;
        ByteArrayInputStream bis = new ByteArrayInputStream(isGradedInput.getBytes());
        System.setIn(bis);
        System.setOut(new PrintStream(bos));

        initialiseModuleList();

        // remarks field is empty
        Task task = new Task(INPUT_ADD_TASK_DESCRIPTION, FORMATTED_DEADLINE_1, EMPTY_STRING);
        AddTaskCommand addTaskCommand = new AddTaskCommand(task);

        addTaskCommand.execute(new UI());

        String output = MESSAGE_TASK_CHECK_GRADED + NEWLINE
                + EXPECTED_ADD_TASK + NEWLINE;

        // checks displayed output to user
        assertEquals(output, bos.toString());

        // checks if new task was really added to task list
        assertTrue(ModuleList.getSelectedModule().getTaskList().contains(task));

        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void execute_taskInputAndInitiallyInvalidIsGradedInputs_expectSuccess() {
        String isGradedInput = EMPTY_STRING + NEWLINE
                + INPUT_INVALID_IS_GRADED + NEWLINE
                + NO_STRING + NEWLINE;
        ByteArrayInputStream bis = new ByteArrayInputStream(isGradedInput.getBytes());
        System.setIn(bis);
        System.setOut(new PrintStream(bos));

        initialiseModuleList();

        Task task = new Task(INPUT_ADD_TASK_DESCRIPTION, FORMATTED_DEADLINE_1, INPUT_ADD_TASK_REMARKS);
        AddTaskCommand addTaskCommand = new AddTaskCommand(task);

        addTaskCommand.execute(new UI());

        String output = MESSAGE_TASK_CHECK_GRADED + NEWLINE
                + MESSAGE_TASK_CHECK_GRADED_INFO + NEWLINE
                + MESSAGE_TASK_CHECK_GRADED_INFO + NEWLINE
                + EXPECTED_ADD_TASK + NEWLINE;

        // checks displayed output to user
        assertEquals(output, bos.toString());

        // checks if new task was really added to task list
        assertTrue(ModuleList.getSelectedModule().getTaskList().contains(task));

        // checks if new task's graded status was set correctly
        assertEquals(false, ModuleList.getSelectedModule().getTaskList().get(0).getGraded());

        System.setIn(originalIn);
        System.setOut(originalOut);
    }
    
    @Test
    void execute_duplicateAndSimilarTasks_expectIgnore() {
        String isGradedInput = YES_STRING + NEWLINE;
        ByteArrayInputStream bis = new ByteArrayInputStream(isGradedInput.getBytes());
        System.setIn(bis);
        System.setOut(new PrintStream(bos));

        initialiseModuleList();

        // New task
        Task duplicateTask = new Task(INPUT_ADD_TASK_DESCRIPTION, FORMATTED_DEADLINE_1, INPUT_ADD_TASK_REMARKS);
        AddTaskCommand addTaskCommand1 = new AddTaskCommand(duplicateTask);
        addTaskCommand1.execute(new UI());
        
        // Duplicate
        AddTaskCommand addTaskCommand2 = new AddTaskCommand(duplicateTask);
        addTaskCommand2.execute(new UI());

        // Similar
        Task similarTask = new Task(INPUT_ADD_TASK_DESCRIPTION, FORMATTED_DEADLINE_2, EMPTY_STRING);
        AddTaskCommand addTaskCommand3 = new AddTaskCommand(similarTask);
        addTaskCommand3.execute(new UI());

        String output = MESSAGE_TASK_CHECK_GRADED + NEWLINE
                + EXPECTED_ADD_TASK + NEWLINE
                + MESSAGE_DUPLICATE_TASK + NEWLINE
                + MESSAGE_SAME_DESCRIPTION_TASK + NEWLINE;
        
        // checks displayed output to user
        assertEquals(output, bos.toString());

        // checks if duplicate and similar tasks were really ignored
        int count = (int)ModuleList.getSelectedModule().getTaskList().stream()
                .filter((t) -> t.getDescription().equalsIgnoreCase(duplicateTask.getDescription()))
                .count();
        assertEquals(1, count);

        System.setIn(originalIn);
        System.setOut(originalOut);
    }
}
