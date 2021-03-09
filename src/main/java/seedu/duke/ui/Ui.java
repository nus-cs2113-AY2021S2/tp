package seedu.duke.ui;

import java.io.PrintStream;

import static seedu.duke.messages.Messages.WELCOME_MESSAGE;

public class Ui {
    private static final PrintStream out = System.out;

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
}
