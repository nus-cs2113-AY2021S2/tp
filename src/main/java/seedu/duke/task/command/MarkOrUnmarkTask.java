package seedu.duke.task.command;

import seedu.duke.Ui;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;

import java.util.ArrayList;

public class MarkOrUnmarkTask {
    public static void markOrUnmarkTask(int taskTypeNumber) {
        if (TaskList.taskListIsEmpty(taskTypeNumber)) {
            Ui.printTaskListIsEmptyMessage();
            return;
        }
        Ui.printSelectTaskNumberToMarkOrUnmark(taskTypeNumber);
        while (true) {
            try {
                int taskNumber = Integer.parseInt(Ui.readCommand());
                Ui.printHorizontalLine();
                switch (taskTypeNumber) {
                case 1:
                    toggleTaskStatus(taskNumber, "[Task]");
                    break;
                case 2:
                    toggleTaskStatus(taskNumber, "[Assignment]");
                    break;
                case 3:
                    toggleTaskStatus(taskNumber, "[Midterm]");
                    break;
                case 4:
                    toggleTaskStatus(taskNumber, "[Final Exam]");
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
        Task task = getTaskToMarkOrUnMark(taskType, taskNumber);
        String taskStatus = task.getStatus();
        String done = "[DONE] ";
        String notDone = "[    ] ";

        if (taskStatus.equals(done)) {
            Ui.printTaskisDoneMessage();
            String input = Ui.readCommand().trim();
            assert input.equalsIgnoreCase("Y") : "if input is not Y, should catch exception";
            if (input.equalsIgnoreCase("Y")) {
                task.markAsUnDone();
                markPinnedTaskAsUnDone(taskType, task.getModule(), task.getDescription());
                assert task.getStatus().equals("[    ] ") : "Task should not be marked as done";
                Ui.printUnmarkedTaskMessage(task);
            }
        } else if (taskStatus.equals(notDone)) {
            Ui.printTaskisNotDoneMessage();
            String input = Ui.readCommand().trim();
            assert input.equalsIgnoreCase("Y") : "if input is not Y, should catch exception";
            if (input.equalsIgnoreCase("Y")) {
                task.markAsDone();
                markPinnedTaskAsDone(taskType, task.getModule(), task.getDescription());
                assert task.getStatus().equals("[DONE] ") : "Task should be marked as done";
                Ui.printMarkedTaskMessage(task);
            }
        }
    }

    public static Task getTaskToMarkOrUnMark(String taskType, int taskNumber) {
        switch (taskType) {
        case "[Task]":
            return TaskList.tasks.get(taskNumber - 1);
        case "[Assignment]":
            return TaskList.assignments.get(taskNumber - 1);
        case "[Midterm]":
            return TaskList.midterms.get(taskNumber - 1);
        case "[Final Exam]":
            return TaskList.finalExams.get(taskNumber - 1);
        default:
            System.out.println("Task type does not exist!");
            return null;
        }
    }

    public static void markPinnedTaskAsDone(String tasktype, String module, String description) {
        if (!TaskList.pinnedTasks.containsKey(tasktype)) {
            return;
        }
        ArrayList<Task> tasks = TaskList.pinnedTasks.get(tasktype);
        for (Task task : tasks) {
            boolean isSameModule = task.getModule().equals(module);
            boolean isSameDescription = task.getDescription().equals(description);
            if (isSameModule && isSameDescription) {
                task.markAsDone();
            }
        }
    }

    public static void markPinnedTaskAsUnDone(String tasktype, String module, String description) {
        if (!TaskList.pinnedTasks.containsKey(tasktype)) {
            return;
        }
        ArrayList<Task> tasks = TaskList.pinnedTasks.get(tasktype);
        for (Task task : tasks) {
            boolean isSameModule = task.getModule().equals(module);
            boolean isSameDescription = task.getDescription().equals(description);
            if (isSameModule && isSameDescription) {
                task.markAsUnDone();
            }
        }
    }
}
