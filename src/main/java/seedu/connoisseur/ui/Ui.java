package seedu.connoisseur.ui;

import java.io.PrintStream;
import java.util.Scanner;

import static seedu.connoisseur.messages.Messages.WELCOME_MESSAGE;

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
    }

    public static void printExitMessage() {
    }

    public static void printErrorMessage() {
    }

    public static void printFileExistsMessage() {
    }

    public static void printFolderExistsMessage() {
    }

    public static void printSuccessfulCreateFolderMessage() {
    }

    public static void printPresentDirectory() {
    }

}
