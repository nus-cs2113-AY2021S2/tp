package seedu.connoisseur.ui;

import java.io.PrintStream;
import java.util.Scanner;

import static seedu.connoisseur.messages.Messages.WELCOME_MESSAGE;
import static seedu.connoisseur.messages.Messages.HELP_MESSAGE;
import static seedu.connoisseur.messages.Messages.EXIT_MESSAGE;
import static seedu.connoisseur.messages.Messages.ERROR_MESSAGE;
import static seedu.connoisseur.messages.Messages.FILE_ALREADY_EXISTS;
import static seedu.connoisseur.messages.Messages.FOLDER_ALREADY_EXISTS;
import static seedu.connoisseur.messages.Messages.FOLDER_SUCCESS;

public class Ui {
    private static final PrintStream out = System.out;
    private final Scanner in;

    public Ui() {
        this.in = new Scanner(System.in);
    }

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
     * @param message lines to be printed, separated by commas
     */
    public static void printToScreen(String... message) {
        for (String m : message) {
            out.println(m);
        }
    }

    public static void printHelpMessage() {
        printToScreen(HELP_MESSAGE);
    }

    public static void printExitMessage() {
        printToScreen(EXIT_MESSAGE);
    }

    public static void printErrorMessage() {
        printToScreen(ERROR_MESSAGE);
    }

    public static void printFileExistsMessage() {
        printToScreen(FILE_ALREADY_EXISTS);
    }

    public static void printFolderExistsMessage() {
        printToScreen(FOLDER_ALREADY_EXISTS);
    }

    public static void printSuccessfulCreateFolderMessage() {
        printToScreen(FOLDER_SUCCESS);
    }

    public static void printPresentDirectory() {
    }

}
