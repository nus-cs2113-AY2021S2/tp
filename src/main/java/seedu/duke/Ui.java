package seedu.duke;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Deals with all interactions with the user.
 */
public class Ui {

    public static void printWelcomeMessage() {
        System.out.println("Hello from\n" + " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n");

    }

    public static void printHorizontalLine() {
        System.out.println("--------------------------------------------");
    }

    public static void printMainMenu() {
        System.out.println("Main Menu:\n"
            + "[1] Module Information\n"
            + "[2] CAP Simulator/Calculator\n"
            + "[3] Task Manager\n"
            + "[4] External Links");
    }

    public static void printLinksMessage() {
        System.out.println("Welcome to the links menu ^~^\n"
            + "Please choose which action you would like to do and enter the number:\n"
            + "[1] --- External links menu\n"
            + "[3] --- View Zoom links\n"
            + "[4] --- Exit to main menu\n");
    }

    public static void printAddTaskMenu() {
        System.out.println("Welcome to the tasks menu ^o^\n"
                + "Please choose which type of task you would like to add and enter the number:\n"
                + "[1] --- Task\n"
                + "[2] --- Assignment\n"
                + "[3] --- Midterm\n"
                + "[4] --- Final Exam");
    }

    public static void printAddTaskModuleMessage(int taskType) {
        if (taskType == 1) {
            System.out.println("What is the module of the task you want to add?");
        } else if (taskType == 2) {
            System.out.println("What is the module of the assignment you want to add?");
        } else if (taskType == 3) {
            System.out.println("What is the module of the midterm you want to add?");
        } else {
            System.out.println("What is the module of the final exam you want to add?");
        }
    }

    public static void printAddTaskDescriptionMessage(int taskType) {
        if (taskType == 1) {
            System.out.println("What is the description of the task you want to add?");
        } else if (taskType == 2) {
            System.out.println("What is the description of the assignment you want to add?");
        } else if (taskType == 3) {
            System.out.println("What is the description of the midterm you want to add?");
        } else {
            System.out.println("What is the description of the final exam you want to add?");
        }
    }

    public static void printAddTaskDateMessage(int taskType) {
        if (taskType == 2) {
            System.out.println("What is the date of the assignment you want to add?");
        } else if (taskType == 3) {
            System.out.println("What is the date of the midterm you want to add?");
        } else {
            System.out.println("What is the date of the final exam you want to add?");
        }
    }

    public static void printAddTaskTimeMessage(int taskType) {
        if (taskType == 2) {
            System.out.println("What is the time of the assignment you want to add?");
        } else if (taskType == 3) {
            System.out.println("What is the time of the midterm you want to add?");
        } else {
            System.out.println("What is the time of the final exam you want to add?");
        }
    }

    public static void printInvalidIntegerMessage() {
        System.out.println("Please enter a valid integer from the menu.");
    }

    public static void printInvalidTimeFormat() {
        System.out.println("Please enter a valid time format.");
    }

    public static void printInvalidDateFormat() {
        System.out.println("Please enter a valid date format.");
    }

    public static void printAddedTaskMessage(Task task) {
        System.out.println("You've added this: " + task.toString());
        System.out.println("Returning back to ModuleInfo menu now!");
        printHorizontalLine();
    }

    public static String readCommand() {
        String command;
        Scanner input = new Scanner(System.in);
        command = input.nextLine();
        return command;
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
