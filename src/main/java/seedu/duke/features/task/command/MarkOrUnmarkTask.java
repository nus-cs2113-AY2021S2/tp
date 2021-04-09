package seedu.duke.features.task.command;

import seedu.duke.ui.Ui;
import seedu.duke.features.task.tasktypes.Task;
import seedu.duke.features.task.TaskManager;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MarkOrUnmarkTask {

    private static final int TOGGLE_TASK_COMMAND = 1;
    private static final int TOGGLE_ASSIGNMENT_COMMAND = 2;
    private static final int TOGGLE_MIDTERM_COMMAND = 3;
    private static final int TOGGLE_FINAL_EXAM_COMMAND = 4;
    private static final String TASK_TYPE = "[Task]";
    private static final String ASSIGNMENT_TYPE = "[Assignment]";
    private static final String MIDTERM_TYPE = "[Midterm]";
    private static final String FINAL_EXAM_TYPE = "[Final Exam]";
    private static final String DONE_STATUS = "[DONE] ";
    private static final String NOT_DONE_STATUS = "[    ] ";
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void execute(int taskTypeNumber) {
        if (TaskManager.taskListIsEmpty(taskTypeNumber)) {
            Ui.printTaskListIsEmptyMessage();
            logger.log(Level.INFO, "task list is empty, marking/unmarking is impossible");
            return;
        }
        Ui.printSelectTaskNumberToMarkOrUnmark(taskTypeNumber);
        while (true) {
            try {
                int taskNumber = Ui.readCommandToInt();
                switch (taskTypeNumber) {
                case TOGGLE_TASK_COMMAND:
                    toggleTaskStatus(taskNumber, TASK_TYPE);
                    break;
                case TOGGLE_ASSIGNMENT_COMMAND:
                    toggleTaskStatus(taskNumber, ASSIGNMENT_TYPE);
                    break;
                case TOGGLE_MIDTERM_COMMAND:
                    toggleTaskStatus(taskNumber, MIDTERM_TYPE);
                    break;
                case TOGGLE_FINAL_EXAM_COMMAND:
                    toggleTaskStatus(taskNumber, FINAL_EXAM_TYPE);
                    break;
                default:
                    Ui.printRepeatInputUntilValidMessage();
                }
                logger.log(Level.FINE, "mark/unmark task successfully executed");
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

    public static void toggleTaskStatus(int taskNumber, String taskType) {
        Task task = TaskManager.getTask(taskType, taskNumber);
        String taskStatus = task.getStatus();

        if (taskStatus.equals(DONE_STATUS)) {
            Ui.printTaskisDoneMessage();
            String input = Ui.readCommand().trim();
            while (!input.equalsIgnoreCase("Y")) {
                if (input.equalsIgnoreCase("N")) {
                    return;
                }
                Ui.printInvalidInputForYOrNMessage();
                logger.log(Level.INFO, "user input is not Y or N");
                input = Ui.readCommand();
            }
            assert input.equalsIgnoreCase("Y") : "input should be Y";
            task.markAsUnDone();
            boolean taskIsPinned = TaskManager.findTaskInPinnedTasks(taskType, task.getModule(),
                    task.getDescription(), task.getStatus(), task.getMessage());
            markPinnedTaskAsUnDone(taskIsPinned, task);
            assert task.getStatus().equals(NOT_DONE_STATUS) : "Task should not be marked as done";
            Ui.printUnmarkedTaskMessage(task);
            logger.log(Level.FINE, "task successfully marked as not done");
        } else if (taskStatus.equals(NOT_DONE_STATUS)) {
            Ui.printTaskisNotDoneMessage();
            String input = Ui.readCommand().trim();
            while (!input.equalsIgnoreCase("Y")) {
                if (input.equalsIgnoreCase("N")) {
                    return;
                }
                Ui.printInvalidInputForYOrNMessage();
                logger.log(Level.INFO, "user input is not Y or N");
                input = Ui.readCommand();
            }
            assert input.equalsIgnoreCase("Y") : "input should be Y";
            task.markAsDone();
            boolean taskIsPinned = TaskManager.findTaskInPinnedTasks(taskType, task.getModule(),
                    task.getDescription(), task.getStatus(), task.getMessage());
            markPinnedTaskAsDone(taskIsPinned, task);
            assert task.getStatus().equals(DONE_STATUS) : "Task should be marked as done";
            Ui.printMarkedTaskMessage(task);
            logger.log(Level.FINE, "task successfully marked as done");
        }
    }

    public static void markPinnedTaskAsDone(boolean taskIsPinned, Task task) {
        if (taskIsPinned) {
            task.markAsDone();
        }
    }

    public static void markPinnedTaskAsUnDone(boolean taskIsPinned, Task task) {
        if (taskIsPinned) {
            task.markAsUnDone();
        }
    }
}
