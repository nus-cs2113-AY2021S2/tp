package seedu.duke;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;

//@@author hazelhedmine-reused
//Reused from https://github.com/hazelhedmine/ip/blob/master/src/main/java/duke/task/TaskList.java
//with modifications
public class TaskList {

    private static ArrayList<Task> tasks;
    private static ArrayList<Assignment> assignments;
    private static ArrayList<Midterm> midterms;
    private static ArrayList<FinalExam> finalExams;

    /**
     * Constructs tasklist.
     */
    public TaskList() {
        tasks = new ArrayList<>();
        assignments = new ArrayList<>();
        midterms = new ArrayList<>();
        finalExams = new ArrayList<>();
    }

    public static void addTask(String module, String description) {
        Task task = new Task(module, description);
        tasks.add(task);
        Ui.printAddedTaskMessage(task);
    }

    public static void addAssignment(String module, String description, String dateAndTime) {
        Assignment assignment = new Assignment(module, description, dateAndTime);
        assignments.add(assignment);
        Ui.printAddedTaskMessage(assignment);
    }

    public static void addMidterm(String module, String description, String dateAndTime) {
        Midterm midterm = new Midterm(module, description, dateAndTime);
        midterms.add(midterm);
        Ui.printAddedTaskMessage(midterm);
    }

    public static void addFinal(String module, String description, String dateAndTime) {
        FinalExam finalExam = new FinalExam(module, description, dateAndTime);
        finalExams.add(finalExam);
        Ui.printAddedTaskMessage(finalExam);
    }

    static String getTime(int taskNumber) {
        while (true) {
            try {
                Ui.printAddTaskTimeMessage(taskNumber);
                String time = Ui.validTime(Ui.readCommand());
                Ui.printHorizontalLine();
                return time;
            } catch (DateTimeParseException e) {
                Ui.printInvalidTimeFormat();
            }
        }
    }

    static String getDate(int taskNumber) {
        while (true) {
            try {
                Ui.printAddTaskDateMessage(taskNumber);
                String date = Ui.validDate(Ui.readCommand());
                Ui.printHorizontalLine();
                return date;
            } catch (DateTimeParseException e) {
                Ui.printInvalidDateFormat();
            }
        }
    }

    static boolean isValidTaskType(String command) {
        try {
            int taskNumber = Integer.parseInt(command);
            boolean isInvalidTaskType = (taskNumber <= 0) || (taskNumber >= 5);
            if (!isInvalidTaskType) {
                return true;
            }
            System.out.println("Please enter a valid integer from the list.");
        } catch (NumberFormatException n) {
            System.out.println("Error! Enter an integer.");
        }
        return false;
    }

    static int getTaskNumber() {
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
}
