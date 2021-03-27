package seedu.duke.ui;

import seedu.duke.Block;
import seedu.duke.BlockAlias;
import seedu.duke.DaySchedulePair;
import seedu.duke.FavouriteLocation;
import seedu.duke.History;
import seedu.duke.Map;
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
    private final Scanner in;
    private final PrintStream out;
    private final UiUtils uiUtils = new UiUtils();

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
        out.print(uiUtils.getInputHeader());
        String userInput = in.nextLine();
        out.println(uiUtils.getDivider());
        return userInput;
    }

    public void showToUser(String... message) {
        assert message != null : "Message cannot be null";

        for (String m : message) {
            out.println(m);
        }
    }

    public void showLogo() {
        showToUser(uiUtils.getDivider(), uiUtils.getLogo());
    }

    public void showGreetMessage() {
        showToUser(uiUtils.getGreetingMessage(), uiUtils.getDivider());
    }

    public void showByeMessage() {
        showToUser(uiUtils.getByeMessage(), uiUtils.getDivider());
    }

    public void showHelpMessage() {
        showToUser(uiUtils.getHelpMessage(), uiUtils.getDivider());
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

        showToUser("Starting Block:");
        startAndDestination[0] = in.nextLine().toUpperCase().trim();

        showToUser("Destination Block:");
        startAndDestination[1] = in.nextLine().toUpperCase().trim();

        return startAndDestination;
    }

    public int getEateryEntry(Block[] eateries) {
        showToUser(uiUtils.getDivider());
        showToUser("Here are the list of eateries(from closest to furthest):");
        for (int i = 0; i < eateries.length; i++) {
            out.println((i + 1) + ". " + eateries[i].getName());
        }
        showToUser(uiUtils.getLineSeparator() + "SELECT ENTRY TO GO:");
        return Integer.parseInt(in.nextLine());
    }

    public int getRepeatEntry() throws RepeatEntryOutOfBoundException, InvalidRepeatEntryException {
        try {
            showToUser("SELECT ENTRY TO REPEAT:");
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
        showToUser("Enter Location of the first activity of the day: ");
        ArrayList<String> dailyBlocks = new ArrayList<>();
        String initialBlock = checkValidBlock();
        dailyBlocks.add(initialBlock);
        while (true) {
            showToUser("Enter Location of the next activity of the day: ");
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
            showToUser(uiUtils.getDivider());
            return block;
        } else if (nusMap.getBlock(block) == null) {
            throw new InvalidBlockException();
        }
        return block;
    }

    public String getValidDay() throws InvalidDayException {
        showToUser("Enter the day: ");
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

        showToUser("Got it! Successfully added " + alias + " for block " + block);
        showToUser(uiUtils.getDivider());
        return newAlias;
    }

    private String getAliasName(HashMap<String, String> aliasMap) throws InvalidAliasException {
        showToUser("Enter the alias name: ");
        String alias = in.nextLine().trim();
        checkValidAlias(alias, aliasMap);
        return alias;
    }

    private String getAliasBlock(String s) throws InvalidBlockException {
        showToUser(s);
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
            showToUser("It seems that you currently do not have any aliases");
        } else {
            showToUser("Your aliases are:");
            for (String alias: aliasMap.keySet()) {
                String block = aliasMap.get(alias);
                System.out.println(block + " - " + alias);
            }
        }
        showToUser(uiUtils.getDivider());
    }

    public String getDeleteAliasInfo(BlockAlias blockAlias) throws InvalidAliasException {
        showToUser("Enter the alias name that you wish to delete: ");
        String toDelete = in.nextLine().trim().toUpperCase();
        if (checkValidDeleteAlias(toDelete, blockAlias.getAliasMap())) {
            showToUser("Got it! Successfully deleted " + toDelete + " from the aliases");
        }
        showToUser(uiUtils.getDivider());
        return toDelete;
    }

    private boolean checkValidDeleteAlias(String aliasToDelete, HashMap<String, String> aliasMap)
            throws InvalidAliasException {
        if (!aliasMap.containsKey(aliasToDelete)) {
            throw new InvalidAliasException();
        }
        return true;
    }

    public void showFavouriteLocations(FavouriteLocation favouriteLocation) {
        assert favouriteLocation != null : "favouriteLocation must be initialised";
        favouriteLocation.showFavouriteLocations();
    }
}
