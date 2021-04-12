package seedu.allinonenus.moduleplanner;

public class Parser {

    protected static int parserToInteger(String input) {
        return Integer.parseInt(input);
    }

    protected static boolean parserToBoolean(String input) {
        return Boolean.parseBoolean(input);
    }
}