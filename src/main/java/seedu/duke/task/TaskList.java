package seedu.duke.task;

import seedu.duke.ModuleInfo;
import seedu.duke.Ui;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;

//@@author hazelhedmine-reused
//Reused from https://github.com/hazelhedmine/ip/blob/master/src/main/java/duke/task/TaskList.java
//with modifications and additional methods
public class TaskList {

    public static ArrayList<Task> tasks;
    public static ArrayList<Assignment> assignments;
    public static ArrayList<Midterm> midterms;
    public static ArrayList<FinalExam> finalExams;
    public static HashMap<String, ArrayList<Task>> pinnedTasks;

    /**
     * Constructs tasklist.
     */
    public TaskList() {
        tasks = new ArrayList<>();
        assignments = new ArrayList<>();
        midterms = new ArrayList<>();
        finalExams = new ArrayList<>();
        pinnedTasks = new HashMap<>();
    }

    public static void addNewTask(int taskTypeNumber) {
        String dateAndTime = "";

        if (ModuleInfo.modules.isEmpty()) {
            Ui.printNoModulesMessage();
            return;
        }

        Ui.printAddTaskModuleMessage(taskTypeNumber);
        String module = getModule();
        Ui.printHorizontalLine();
        Ui.printAddTaskDescriptionMessage(taskTypeNumber);
        String description = Ui.readCommand();
        Ui.printHorizontalLine();
        if (taskTypeNumber != 1) {
            dateAndTime = TaskList.getDate(taskTypeNumber) + ", " + TaskList.getTime(taskTypeNumber);
        }
        Ui.printAddMessageAfterCompletedTask();
        String message = Ui.readCommand();
        Ui.printHorizontalLine();

        switch (taskTypeNumber) {
        case 1:
            addTask(module, description, message);
            break;
        case 2:
            addAssignment(module, description, message, dateAndTime);
            break;
        case 3:
            addMidterm(module, description, message, dateAndTime);
            break;
        case 4:
            addFinal(module, description, message, dateAndTime);
            break;
        default:
            Ui.printInvalidIntegerMessage();
        }
    }

    private static void addTask(String module, String description, String message) {
        Task task = new Task(module, description, message);
        tasks.add(task);
        Ui.printAddedTaskMessage(task);
    }

    private static void addAssignment(String module, String description,
                                     String message, String dateAndTime) {
        Assignment assignment = new Assignment(module, description, message, dateAndTime);
        assignments.add(assignment);
        Ui.printAddedTaskMessage(assignment);
    }

    private static void addMidterm(String module, String description,
                                  String message, String dateAndTime) {
        Midterm midterm = new Midterm(module, description, message, dateAndTime);
        midterms.add(midterm);
        Ui.printAddedTaskMessage(midterm);
    }

    private static void addFinal(String module, String description,
                                String message, String dateAndTime) {
        FinalExam finalExam = new FinalExam(module, description, message, dateAndTime);
        finalExams.add(finalExam);
        Ui.printAddedTaskMessage(finalExam);
    }

    public static String getModule() {
        for (int i = 1; i <= ModuleInfo.modules.size(); ++i) {
            System.out.println("[" + i + "] " + ModuleInfo.modules.get(i - 1).getName());
        }
        int moduleNumber = Integer.parseInt(Ui.readCommand());
        String module = ModuleInfo.modules.get(moduleNumber - 1).getName();

        return module;
    }

    public static String getTime(int taskNumber) {
        while (true) {
            try {
                Ui.printAddTaskTimeMessage(taskNumber);
                String time = validTime(Ui.readCommand());
                assert !time.isBlank() : "Time field cannot be empty";
                Ui.printHorizontalLine();
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
                Ui.printHorizontalLine();
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

    public static void markOrUnmarkTask(int taskTypeNumber) {
        if (taskListIsEmpty(taskTypeNumber)) {
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
                    toggleTaskStatus(taskNumber);
                    break;
                case 2:
                    toggleAssigmentStatus(taskNumber);
                    break;
                case 3:
                    toggleMidtermStatus(taskNumber);
                    break;
                case 4:
                    toggleFinalExamStatus(taskNumber);
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

    public static void deleteTask(int taskTypeNumber) {
        if (taskListIsEmpty(taskTypeNumber)) {
            Ui.printTaskListIsEmptyMessage();
            return;
        }
        Ui.printSelectTaskNumberToDelete(taskTypeNumber);
        while (true) {
            try {
                int taskNumber = Integer.parseInt(Ui.readCommand());
                Ui.printHorizontalLine();
                switch (taskTypeNumber) {
                case 1:
                    findAndDeleteTask(taskNumber);
                    break;
                case 2:
                    findAndDeleteAssigment(taskNumber);
                    break;
                case 3:
                    findAndDeleteMidterm(taskNumber);
                    break;
                case 4:
                    findAndDeleteFinalExam(taskNumber);
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

    private static boolean taskListIsEmpty(int taskTypeNumber) {
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

    private static void toggleTaskStatus(int taskNumber) {
        Task task = tasks.get(taskNumber - 1);
        String taskStatus = task.getStatus();
        String done = "[DONE] ";
        String notDone = "[    ] ";
        if (taskStatus.equals(done)) {
            Ui.printTaskisDoneMessage();
            String input = Ui.readCommand().trim();
            if (input.equals("Y")) {
                task.markAsUnDone();
                Ui.printUnmarkedTaskMessage(task);
            }
        } else if (taskStatus.equals(notDone)) {
            Ui.printTaskisNotDoneMessage();
            String input = Ui.readCommand().trim();
            if (input.equals("Y")) {
                task.markAsDone();
                Ui.printMarkedTaskMessage(task);
            }
        }
    }

    private static void toggleAssigmentStatus(int taskNumber) {
        Assignment task = assignments.get(taskNumber - 1);
        String taskStatus = task.getStatus();
        String done = "[DONE] ";
        String notDone = "[    ] ";
        if (taskStatus.equals(done)) {
            Ui.printTaskisDoneMessage();
            String input = Ui.readCommand().trim();
            if (input.equals("Y")) {
                task.markAsUnDone();
                Ui.printUnmarkedTaskMessage(task);
            }
        } else if (taskStatus.equals(notDone)) {
            Ui.printTaskisNotDoneMessage();
            String input = Ui.readCommand().trim();
            if (input.equals("Y")) {
                task.markAsDone();
                Ui.printMarkedTaskMessage(task);
            }
        }
    }

    private static void toggleMidtermStatus(int taskNumber) {
        Midterm task = midterms.get(taskNumber - 1);
        String taskStatus = task.getStatus();
        String done = "[DONE] ";
        String notDone = "[    ] ";
        if (taskStatus.equals(done)) {
            Ui.printTaskisDoneMessage();
            String input = Ui.readCommand().trim();
            if (input.equals("Y")) {
                task.markAsUnDone();
                Ui.printUnmarkedTaskMessage(task);
            }
        } else if (taskStatus.equals(notDone)) {
            Ui.printTaskisNotDoneMessage();
            String input = Ui.readCommand().trim();
            if (input.equals("Y")) {
                task.markAsDone();
                Ui.printMarkedTaskMessage(task);
            }
        }
    }

    private static void toggleFinalExamStatus(int taskNumber) {
        FinalExam task = finalExams.get(taskNumber - 1);
        String taskStatus = task.getStatus();
        String done = "[DONE] ";
        String notDone = "[    ] ";
        if (taskStatus.equals(done)) {
            Ui.printTaskisDoneMessage();
            String input = Ui.readCommand().trim();
            if (input.equals("Y")) {
                task.markAsUnDone();
                Ui.printUnmarkedTaskMessage(task);
            }
        } else if (taskStatus.equals(notDone)) {
            Ui.printTaskisNotDoneMessage();
            String input = Ui.readCommand().trim();
            if (input.equals("Y")) {
                task.markAsDone();
                Ui.printMarkedTaskMessage(task);
            }
        }
    }

    private static void findAndDeleteTask(int taskNumber) {
        Task deletedTask = tasks.get(taskNumber - 1);
        tasks.remove(deletedTask);
        boolean typeTaskIsPinned = pinnedTasks.containsKey("[Task]");
        if (typeTaskIsPinned) {
            if (pinnedTasks.get("[Task]").contains((deletedTask))) {
                pinnedTasks.get("[Task]").remove(deletedTask);
            }
        }
        Ui.printDeletedTaskMessage(deletedTask);
    }

    private static void findAndDeleteAssigment(int taskNumber) {
        Assignment deletedAssignment = assignments.get(taskNumber - 1);
        assignments.remove(deletedAssignment);
        if (pinnedTasks.get("[Assignment]").contains((deletedAssignment))) {
            pinnedTasks.get("[Assignment]").remove(deletedAssignment);
        }
        Ui.printDeletedTaskMessage(deletedAssignment);
    }

    private static void findAndDeleteMidterm(int taskNumber) {
        Midterm deletedMidterm = midterms.get(taskNumber - 1);
        midterms.remove(deletedMidterm);
        if (pinnedTasks.get("[Midterm]").contains((deletedMidterm))) {
            pinnedTasks.get("[Midterm]").remove(deletedMidterm);
        }
        Ui.printDeletedTaskMessage(deletedMidterm);
    }

    private static void findAndDeleteFinalExam(int taskNumber) {
        FinalExam deletedFinalExam = finalExams.get(taskNumber - 1);
        finalExams.remove(deletedFinalExam);
        if (pinnedTasks.get("[Final Exam]").contains((deletedFinalExam))) {
            pinnedTasks.get("[Final Exam]").remove(deletedFinalExam);
        }
        Ui.printDeletedTaskMessage(deletedFinalExam);
    }

    public static void pinTask(int taskTypeNumber) {
        if (taskListIsEmpty(taskTypeNumber)) {
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
                    addTaskToPinnedTasks(tasks.get(taskNumber - 1), "[Task]");
                    break;
                case 2:
                    addTaskToPinnedTasks(assignments.get(taskNumber - 1), "[Assignment]");
                    break;
                case 3:
                    addTaskToPinnedTasks(midterms.get(taskNumber - 1), "[Midterm]");
                    break;
                case 4:
                    addTaskToPinnedTasks(finalExams.get(taskNumber - 1), "[Final Exam]");
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

    private static void addTaskToPinnedTasks(Task task, String taskTypeName) {
        pinnedTasks.computeIfAbsent(taskTypeName, k -> new ArrayList<>());
        if (pinnedTasks.get(taskTypeName).contains((task))) {
            Ui.printTaskAlreadyPinnedMessage();
            return;
        }
        pinnedTasks.get(taskTypeName).add(task);
        Ui.printPinnedTaskMessage(task);
        return;
    }

}
