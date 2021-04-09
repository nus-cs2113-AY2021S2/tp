package seedu.duke.features.task.command;

import seedu.duke.ui.Ui;
import seedu.duke.features.task.tasktypes.Task;
import seedu.duke.features.task.TaskManager;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PinTask {

    private static final int PIN_TASK_COMMAND = 1;
    private static final int PIN_ASSIGNMENT_COMMAND = 2;
    private static final int PIN_MIDTERM_COMMAND = 3;
    private static final int PIN_FINAL_EXAM_COMMAND = 4;
    private static final String TASK_TYPE = "[Task]";
    private static final String ASSIGNMENT_TYPE = "[Assignment]";
    private static final String MIDTERM_TYPE = "[Midterm]";
    private static final String FINAL_EXAM_TYPE = "[Final Exam]";
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void execute(int taskTypeNumber) {
        if (TaskManager.taskListIsEmpty(taskTypeNumber)) {
            Ui.printTaskListIsEmptyMessage();
            logger.log(Level.INFO, "task list is empty, pinning is impossible");
            return;
        }
        Ui.printSelectTaskNumberToPin(taskTypeNumber);
        while (true) {
            try {
                int taskNumber = Ui.readCommandToInt();
                switch (taskTypeNumber) {
                case PIN_TASK_COMMAND:
                    addTaskToPinnedTasks(TaskManager.tasks.get(taskNumber - 1), TASK_TYPE);
                    break;
                case PIN_ASSIGNMENT_COMMAND:
                    addTaskToPinnedTasks(TaskManager.assignments.get(taskNumber - 1), ASSIGNMENT_TYPE);
                    break;
                case PIN_MIDTERM_COMMAND:
                    addTaskToPinnedTasks(TaskManager.midterms.get(taskNumber - 1), MIDTERM_TYPE);
                    break;
                case PIN_FINAL_EXAM_COMMAND:
                    addTaskToPinnedTasks(TaskManager.finalExams.get(taskNumber - 1), FINAL_EXAM_TYPE);
                    break;
                default:
                    Ui.printRepeatInputUntilValidMessage();
                }
                logger.log(Level.FINE, "pinning task successfully executed");
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

    public static void addTaskToPinnedTasks(Task task, String taskTypeName) {
        TaskManager.pinnedTasks.computeIfAbsent(taskTypeName, k -> new ArrayList<>());
        if (TaskManager.pinnedTasks.get(taskTypeName).contains((task))) {
            Ui.printTaskAlreadyPinnedMessage();
            logger.log(Level.INFO, "task is already pinned, cannot pin again");
            return;
        }
        TaskManager.pinnedTasks.get(taskTypeName).add(task);
        assert TaskManager.pinnedTasks.get(taskTypeName).contains(task) : "Task was not added to pinned list";
        Ui.printPinnedTaskMessage(task);
        logger.log(Level.FINE, "task was successfully pinned");
    }
}
