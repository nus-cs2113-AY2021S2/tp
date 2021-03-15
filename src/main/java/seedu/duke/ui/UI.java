package seedu.duke.ui;

import java.util.Scanner;

public class UI {

    public static final String DIVIDER = "------------------------------------------------\n";
    private Scanner sc;

    public UI(){
        sc = new Scanner(System.in);
    }

    public String getUserInput(){
        return sc.nextLine();
    }

    public void printGreetings() {
        System.out.println(DIVIDER
                + "Welcome to your personal fitness app - Healthier\n"
                + "What's in your mind today?\n"
                + DIVIDER);
    }

    public void printExitMessage() {
        System.out.println(DIVIDER
                + "Nice work today!\n"
                + "You are one step closer to ultimate fitness!\n"
                + "See you again soon!\n"
                + DIVIDER);
    }

    public void printHelpPrompt() {
        System.out.println(DIVIDER
                + "Not sure what to do?\n"
                + "Run command 'help' to see what you can do.\n"
                + DIVIDER);
    }
}
