package seedu.duke.common;

/**
 * Container for commonly used messages.
 */
public class Messages {
    public static final String MESSAGE_VERSION = "V1.0";
    public static final String MESSAGE_FEATURES = "You can use the app by using command ADD, VIEW, and DELETE.";
    public static final String MESSAGE_WELCOME = "Welcome to your personal fitness app - Healthier\n"
            + "What's in your mind today?\n";
    public static final String MESSAGE_BYE = "Nice work today!\n"
            + "You are one step closer to ultimate fitness!\n"
            + "See you again soon :)\n";
    public static final String MESSAGE_EXIT = "Thank you for using this app. The app is exiting...";
    public static final String MESSAGE_HELP_PROMPT = "Not sure how to use this app?\n"
            + "Use command 'help' to see what you can do.";
    public static final String MESSAGE_HELP_GREETINGS = "Thank you for choosing to be healthier with us.\n"
            + "The current version of this application is: " + MESSAGE_VERSION + "\n"
            + MESSAGE_FEATURES + "\n";
    public static final String MESSAGE_VIEW_TITLE = "Displaying all eligible %s records:\n";
    public static final String MESSAGE_CHECK_TITLE = "Checking the progress of eligible %s goals:\n";
    public static final String MESSAGE_CHECK_HEADER = "Index\t\tDate Set\t\tGoal Type\t\tTarget\t\t\tProgress\n";
    public static final String MESSAGE_VIEW_HEADER_EXERCISE = "Index\t\tDate\t\tActivity\t\tDuration\t\tCalories\n";
    public static final String MESSAGE_VIEW_HEADER_DIET = "Index\t\tDate\t\tFood Category\t\tWeight\t\tCalories\n";
    public static final String MESSAGE_VIEW_HEADER_SLEEP = "Index\t\tDate\t\t\tDuration\n";
    public static final String MESSAGE_VIEW_HEADER_WEIGHT = "Index\t\tDate\t\t\tBody Weight\n";
    public static final String MESSAGE_NO_RECORD = "Sorry, no records found.\n"
            + "You can try adding records by using command 'add'.";
    public static final String MESSAGE_NO_GOAL = "Sorry, no goals found.\n"
            + "You can try setting a goal by using command 'set'.";
    public static final String MESSAGE_NO_ELIGIBLE_GOAL = "Sorry, there are currently no eligible goals\n"
            + "You can try setting a goal by using command 'set'.";
    public static final String MESSAGE_INDEX_NUMBER_FORMAT_EXCEPTION = "The index field is not a valid integer "
            + "number.\nPlease try again.";
    public static final String MESSAGE_INDEX_OUT_OF_RANGE_EXCEPTION = "The index entered is out of range.\n"
            + "Please try again.";
    public static final String MESSAGE_CANT_ADD_RECORD = "Sorry, you cannot add record of an unrecognized type.";
    public static final String MESSAGE_CANT_SET_GOAL = "Sorry, you cannot set goal for an unrecognized type.";
    public static final String MESSAGE_CANT_VIEW_LIST = "Sorry, you cannot view a record list "
            + "of an incorrect record type.";
    public static final String MESSAGE_NO_BODY_WEIGHT_RECORD = "You haven't input any body weight record. "
            + "Use add command to track the change of your body weight.";
    public static final String MESSAGE_CANT_CHECK_GOAL = "Sorry, you cannot check a goal list "
            + "of an incorrect goal type.";
    public static final String MESSAGE_CANT_CANCEL_GOAL = "Sorry, you cannot cancel a goal from a goal list "
            + "of an incorrect goal type.";
    public static final String MESSAGE_SYSTEM_ERROR = "There is something wrong within the system.";
    public static final String MESSAGE_DOUBLE_FORMAT_ERROR = "A double value is expected for the number field. "
            + "Please verify your input and try again.";
    public static final String MESSAGE_INVALID_PERIOD_TYPE = "The period type you entered is invalid.\n"
            + "The period type can only be 'D' or 'W'. Please try again.";
    public static final String MESSAGE_INVALID_DATE_FORMAT = "The date format is incorrect or the date is invalid. "
            + "Please try again.\n";
    public static final String MESSAGE_INVALID_SLEEP_HOUR = "The duration you entered is invalid.\n"
            + "It should be an positive integer between 0 and 24, with the unit of hour.\nPlease try again.";
    public static final String MESSAGE_INVALID_WORKOUT_MIN = "The duration you entered is invalid.\n"
            + "It should be an positive integer between 0 and 1440, with the unit of minute.\nPlease try again.";
    public static final String MESSAGE_INVALID_WEIGHT = "The weight you entered is invalid.\n"
            + "It should be an positive floating point number, with the unit of kilogram(kg).\nPlease try again.";
    public static final String MESSAGE_INVALID_FOOD_CATEGORY = "The food category you entered is invalid.\n"
            + "The acceptable food category list is:\n";
    public static final String MESSAGE_INVALID_FOOD_AMOUNT = "The amount you entered is invalid.\n"
            + "The acceptable amount of food should be a floating point number, with the unit of gram(g).\n"
            + "Please try again.";
    public static final String MESSAGE_INVALID_WORKOUT_CATEGORY = "The workout category you entered is invalid.\n"
            + "The acceptable workout category list is:\n";
    public static final String MESSAGE_INVALID_COMMAND = "Sorry, the command you entered cannot be recognized.\n\n";
    public static final String MESSAGE_INVALID_COMMAND_WORD = "The command word is invalid. "
            + "Enter help to see help messages\n";
    public static final String MESSAGE_INVALID_COMMAND_SYNTAX = "Sorry, "
            + "the syntax of the command entered is incorrect.\n\n";
    public static final String MESSAGE_SYNTAX_ADD_COMMAND = "The syntax for add command is:\n"
            + "1. Add exercise record\n\tadd t/E a/ACTIVITY_NAME d/DURATION [date/DD-MM-YYYY]\n"
            + "   The duration is with unit of minute.\n"
            + "2. Add diet record\n\tadd t/D f/FOOD_TYPE w/WEIGHT [date/DD-MM-YYYY]\n"
            + "   The amount is with unit of gram.\n"
            + "3. Add sleep record\n\tadd t/S d/DURATION [date/DD-MM-YYYY]\n"
            + "   The duration is with unit of hour.\n"
            + "4. Add body weight record\n\tadd t/W w/WEIGHT [date/DD-MM-YYYY]\n"
            + "   The weight is with unit of kilogram.\n"
            + "Please note the type must be in uppercase.";
    public static final String MESSAGE_SYNTAX_VIEW_COMMAND = "The syntax for view command is:\n"
            + "1. View exercise records\n\tview t/E [a/ACTIVITY_NAME] [date/DD-MM-YYYY]\n"
            + "2. View diet records\n\tview t/D [f/FOOD_NAME] [date/DD-MM-YYYY]\n"
            + "3. View sleep records\n\tview t/S [date/DD-MM-YYYY]\n"
            + "4. View body weight records\n\tview t/W [date/DD-MM-YYYY]";
    public static final String MESSAGE_SYNTAX_DELETE_COMMAND = "The syntax for delete command is:\n"
            + "1. Delete exercise records\n\tdelete t/E [a/ACTIVITY_NAME] [date/DD-MM-YYYY]\n"
            + "2. Delete diet records\n\tdelete t/D i/index\n"
            + "3. Delete sleep records\n\tdelete t/S i/index\n"
            + "4. Delete body weight records\n\tdelete t/W i/index";
    public static final String MESSAGE_SYNTAX_SET_COMMAND = "The syntax for set command is:\n"
            + "1. Set exercise goals\n\tset t/E p/PERIOD_TYPE target/TARGET_ENERGY\n"
            + "2. Set diet goals\n\tset t/D p/PERIOD_TYPE target/TARGET_ENERGY\n"
            + "3. Set sleep goals\n\tset t/S p/PERIOD_TYPE target/TARGET_DURATION\n"
            + "4. Set body weight goals\n\tset t/W p/PERIOD_TYPE target/TARGET_WEIGHT";
    public static final String MESSAGE_SYNTAX_CHECK_COMMAND = "The syntax for check command is:\n"
            + "1. check exercise goals\n\tcheck t/E [p/PERIOD_TYPE]\n"
            + "2. check diet goals\n\tcheck t/D [p/PERIOD_TYPE]\n"
            + "3. check sleep goals\n\tcheck t/S [p/PERIOD_TYPE]\n"
            + "4. check body weight goals\n\tcheck t/W [p/PERIOD_TYPE]";
    public static final String MESSAGE_SYNTAX_CANCEL_COMMAND = "The syntax for cancel command is:\n"
            + "1. cancel exercise goals\n\tcancel t/E i/INDEX\n"
            + "2. cancel diet goals\n\tcancel t/D i/INDEX\n"
            + "3. cancel sleep goals\n\tcancel t/S i/INDEX\n"
            + "4. cancel body weight goals\n\tcancel t/W i/INDEX";
}