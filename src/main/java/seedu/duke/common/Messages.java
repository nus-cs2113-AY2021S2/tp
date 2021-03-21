package seedu.duke.common;

public class Messages {


    //General message
    public static final String FORMAT_LIST_HELP = "%s \n\t- %s";
    public static final String FORMAT_LIST_ITEMS = "%2s. %s";
    public static final String FORMAT_INDEX_ITEM = "%d. %s";
    public static final String NEWLINE = System.lineSeparator();
    public static final String DIVIDER = "--------------------------------------------------------------------------";
    public static final String INDENTATION = "\t\t";

    public static final String MESSAGE_EXIT = "Have a nice day! Bye bye!";
    public static final String MESSAGE_WELCOME = "What can I do for you today?";
    public static final String MESSAGE_CLOSED_MODULE = "%s closed.";

    public static final String TAG_GULIO = "GULIO >> ";
    public static final String TAG_MODULE = "%s >> ";

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command.";
    public static final String MESSAGE_INVALID_INDICES = "Invalid indices. Please enter only numbers.";

    //Parser messages
    public static final String MESSAGE_MODULE_CODE_EMPTY = "Module not specified.";
    public static final String MESSAGE_INVALID_MODULE_CODE = "Invalid module code.";

    public static final String MESSAGE_LESSON_FIELDS_EMPTY = "Missing lesson details.";
    public static final String MESSAGE_INVALID_LESSON_TYPE = "Invalid lesson type entered.";
    public static final String MESSAGE_INVALID_LESSON_LINK = "Invalid link entered.";
    public static final String MESSAGE_INVALID_LESSON_EMAIL = "Invalid email entered.";

    public static final String MESSAGE_TASK_FIELDS_EMPTY = "Missing task details.";
    public static final String MESSAGE_INVALID_TASK_DEADLINE = "Invalid/missing deadline.";

    public static final String MESSAGE_NON_INTEGER_INDICES = "Warning, non-integer values removed: %s";
    public static final String MESSAGE_OUT_OF_BOUNDS_INDICES = "Warning, out of bounds index removed: %s";

    public static final String MESSAGE_INVALID_DAY_TIME = "Invalid format. Please enter a valid day and time!";

    //Module messages
    public static final String MESSAGE_ADDED_MODULE = "Added %s to the module list.";
    public static final String MESSAGE_REMOVED_MODULE = "Removed %s from the module list.";
    public static final String MESSAGE_DUPLICATE_MODULE = "Module code %s already exists in the module list.";
    public static final String MESSAGE_INVALID_MODULE = "Unable to find %s.";
    public static final String MESSAGE_NO_MODULES_TO_DELETE = "No modules to be deleted.";
    public static final String MESSAGE_DASHBOARD_HELP = "Dashboard commands information"
            + "\n------------------------------";
    public static final String MESSAGE_MODULE_HELP = "Module commands information"
            + "\n---------------------------";

    public static final String MESSAGE_MODULE_TO_DELETE = "Which modules would you like to delete?" + NEWLINE;
    public static final String MESSAGE_DELETE_MODULE_INFO =
            "Please enter the indices of the modules you would like to delete."
                    + NEWLINE + "Separate indices with a blank space.";
    public static final String MESSAGE_MODULE_TO_LIST = "Modules in your list:";
    public static final String MESSAGE_MODULE_OPENED = "Opening %s." + NEWLINE;


    //Lesson messages
    public static final String FORMAT_PRINT_LESSON = "%d. %s - %s";
    public static final String FORMAT_PRINT_TEACHING_STAFF = "%d. %s - %s";

    public static final String MESSAGE_ADDED_LESSON = "Added %s to lesson list.";
    public static final String MESSAGE_REMOVED_LESSON = "Removed %s from the lesson list.";
    public static final String MESSAGE_OPENED_LESSON_LINK = "Opening %s link in browser.";
    public static final String MESSAGE_UNABLE_TO_OPEN_LINK = "Cannot open lesson link";
    public static final String MESSAGE_INVALID_LINK_ENTERED = "Invalid link entered.";

    public static final String MESSAGE_LESSONS_TO_DELETE = "Which lessons would you like to delete?";
    public static final String MESSAGE_LESSONS_TO_LIST = "Lessons for %s:";
    public static final String MESSAGE_LESSON_TO_OPEN_LINK = "Which lesson's link would you like to open?";
    public static final String MESSAGE_TEACHING_STAFF_TO_LIST = "Teaching staff for %s:";

    public static final String MESSAGE_LESSONS_LIST_EMPTY = "Your list of lessons is empty.";
    public static final String MESSAGE_SORT_LESSON_LIST = "Sorting list of lessons based on lesson type...";

    //Task messages
    public static final String FORMAT_PRINT_TASK = "%d. %s%s - %s";
    public static final String FORMAT_DAYS_REMAINING = " (%d days remaining)";
    public static final String FORMAT_OVERDUE = " (Overdue by %d days)";
    public static final String FORMAT_DUE_TODAY = " (Due today)";

    public static final String COMMAND_VERB_DELETE = "delete";
    public static final String COMMAND_VERB_MARK = "mark as done";
    public static final String COMMAND_VERB_UNMARK = "mark as undone";

    public static final String HEADER_DONE = "[Done]";
    public static final String HEADER_UNDONE = "[Undone]";
    public static final String MESSAGE_GRADED = " (graded)";

    public static final String MESSAGE_ADDED_TASK = "Added %s to task list.";
    public static final String MESSAGE_REMOVED_TASK = "Removed %s from the task list.";
    public static final String MESSAGE_MARKED_AS_DONE = "Marked %s as done.";
    public static final String MESSAGE_MARKED_AS_UNDONE = "Marked %s as undone.";

    public static final String MESSAGE_TASKS_TO_DELETE = "Which tasks would you like to delete?";
    public static final String MESSAGE_TASKS_TO_LIST = "Tasks for %s:";
    public static final String MESSAGE_TASKS_TO_MARK = "Which undone tasks have you completed?";
    public static final String MESSAGE_TASKS_TO_UNMARK = "Which done tasks would you like to undo?";
    public static final String MESSAGE_TASK_CHECK_GRADED = "Is this task graded? (Y / N)";
    public static final String MESSAGE_TASK_CHECK_GRADED_INFO = "Please enter \"Y\" or \"N\"";
    public static final String MESSAGE_TASK_SELECT_INFO = NEWLINE
            + "Please enter the indices of the tasks you would like to %s." + NEWLINE
            + "Separate indices with a blank space.";
    public static final String MESSAGE_TASKS_EMPTY = "No task here.";
    public static final String MESSAGE_TASKS_DONE = "You have completed all your tasks.";


    //Storage messages
    public static final String FILE_INSTRUCTIONS = " Data File" + NEWLINE
            + NEWLINE
            + "Note for editing:" + NEWLINE
            + "Please follow the format strictly when adding/editing/removing lessons or tasks." + NEWLINE
            + "Do not edit anything above the line, as well as the line." + NEWLINE
            + "Please do not use '\\n' in any of the entries." + NEWLINE
            + "Please do not use '|' except for separating fields." + NEWLINE
            + NEWLINE
            + "Choose 1 of the 4 formats for lessons:" + NEWLINE
            + "1) lesson | <type> | <Day & Time>" + NEWLINE
            + "2) lesson | <type> | <Day & Time> | <Link>" + NEWLINE
            + "3) lesson | <type> | <Day & Time> | <Link> | <Teaching Staff Name>" + NEWLINE
            + "4) lesson | <type> | <Day & Time> | <Link> | <Teaching Staff Name> | <Teaching Staff Email>" + NEWLINE
            + NEWLINE
            + "Type: \"lecture\", \"tutorial\" or \"lab\"." + NEWLINE
            + "Day & time: When the lesson occurs." + NEWLINE
            + "Link: Online meeting link for the lesson." + NEWLINE
            + "Teaching staff name: Name of teaching staff for the lesson." + NEWLINE
            + "Teaching staff email: Email of teaching staff for the lesson." + NEWLINE
            + NEWLINE
            + "Choose 1 of the 2 formats for tasks:" + NEWLINE
            + "1) task | <description> | <deadline> | <is done> | <is graded>" + NEWLINE
            + "2) task | <description> | <deadline> | <is done> | <is graded> | <remarks>" + NEWLINE
            + NEWLINE
            + "Description: Name/description of the task." + NEWLINE
            + "Deadline: In the format DD-MM-YYYY." + NEWLINE
            + "Is done: 'T' for true and 'F' for false." + NEWLINE
            + "Is graded: 'T' for true and 'F' for false." + NEWLINE
            + "Remarks: Additional information for task." + NEWLINE
            + NEWLINE
            + "--------------------------------------------------------------------------------" + NEWLINE
            + NEWLINE;

    //Module info messages
    public static final String FORMAT_LESSONS_INFO = "%s - %s";
    public static final String FORMAT_MODULE_INFO = "<Overview for %s>";
    public static final String MESSAGE_TASKS_TO_LIST_UNDONE = "Undone tasks:";

    //Logging messages
    public static final String MESSAGE_LOAD_FAILED = "LOADER: failed to load %s.";

    //Cheat sheet
    public static final String MESSAGE_CHEAT_SHEET_ALREADY_EXISTS = "Cheat sheet already exists!";
    public static final String MESSAGE_CHEATSHEET_ADDED = "%s has been added to your Cheatsheet folder";

}
