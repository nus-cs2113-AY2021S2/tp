package seedu.duke;

import seedu.duke.exception.InvalidInputException;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class handles all UI-related functions.
 */
public class Ui {
    private Scanner userInputScanner;

    /**
     * Initialize a UI handler.
     */
    public Ui() {
        userInputScanner = new Scanner(System.in);
    }

    /**
     * Returns user input as a String.
     *
     * @return user input
     */
    public String readInput() throws InvalidInputException {
        String userInput = null;
        try {
            userInput = userInputScanner.nextLine();
        } catch (NoSuchElementException noSuchElementException) {
            throw new InvalidInputException(InvalidInputException.Type.END_OF_FILE, noSuchElementException);
        }
        return userInput;
    }

    /**
     * Closes scanner.
     */
    public void closeScanner() {
        userInputScanner.close();
    }

    /**
     * Prints the String specified in @param.
     *
     * @param message String to be printed
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Prints a welcome message.
     */
    public void printWelcome() {
        printMessage(Constants.WELCOME_MESSAGE);
        printMessage(Constants.INPUT_PROMPT);
    }

    /**
     * Prints a detailed error message for the exception specified in @param.
     *
     * @param exception Exception to be printed
     */
    public void printException(Exception exception) {
        String exceptionMessage = exception.getMessage();
        String[] messageLines = exceptionMessage.split("\n");
        for (String line : messageLines) {
            printMessage(line);
        }
    }

    /**
     * This prints a long breaking line to separate user input and command outputs.
     */
    public void printLine() {
        printMessage(Constants.LONG_LINE);
    }
}
