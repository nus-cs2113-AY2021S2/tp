package seedu.duke;

public abstract class Ui {

    protected static final String DIVIDER = "-------------------------------------";

    protected static void printDivider() {
        System.out.println(DIVIDER);
    }

    public static void showWelcomeScreen() {
        printDivider();
        System.out.println("Welcome to diliveri");
        printDivider();
    }


}
