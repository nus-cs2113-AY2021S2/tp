package seedu.duke;

public class UiManager {
    private static final String DIVIDER = "--------------------------------------------------------------------------";

    public static void printDivider() {
        System.out.println(DIVIDER);
    }

    public static void showLogo() {
        String logo =  " /$$   /$$ /$$   /$$  /$$$$$$  /$$      /$$\n"
                + "| $$$ | $$| $$  | $$ /$$__  $$| $$$    /$$$\n"
                + "| $$$$| $$| $$  | $$| $$  \\__/| $$$$  /$$$$  /$$$$$$  /$$$$$$$$  /$$$$$$\n"
                + "| $$ $$ $$| $$  | $$|  $$$$$$ | $$ $$/$$ $$ |____  $$|____ /$$/ /$$__  $$\n"
                + "| $$  $$$$| $$  | $$ \\____  $$| $$  $$$| $$  /$$$$$$$   /$$$$/ | $$$$$$$$\n"
                + "| $$\\  $$$| $$  | $$ /$$  \\ $$| $$\\  $ | $$ /$$__  $$  /$$__/  | $$_____/\n"
                + "| $$ \\  $$|  $$$$$$/|  $$$$$$/| $$ \\/  | $$|  $$$$$$$ /$$$$$$$$|  $$$$$$$\n"
                + "|__/  \\__/ \\______/  \\______/ |__/     |__/ \\_______/|________/ \\_______/\n";
        printDivider();
        System.out.println(logo);
        printDivider();
    }

    public static void showGreetMessage() {
        System.out.println("Hello! Welcome to NUSMaze");
        System.out.println("Where do you want to go today?");
        printDivider();
    }

    public static void showByeMessage() {
        System.out.println("Bye. Hope to see you again soon!");
        printDivider();
    }

    public static void showInvalidMessage() {
        System.out.println("Sorry, I didn't understand that");
    }
}
