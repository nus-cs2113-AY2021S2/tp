package seedu.duke.ui;

public class UI {

    public static final String DIVIDER = "------------------------------------------------\n";

    public static void printGreetings() {
        System.out.println(DIVIDER +
                "Welcome to your personal fitness app - Healthier\n" +
                "What's in your mind today?\n" +
                DIVIDER);
    }

    public static void printExitMessage() {
        System.out.println(DIVIDER +
                "Nice work today!\n" +
                "You are one step closer to ultimate fitness!\n" +
                "See you again soon!\n" +
                DIVIDER);
    }

    public static void printHelpPrompt() {
        System.out.println(DIVIDER +
                "Not sure what to do?\n" +
                "Run command 'help' to see what you can do.\n"
                + DIVIDER);
    }
}
