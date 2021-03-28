package seedu.duke.task;

import seedu.duke.Ui;
import seedu.duke.task.command.AddTask;
import seedu.duke.task.command.DeleteTask;
import seedu.duke.task.command.MarkOrUnmarkTask;
import seedu.duke.task.command.PinTask;

public class TaskManager {

    private static final int ADD_NEW_TASK_COMMAND = 1;
    private static final int MARK_OR_UNMARK_TASK_COMMAND = 2;
    private static final int DELETE_TASK_COMMAND = 3;
    private static final int VIEW_ALL_TASKS_COMMAND = 4;
    private static final int PIN_TASK_COMMAND = 5;
    private static final int EXIT_COMMAND = 6;

    public static void execute() {
        while (true) {
            Ui.printTaskManagerMenu();
            String command = Ui.readCommand();
            try {
                int taskNumber = Integer.parseInt(command);
                switch (taskNumber) {
                case ADD_NEW_TASK_COMMAND:
                    addNewTask();
                    break;
                case MARK_OR_UNMARK_TASK_COMMAND:
                    markOrUnmarkTask();
                    break;
                case DELETE_TASK_COMMAND:
                    deleteTask();
                    break;
                case VIEW_ALL_TASKS_COMMAND:
                    viewAllTasks();
                    break;
                case PIN_TASK_COMMAND:
                    pinTask();
                    break;
                case EXIT_COMMAND:
                    return;
                default:
                    Ui.printInvalidIntegerMessage();
                }
            } catch (NumberFormatException e) {
                Ui.printInvalidIntegerMessage();
                Ui.printHorizontalLine();
            }
        }
    }

    public static void addNewTask() {
        Ui.printAddTaskMenu();
        int taskTypeNumber = TaskList.getTaskNumber();

        //AddTask.addNewTask(taskTypeNumber);
        new AddTask(taskTypeNumber);
    }

    private static void markOrUnmarkTask() {
        Ui.printMarkTaskMenu();
        int taskTypeNumber = TaskList.getTaskNumber();

        MarkOrUnmarkTask.markOrUnmarkTask(taskTypeNumber);

    }

    private static void viewAllTasks() {
        Ui.printPinnedTaskList(TaskList.pinnedTasks);
        Ui.printEmptyLine();
        Ui.printTaskList(TaskList.tasks);
        Ui.printEmptyLine();
        Ui.printAssignmentList(TaskList.assignments);
        Ui.printEmptyLine();
        Ui.printMidtermList(TaskList.midterms);
        Ui.printEmptyLine();
        Ui.printFinalExamList(TaskList.finalExams);
        Ui.printEmptyLine();
        Ui.printHorizontalLine();
    }

    private static void pinTask() {
        Ui.printPinTaskMenu();
        int taskTypeNumber = TaskList.getTaskNumber();

        PinTask.pinTask(taskTypeNumber);
    }

    public static void deleteTask() {
        Ui.printDeleteTaskMenu();
        int taskTypeNumber = TaskList.getTaskNumber();
        Ui.printHorizontalLine();

        DeleteTask.deleteTask(taskTypeNumber);
    }
}
