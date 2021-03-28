package seedu.duke.task.command;

import seedu.duke.Ui;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;

import java.util.ArrayList;

public class PinTask {
    public static void pinTask(int taskTypeNumber) {
        if (TaskList.taskListIsEmpty(taskTypeNumber)) {
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
                    addTaskToPinnedTasks(TaskList.tasks.get(taskNumber - 1), "[Task]");
                    break;
                case 2:
                    addTaskToPinnedTasks(TaskList.assignments.get(taskNumber - 1), "[Assignment]");
                    break;
                case 3:
                    addTaskToPinnedTasks(TaskList.midterms.get(taskNumber - 1), "[Midterm]");
                    break;
                case 4:
                    addTaskToPinnedTasks(TaskList.finalExams.get(taskNumber - 1), "[Final Exam]");
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
        TaskList.pinnedTasks.computeIfAbsent(taskTypeName, k -> new ArrayList<>());
        if (TaskList.pinnedTasks.get(taskTypeName).contains((task))) {
            Ui.printTaskAlreadyPinnedMessage();
            return;
        }
        TaskList.pinnedTasks.get(taskTypeName).add(task);
        assert TaskList.pinnedTasks.get(taskTypeName).contains(task) : "Task was not added to pinned list";
        Ui.printPinnedTaskMessage(task);
        return;
    }
}
