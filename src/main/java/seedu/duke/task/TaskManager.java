package seedu.duke.task;

import seedu.duke.Ui;
import seedu.duke.task.command.AddTask;
import seedu.duke.task.command.DeleteTask;
import seedu.duke.task.command.MarkOrUnmarkTask;
import seedu.duke.task.command.PinTask;

import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {

    private static final int ADD_NEW_TASK_COMMAND = 1;
    private static final int MARK_OR_UNMARK_TASK_COMMAND = 2;
    private static final int DELETE_TASK_COMMAND = 3;
    private static final int VIEW_ALL_TASKS_COMMAND = 4;
    private static final int PIN_TASK_COMMAND = 5;
    private static final int EXIT_COMMAND = 6;

    public static ArrayList<Task> tasks;
    public static ArrayList<Assignment> assignments;
    public static ArrayList<Midterm> midterms;
    public static ArrayList<FinalExam> finalExams;
    public static HashMap<String, ArrayList<Task>> pinnedTasks;

    public TaskManager() {
        tasks = new ArrayList<>();
        assignments = new ArrayList<>();
        midterms = new ArrayList<>();
        finalExams = new ArrayList<>();
        pinnedTasks = new HashMap<>();
    }

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
        int taskTypeNumber = getTaskNumber();

        //AddTask.addNewTask(taskTypeNumber);
        AddTask addTask = new AddTask(taskTypeNumber);
    }

    private static void markOrUnmarkTask() {
        Ui.printMarkTaskMenu();
        int taskTypeNumber = getTaskNumber();

        MarkOrUnmarkTask.markOrUnmarkTask(taskTypeNumber);

    }

    private static void viewAllTasks() {
        Ui.printPinnedTaskList(pinnedTasks);
        Ui.printEmptyLine();
        Ui.printTaskList(tasks);
        Ui.printEmptyLine();
        Ui.printAssignmentList(assignments);
        Ui.printEmptyLine();
        Ui.printMidtermList(midterms);
        Ui.printEmptyLine();
        Ui.printFinalExamList(finalExams);
        Ui.printEmptyLine();
        Ui.printHorizontalLine();
    }

    private static void pinTask() {
        Ui.printPinTaskMenu();
        int taskTypeNumber = getTaskNumber();

        PinTask.pinTask(taskTypeNumber);
    }

    public static void deleteTask() {
        Ui.printDeleteTaskMenu();
        int taskTypeNumber = getTaskNumber();
        Ui.printHorizontalLine();

        DeleteTask.deleteTask(taskTypeNumber);
    }

    public static boolean isValidTaskType(String command) {
        try {
            int taskNumber = Integer.parseInt(command);
            boolean isInvalidTaskType = (taskNumber <= 0) || (taskNumber >= 5);
            assert !command.isBlank() : "Task number cannot be empty";
            if (!isInvalidTaskType) {
                return true;
            }
            System.out.println("Please enter a valid integer from the list.");
        } catch (NumberFormatException n) {
            System.out.println("Error! Enter an integer.");
        }
        return false;
    }

    public static int getTaskNumber() {
        int taskNumber;
        while (true) {
            String command = Ui.readCommand();
            if (isValidTaskType(command)) {
                taskNumber = Integer.parseInt(command);
                break;
            }
        }
        return taskNumber;
    }

    public static boolean taskListIsEmpty(int taskTypeNumber) {
        boolean isEmpty = false;
        switch (taskTypeNumber) {
        case 1:
            isEmpty = tasks.isEmpty();
            break;
        case 2:
            isEmpty = assignments.isEmpty();
            break;
        case 3:
            isEmpty = midterms.isEmpty();
            break;
        case 4:
            isEmpty = finalExams.isEmpty();
            break;
        default:
            Ui.printInvalidIntegerMessage();
        }
        return isEmpty;
    }
}
