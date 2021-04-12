package seedu.duke.common;

public class Messages {

    private static final String USER_GUIDE_LINK = "https://ay2021s2-cs2113t-t09-1.github.io/tp/UserGuide.html";
    public static final String GENERAL_INPUT_ERROR  = "If unsure, please use 'help' command to check the format.";

    /**
     * Messages for errors.
     */
    public static final String GENERAL_INVALID_INPUT = "If unsure, please use 'help' command to check the format.";
    public static final String PERSON_NOT_FOUND = "Person not found!";
    public static final String DIFF_NAME_SAME_ID = "Person with the same Id already exist!";
    public static final String INVALID_COMMAND = "Invalid command detected, or you are missing parameters! Try again!"
            + System.lineSeparator() + GENERAL_INVALID_INPUT;
    public static final String NO_ARGUMENT = "No argument passed! Try again!"
            + System.lineSeparator() + GENERAL_INVALID_INPUT;
    public static final String WRONG_FLAG = "Wrong flags used!"
            + System.lineSeparator() + GENERAL_INVALID_INPUT;
    public static final String INVALID_MAX_CAPACITY_ARG = "Invalid argument for max capacity! Try again!"
            + System.lineSeparator() + "E.g. java -jar CYC.jar 1000";
    public static final String INVALID_ARGUMENT_SIZE = "There should be exactly 1 argument! Try again!"
            + System.lineSeparator() + "E.g. java -jar CYC.jar 1000";
    public static final String INVALID_MAX_CAPACITY = "Maximum capacity should be a positive integer that is less than"
            + " 7 digits.";
    public static final String INVALID_MAX_CAPACITY_CHECKED_IN = "Maximum capacity should be more than the total"
            + " number of checked in people: ";
    public static final String ID_ERROR = "ID should be 3 digits followed by a uppercase letter."
            + System.lineSeparator() + GENERAL_INVALID_INPUT;
    public static final String NAME_ERROR = "Name should consist of alphabets (or spaces) only. (30 characters limit)"
            + System.lineSeparator() + GENERAL_INVALID_INPUT;
    public static final String PHONE_ERROR = "Phone number should consist of only 8 digits"
            + System.lineSeparator() + GENERAL_INVALID_INPUT;
    public static final String INVALID_INTEGER = "Argument should only consist of positive integers!";
    public static final String ALREADY_CHECKEDOUT = "%s is already checked out.";
    public static final String ALREADY_CHECKEDIN = "%s is already checked in.";
  
    /**
     * Command summary for help command.
     */
    public static final String CHECKIN_HELP = "Check-in visitor: checkin i/LAST_4_CHARS_OF_ID n/NAME [p/PHONE_NUMBER]";
    public static final String LIST_ALL_HELP = "List all visitors: listall";
    public static final String LIST_CHECKED_IN_HELP = "List checked-in visitors only: listcheckedin";
    public static final String FIND_BY_ID_HELP = "Find visitor by ID: find i/LAST_4_CHARS_OF_ID";
    public static final String CHECKOUT_HELP = "Checkout visitor: checkout i/LAST_4_CHARS_OF_ID";
    public static final String CLEAR_HELP = "Clear all visitor entries: clear";
    public static final String EDIT_CAPACITY_HELP = "Edit venue capacity: editmax NEW_CAPACITY";
    public static final String MOVE_STORAGE_HELP = "Move location of storage file: movestorage PATH";
    public static final String EXIT_HELP = "Exit Control Your Crowd: exit";
    public static final String USER_GUIDE_LINK_HELP = "Refer to the user guide: " + USER_GUIDE_LINK;
}
