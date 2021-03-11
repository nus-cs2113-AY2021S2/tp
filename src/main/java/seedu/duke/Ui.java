package seedu.duke;

import java.util.ArrayList;
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
            + "[2] --- View Zoom links\n"
            + "[3] --- Exit to main menu\n");
    }

    public static void printLinkToDelete() {
        System.out
            .println("Please choose which link you would like to delete and enter the number\n"
                + "Please choose which action you would like to do and enter the number:\n"
                + "[1] --- External links menu\n"
                + "[3] --- View Zoom links\n"
                + "[4] --- Exit to main menu\n");
    }

    public static void printModuleInfoMessage() {
        System.out.println("Welcome to the module information menu ^~^\n"
            + "Please choose which action you would like to do and enter the number:\n"
            + "[1] --- Add/View Module Description\n"
            + "[2] --- Add/View Components and Their Weightages\n"
            + "[3] --- Add Zoom Links\n"
            + "[4] --- Add a New Task\n"
            + "[5] --- Add a Review\n"
            + "[6] --- View All Reviews\n"
            + "[7] --- Delete modules\n"
            + "[8] --- Delete tasks\n"
            + "[9] --- Exit to main menu\n");
    }

    public static void printAddTaskMenu() {
        System.out.println("Welcome to the tasks menu ^o^\n"
            + "Please choose which type of task you would like to add and enter the number:\n"
            + "[1] --- Task\n"
            + "[2] --- Assignment\n"
            + "[3] --- Midterm\n"
            + "[4] --- Final Exam");
    }

    public static void printDeleteTaskMenu() {
        System.out.println(
            "Please choose which type of task you would like to delete and enter the number:\n"
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

    public static void printAddMessageAfterCompletedTask() {
        System.out.println("What is the message you would like to see after completing this?");
    }

    public static void printAddedTaskMessage(Task task) {
        System.out.println("You've added this: " + task.toString());
        System.out.println("Returning back to ModuleInfo menu now!");
        printHorizontalLine();
    }

    public static void printDeletedTaskMessage(Task task) {
        System.out.println("You've deleted this: " + task.toString());
        System.out.println("NOTE: " + task.getMessage());
        System.out.println("Returning back to ModuleInfo menu now!");
        printHorizontalLine();
    }

    public static void printDeletedModuleMessage(Module module) {
        System.out.println("You've deleted this: " + module.getName());
        System.out.println("NOTE: You are deleting your review\n"
            + module.getReview() + "\n"
            + "NOTE: You are deleting your module description\n"
            + module.getDescription());
        System.out.println("Returning back to ModuleInfo menu now!");
        printHorizontalLine();
    }

    public static void printSelectModuleToDeleteMessage() {
        System.out.println("Enter the module number to be deleted:");
    }

    public static void printSelectTaskNumberToDeleteMessage() {
        System.out.println("\nWhat is the number of the task you want to delete?");
    }

    public static void printTaskListIsEmptyMessage() {
        System.out.println("Task list is empty, there are no tasks to delete!");
        System.out.println("Returning back to ModuleInfo menu now!");
        printHorizontalLine();
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

    public static void printInvalidTaskNumberMessage() {
        System.out.println("Please input a valid task number.");
    }

    public static String readCommand() {
        String command;
        Scanner input = new Scanner(System.in);
        command = input.nextLine();
        return command;
    }

    public static void printLinks(ArrayList<String> linksList) {
        int sizeOfList = 1;
        System.out.println("These are the links you have added --->");
        for (String link : linksList) {
            System.out.println("[" + (sizeOfList++) + "] --- " + link);
        }
        System.out.print("\n");
    }

    public static void printExternalLinksMessage() {
        System.out.println("Welcome to the external links menu!\n"
            + "Please choose which action you would like to do and enter the number:\n"
            + "[1] --- add link\n"
            + "[2] --- remove link\n"
            + "[3] --- view links\n"
            + "[4] --- exit to links menu\n");
    }

    public static int readCommandToInt() {
        int command;
        Scanner input = new Scanner(System.in);
        try {
            command = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
        return command;

    }

    public static void printAddLinkMessage(String description) {
        System.out.println("Alright! I have added the following link ---  " + description + "\n");
    }

    public static void printEnterLinkMessage() {
        System.out.println("Please enter the link in this format:\n"
            + "<scheme>www.<domain name>.<TLD>/<path name>\n"
            + "supported schemes: https, http for now... Sorry!\n"
            + "supported TLD: .com, .org for now... we will work on it!\n");
    }

    public static void printInvalidLinkMessage() {
        System.out.println("Oh no... That was an invalid link *sobs...*\n"
            + "Please enter a valid one!");

    }

    public static void printListIsEmpty() {
        System.out.println("No links have been added... Please add one!");
    }
}
