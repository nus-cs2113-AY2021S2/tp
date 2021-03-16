package seedu.connoisseur.ui;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import static seedu.connoisseur.messages.Messages.WELCOME_MESSAGE;
import static seedu.connoisseur.messages.Messages.HELP_MESSAGE;
import static seedu.connoisseur.messages.Messages.EXIT_MESSAGE;
import static seedu.connoisseur.messages.Messages.ERROR_MESSAGE;
import static seedu.connoisseur.messages.Messages.FILE_ALREADY_EXISTS;
import static seedu.connoisseur.messages.Messages.FOLDER_ALREADY_EXISTS;
import static seedu.connoisseur.messages.Messages.FOLDER_SUCCESS;
import static seedu.connoisseur.messages.Messages.CURRENT_DIRECTORY;

public class Ui {
    private static final PrintStream out = System.out;
    private final Scanner in;

    /**
     * Constructor for Ui class.
     */
    public Ui() {
        this.in = new Scanner(System.in);
    }

    /**
     * Reads user input.
     *
     * @return the input line as a string
     */
    public String readCommand() {
        return in.nextLine();
    }

    /**
     * Prints the welcome message to the printstream.
     */
    public static void printGreeting() {
        printToScreen(WELCOME_MESSAGE);
    }

    /**
     * Prints an array of Strings to the output stream.
     *
     * @param message lines to be printed, separated by commas
     */
    public static void printToScreen(String... message) {
        for (String m : message) {
            out.println(m);
        }
    }

    /**
     * Prints help message.
     */
    public static void printHelpMessage() {
        printToScreen(HELP_MESSAGE);
    }

    /**
     * Prints exit message.
     */
    public static void printExitMessage() {
        printToScreen(EXIT_MESSAGE);
    }

    /**
     * Prints error message.
     *
     * @param e error encountered
     */
    public static void printErrorMessage(IOException e) {
        printToScreen(ERROR_MESSAGE);
        e.printStackTrace();
    }

    /**
     * Prints file exists message.
     */
    public static void printFileExistsMessage() {
        printToScreen(FILE_ALREADY_EXISTS);
    }

    /**
     * Prints folder exists message.
     */
    public static void printFolderExistsMessage() {
        printToScreen(FOLDER_ALREADY_EXISTS);
    }

    /**
     * Prints folder created message.
     */
    public static void printSuccessfulCreateFolderMessage() {
        printToScreen(FOLDER_SUCCESS);
    }

    /**
     * Prints current directory.
     */
    public static void printPresentDirectory() {
        printToScreen(CURRENT_DIRECTORY);
    }

    public static void printDetermineReviewTypeMessage(String reviewType) {
        if (reviewType.equals("quick")) {
            System.out.print("Quick Review Select\n" +
                    "Please enter Category, Title, Rating/5\n");
        } else if (reviewType.equals("long")) {
            System.out.print("Long Review Select\n" +
                    "Please enter Category, Title, Rating/5, Details\n");
        }
    }


}
