package seedu.duke;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class UiManager {
    private static final String LS = System.lineSeparator();
    private static final String DIVIDER = "--------------------------------------------------------------------------";
    private static final String SPACING = "      ";
    private static final String INPUT_HEADER = "> ";
    private static final String LOGO =  " /$$   /$$ /$$   /$$  /$$$$$$  /$$      /$$\n"
            + "| $$$ | $$| $$  | $$ /$$__  $$| $$$    /$$$\n"
            + "| $$$$| $$| $$  | $$| $$  \\__/| $$$$  /$$$$  /$$$$$$  /$$$$$$$$  /$$$$$$\n"
            + "| $$ $$ $$| $$  | $$|  $$$$$$ | $$ $$/$$ $$ |____  $$|____ /$$/ /$$__  $$\n"
            + "| $$  $$$$| $$  | $$ \\____  $$| $$  $$$| $$  /$$$$$$$   /$$$$/ | $$$$$$$$\n"
            + "| $$\\  $$$| $$  | $$ /$$  \\ $$| $$\\  $ | $$ /$$__  $$  /$$__/  | $$_____/\n"
            + "| $$ \\  $$|  $$$$$$/|  $$$$$$/| $$ \\/  | $$|  $$$$$$$ /$$$$$$$$|  $$$$$$$\n"
            + "|__/  \\__/ \\______/  \\______/ |__/     |__/ \\_______/|________/ \\_______/\n";
    private static final String GREETING_MESSAGE = "Hello! Welcome to NUSMaze" + LS
            + "Where do you want to go today?";
    private static final String BYE_MESSAGE = "Bye. Hope to see you again soon!";

    private final Scanner in;
    private final PrintStream out;

    public UiManager() {
        this(System.in, System.out);
    }

    public UiManager(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    public String getUserInput() {
        out.print(INPUT_HEADER);
        String userInput = in.nextLine();
        out.println(DIVIDER);
        return userInput;

    }

    public void showToUser(String... message) {
        for (String m : message) {
            out.println(m);
        }
        out.println(DIVIDER);
    }

    public void showLogo() {
        showToUser(DIVIDER, LOGO);
    }

    public void showGreetMessage() {
        showToUser(GREETING_MESSAGE);
    }

    public void showByeMessage() {
        showToUser(BYE_MESSAGE);
    }

    public void showHelpMessage() {
        showToUser(
                "1. go:\n",
                SPACING + "finds the route to go from one block to another\n",
                "2. history:\n",
                SPACING + "lists past 10 route searches\n",
                "3. add note LOCATION/DESCRIPTION:\n",
                SPACING + "adds and tags a note to a particular location\n",
                "4. list notes LOCATION:\n",
                SPACING + "list notes tagged to the given location\n",
                "5. delete note LOCATION/NOTE INDEX:\n",
                SPACING + "deletes notes based on index number tagged to the given location\n"
        );
    }

    public String[] getRoutingInfo() {
        String[] startAndDestination = new String[2];

        out.println("Starting Block:");
        startAndDestination[0] = in.nextLine().toUpperCase().trim();

        out.println("Destination Block:");
        startAndDestination[1] = in.nextLine().toUpperCase().trim();

        return startAndDestination;
    }
}
