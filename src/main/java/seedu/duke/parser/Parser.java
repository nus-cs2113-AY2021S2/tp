package seedu.duke.parser;

import seedu.duke.commands.Command;
import seedu.duke.exception.InvalidCommandFormatException;
import seedu.duke.exception.UnknownCommandException;
import seedu.duke.lesson.Lesson;
import seedu.duke.lesson.LessonType;
import seedu.duke.lesson.TeachingStaff;
import seedu.duke.module.ModuleList;

import java.util.ArrayList;
import java.util.Arrays;

public class Parser {

    public static final int ADD_MODULE = 1;
    public static final int DEL_MODULE = 2;
    public static final int LIST_MODULE = 3;
    public static final int ENTER_MODULE = 4;
    public static final int PRINT_HELP = 5;
    public static final int EXIT_PROGRAM = 6;

    public static final int IN_MODULE_HELP = 11;
    public static final int CLOSE_MODULE = 12;
    public static final int SHOW_MODULE_INFO = 13;
    public static final int LIST_LESSONS = 14;
    public static final int OPEN_LINK = 15;
    public static final int LIST_TASKS = 16;
    public static final int MARK_DONE = 17;
    public static final int UNMARK_DONE = 18;
    public static final int LIST_TEACHING_STAFF = 19;
    public static final int ADD_LESSON = 20;
    public static final int DEL_LESSON = 21;
    public static final int ADD_TASK = 22;
    public static final int DEL_TASK = 23;

    public static final int UNKNOWN_COMMAND = 99;

    public Command parse(String input) throws UnknownCommandException {
        Command parsedCommand;

        if (moduleIsSelected()) {
            parsedCommand = parseInModule(input);
        } else {
            parsedCommand = parseAtDashboard(input);
        }
        return parsedCommand;
    }

    /**
     * Before user has selected module. (outer commands)
     */
    private Command parseAtDashboard(String input) throws UnknownCommandException {
        Command command;
        int commandCode = parseDashboardCommandFromInput(input);
        String moduleCode;

        switch (commandCode) {
        case PRINT_HELP:
            command = new PrintHelp();
            break;
        case EXIT_PROGRAM:
            command = new ExitProgram();
            break;
        case LIST_MODULE:
            command = new ListModule();
            break;
        case ADD_MODULE:
            moduleCode = getModuleCode(input);
            command = new AddModule(moduleCode);
            break;
        case DEL_MODULE:
            moduleCode = getModuleCode(input);
            command = new DeleteModule(moduleCode);
            break;
        case ENTER_MODULE:
            command = new EnterModule(input);
            break;
        default:
            throw new UnknownCommandException();
        }

        return command;
    }

    private String getModuleCode(String input) {
        // TODO  - error handling
        String[] words = input.split(" ");

        return words[1];
    }


    // check if module is selected
    private boolean moduleIsSelected() {
        return ModuleList.selectedModule != null;
    }

    // check if module name is valid
    private boolean isValidModuleName(String name) {
        // TODO - add stricter checks
        boolean isValid;
        String[] words = name.split(" ");

        // ensure there is only one word
        isValid = words.length == 1;

        return isValid;
    }

    private int parseDashboardCommandFromInput(String input) {
        if (input.equalsIgnoreCase("help")) {
            return PRINT_HELP;
        } else if (input.equalsIgnoreCase("exit")) {
            return EXIT_PROGRAM;
        } else if (input.equalsIgnoreCase("list")) {
            return LIST_MODULE;
        } else if (startsWith(input, "add")) {
            return ADD_MODULE;
        } else if (startsWith(input, "delete")) {
            return DEL_MODULE;
        } else if (isValidModuleName(input)) {
            return ENTER_MODULE;
        } else {
            return UNKNOWN_COMMAND;
        }
    }

    private boolean startsWith(String input, String command) {
        return input.toUpperCase().startsWith(command.toUpperCase());
    }


    /**
     * After user has selected module. (Inner commands)
     */
    private Command parseInModule(String input) throws UnknownCommandException, InvalidCommandFormatException {
        Command command;
        int commandCode = parseInModuleCommandsFromInput(input);
        String moduleCode;

        switch (commandCode) {
        case IN_MODULE_HELP:
            command = new PrintHelp();
            break;
        case CLOSE_MODULE:
            command = new ExitModule();
            break;
        case SHOW_MODULE_INFO:
            command = new ListModuleInfo();
            break;
        case LIST_LESSONS:
            command = new ListLessons();
            break;
        case OPEN_LINK:
            command = new OpenLessonLink();
            break;
        case LIST_TASKS:
            command = new ListTasks();
            break;
        case MARK_DONE:
            command = new MarkAsDone();
            break;
        case UNMARK_DONE:
            command = new MarkAsUndone();
            break;
        case LIST_TEACHING_STAFF:
            command = new ViewTeachingStaff();
            break;
        case ADD_LESSON:
            Lesson newLesson = parseNewLessonDetails(input);
            command = new AddLesson(newLesson);
            break;
        case DEL_LESSON:
            command = new DeleteLesson();
            break;
        case ADD_TASK:
            Task newTask;
            command = new AddLesson(newLesson);
            break;
        default:
            throw new UnknownCommandException();
        }

        return null;
    }

    private Lesson parseNewLessonDetails(String input) {
        // TODO - validate input
        
        // initialize an array of empty strings to store lesson details
        String[] allDetails = new String[5];
        Arrays.fill(allDetails, "");

        // to remove only the first two words "add lesson"
        String[] lessonDetails = input.trim().split(" ", 3);
        
        // split the details field using DELIMITER to get the individual detail fields
        String[] details = lessonDetails[2].split("\\s+;;\\s+");
        
        // store detail fields that have been filled by the user into an array
        // if user did not enter that field, it will remain as an empty string
        for(int i=0; i<details.length && i<allDetails.length; i++) {
            allDetails[i] = details[i].trim();
        }

        String type = allDetails[0].toUpperCase();
        // this throws "illegal argument exception" if enum value is wrong
        LessonType TYPE = LessonType.valueOf(type);
        String timeAndDay = allDetails[1];
        String link = allDetails[2];
        String teacherName = allDetails[3];
        String email = allDetails[4];
        
        TeachingStaff teacher = new TeachingStaff(teacherName, email);

        return new Lesson (TYPE, timeAndDay, link, teacher);
    }
    

    private int parseInModuleCommandsFromInput(String input) {
        if (input.equalsIgnoreCase("help")) {
            return IN_MODULE_HELP;
        } else if (input.equalsIgnoreCase("close")) {
            return CLOSE_MODULE;
        } else if (input.equalsIgnoreCase("info")) {
            return SHOW_MODULE_INFO;
        } else if (input.equalsIgnoreCase("lessons")) {
            return LIST_LESSONS;
        } else if (input.equalsIgnoreCase("link")) {
            return OPEN_LINK;
        } else if (input.equalsIgnoreCase("tasks")) {
            return LIST_TASKS;
        } else if (input.equalsIgnoreCase("mark")) {
            return MARK_DONE;
        } else if (input.equalsIgnoreCase("unmark")) {
            return UNMARK_DONE;
        } else if (input.equalsIgnoreCase("teacher")) {
            return LIST_TEACHING_STAFF;
        } else if (startsWith(input, "add lesson")) {
            return ADD_LESSON;
        } else if (startsWith(input, "delete lesson")) {
            return DEL_LESSON;
        } else if (startsWith(input, "add task")) {
            return ADD_TASK;
        } else if (startsWith(input, "delete task")) {
            return DEL_TASK;
        } else {
            return UNKNOWN_COMMAND;
        }
    }

    /**
     * add lesson tutorial // Wednesday 9 am - 10am // https://nus-sg.zoom.us/j/abc
     *
     * type = getType();
     * throws InvalidTypeException;
     *
     * time = Wed 9-10am;
     * link = https://nus-sg.zoom.us
     *
     * Command command = new AddLesson(type, time, link);
     *
     */


    /**
     * Parsers for second stage input.
     */

    public static ArrayList<Integer> checkIndex(String input, int max) throws NumberFormatException {
        ArrayList<Integer> indices = new ArrayList<>();
        int index;

        String[] words = input.trim().split(" ");

        for (String word : words) {
            index = Integer.parseInt(word);
            indices.add(index);
        }

        // TODO - check duplicates and out of bounds

        return indices;
    }
}
