package seedu.duke;

public class UiManager {
    private static final String DIVIDER = "--------------------------------------------------------------------------";
    private static final String SPACING = "      ";
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

    public static void showHelpMessage() {
        System.out.print(
                "1. go:\n" + SPACING + "finds the route to go from one block to another\n" +
                "2. history:\n" + SPACING + "lists past 10 route searches\n" +
                "3. add note LOCATION/DESCRIPTION:\n" + SPACING + "adds and tags a note to a particular location\n" +
                "4. list notes LOCATION:\n" + SPACING + "list notes tagged to the given location\n" +
                "5. delete note LOCATION/NOTE INDEX:\n" + SPACING +
                "deletes notes based on index number tagged to the given location\n"
        );
    }
}
