package seedu.connoisseur.ui;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import static seedu.connoisseur.messages.Messages.WELCOME_MESSAGE;
import static seedu.connoisseur.messages.Messages.HELP_MESSAGE;
import static seedu.connoisseur.messages.Messages.EXIT_MESSAGE;
import static seedu.connoisseur.messages.Messages.ERROR_MESSAGE;
import static seedu.connoisseur.messages.Messages.FILE_ALREADY_EXISTS;

public class Ui {
    private static final PrintStream out = System.out;
    private static final PrintStream logPrintStream = System.out;
    private static final int MAX_WHITE_SPACE = 15;
    private final Scanner in;
    private final boolean showLogs;

    /**
     * Constructor for Ui class.
     */
    public Ui(boolean showLogs) {
        this.in = new Scanner(System.in);
        this.showLogs = showLogs;
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
    public void printGreeting() {
        println(WELCOME_MESSAGE);
    }

    /**
     * Prints header for list command. 
     */
    public void printListHeading() {
        println("Here are your reviews: ");
        println("    Title          Category       Rating         Date");
    }
    
    /**
     * Prints whitespace to align items to header. 
     * @param wordLength length of word to subtract
     */
    public void printWhiteSpace(int wordLength) {
        int numOfSpaces = MAX_WHITE_SPACE - wordLength;
        while (numOfSpaces > 0) {
            out.print(" ");
            numOfSpaces--;
        }
    }

    /**
     * Prints an array of Strings to the output stream.
     *
     * @param message array of strings to be printed
     */
    public void println(String... message) {
        for (String m : message) {
            out.println(m);
        }
    }

    /**
     * Prints a message to the output stream without a newline ending. 
     * @param message string to be printed
     */
    public void print(String message) {
        out.print(message);
    }

    /**
     * Prints log messages. 
     * @param message log message to be printed
     */
    public void printLog(String... message) {
        if (showLogs) {
            for (String m : message) {
                logPrintStream.println(m);
            }
        }
    }

    /**
     * Prints help message.
     */
    public void printHelpMessage() {
        println(HELP_MESSAGE);
    }

    /**
     * Prints exit message.
     */
    public void printExitMessage() {
        println(EXIT_MESSAGE);
    }

    /**
     * Prints error message.
     *
     * @param e error encountered
     */
    public void printErrorMessage(IOException e) {
        println(ERROR_MESSAGE);
        e.printStackTrace();
    }

    /**
     * Prints file exists message.
     */
    public void printFileExistsMessage() {
        printLog(FILE_ALREADY_EXISTS);
    }
}
