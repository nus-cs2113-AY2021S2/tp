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

    public static void addTask(String module, String description, String message) {
        Task task = new Task(module, description, message);
        tasks.add(task);
        Ui.printAddedTaskMessage(task);
    }

    public static void addAssignment(String module, String description,
                                     String message, String dateAndTime) {
        Assignment assignment = new Assignment(module, description, message, dateAndTime);
        assignments.add(assignment);
        Ui.printAddedTaskMessage(assignment);
    }

    public static void addMidterm(String module, String description,
                                  String message, String dateAndTime) {
        Midterm midterm = new Midterm(module, description, message, dateAndTime);
        midterms.add(midterm);
        Ui.printAddedTaskMessage(midterm);
    }

    public static void addFinal(String module, String description,
                                String message, String dateAndTime) {
        FinalExam finalExam = new FinalExam(module, description, message, dateAndTime);
        finalExams.add(finalExam);
        Ui.printAddedTaskMessage(finalExam);
    }

    public static String getTime(int taskNumber) {
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

    public static String getDate(int taskNumber) {
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

    public static boolean isValidTaskType(String command) {
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

    public static void printSelectTaskNumberToDelete(int taskNumber) {
        switch (taskNumber) {
        case 1:
            printTaskList(tasks);
            break;
        case 2:
            printAssignmentList(assignments);
            break;
        case 3:
            printMidtermList(midterms);
            break;
        case 4:
            printFinalExamList(finalExams);
            break;
        default:
            Ui.printInvalidIntegerMessage();
        }
        Ui.printSelectTaskNumberToDeleteMessage();
    }

    public static void printTaskList(ArrayList<Task> tasks) {
        int taskNumber = 1;
        System.out.println("Here are the tasks in your list:");
        for (Task task: tasks) {
            System.out.println(taskNumber + ". " + task.toString());
        }
    }

    public static void printAssignmentList(ArrayList<Assignment> assignments) {
        int taskNumber = 1;
        System.out.println("Here are the assignments in your list:");
        for (Assignment assignment: assignments) {
            System.out.println(taskNumber + ". " + assignment.toString());
        }
    }

    public static void printMidtermList(ArrayList<Midterm> midterms) {
        int taskNumber = 1;
        System.out.println("Here are the midterms in your list:");
        for (Midterm midterm: midterms) {
            System.out.println(taskNumber + ". " + midterm.toString());
        }
    }

    public static void printFinalExamList(ArrayList<FinalExam> finalExams) {
        int taskNumber = 1;
        System.out.println("Here are the finals in your list:");
        for (FinalExam finalExam: finalExams) {
            System.out.println(taskNumber + ". " + finalExam.toString());
        }
    }

    public static void deleteTask(int taskTypeNumber) {
        if (taskListIsEmpty(taskTypeNumber)) {
            Ui.printTaskListIsEmptyMessage();
            return;
        }
        printSelectTaskNumberToDelete(taskTypeNumber);
        while (true) {
            try {
                int taskNumber = Integer.parseInt(Ui.readCommand());
                Ui.printHorizontalLine();
                switch (taskTypeNumber) {
                case 1:
                    Task deletedTask = tasks.get(taskNumber - 1);
                    tasks.remove(deletedTask);
                    Ui.printDeletedTaskMessage(deletedTask);
                    break;
                case 2:
                    Assignment deletedAssignment = assignments.get(taskNumber - 1);
                    assignments.remove(deletedAssignment);
                    Ui.printDeletedTaskMessage(deletedAssignment);
                    break;
                case 3:
                    Midterm deletedMidterm = midterms.get(taskNumber - 1);
                    midterms.remove(deletedMidterm);
                    Ui.printDeletedTaskMessage(deletedMidterm);
                    break;
                case 4:
                    FinalExam deletedFinalExam = finalExams.get(taskNumber - 1);
                    finalExams.remove(deletedFinalExam);
                    Ui.printDeletedTaskMessage(deletedFinalExam);
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
}
