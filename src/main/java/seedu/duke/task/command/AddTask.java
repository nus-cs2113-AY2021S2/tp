package seedu.duke.task.command;

import seedu.duke.ModuleInfo;
import seedu.duke.Ui;
import seedu.duke.task.Assignment;
import seedu.duke.task.FinalExam;
import seedu.duke.task.Midterm;
import seedu.duke.task.Task;
import seedu.duke.task.TaskManager;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AddTask {

    private static final int ADD_TASK_COMMAND = 1;
    private static final int ADD_ASSIGNMENT_COMMAND = 2;
    private static final int ADD_MIDTERM_COMMAND = 3;
    private static final int ADD_FINAL_EXAM_COMMAND = 4;
    private static final String EMPTY_STRING = "";

    public static void execute(int taskTypeNumber) {
        String dateAndTime = EMPTY_STRING;

        if (ModuleInfo.modules.isEmpty()) {
            Ui.printNoModulesMessage();
            return;
        }

        Ui.printAddTaskModuleMessage(taskTypeNumber);
        String module = printAndGetModule();
        if (module.equals("")) {
            return;
        }
        Ui.printAddTaskDescriptionMessage(taskTypeNumber);
        String description = Ui.readCommand();
        if (taskTypeNumber != 1) {
            dateAndTime = getDate(taskTypeNumber) + ", " + getTime(taskTypeNumber);
        }
        Ui.printAddMessageAfterCompletedTask();
        String message = Ui.readCommand();

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
            Ui.printInvalidIntegerMessage();
        }
    }

    public static void addTask(String module, String description, String message) {
        Task task = new Task(module, description, message);
        TaskManager.tasks.add(task);
        assert TaskManager.tasks.contains(task) : "Task was not added to task list";
        Ui.printAddedTaskMessage(task);
    }

    public static void addAssignment(String module, String description,
                                     String message, String dateAndTime) {
        Assignment assignment = new Assignment(module, description, message, dateAndTime);
        TaskManager.assignments.add(assignment);
        assert TaskManager.assignments.contains(assignment) : "Assignment was not added to assignment list";
        Ui.printAddedTaskMessage(assignment);
    }

    public static void addMidterm(String module, String description,
                                  String message, String dateAndTime) {
        Midterm midterm = new Midterm(module, description, message, dateAndTime);
        TaskManager.midterms.add(midterm);
        assert TaskManager.midterms.contains(midterm) : "Midterm was not added to midterm list";
        Ui.printAddedTaskMessage(midterm);
    }

    public static void addFinalExam(String module, String description,
                                    String message, String dateAndTime) {
        FinalExam finalExam = new FinalExam(module, description, message, dateAndTime);
        TaskManager.finalExams.add(finalExam);
        assert TaskManager.finalExams.contains(finalExam) : "Final exam was not added to final exam list";
        Ui.printAddedTaskMessage(finalExam);
    }

    public static String printAndGetModule() {
        Ui.printModuleList();
        try {
            int moduleNumber = Integer.parseInt(Ui.readCommand());
            String module = ModuleInfo.modules.get(moduleNumber - 1).getName();
            return module;
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            Ui.printModuleNumberDoesNotExistMessage();
        }
        String input = Ui.readCommand().trim();
        if (input.equalsIgnoreCase("N")) {
            return "";
        }
        ModuleInfo.addNewModule();
        String module = ModuleInfo.modules.get(ModuleInfo.modules.size() - 1).getName();
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
                Ui.printInvalidTimeFormat();
            }
        }
    }

    public static String getDate(int taskNumber) {
        while (true) {
            try {
                Ui.printAddTaskDateMessage(taskNumber);
                String date = validDate(Ui.readCommand());
                assert !date.isBlank() : "Time field cannot be empty";
                return date;
            } catch (DateTimeParseException e) {
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
