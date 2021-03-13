package seedu.connoisseur.ui;

import java.io.IOException;
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

    public static void printErrorMessage(IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }

    public static void printFileExistsMessage() {
        System.out.println("Text file already exists.");
    }

    public static void printFolderExistsMessage() {
        System.out.println("Folder already exists.");
    }

    public static void printSuccessfulCreateFolderMessage() {
        System.out.println("Folder created successfully.");
    }

    public static void printPresentDirectory() {
        System.out.println("Present project directory is: " + System.getProperty("user.dir"));
    }

}
