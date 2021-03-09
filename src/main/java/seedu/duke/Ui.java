package seedu.duke;

import java.util.ArrayList;
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
            + "[2] --- View Zoom links\n"
            + "[3] --- Exit to main menu\n"
            + "Press enter to return back to the main menu");
    }

    public static void printLinkToDelete() {
        System.out
            .println("Please choose which link you would like to delete and enter the number");
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
            + "[4] --- exit to links menu\n"
            + "Press enter to return back to the main menu");
    }

    public static void printNextLinkMessage() {
        System.out.println("What would you like to do next?\n"
            + "[1] --- add link\n"
            + "[2] --- remove link\n"
            + "[3] --- view links\n"
            + "[4] --- exit to links menu\n"
            + "Press enter to return back to the main menu");
    }

    public static void printAddLinkMessage(String description) {
        System.out.println("Alright! I have added the following link ---  " + description + "\n");
    }

    public static void printEnterLinkMessage() {
        System.out.println("Please enter the link below :)");
    }

    public static void printInvalidLinkMessage() {
        System.out.println("Oh no... That was an invalid link\n"
            + "Please enter a valid one!");
    }

    public static void printListIsEmpty() {
        System.out.println("No links have been added... Please add one!");
    }
}
