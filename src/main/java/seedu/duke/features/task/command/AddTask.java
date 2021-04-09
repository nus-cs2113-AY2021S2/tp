package seedu.duke.features.task.command;

import seedu.duke.features.moduleinfo.ModuleInfo;
import seedu.duke.ui.Ui;
import seedu.duke.features.task.tasktypes.Assignment;
import seedu.duke.features.task.tasktypes.FinalExam;
import seedu.duke.features.task.tasktypes.Midterm;
import seedu.duke.features.task.tasktypes.Task;
import seedu.duke.features.task.TaskManager;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddTask {

    private static final int ADD_TASK_COMMAND = 1;
    private static final int ADD_ASSIGNMENT_COMMAND = 2;
    private static final int ADD_MIDTERM_COMMAND = 3;
    private static final int ADD_FINAL_EXAM_COMMAND = 4;
    private static final String EMPTY_STRING = "";
    private static final String NOT_DONE_STATUS = "[    ] ";
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void execute(int taskTypeNumber) {
        String dateAndTime = EMPTY_STRING;
        String module;

        if (ModuleInfo.modules.isEmpty()) {
            Ui.printNoModulesMessage();
            String input = Ui.readCommand().trim();
            if (input.equalsIgnoreCase("N")) {
                return;
            }
            module = getModuleForTask();
        } else {
            Ui.printAddTaskModuleMessage(taskTypeNumber);
            module = printAndGetModule();
            if (module.equals("")) {
                return;
            }
        }

        Ui.printAddTaskDescriptionMessage(taskTypeNumber);
        String description = getDescription();
        if (taskTypeNumber != 1) {
            dateAndTime = getDateAndTime(taskTypeNumber);
        }
        Ui.printAddMessageAfterCompletedTask();
        String message = getMessage();

        switch (taskTypeNumber) {
        case ADD_TASK_COMMAND:
            addTask(module, description, message);
            break;
        case ADD_ASSIGNMENT_COMMAND:
            addAssignment(module, description, message, dateAndTime);
            break;
        case ADD_MIDTERM_COMMAND:
            addMidterm(module, description, message, dateAndTime);
            break;
        case ADD_FINAL_EXAM_COMMAND:
            addFinalExam(module, description, message, dateAndTime);
            break;
        default:
            Ui.printRepeatInputUntilValidMessage();
        }
        logger.log(Level.FINE, "add task successfully executed");
    }

    private static String getDateAndTime(int taskTypeNumber) {
        String dateAndTime;
        dateAndTime = getDate(taskTypeNumber) + ", " + getTime(taskTypeNumber);
        return dateAndTime;
    }

    private static String getModuleForTask() {
        String module;
        ModuleInfo.addNewModule();
        module = ModuleInfo.modules.get(ModuleInfo.modules.size() - 1).getName();
        return module;
    }

    private static String getDescription() {
        String description = Ui.readCommand();
        while (Ui.userCommandIsEmpty(description)) {
            System.out.println("Description should not be empty! Please try again.");
            description = Ui.readCommand();
        }
        logger.log(Level.INFO, "description is not an empty string");
        return description;
    }

    private static String getMessage() {
        String message = Ui.readCommand();
        while (Ui.userCommandIsEmpty(message)) {
            System.out.println("Message should not be empty! Please try again.");
            message = Ui.readCommand();
        }
        logger.log(Level.INFO, "message is not an empty string");
        return message;
    }

    public static void addTask(String module, String description, String message) {
        Task task = new Task(module, description, message);
        if (TaskManager.findIfTaskExists(module, description, NOT_DONE_STATUS)) {
            Ui.printTaskAlreadyExistsMessage(task);
            logger.log(Level.INFO, "task already added, will not be added again");
            return;
        }
        TaskManager.tasks.add(task);
        assert TaskManager.tasks.contains(task) : "Task was not added to task list";
        Ui.printAddedTaskMessage(task);
        logger.log(Level.FINE, "task successfully added");
    }

    public static void addAssignment(String module, String description,
                                     String message, String dateAndTime) {
        Assignment assignment = new Assignment(module, description, message, dateAndTime);
        if (TaskManager.findIfAssignmentExists(module, description, dateAndTime, NOT_DONE_STATUS)) {
            Ui.printTaskAlreadyExistsMessage(assignment);
            logger.log(Level.INFO, "assignment already added, will not be added again");
            return;
        }
        TaskManager.assignments.add(assignment);
        assert TaskManager.assignments.contains(assignment) : "Assignment was not added to assignment list";
        Ui.printAddedTaskMessage(assignment);
        logger.log(Level.FINE, "assignment successfully added");
    }

    public static void addMidterm(String module, String description,
                                  String message, String dateAndTime) {
        Midterm midterm = new Midterm(module, description, message, dateAndTime);
        if (TaskManager.findIfMidtermExists(module, description, dateAndTime, NOT_DONE_STATUS)) {
            Ui.printTaskAlreadyExistsMessage(midterm);
            logger.log(Level.INFO, "midterm already added, will not be added again");
            return;
        }
        TaskManager.midterms.add(midterm);
        assert TaskManager.midterms.contains(midterm) : "Midterm was not added to midterm list";
        Ui.printAddedTaskMessage(midterm);
        logger.log(Level.FINE, "midterm successfully added");
    }

    public static void addFinalExam(String module, String description,
                                    String message, String dateAndTime) {
        FinalExam finalExam = new FinalExam(module, description, message, dateAndTime);
        if (TaskManager.findIfFinalExamExists(module, description, dateAndTime, NOT_DONE_STATUS)) {
            Ui.printTaskAlreadyExistsMessage(finalExam);
            logger.log(Level.INFO, "final exam already added, will not be added again");
            return;
        }
        TaskManager.finalExams.add(finalExam);
        assert TaskManager.finalExams.contains(finalExam) : "Final exam was not added to final exam list";
        Ui.printAddedTaskMessage(finalExam);
        logger.log(Level.FINE, "final exam successfully added");
    }

    public static String printAndGetModule() {
        Ui.printModuleList();
        try {
            int moduleNumber = Integer.parseInt(Ui.readCommand());
            String module = ModuleInfo.modules.get(moduleNumber - 1).getName();
            return module;
        } catch (IndexOutOfBoundsException e) {
            logger.log(Level.WARNING, "IndexOutOfBoundsException, number is out of range of task list");
            Ui.printModuleNumberDoesNotExistMessage();
        } catch (NumberFormatException e) {
            logger.log(Level.WARNING, "NumberFormatException, user input was not a number");
            Ui.printModuleNumberDoesNotExistMessage();
        }
        String input = Ui.readCommand();
        while (!input.equalsIgnoreCase("Y")) {
            if (input.equalsIgnoreCase("N")) {
                return "";
            }
            System.out.println("Invalid input! Please input Y or N.");
            input = Ui.readCommand();
        }
        ModuleInfo.addNewModule();
        String module = ModuleInfo.modules.get(ModuleInfo.modules.size() - 1).getName();
        logger.log(Level.INFO, "module successfully added");
        return module;
    }

    public static String getTime(int taskNumber) {
        while (true) {
            try {
                Ui.printAddTaskTimeMessage(taskNumber);
                String time = validTime(Ui.readCommand());
                assert !time.isBlank() : "Time field cannot be empty";
                return time;
            } catch (DateTimeParseException e) {
                logger.log(Level.WARNING, "DateTimeParseException, time format is not valid");
                Ui.printInvalidTimeFormat();
            }
        }
    }

    public static String getDate(int taskNumber) {
        while (true) {
            try {
                Ui.printAddTaskDateMessage(taskNumber);
                String date = validDate(Ui.readCommand());
                assert !date.isBlank() : "Date field cannot be empty";
                return date;
            } catch (DateTimeParseException e) {
                logger.log(Level.WARNING, "DateTimeParseException, date format is not valid");
                Ui.printInvalidDateFormat();
            }
        }
    }

    public static String validTime(String time) throws DateTimeParseException {
        LocalTime taskTime = LocalTime.parse(time);
        String formattedTime = taskTime.format(DateTimeFormatter.ofPattern("hh:mm a"));
        return formattedTime;
    }

    public static String validDate(String date) throws DateTimeParseException {
        LocalDate taskDate = LocalDate.parse(date);
        String formattedDate = taskDate.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
        return formattedDate;
    }
}
