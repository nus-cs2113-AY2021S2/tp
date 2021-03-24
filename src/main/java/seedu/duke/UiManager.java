package seedu.duke;

import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.InvalidDayException;
import seedu.duke.exception.InvalidRepeatEntryException;
import seedu.duke.exception.RepeatEntryOutOfBoundException;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class UiManager {
    private static final String LINE_SEPARATOR = System.lineSeparator();
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
            + "|__/  \\__/ \\______/  \\______/ |__/     |__/ \\_______/|________/ \\_______/";
    private static final String GREETING_MESSAGE = "Hello! Welcome to NUSMaze" + LINE_SEPARATOR
            + "Where do you want to go today?";
    private static final String BYE_MESSAGE = "Bye. Hope to see you again soon!";
    private static final String HELP_MESSAGE = "1. go:\n"
            + SPACING + "finds the route to go from one block to another\n"
            + "2. history:\n"
            + SPACING + "lists past 10 route searches\n"
            + "3. add note LOCATION/DESCRIPTION:\n"
            + SPACING + "adds and tags a note to a particular location\n"
            + "4. list notes LOCATION:\n"
            + SPACING + "list notes tagged to the given location\n"
            + "5. delete note LOCATION/NOTE INDEX:\n"
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

    public int getEateryEntry(Block[] eateries) {
        out.println(DIVIDER);
        out.println("Here are the list of eateries(from closest to furthest):");
        for (int i = 0; i < eateries.length; i++) {
            out.println((i + 1) + ". " + eateries[i].getName());
        }
        out.println(LINE_SEPARATOR + "SELECT ENTRY TO REPEAT:");
        return Integer.parseInt(in.nextLine());
    }

    public int getRepeatEntry() throws RepeatEntryOutOfBoundException, InvalidRepeatEntryException {
        try {
            out.println("SELECT ENTRY TO REPEAT:");
            return Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            throw new InvalidRepeatEntryException();
        }
    }

    public AbstractMap.SimpleEntry<String, ArrayList<String>> getDailyRouteInfo() 
            throws InvalidDayException, InvalidBlockException {
        out.println("Enter the day: ");
        String day = in.nextLine().toUpperCase().trim();
        checkValidDay(day);
        ArrayList<String> dailyBlocks = new ArrayList<>();
        out.println("Enter Location of the first activity of the day: ");
        String initialBlock = in.nextLine().toUpperCase().trim();
        checkValidBlock(initialBlock);
        dailyBlocks.add(initialBlock);
        while (true) {
            out.println("Enter Location of the next activity of the day: ");
            String nextBlock = in.nextLine().toUpperCase().trim();
            if (nextBlock.equals("END")) {
                break;
            } else {
                checkValidBlock(nextBlock);
                dailyBlocks.add(nextBlock);
            }
        }
        return new AbstractMap.SimpleEntry<>(day, dailyBlocks);
    }

    public void checkValidBlock(String block) throws InvalidBlockException {
        Map nusMap = new Map();
        if (nusMap.getBlock(block) == null) {
            throw new InvalidBlockException();
        }
    }

    public void checkValidDay(String day) throws InvalidDayException {
        List<String> daysList = List.of("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY");
        ArrayList<String> days = new ArrayList<>(daysList);
        if (!days.contains(day)) {
            throw new InvalidDayException();
        }
    }

    public String getDay() throws InvalidDayException {
        out.println("Select Day:");
        String day = in.nextLine().toUpperCase().trim();
        checkValidDay(day);
        return day;
    }
}
