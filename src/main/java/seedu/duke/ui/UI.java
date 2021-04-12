package seedu.duke.ui;

import seedu.duke.account.FitCenter;
import seedu.duke.account.User;
import seedu.duke.command.CommandResult;
import seedu.duke.common.Messages;
import seedu.duke.goal.Goal;

import java.util.Scanner;

import static seedu.duke.command.CommandRecordType.DIET;

/**
 * Manages the logic of UI interaction.
 */
public class UI {

    /**
     * A divider with line break.
     */
    public static final String DIVIDER = "--------------------------------------------------------------------\n";
    /**
     * A divider line.
     */
    public static final String DIVIDER_LINE_ONLY =
            "--------------------------------------------------------------------";
    private final Scanner sc;

    /**
     * Initializes a UI controller instance.
     */
    public UI() {
        sc = new Scanner(System.in);
    }

    /**
     * Gets the user input in the next line.
     *
     * @return the user input in the next line.
     */
    public String getUserInput() {
        return sc.nextLine();
    }

    /**
     * Prints greetings when the app is started.
     */
    public void printGreetings() {
        System.out.print(DIVIDER
                + Messages.MESSAGE_WELCOME
                + DIVIDER);
    }

    /**
     * Prints greetings when the app is exiting.
     */
    public void printExitMessage() {
        System.out.print(DIVIDER
                + Messages.MESSAGE_BYE
                + DIVIDER);
    }

    /**
     * Prints the result of an executed command.
     *
     * @param commandResult the result of an executed command in String.
     */
    public void printCommandResult(CommandResult commandResult) {
        System.out.println(DIVIDER
                + commandResult.getFeedback()
                + "\n"
                + DIVIDER_LINE_ONLY);
    }

    /**
     * Prints the error message that the file cannot be accessed.
     */
    public void showFileErrorMessage() {
        System.out.println("The source file can't be accessed, please check your access settings.");
    }

    /**
     * Prints a message surrounded by divider lines.
     *
     * @param message a message to be printed in String.
     */
    public static void printMessage(String message) {
        System.out.println(DIVIDER
                + message
                + "\n"
                + DIVIDER_LINE_ONLY);
    }

    /**
     * Prints the error message that the system file contains invalid content that can't be recognized.
     */
    public void showFileParserErrorMessage() {
        System.out.println("The file contains invalid content that can't be recognized, please fix it\n"
                + "You can try to delete everything in the file but you will lose the information you had.");
    }

}
