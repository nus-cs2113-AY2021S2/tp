package seedu.duke.task.command;

import seedu.duke.Ui;
import seedu.duke.task.Task;
import seedu.duke.task.TaskManager;

import java.util.ArrayList;

public class DeleteTask {

    private static final int DELETE_TASK = 1;
    private static final int DELETE_ASSIGNMENT = 2;
    private static final int DELETE_MIDTERM = 3;
    private static final int DELETE_FINAL_EXAM = 4;
    private static final String TASK_TYPE = "[Task]";
    private static final String ASSIGNMENT_TYPE = "[Assignment]";
    private static final String MIDTERM_TYPE = "[Midterm]";
    private static final String FINAL_EXAM_TYPE = "[Final Exam]";

    public static void execute(int taskTypeNumber) {
        if (TaskManager.taskListIsEmpty(taskTypeNumber)) {
            Ui.printTaskListIsEmptyMessage();
            return;
        }
        Ui.printSelectTaskNumberToDelete(taskTypeNumber);
        while (true) {
            try {
                int taskNumber = Integer.parseInt(Ui.readCommand());
                switch (taskTypeNumber) {
                case DELETE_TASK:
                    findAndDeleteTask(taskNumber, TASK_TYPE);
                    break;
                case DELETE_ASSIGNMENT:
                    findAndDeleteTask(taskNumber, ASSIGNMENT_TYPE);
                    break;
                case DELETE_MIDTERM:
                    findAndDeleteTask(taskNumber, MIDTERM_TYPE);
                    break;
                case DELETE_FINAL_EXAM:
                    findAndDeleteTask(taskNumber, FINAL_EXAM_TYPE);
                    break;
                default:
                    Ui.printInvalidIntegerMessage();
                }
                return;
            } catch (NumberFormatException e) {
                Ui.printInvalidIntegerMessage();
            } catch (IndexOutOfBoundsException e) {
                Ui.printInvalidTaskNumberMessage();
            }
        }
    }

    public static void findAndDeleteTask(int taskNumber, String taskType) {
        Task task = TaskManager.getTask(taskType, taskNumber);
        deleteTask(taskType, task);
        boolean typeTaskIsPinned = TaskManager.pinnedTasks.containsKey(taskType);
        if (typeTaskIsPinned) {
            assert TaskManager.pinnedTasks.containsKey(taskType) : "Pinned task list for task should exist";
            assert task != null : "Task should not be null";
            findAndDeletePinnedTask(taskType, task);
        }
        assert task != null : "Task should not be null";
        Ui.printDeletedTaskMessage(task);
    }

    public static void deleteTask(String taskType, Task task) {
        switch (taskType) {
        case TASK_TYPE:
            TaskManager.tasks.remove(task);
            break;
        case ASSIGNMENT_TYPE:
            TaskManager.assignments.remove(task);
            break;
        case MIDTERM_TYPE:
            TaskManager.midterms.remove(task);
            break;
        case FINAL_EXAM_TYPE:
            TaskManager.finalExams.remove(task);
            break;
        default:
            System.out.println("Task type does not exist!");
        }
    }


    public static void findAndDeletePinnedTask(String taskType, Task task) {
        boolean taskIsPinned = TaskManager.findTaskInPinnedTasks(taskType, task.getModule(), task.getDescription(),
                task.getStatus(), task.getMessage());
        if (taskIsPinned) {
            assert !TaskManager.pinnedTasks.get(taskType).isEmpty() : "Pinned task list should not be empty";
            Task pinnedTask = TaskManager.getPinnedTask(taskType, task.getModule(), task.getDescription(),
                    task.getStatus(), task.getMessage());
            TaskManager.pinnedTasks.get(taskType).remove(pinnedTask);
        }
    }
}
