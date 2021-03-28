package seedu.duke;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.task.Assignment;
import seedu.duke.task.FinalExam;
import seedu.duke.task.Midterm;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;

import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaskListTest {

    private TaskList taskList;

    @BeforeEach
    public void setUp() {
        taskList = new TaskList();
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

        assertTrue(TaskList.tasks.isEmpty());
        TaskList.addTask(module, description, message);
        assertEquals(module, TaskList.tasks.get(0).getModule());
        assertFalse(TaskList.tasks.isEmpty());
    }

    @Test
    public void addAssignment_validAssignment_success() {
        String module = "CS2113T";
        String description = "week 10 topics";
        String dateAndTime = "Mar 30 2021, 11:59 PM";
        String message = "yay!";

        assertTrue(TaskList.assignments.isEmpty());
        TaskList.addAssignment(module, description, message, dateAndTime);
        assertEquals(module, TaskList.assignments.get(0).getModule());
        assertFalse(TaskList.assignments.isEmpty());
    }

    @Test
    public void addMidterm_validMidterm_success() {
        String module = "CS2113T";
        String description = "week 10 topics";
        String dateAndTime = "Mar 30 2021, 11:59 PM";
        String message = "yay!";

        assertTrue(TaskList.midterms.isEmpty());
        TaskList.addMidterm(module, description, message, dateAndTime);
        assertEquals(module, TaskList.midterms.get(0).getModule());
        assertFalse(TaskList.midterms.isEmpty());
    }

    @Test
    public void addFinalExam_validFinalExam_success() {
        String module = "CS2113T";
        String description = "week 10 topics";
        String dateAndTime = "Mar 30 2021, 11:59 PM";
        String message = "yay!";

        assertTrue(TaskList.finalExams.isEmpty());
        TaskList.addFinalExam(module, description, message, dateAndTime);
        assertEquals(module, TaskList.finalExams.get(0).getModule());
        assertFalse(TaskList.finalExams.isEmpty());
    }

    @Test
    public void isValidTaskType_validTasktype_success() {
        String invalidTaskType = "1";
        assertTrue(TaskList.isValidTaskType(invalidTaskType));
    }

    @Test
    public void isValidTaskType_invalidTasktype_printErrorMessage() {
        String invalidTaskType = "5";
        assertFalse(TaskList.isValidTaskType(invalidTaskType));
    }

    @Test
    public void validTime_validTimeFormat_success() {
        String inputTime = "14:00";
        assertEquals("02:00 PM", TaskList.validTime(inputTime));
    }

    @Test
    public void validTime_invalidTimeFormat_DateTimeParseException() {
        String inputTime = "2.00 pm";
        assertThrows(DateTimeParseException.class, () -> {
            TaskList.validTime(inputTime);
        });
    }

    @Test
    public void validDate_validDateFormat_success() {
        String inputTime = "2021-03-23";
        assertEquals("Mar 23 2021", TaskList.validDate(inputTime));
    }

    @Test
    public void validDate_invalidDateFormat_DateTimeParseException() {
        String inputDate = "23 march 2021";
        assertThrows(DateTimeParseException.class, () -> {
            TaskList.validDate(inputDate);
        });
    }

    @Test
    public void findAndDeleteTask_validTaskNumber_success() {
        String module = "CS2113T";
        String description = "week 10 topics";
        String message = "yay!";

        TaskList.addTask(module, description, message);
        assertFalse(TaskList.tasks.isEmpty());
        TaskList.findAndDeleteTask(1);
        assertTrue(TaskList.tasks.isEmpty());
    }

    @Test
    public void findAndDeleteAssignment_validTaskNumber_success() {
        String module = "CS2113T";
        String description = "week 10 topics";
        String dateAndTime = "Mar 30 2021, 11:59 PM";
        String message = "yay!";

        TaskList.addAssignment(module, description, message, dateAndTime);
        assertFalse(TaskList.assignments.isEmpty());
        TaskList.findAndDeleteAssigment(1);
        assertTrue(TaskList.assignments.isEmpty());
    }

    @Test
    public void findAndDeleteMidterm_validTaskNumber_success() {
        String module = "CS2113T";
        String description = "week 10 topics";
        String dateAndTime = "Mar 30 2021, 11:59 PM";
        String message = "yay!";

        TaskList.addMidterm(module, description, message, dateAndTime);
        assertFalse(TaskList.midterms.isEmpty());
        TaskList.findAndDeleteMidterm(1);
        assertTrue(TaskList.midterms.isEmpty());
    }

    @Test
    public void findAndDeleteFinalExam_validTaskNumber_success() {
        String module = "CS2113T";
        String description = "week 10 topics";
        String dateAndTime = "Mar 30 2021, 11:59 PM";
        String message = "yay!";

        TaskList.addFinalExam(module, description, message, dateAndTime);
        assertFalse(TaskList.finalExams.isEmpty());
        TaskList.findAndDeleteFinalExam(1);
        assertTrue(TaskList.finalExams.isEmpty());
    }

    @Test
    public void addTaskToPinnedTasks_validTask_success() {
        String module = "CS2113T";
        String description = "week 10 topics";
        String message = "yay!";
        String taskTypeName = "[Task]";

        assertTrue(TaskList.pinnedTasks.isEmpty());
        Task task = new Task(module, description, message);
        TaskList.addTaskToPinnedTasks(task, taskTypeName);
        assertFalse(TaskList.pinnedTasks.isEmpty());
    }

}