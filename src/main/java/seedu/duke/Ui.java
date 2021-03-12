package seedu.duke;

import java.util.Scanner;

/**
 * This class handles all UI-related functions
 */
public class Ui {
    private Scanner userInputScanner;

    /**
     * Initialize a UI handler
     */
    public Ui() {
        userInputScanner = new Scanner(System.in);
    }

    /**
     * Returns user input as a String
     * @return user input
     */
    public String readInput() {
        return userInputScanner.nextLine();
    }

    /**
     * Closes scanner
     */
    public void closeScanner() {
        userInputScanner.close();
    }

    /**
     * Prints the String specified in @param
     * @param printstr String to be printed
     */
    public void printString(String printstr) {
        System.out.println(printstr);
    }

}
