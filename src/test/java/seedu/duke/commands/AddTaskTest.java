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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static seedu.duke.commands.CommandTestUtil.NEWLINE;
import static seedu.duke.commands.CommandTestUtil.formatter;
import static seedu.duke.commands.CommandTestUtil.initialiseModule;

class AddTaskTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    private final ModuleList modules = new ModuleList();

    @Test
    void execute_task_taskAddedSuccessfully() {
        String input = "Y" + NEWLINE;
        ByteArrayInputStream bis = new ByteArrayInputStream(input.getBytes());
        System.setIn(bis);
        System.setOut(new PrintStream(bos));
        UI ui = new UI();

        Module module = initialiseModule(modules);

        LocalDate deadline = LocalDate.parse("3-3-2021", formatter);
        Task task = new Task("iP submission", deadline, "remember to attach JAR file");
        AddTaskCommand addTask = new AddTaskCommand(task);

        addTask.execute(modules, ui);

        String output = "Is this task graded? (Y / N)" + NEWLINE
                + "Added iP submission.";

        // checks displayed output to user
        assertEquals(bos.toString(), output + NEWLINE);

        // checks if task was really added to task list
        assertTrue(module.getTaskList().contains(task));

        // checks if task's graded status was set correctly
        assertEquals(true, module.getTaskList().get(0).getGraded());

        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void execute_taskWithNoRemarks_taskAddedSuccessfully() {
        String input = "Y" + NEWLINE;
        ByteArrayInputStream bis = new ByteArrayInputStream(input.getBytes());
        System.setIn(bis);
        System.setOut(new PrintStream(bos));
        UI ui = new UI();

        Module module = initialiseModule(modules);

        LocalDate deadline = LocalDate.parse("3-3-2021", formatter);
        // remarks field is empty
        Task task = new Task("iP submission", deadline, "");
        AddTaskCommand addTask = new AddTaskCommand(task);

        addTask.execute(modules, ui);

        String output = "Is this task graded? (Y / N)" + NEWLINE
                + "Added iP submission.";

        // checks displayed output to user
        assertEquals(output + NEWLINE, bos.toString());

        // checks if task was really added to task list
        assertTrue(module.getTaskList().contains(task));

        // checks if task's graded status was set correctly
        assertEquals(true, module.getTaskList().get(0).getGraded());

        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void execute_taskWithSomeInvalidIsGradedInputs_taskAddedSuccessfully() {
        String input = "n" + NEWLINE
                + "nooooo" + NEWLINE
                + "N" + NEWLINE;
        ByteArrayInputStream bis = new ByteArrayInputStream(input.getBytes());
        System.setIn(bis);
        System.setOut(new PrintStream(bos));
        UI ui = new UI();

        Module module = initialiseModule(modules);

        LocalDate deadline = LocalDate.parse("3-3-2021", formatter);
        Task task = new Task("iP submission", deadline, "remember to attach JAR file");
        AddTaskCommand addTask = new AddTaskCommand(task);

        addTask.execute(modules, ui);

        String output = "Is this task graded? (Y / N)" + NEWLINE
                + "Please enter \"Y\" or \"N\"" + NEWLINE
                + "Please enter \"Y\" or \"N\"" + NEWLINE
                + "Added iP submission.";

        // checks displayed output to user
        assertEquals(output + NEWLINE, bos.toString());

        // checks if task was really added to task list
        assertTrue(module.getTaskList().contains(task));

        // checks if task's graded status was set correctly
        assertEquals(false, module.getTaskList().get(0).getGraded());

        System.setIn(originalIn);
        System.setOut(originalOut);
    }
}
