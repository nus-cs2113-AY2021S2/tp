package seedu.duke.common;

public class ParserConstants {
    /**
     * Integer constants used within the parser to represent commands.
     */
    // Dashboard commands
    public static final int ADD_MODULE = 11;
    public static final int DEL_MODULE = 12;
    public static final int LIST_MODULE = 13;
    public static final int ENTER_MODULE = 14;
    public static final int PRINT_HELP = 15;
    public static final int EXIT_PROGRAM = 16;

    // In-Module Commands
    public static final int PRINT_HELP_MODULE = 21;
    public static final int EXIT_MODULE = 22;
    public static final int LIST_MODULE_INFO = 23;
    public static final int LIST_LESSONS = 24;
    public static final int OPEN_LINK = 25;
    public static final int LIST_TASKS = 26;
    public static final int MARK_DONE = 27;
    public static final int UNMARK_DONE = 28;
    public static final int LIST_TEACHING_STAFF = 29;
    public static final int ADD_LESSON = 30;
    public static final int DEL_LESSON = 31;
    public static final int ADD_TASK = 32;
    public static final int DEL_TASK = 33;
    public static final int UNKNOWN_COMMAND = 99;

    // String Constants
    public static final String DELIM = "\\s+;;\\s+";
    public static final String WHITESPACE = " ";
    public static final String DATE_INPUT_FORMAT = "d-M-yyyy";
    public static final String MODULE_CODE_FORMAT = "([A-z]{2,3}[\\d]{4}[A-z]?)";


    // Lesson parser constants
    public static final int LESSON_TYPE_INDEX = 0;
    public static final int LESSON_TIME_DAY_INDEX = 1;
    public static final int LESSON_LINK_INDEX = 2;
    public static final int LESSON_TEACHER_INDEX = 3;
    public static final int LESSON_EMAIL_INDEX = 4;

    public static final int LESSON_MAX_DETAILS = 5;

    // Task parser constants
    public static final int TASK_DESCRIPTION_INDEX = 0;
    public static final int TASK_DEADLINE_INDEX = 1;
    public static final int TASK_REMARKS_INDEX = 2;

    public static final int TASK_MAX_DETAILS = 3;
}
