package seedu.duke.task.command;

import seedu.duke.Ui;
import seedu.duke.task.Task;
import seedu.duke.task.TaskManager;

import java.util.ArrayList;

public class PinTask {
    public static void pinTask(int taskTypeNumber) {
        if (TaskManager.taskListIsEmpty(taskTypeNumber)) {
            Ui.printTaskListIsEmptyMessage();
            return;
        }
        Ui.printSelectTaskNumberToPin(taskTypeNumber);
        while (true) {
            try {
                int taskNumber = Integer.parseInt(Ui.readCommand());
                Ui.printHorizontalLine();
                switch (taskTypeNumber) {
                case 1:
                    addTaskToPinnedTasks(TaskManager.tasks.get(taskNumber - 1), "[Task]");
                    break;
                case 2:
                    addTaskToPinnedTasks(TaskManager.assignments.get(taskNumber - 1), "[Assignment]");
                    break;
                case 3:
                    addTaskToPinnedTasks(TaskManager.midterms.get(taskNumber - 1), "[Midterm]");
                    break;
                case 4:
                    addTaskToPinnedTasks(TaskManager.finalExams.get(taskNumber - 1), "[Final Exam]");
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

    public static void addTaskToPinnedTasks(Task task, String taskTypeName) {
        TaskManager.pinnedTasks.computeIfAbsent(taskTypeName, k -> new ArrayList<>());
        if (TaskManager.pinnedTasks.get(taskTypeName).contains((task))) {
            Ui.printTaskAlreadyPinnedMessage();
            return;
        }
        TaskManager.pinnedTasks.get(taskTypeName).add(task);
        assert TaskManager.pinnedTasks.get(taskTypeName).contains(task) : "Task was not added to pinned list";
        Ui.printPinnedTaskMessage(task);
        return;
    }
}
