package seedu.duke;

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

    public static void printInvalidIntegerMessage() {
        System.out.println("Please enter a valid integer from the menu.");
    }

    public static String readCommand() {
        String command;
        Scanner input = new Scanner(System.in);
        command = input.nextLine();
        return command;
    }

}
