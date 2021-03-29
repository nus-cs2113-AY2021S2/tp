package seedu.duke.task.command;

import seedu.duke.Ui;
import seedu.duke.task.Task;
import seedu.duke.task.TaskManager;

public class MarkOrUnmarkTask {

    private static final int ADD_TASK_COMMAND = 1;
    private static final int ADD_ASSIGNMENT_COMMAND = 2;
    private static final int ADD_MIDTERM_COMMAND = 3;
    private static final int ADD_FINAL_EXAM_COMMAND = 4;
    private static final String TASK_TYPE = "[Task]";
    private static final String ASSIGNMENT_TYPE = "[Assignment]";
    private static final String MIDTERM_TYPE = "[Midterm]";
    private static final String FINAL_EXAM_TYPE = "[Final Exam]";
    private static final String DONE_STATUS = "[DONE] ";
    private static final String NOT_DONE_STATUS = "[    ] ";

    public static void execute(int taskTypeNumber) {
        if (TaskManager.taskListIsEmpty(taskTypeNumber)) {
            Ui.printTaskListIsEmptyMessage();
            return;
        }
        Ui.printSelectTaskNumberToMarkOrUnmark(taskTypeNumber);
        while (true) {
            try {
                int taskNumber = Integer.parseInt(Ui.readCommand());
                switch (taskTypeNumber) {
                case ADD_TASK_COMMAND:
                    toggleTaskStatus(taskNumber, TASK_TYPE);
                    break;
                case ADD_ASSIGNMENT_COMMAND:
                    toggleTaskStatus(taskNumber, ASSIGNMENT_TYPE);
                    break;
                case ADD_MIDTERM_COMMAND:
                    toggleTaskStatus(taskNumber, MIDTERM_TYPE);
                    break;
                case ADD_FINAL_EXAM_COMMAND:
                    toggleTaskStatus(taskNumber, FINAL_EXAM_TYPE);
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

    public static void toggleTaskStatus(int taskNumber, String taskType) {
        Task task = TaskManager.getTask(taskType, taskNumber);
        String taskStatus = task.getStatus();

        if (taskStatus.equals(DONE_STATUS)) {
            Ui.printTaskisDoneMessage();
            String input = Ui.readCommand().trim();
            if (input.equalsIgnoreCase("Y")) {
                assert input.equalsIgnoreCase("Y") : "input should be Y";
                task.markAsUnDone();
                boolean taskIsPinned = TaskManager.findTaskInPinnedTasks(taskType, task.getModule(),
                        task.getDescription(), task.getStatus(), task.getMessage());
                markPinnedTaskAsUnDone(taskIsPinned, task);
                assert task.getStatus().equals(NOT_DONE_STATUS) : "Task should not be marked as done";
                Ui.printUnmarkedTaskMessage(task);
            }
        } else if (taskStatus.equals(NOT_DONE_STATUS)) {
            Ui.printTaskisNotDoneMessage();
            String input = Ui.readCommand().trim();
            if (input.equalsIgnoreCase("Y")) {
                assert input.equalsIgnoreCase("Y") : "input should be Y";
                task.markAsDone();
                boolean taskIsPinned = TaskManager.findTaskInPinnedTasks(taskType, task.getModule(),
                        task.getDescription(), task.getStatus(), task.getMessage());
                markPinnedTaskAsDone(taskIsPinned, task);
                assert task.getStatus().equals(DONE_STATUS) : "Task should be marked as done";
                Ui.printMarkedTaskMessage(task);
            }
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
