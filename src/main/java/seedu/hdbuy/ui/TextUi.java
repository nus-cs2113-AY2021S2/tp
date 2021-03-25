package seedu.hdbuy.ui;

import seedu.hdbuy.data.QueryKey;
import seedu.hdbuy.data.Unit;
import seedu.hdbuy.data.exception.EmptyParameterException;
import seedu.hdbuy.data.exception.InvalidFilterException;
import seedu.hdbuy.data.exception.InvalidParameterException;
import seedu.hdbuy.data.exception.NoFlatsException;

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
        System.out.println("You can type \"help\" for more information.");
    }

    public static void showHelp() {
        System.out.print("*HELP PLACEHOLDER*\n");
    }

    public static void showParameters(HashMap<QueryKey, String> inputs) {
        System.out.print("Parameters:\n" + inputs + "\n");
    }

    public static void showInvalidFilter(String criteria, InvalidFilterException e) {
        System.out.println("\"" + criteria + "\" " + e.getMessage());
        System.out.println("Please use these filters: " + Arrays.asList(QueryKey.values()));
    }

    public static void showInvalidParameter(String key, InvalidParameterException e) {
        System.out.println(e.getMessage());
        switch (key) {
        case "filter":
            System.out.println("FILTER command needs a type and a parameter to work.");
            System.out.println("Filter types: " + Arrays.asList(QueryKey.values()));
            System.out.println("Example: \"filter location clementi\"");
            break;
        case "find":
            System.out.println("FIND command does not need any parameters.");
            System.out.println("However, you need to provide filter before you execute the FIND command.");
            break;
        default:
            break;
        }
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
        System.out.println("Please specified a filter to use before executing this command.");
        System.out.println("Filters included: " + Arrays.asList(QueryKey.values()));
        System.out.println("An example will be \"filter location clementi\"");
    }
}
