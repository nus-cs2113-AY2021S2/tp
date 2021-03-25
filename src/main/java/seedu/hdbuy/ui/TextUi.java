package seedu.hdbuy.ui;

import seedu.hdbuy.common.QueryKey;
import seedu.hdbuy.common.Unit;
import seedu.hdbuy.common.exception.EmptyParameterException;
import seedu.hdbuy.common.exception.InvalidFilterException;
import seedu.hdbuy.common.exception.InvalidParameterException;
import seedu.hdbuy.common.exception.NoFlatsException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TextUi {

    /**
     * Number of dashes for the separator.
     */
    private static final int SEPARATOR_LENGTH = 80;
    private static final Scanner in = new Scanner(System.in);

    public static void showSeparator() {
        for (int i = 0; i < SEPARATOR_LENGTH; i++) {
            System.out.print('-');
        }
        System.out.print('\n');
    }

    public static void showWelcome() {
        showSeparator();
        System.out.print("Welcome to HDBuy!\nHow may I help you today?\n");
        showSeparator();
    }

    public static void showExit() {
        System.out.print("HDBuy Bye Bye!\n");
        in.close();
    }

    public static String readCommand() {
        return in.nextLine();
    }

    public static void showInvalidInput(String input) {
        System.out.print("I'm sorry. \"" + input + "\" is not a valid command.\n");
    }

    public static void showHelp() {
        System.out.print("*HELP PLACEHOLDER*\n");
    }

    public static void showParameters(HashMap<QueryKey, String> inputs) {
        if (inputs.isEmpty()) {
            System.out.println("Currently there are no filter conditions set.");
            return;
        }
        System.out.print("Filter conditions:\n" + inputs + "\n");
    }

    public static void showInvalidFilter(String criteria, InvalidFilterException e) {
        System.out.println("\"" + criteria + "\" " + e.getMessage());
        System.out.println("Please use these filters: " + Arrays.asList(QueryKey.values()));
    }

    public static void showInvalidParameter(InvalidParameterException e) {
        System.out.println(e.getMessage());
    }

    public static void showUnits(HashMap<Integer, Unit> units) {
        Object[] columnNames = {"Index", "Address", "Type", "Lease", "Price"};
        System.out.format("%5s%24s%12s%24s%12s\n", columnNames);
        int i = 0;
        for (HashMap.Entry<Integer, Unit> mapElement : units.entrySet()) {
            Object[] unitData = {++i, (mapElement.getValue()).getAddress(), (mapElement.getValue()).getType(),
                    (mapElement.getValue()).getLease(), "$" + (mapElement.getValue()).getPrice()};
            System.out.format("%5s%24s%12s%24s%12s\n", unitData);
        }
    }

    public static void showNoFlats(NoFlatsException e) {
        System.out.println(e.getMessage());
    }

    public static void showEmptyParameter(String key, EmptyParameterException e) {
        System.out.println("\"" + key + "\"" + e.getMessage());
    }

    public static void showClearedFilterConditions() {
        System.out.print("Cleared filter conditions.\n");
    }
}
