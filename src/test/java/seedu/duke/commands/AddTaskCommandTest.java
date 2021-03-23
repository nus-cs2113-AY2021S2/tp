package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.TestUtilAndConstants;
import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.TestUtilAndConstants.EXPECTED_ADD_TASK;
import static seedu.duke.TestUtilAndConstants.FORMATTER;
import static seedu.duke.TestUtilAndConstants.MODULE_CODE_1;
import static seedu.duke.TestUtilAndConstants.initialiseTaskList;
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

    //@@author aliciatay-zls
    @Test
    void execute_fullTaskInput_expectSuccess() {
        String isGradedInput = YES_STRING + NEWLINE;
        ByteArrayInputStream bis = new ByteArrayInputStream(isGradedInput.getBytes());
        System.setIn(bis);
        System.setOut(new PrintStream(bos));

        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleNames();
        ModuleList.addModule(MODULE_CODE_1);
        ModuleList.setSelectedModule(MODULE_CODE_1);

        LocalDate deadline = LocalDate.parse("3-3-2021", FORMATTER);
        Task task = new Task("iP submission", deadline, "remember to attach JAR file");
        AddTaskCommand addTaskCommand = new AddTaskCommand(task);

        addTaskCommand.execute(new UI());


        String output = MESSAGE_TASK_CHECK_GRADED + NEWLINE
                + EXPECTED_ADD_TASK;

        // checks displayed output to user
        assertEquals(bos.toString(), output + NEWLINE);

        // checks if new task was really added to task list
        assertTrue(ModuleList.getSelectedModule().getTaskList().contains(task));

        // checks if new task's graded status was set correctly
        assertEquals(true, ModuleList.getSelectedModule().getTaskList().get(0).getGraded());

        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void execute_taskInputWithNoRemarks_expectSuccess() {
        String isGradedInput = YES_STRING + NEWLINE;
        ByteArrayInputStream bis = new ByteArrayInputStream(isGradedInput.getBytes());
        System.setIn(bis);
        System.setOut(new PrintStream(bos));

        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleNames();
        ModuleList.addModule(MODULE_CODE_1);
        ModuleList.setSelectedModule(MODULE_CODE_1);

        LocalDate deadline = LocalDate.parse("3-3-2021", FORMATTER);
        // remarks field is empty
        Task task = new Task("iP submission", deadline, "");
        AddTaskCommand addTaskCommand = new AddTaskCommand(task);

        addTaskCommand.execute(new UI());

        String output = MESSAGE_TASK_CHECK_GRADED + NEWLINE
                + EXPECTED_ADD_TASK;

        // checks displayed output to user
        assertEquals(output + NEWLINE, bos.toString());

        // checks if new task was really added to task list
        assertTrue(ModuleList.getSelectedModule().getTaskList().contains(task));

        // checks if new task's graded status was set correctly
        assertEquals(true, ModuleList.getSelectedModule().getTaskList().get(0).getGraded());

        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void execute_taskInputAndInitiallyInvalidIsGradedInputs_expectSuccess() {
        String isGradedInput = " " + NEWLINE
                + "no" + NEWLINE
                + NO_STRING + NEWLINE;
        ByteArrayInputStream bis = new ByteArrayInputStream(isGradedInput.getBytes());
        System.setIn(bis);
        System.setOut(new PrintStream(bos));

        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleNames();
        ModuleList.addModule(MODULE_CODE_1);
        ModuleList.setSelectedModule(MODULE_CODE_1);

        LocalDate deadline = LocalDate.parse("3-3-2021", FORMATTER);
        Task task = new Task("iP submission", deadline, "remember to attach JAR file");
        AddTaskCommand addTaskCommand = new AddTaskCommand(task);

        addTaskCommand.execute(new UI());

        String output = MESSAGE_TASK_CHECK_GRADED + NEWLINE
                + MESSAGE_TASK_CHECK_GRADED_INFO + NEWLINE
                + MESSAGE_TASK_CHECK_GRADED_INFO + NEWLINE
                + EXPECTED_ADD_TASK;

        // checks displayed output to user
        assertEquals(output + NEWLINE, bos.toString());

        // checks if new task was really added to task list
        assertTrue(ModuleList.getSelectedModule().getTaskList().contains(task));

        // checks if new task's graded status was set correctly
        assertEquals(false, ModuleList.getSelectedModule().getTaskList().get(0).getGraded());

        System.setIn(originalIn);
        System.setOut(originalOut);
    }
    
    @Test
    void execute_duplicateAndSimilarTasks_expectFail() {
        System.setOut(new PrintStream(bos));

        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleNames();
        ModuleList.addModule(MODULE_CODE_1);
        ModuleList.setSelectedModule(MODULE_CODE_1);
        
        initialiseTaskList(ModuleList.getSelectedModule());

        LocalDate sameDeadline = LocalDate.parse("3-3-2021", FORMATTER);
        Task duplicateTask = new Task("tP milestone", sameDeadline, "");
        AddTaskCommand addTaskCommand1 = new AddTaskCommand(duplicateTask);
        addTaskCommand1.execute(new UI());

        LocalDate differentDeadline = LocalDate.parse("20-4-2021", FORMATTER);
        Task similarTask = new Task("tP milestone", differentDeadline, "");
        AddTaskCommand addTaskCommand2 = new AddTaskCommand(similarTask);
        addTaskCommand2.execute(new UI());

        String output = MESSAGE_DUPLICATE_TASK + NEWLINE
                + MESSAGE_SAME_DESCRIPTION_TASK;
        
        // checks displayed output to user
        assertEquals(output + NEWLINE, bos.toString());

        // checks if duplicate and similar tasks were really ignored
        assertFalse(ModuleList.getSelectedModule().getTaskList().contains(duplicateTask));
        assertFalse(ModuleList.getSelectedModule().getTaskList().contains(similarTask));

        System.setOut(originalOut);
    }
}
