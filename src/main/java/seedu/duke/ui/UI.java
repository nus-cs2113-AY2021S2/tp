package seedu.duke.ui;

import seedu.duke.common.Messages;

import java.util.Scanner;

public class UI {

    public static final String DIVIDER = "----------------------------------------------------------------\n";
    private Scanner sc;

    public UI() {
        sc = new Scanner(System.in);
    }

    public String getUserInput() {
        return sc.nextLine();
    }

    public void printGreetings() {
        System.out.print(DIVIDER
                + Messages.MESSAGE_WELCOME
                + DIVIDER);
    }

    public void printExitMessage() {
        System.out.print(DIVIDER
                + Messages.MESSAGE_BYE
                + DIVIDER);
    }

    public void printHelpPrompt() {
        System.out.print(DIVIDER
                + Messages.MESSAGE_HELP
                + DIVIDER);
    }

    public static void printMessage(String message) {
        System.out.println(DIVIDER
                + message
                + "\n"
                + DIVIDER);
    }

    public static void printDivider() {
        System.out.println(DIVIDER);
    }
}
