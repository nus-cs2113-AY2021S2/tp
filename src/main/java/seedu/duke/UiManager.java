package seedu.duke;

import seedu.duke.exception.InvalidRepeatEntryException;
import seedu.duke.exception.RepeatEntryOutOfBoundException;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class UiManager {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String DIVIDER = "--------------------------------------------------------------------------";
    private static final String SPACING = "      ";
    private static final String INPUT_HEADER = "> ";
    private static final String LOGO =  " /$$   /$$ /$$   /$$  /$$$$$$  /$$      /$$" + LINE_SEPARATOR
            + "| $$$ | $$| $$  | $$ /$$__  $$| $$$    /$$$" + LINE_SEPARATOR
            + "| $$$$| $$| $$  | $$| $$  \\__/| $$$$  /$$$$  /$$$$$$  /$$$$$$$$  /$$$$$$" + LINE_SEPARATOR
            + "| $$ $$ $$| $$  | $$|  $$$$$$ | $$ $$/$$ $$ |____  $$|____ /$$/ /$$__  $$" + LINE_SEPARATOR
            + "| $$  $$$$| $$  | $$ \\____  $$| $$  $$$| $$  /$$$$$$$   /$$$$/ | $$$$$$$$" + LINE_SEPARATOR
            + "| $$\\  $$$| $$  | $$ /$$  \\ $$| $$\\  $ | $$ /$$__  $$  /$$__/  | $$_____/" + LINE_SEPARATOR
            + "| $$ \\  $$|  $$$$$$/|  $$$$$$/| $$ \\/  | $$|  $$$$$$$ /$$$$$$$$|  $$$$$$$" + LINE_SEPARATOR
            + "|__/  \\__/ \\______/  \\______/ |__/     |__/ \\_______/|________/ \\_______/";
    private static final String GREETING_MESSAGE = "Hello! Welcome to NUSMaze" + LINE_SEPARATOR
            + "Where do you want to go today?";
    private static final String BYE_MESSAGE = "Bye. Hope to see you again soon!";
    private static final String HELP_MESSAGE = "1. go:" + LINE_SEPARATOR
            + SPACING + "finds the route to go from one block to another" + LINE_SEPARATOR
            + "2. history:" + LINE_SEPARATOR
            + SPACING + "lists past 10 route searches" + LINE_SEPARATOR
            + "3. add note LOCATION/DESCRIPTION:" + LINE_SEPARATOR
            + SPACING + "adds and tags a note to a particular location" + LINE_SEPARATOR
            + "4. list notes LOCATION:" + LINE_SEPARATOR
            + SPACING + "list notes tagged to the given location" + LINE_SEPARATOR
            + "5. delete note LOCATION/NOTE INDEX:" + LINE_SEPARATOR
            + SPACING + "deletes notes based on index number tagged to the given location";

    private final Scanner in;
    private final PrintStream out;

    public UiManager() {
        this(System.in, System.out);
    }

    public UiManager(InputStream in, PrintStream out) {
        assert in != null : "Input stream cannot be null";
        assert out != null : "Output stream cannot be null";

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
        assert message != null : "Message cannot be null";

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
        showToUser(HELP_MESSAGE);
    }

    public void showHistory(History history) {
        assert history != null : "History must be initialized before, cannot be null";

        showToUser(
                "Number of records in your history: " + history.getTotalNoOfHistory(),
                history.getHistoryAsString()
        );
    }

    public void showClearHistoryResponse() {
        showToUser("Your history has been cleared.");
    }


    public String[] getRoutingInfo() {
        String[] startAndDestination = new String[2];

        out.println("Starting Block:");
        startAndDestination[0] = in.nextLine().toUpperCase().trim();

        out.println("Destination Block:");
        startAndDestination[1] = in.nextLine().toUpperCase().trim();

        return startAndDestination;
    }

    public int getRepeatEntry() throws RepeatEntryOutOfBoundException, InvalidRepeatEntryException {
        try {
            out.println("SELECT ENTRY TO REPEAT:");
            return Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            throw new InvalidRepeatEntryException();
        }
    }
}
