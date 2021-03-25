package seedu.duke;

import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.InvalidDayException;
import seedu.duke.exception.InvalidRepeatEntryException;
import seedu.duke.exception.RepeatEntryOutOfBoundException;
import seedu.duke.exception.InvalidAliasException;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;

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
        out.println(LINE_SEPARATOR + "SELECT ENTRY TO GO:");
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

    public static String getListOfLocations() {
        return "E1  E1A  E2  E2A  E3  E3A  E4  E4A  E5"
                + System.lineSeparator()
                + "E6  E7  EA  EW1  EW1A EW2  LT1  LT2  LT5  LT6"
                + System.lineSeparator()
                + "AS1 LT7  LT7A IT  T-LAB"
                + System.lineSeparator()
                + "TECHNO EDGE";
    }


    public DaySchedulePair getDailyRouteInfo()
            throws InvalidDayException, InvalidBlockException {
        String day = getValidDay();
        ArrayList<String> dailyBlocks = getSchedule();
        return new DaySchedulePair(day, dailyBlocks);
    }

    public ArrayList<String> getSchedule() throws InvalidBlockException {
        out.println("Enter Location of the first activity of the day: ");
        ArrayList<String> dailyBlocks = new ArrayList<>();
        String initialBlock = checkValidBlock();
        dailyBlocks.add(initialBlock);
        while (true) {
            out.println("Enter Location of the next activity of the day: ");
            String nextBlock = checkValidBlock();
            if (nextBlock.equals("END")) {
                break;
            } else {
                dailyBlocks.add(nextBlock);
            }
        }
        return dailyBlocks;
    }

    public String checkValidBlock() throws InvalidBlockException {
        String block = in.nextLine().toUpperCase().trim();
        Map nusMap = new Map();
        if (block.equals("END")) {
            out.println(DIVIDER);
            return block;
        } else if (nusMap.getBlock(block) == null) {
            throw new InvalidBlockException();
        }
        return block;
    }

    public String getValidDay() throws InvalidDayException {
        out.println("Enter the day: ");
        String day = in.nextLine().toUpperCase().trim();
        List<String> daysList = List.of("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY");
        ArrayList<String> days = new ArrayList<>(daysList);
        if (!days.contains(day)) {
            throw new InvalidDayException();
        }
        return day;
    }

    public HashMap<String, String> getAliasInfo(HashMap<String, String> aliasMap)
            throws InvalidAliasException, InvalidBlockException {
        String block = getAliasBlock("Enter the block: ");
        String alias = getAliasName(aliasMap).toUpperCase();

        HashMap<String, String> newAlias = new HashMap<>();
        newAlias.put(alias, block);

        System.out.println("Got it! Successfully added " + alias + " for block " + block);
        System.out.println(DIVIDER);
        return newAlias;
    }

    private String getAliasName(HashMap<String, String> aliasMap) throws InvalidAliasException {
        out.println("Enter the alias name: ");
        String alias = in.nextLine().trim();
        checkValidAlias(alias, aliasMap);
        return alias;
    }

    private String getAliasBlock(String s) throws InvalidBlockException {
        out.println(s);
        String block = in.nextLine().toUpperCase().trim();
        checkValidAliasBlock(block);
        return block;
    }

    private void checkValidAlias(String alias, HashMap<String, String> aliasMap) throws InvalidAliasException {
        Map nusMap = new Map();
        if (aliasMap.containsValue(alias)) {
            throw new InvalidAliasException();
        } else if (nusMap.getBlock(alias.toUpperCase()) != null) {
            throw new InvalidAliasException();
        }
    }

    public void checkValidAliasBlock(String block) throws InvalidBlockException {
        Map nusMap = new Map();
        if (nusMap.getBlock(block) == null) {
            throw new InvalidBlockException();
        }
    }

    public void showCustomAliases(HashMap<String, String> aliasMap) {
        if (aliasMap.isEmpty()) {
            System.out.println("It seems that you currently do not have any aliases");
        } else {
            System.out.println("Your aliases are:");
            for (String alias: aliasMap.keySet()) {
                String block = aliasMap.get(alias);
                System.out.println(block + " - " + alias);
            }
        }
        System.out.println(DIVIDER);
    }

    public String getDeleteAliasInfo(BlockAlias blockAlias) throws InvalidAliasException {
        out.println("Enter the alias name that you wish to delete: ");
        String toDelete = in.nextLine().trim().toUpperCase();
        checkValidDeleteAlias(toDelete, blockAlias.getAliasMap());
        System.out.println("Got it! Successfully deleted " + toDelete + " from the aliases");
        System.out.println(DIVIDER);
        return toDelete;
    }

    private void checkValidDeleteAlias(String aliasToDelete, HashMap<String, String> aliasMap)
            throws InvalidAliasException {
        if (!aliasMap.containsKey(aliasToDelete)) {
            throw new InvalidAliasException();
        }
    }

    public void showFavouriteLocations(FavouriteLocation favouriteLocation) {
        assert favouriteLocation != null : "favouriteLocation must be initialised";
        favouriteLocation.showFavouriteLocations();
    }

}
