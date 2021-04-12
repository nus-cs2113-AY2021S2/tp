package seedu.duke;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.features.task.tasktypes.Assignment;
import seedu.duke.features.task.tasktypes.FinalExam;
import seedu.duke.features.task.tasktypes.Midterm;
import seedu.duke.features.task.tasktypes.Task;
import seedu.duke.features.task.TaskManager;
import seedu.duke.features.task.command.AddTask;
import seedu.duke.features.task.command.DeleteTask;
import seedu.duke.features.task.command.PinTask;

import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaskListTest {

    private TaskManager taskManager;

    @BeforeEach
    public void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    public void task_validData_correctlyConstructed() {
        String module = "CS2113T";
        String description = "week 10 topics";
        String message = "yay!";

        Task task = new Task(module, description, message);

        assertEquals(module, task.getModule());
        assertEquals(description, task.getDescription());
        assertEquals(message, task.getMessage());

        String notDone = "[    ] ";
        String done = "[DONE] ";

        assertEquals(notDone, task.getStatus());
        task.markAsDone();
        assertEquals(done, task.getStatus());
        task.markAsUnDone();
        assertEquals(notDone, task.getStatus());
    }

    @Test
    public void assignment_validData_correctlyConstructed() {
        String module = "CS2113T";
        String description = "tp v2";
        String message = "yay!";
        String dateAndTime = "Mar 30 2021, 11:59 PM";

        Assignment assignment = new Assignment(module, description, message, dateAndTime);

        assertEquals(module, assignment.getModule());
        assertEquals(description, assignment.getDescription());
        assertEquals(message, assignment.getMessage());
        assertEquals(dateAndTime, assignment.getBy());

        String notDone = "[    ] ";
        assertEquals(notDone, assignment.getStatus());
    }

    @Test
    public void midterm_validData_correctlyConstructed() {
        String module = "CS2113T";
        String description = "tp v2";
        String message = "yay!";
        String dateAndTime = "Mar 30 2021, 11:59 PM";

        Midterm midterm = new Midterm(module, description, message, dateAndTime);

        assertEquals(module, midterm.getModule());
        assertEquals(description, midterm.getDescription());
        assertEquals(message, midterm.getMessage());
        assertEquals(dateAndTime, midterm.getOn());

        String notDone = "[    ] ";
        assertEquals(notDone, midterm.getStatus());
    }

    @Test
    public void finalExam_validData_correctlyConstructed() {
        String module = "CS2113T";
        String description = "tp v2";
        String dateAndTime = "Mar 30 2021, 11:59 PM";
        String message = "yay!";

        FinalExam finalExam = new FinalExam(module, description, message, dateAndTime);

        assertEquals(module, finalExam.getModule());
        assertEquals(description, finalExam.getDescription());
        assertEquals(message, finalExam.getMessage());
        assertEquals(dateAndTime, finalExam.getOn());

        String notDone = "[    ] ";
        assertEquals(notDone, finalExam.getStatus());
    }

    @Test
    public void addTask_validTask_success() {
        String module = "CS2113T";
        String description = "week 10 topics";
        String message = "yay!";

        assertTrue(TaskManager.tasks.isEmpty());
        AddTask.addTask(module, description, message);
        assertEquals(module, TaskManager.tasks.get(0).getModule());
        assertFalse(TaskManager.tasks.isEmpty());
    }

    @Test
    public void addAssignment_validAssignment_success() {
        String module = "CS2113T";
        String description = "week 10 topics";
        String dateAndTime = "Mar 30 2021, 11:59 PM";
        String message = "yay!";

        assertTrue(TaskManager.assignments.isEmpty());
        AddTask.addAssignment(module, description, message, dateAndTime);
        assertEquals(module, TaskManager.assignments.get(0).getModule());
        assertFalse(TaskManager.assignments.isEmpty());
    }

    @Test
    public void addMidterm_validMidterm_success() {
        String module = "CS2113T";
        String description = "week 10 topics";
        String dateAndTime = "Mar 30 2021, 11:59 PM";
        String message = "yay!";

        assertTrue(TaskManager.midterms.isEmpty());
        AddTask.addMidterm(module, description, message, dateAndTime);
        assertEquals(module, TaskManager.midterms.get(0).getModule());
        assertFalse(TaskManager.midterms.isEmpty());
    }

    @Test
    public void addFinalExam_validFinalExam_success() {
        String module = "CS2113T";
        String description = "week 10 topics";
        String dateAndTime = "Mar 30 2021, 11:59 PM";
        String message = "yay!";

        assertTrue(TaskManager.finalExams.isEmpty());
        AddTask.addFinalExam(module, description, message, dateAndTime);
        assertEquals(module, TaskManager.finalExams.get(0).getModule());
        assertFalse(TaskManager.finalExams.isEmpty());
    }

    @Test
    public void isValidTaskType_validTasktype_success() {
        int validTaskType = 1;
        assertTrue(TaskManager.isValidTaskType(validTaskType));
    }

    @Test
    public void isValidTaskType_invalidTasktype_printErrorMessage() {
        int invalidTaskType = 5;
        assertFalse(TaskManager.isValidTaskType(invalidTaskType));
    }

    @Test
    public void validTime_validTimeFormat_success() {
        String inputTime = "14:00";
        assertEquals("02:00 PM", AddTask.validTime(inputTime));
    }

    @Test
    public void validTime_invalidTimeFormat_DateTimeParseException() {
        String inputTime = "2.00 pm";
        assertThrows(DateTimeParseException.class, () -> {
            AddTask.validTime(inputTime);
        });
    }

    @Test
    public void validDate_validDateFormat_success() {
        String inputTime = "2021-03-23";
        assertEquals("Mar 23 2021", AddTask.validDate(inputTime));
    }

    @Test
    public void validDate_invalidDateFormat_DateTimeParseException() {
        String inputDate = "23 march 2021";
        assertThrows(DateTimeParseException.class, () -> {
            AddTask.validDate(inputDate);
        });
    }

    @Test
    public void findAndDeleteTask_validTaskNumber_success() {
        String module = "CS2113T";
        String description = "week 10 topics";
        String message = "yay!";

        AddTask.addTask(module, description, message);
        assertFalse(TaskManager.tasks.isEmpty());
        DeleteTask.findAndDeleteTask(1, "[Task]");
        assertTrue(TaskManager.tasks.isEmpty());
    }

    @Test
    public void findAndDeleteAssignment_validTaskNumber_success() {
        String module = "CS2113T";
        String description = "week 10 topics";
        String dateAndTime = "Mar 30 2021, 11:59 PM";
        String message = "yay!";

        AddTask.addAssignment(module, description, message, dateAndTime);
        assertFalse(TaskManager.assignments.isEmpty());
        DeleteTask.findAndDeleteTask(1, "[Assignment]");
        assertTrue(TaskManager.assignments.isEmpty());
    }

    @Test
    public void findAndDeleteMidterm_validTaskNumber_success() {
        String module = "CS2113T";
        String description = "week 10 topics";
        String dateAndTime = "Mar 30 2021, 11:59 PM";
        String message = "yay!";

        AddTask.addMidterm(module, description, message, dateAndTime);
        assertFalse(TaskManager.midterms.isEmpty());
        DeleteTask.findAndDeleteTask(1, "[Midterm]");
        assertTrue(TaskManager.midterms.isEmpty());
    }

    @Test
    public void findAndDeleteFinalExam_validTaskNumber_success() {
        String module = "CS2113T";
        String description = "week 10 topics";
        String dateAndTime = "Mar 30 2021, 11:59 PM";
        String message = "yay!";

        AddTask.addFinalExam(module, description, message, dateAndTime);
        assertFalse(TaskManager.finalExams.isEmpty());
        DeleteTask.findAndDeleteTask(1, "[Final Exam]");
        assertTrue(TaskManager.finalExams.isEmpty());
    }

    @Test
    public void addTaskToPinnedTasks_validTask_success() {
        String module = "CS2113T";
        String description = "week 10 topics";
        String message = "yay!";
        String taskTypeName = "[Task]";

        assertTrue(TaskManager.pinnedTasks.isEmpty());
        Task task = new Task(module, description, message);
        PinTask.addTaskToPinnedTasks(task, taskTypeName);
        assertFalse(TaskManager.pinnedTasks.isEmpty());
    }

}