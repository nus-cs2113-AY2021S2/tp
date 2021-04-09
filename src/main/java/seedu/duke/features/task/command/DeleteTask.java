package seedu.duke.features.task.command;

import seedu.duke.ui.Ui;
import seedu.duke.features.task.tasktypes.Task;
import seedu.duke.features.task.TaskManager;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteTask {

    private static final int DELETE_TASK = 1;
    private static final int DELETE_ASSIGNMENT = 2;
    private static final int DELETE_MIDTERM = 3;
    private static final int DELETE_FINAL_EXAM = 4;
    private static final String TASK_TYPE = "[Task]";
    private static final String ASSIGNMENT_TYPE = "[Assignment]";
    private static final String MIDTERM_TYPE = "[Midterm]";
    private static final String FINAL_EXAM_TYPE = "[Final Exam]";
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void execute(int taskTypeNumber) {
        if (TaskManager.taskListIsEmpty(taskTypeNumber)) {
            Ui.printTaskListIsEmptyMessage();
            logger.log(Level.INFO, "task list is empty, deleting is impossible");
            return;
        }
        Ui.printSelectTaskNumberToDelete(taskTypeNumber);
        while (true) {
            try {
                int taskNumber = Ui.readCommandToInt();
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
                    Ui.printRepeatInputUntilValidMessage();
                }
                logger.log(Level.FINE, "delete task successfully executed");
                return;
            } catch (NumberFormatException e) {
                logger.log(Level.WARNING, "NumberFormatException, task number is not a number");
                Ui.printRepeatInputUntilValidMessage();
            } catch (IndexOutOfBoundsException e) {
                logger.log(Level.WARNING, "IndexOutOfBoundsException, task number is not a valid number");
                Ui.printRepeatInputUntilValidMessage();
            }
        }
    }

    public static void findAndDeleteTask(int taskNumber, String taskType) {
        Task task = TaskManager.getTask(taskType, taskNumber);
        deleteTask(taskType, task);
        logger.log(Level.FINE, "task was successfully deleted");
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
            logger.log(Level.INFO, "this task is pinned");
            assert !TaskManager.pinnedTasks.get(taskType).isEmpty() : "Pinned task list should not be empty";
            Task pinnedTask = TaskManager.getPinnedTask(taskType, task.getModule(), task.getDescription(),
                    task.getStatus(), task.getMessage());
            TaskManager.pinnedTasks.get(taskType).remove(pinnedTask);
            logger.log(Level.FINE, "pinned task was successfully deleted");
        }
    }
}
