package seedu.duke.features.task;

import seedu.duke.features.task.tasktypes.Assignment;
import seedu.duke.features.task.tasktypes.FinalExam;
import seedu.duke.features.task.tasktypes.Midterm;
import seedu.duke.features.task.tasktypes.Task;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;
import seedu.duke.features.task.command.AddTask;
import seedu.duke.features.task.command.DeleteTask;
import seedu.duke.features.task.command.MarkOrUnmarkTask;
import seedu.duke.features.task.command.PinTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * TaskManager manages the task list for modules and contains methods to
 * add, delete, mark/unmark, view and pin assignments, midterm, final exam and normal tasks.
 */
public class TaskManager {

    private static final int ADD_NEW_TASK_COMMAND = 1;
    private static final int MARK_OR_UNMARK_TASK_COMMAND = 2;
    private static final int DELETE_TASK_COMMAND = 3;
    private static final int VIEW_ALL_TASKS_COMMAND = 4;
    private static final int PIN_TASK_COMMAND = 5;
    private static final int EXIT_COMMAND = 6;
    private static final String TASK_TYPE = "[Task]";
    private static final String ASSIGNMENT_TYPE = "[Assignment]";
    private static final String MIDTERM_TYPE = "[Midterm]";
    private static final String FINAL_EXAM_TYPE = "[Final Exam]";
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static ArrayList<Task> tasks;
    public static ArrayList<Assignment> assignments;
    public static ArrayList<Midterm> midterms;
    public static ArrayList<FinalExam> finalExams;
    public static HashMap<String, ArrayList<Task>> pinnedTasks;

    /**
     * Constructs task list for all different task types.
     */
    public TaskManager() {
        tasks = new ArrayList<>();
        assignments = new ArrayList<>();
        midterms = new ArrayList<>();
        finalExams = new ArrayList<>();
        pinnedTasks = new HashMap<>();
    }

    /**
     * Prints task manager menu and executes task manager features.
     */
    public static void execute() {
        while (true) {
            Ui.printTaskManagerMenu();
            try {
                int taskNumber = Ui.readCommandToInt();
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
                    Ui.printInvalidInputMessage();
                }
            } catch (NumberFormatException e) {
                Ui.printInvalidInputMessage();
            }
            try {
                Storage.saveAllFiles();
            } catch (IOException e) {
                Ui.printFilesCouldNotBeSavedMessage();
            }
            Ui.printReturnToTaskManagerMenuMessage();
            logger.log(Level.FINE, "command successfully executed");
        }
    }

    /**
     * Executes add new task feature.
     */
    public static void addNewTask() {
        Ui.printAddTaskMenu();
        int taskTypeNumber = getTaskNumber();

        AddTask.execute(taskTypeNumber);
    }

    /**
     * Executes mark or unmark task feature.
     */
    private static void markOrUnmarkTask() {
        Ui.printMarkTaskMenu();
        int taskTypeNumber = getTaskNumber();

        MarkOrUnmarkTask.execute(taskTypeNumber);

    }

    /**
     * Executes view all tasks feature.
     */
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

    /**
     * Executes pin task feature.
     */
    private static void pinTask() {
        Ui.printPinTaskMenu();
        int taskTypeNumber = getTaskNumber();

        PinTask.execute(taskTypeNumber);
    }

    /**
     * Executes delete task feature.
     */
    public static void deleteTask() {
        Ui.printDeleteTaskMenu();
        int taskTypeNumber = getTaskNumber();

        DeleteTask.execute(taskTypeNumber);
    }

    /**
     * Checks if user input corresponds to a valid task type. The number should range from 1 to 4.
     *
     * @param taskNumber User input for task type.
     * @return If the user input corresponds to a valid task type.
     */
    public static boolean isValidTaskType(int taskNumber) {
        try {
            boolean isInvalidTaskType = (taskNumber <= 0) || (taskNumber >= 5);
            if (!isInvalidTaskType) {
                logger.log(Level.INFO, "task number is valid");
                return true;
            }
            Ui.printRepeatInputUntilValidMessage();
        } catch (NumberFormatException n) {
            Ui.printRepeatInputUntilValidMessage();
        }
        logger.log(Level.INFO, "task number is NOT valid");
        return false;
    }

    /**
     * Gets user input for task type.
     *
     * @return Number of the task type.
     */
    public static int getTaskNumber() {
        int taskNumber;
        while (true) {
            int command = Ui.readCommandToInt();
            if (isValidTaskType(command)) {
                taskNumber = command;
                break;
            }
        }
        return taskNumber;
    }

    /**
     * Checks if the task list for a specific task type is empty.
     *
     * @param taskTypeNumber The number corresponding to the 4 different task types.
     * @return If the task list for the specified task type is empty.
     */
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
            Ui.printInvalidInputMessage();
        }
        return isEmpty;
    }

    /**
     * Checks if a normal task already exists.
     *
     * @param module The module code of the task.
     * @param description The description of the task.
     * @param status The status of whether the task is done.
     * @return If the task already exists in the task list.
     */
    public static boolean findIfTaskExists(String module, String description, String status) {
        for (Task task : tasks) {
            boolean isSameModule = task.getModule().equals(module);
            boolean isSameDescription = task.getDescription().equals(description);
            boolean isSameStatus = task.getStatus().equals(status);
            if (isSameModule && isSameDescription && isSameStatus) {
                logger.log(Level.INFO, "task already exists in task list");
                return true;
            }
        }
        logger.log(Level.INFO, "task does not exist in task list");
        return false;
    }

    /**
     * Checks if an assignment already exists.
     *
     * @param module The module code of the assignment.
     * @param description The description of the assignment.
     * @param dateAndTime The date and time of the assignment.
     * @param status The status of whether the assignment is done.
     * @return If the assignment already exists in the assignment list.
     */
    public static boolean findIfAssignmentExists(String module, String description,
                                                 String dateAndTime, String status) {
        for (Assignment assignment : assignments) {
            boolean isSameModule = assignment.getModule().equals(module);
            boolean isSameDescription = assignment.getDescription().equals(description);
            boolean isSameDateAndTime = assignment.getBy().equals(dateAndTime);
            boolean isSameStatus = assignment.getStatus().equals(status);
            if (isSameModule && isSameDescription && isSameDateAndTime && isSameStatus) {
                logger.log(Level.INFO, "assignment already exists in assignment list");
                return true;
            }
        }
        logger.log(Level.INFO, "assignment does not exist in assignment list");
        return false;
    }

    /**
     * Checks if a midterm already exists.
     *
     * @param module The module code of the midterm.
     * @param description The description of the midterm.
     * @param dateAndTime The date and time of the midterm.
     * @param status The status of whether the midterm is done.
     * @return If the midterm already exists in the midterm list.
     */
    public static boolean findIfMidtermExists(String module, String description,
                                              String dateAndTime, String status) {
        for (Midterm midterm : midterms) {
            boolean isSameModule = midterm.getModule().equals(module);
            boolean isSameDescription = midterm.getDescription().equals(description);
            boolean isSameDateAndTime = midterm.getOn().equals(dateAndTime);
            boolean isSameStatus = midterm.getStatus().equals(status);
            if (isSameModule && isSameDescription && isSameDateAndTime && isSameStatus) {
                logger.log(Level.INFO, "midterm already exists in midterm list");
                return true;
            }
        }
        logger.log(Level.INFO, "midterm does not exist in midterm list");
        return false;
    }

    /**
     * Checks if a final exam already exists.
     *
     * @param module The module code of the final exam.
     * @param description The description of the final exam.
     * @param dateAndTime The date and time of the final exam.
     * @param status The status of whether the final exam is done.
     * @return If the final exam already exists in the final exam list.
     */
    public static boolean findIfFinalExamExists(String module, String description,
                                                String dateAndTime, String status) {
        for (FinalExam finalExam : finalExams) {
            boolean isSameModule = finalExam.getModule().equals(module);
            boolean isSameDescription = finalExam.getDescription().equals(description);
            boolean isSameDateAndTime = finalExam.getOn().equals(dateAndTime);
            boolean isSameStatus = finalExam.getStatus().equals(status);
            if (isSameModule && isSameDescription && isSameDateAndTime && isSameStatus) {
                logger.log(Level.INFO, "final already exists in final exam list");
                return true;
            }
        }
        logger.log(Level.INFO, "final does not exist in final exam list");
        return false;
    }

    /**
     * Gets a task.
     *
     * @param taskType The task type.
     * @param taskNumber The index of the task.
     * @return The task.
     */
    public static Task getTask(String taskType, int taskNumber) {
        switch (taskType) {
        case TASK_TYPE:
            return tasks.get(taskNumber - 1);
        case ASSIGNMENT_TYPE:
            return assignments.get(taskNumber - 1);
        case MIDTERM_TYPE:
            return midterms.get(taskNumber - 1);
        case FINAL_EXAM_TYPE:
            return finalExams.get(taskNumber - 1);
        default:
            System.out.println("Task type does not exist!");
            return null;
        }
    }

    /**
     * Gets a pinned task.
     *
     * @param taskType The task type.
     * @param module The module of the task.
     * @param description The description of the task.
     * @param status The status of whether a task is done.
     * @param message The message belonging to the task.
     * @return The pinned task.
     */
    public static Task getPinnedTask(String taskType, String module, String description,
                                     String status, String message) {
        ArrayList<Task> tasks = pinnedTasks.get(taskType);
        for (Task task : tasks) {
            boolean isSameModule = task.getModule().equals(module);
            boolean isSameDescription = task.getDescription().equals(description);
            boolean isSameStatus = task.getStatus().equals(status);
            boolean isSameMessage = task.getMessage().equals(message);
            if (isSameModule && isSameDescription && isSameStatus && isSameMessage) {
                return task;
            }
        }
        logger.log(Level.WARNING, "task should exist!");
        return null;
    }

    /**
     * Checks if a pinned task already exists.
     *
     * @param taskType The task type.
     * @param module The module of the task.
     * @param description The description of the task.
     * @param status The status of whether the task is done.
     * @param message The message corresponding to the task.
     * @return If the task already exists in the pinned task list.
     */
    public static boolean findTaskInPinnedTasks(String taskType, String module, String description,
                                                String status, String message) {
        if (!pinnedTasks.containsKey(taskType)) {
            return false;
        }
        ArrayList<Task> tasks = pinnedTasks.get(taskType);
        for (Task task : tasks) {
            boolean isSameModule = task.getModule().equals(module);
            boolean isSameDescription = task.getDescription().equals(description);
            boolean isSameStatus = task.getStatus().equals(status);
            boolean isSameMessage = task.getMessage().equals(message);
            if (isSameModule && isSameDescription && isSameStatus && isSameMessage) {
                logger.log(Level.INFO, "pinned task already exists in pinned task list");
                return true;
            }
        }
        logger.log(Level.INFO, "pinned task does not exist in pinned task list");
        return false;
    }
}
