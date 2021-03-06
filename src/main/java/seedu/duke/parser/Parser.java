package seedu.duke.parser;

import seedu.duke.commands.Command;
import seedu.duke.exception.InvalidCommandFormatException;
import seedu.duke.exception.UnknownCommandException;
import seedu.duke.lesson.Lesson;
import seedu.duke.lesson.LessonType;
import seedu.duke.lesson.TeachingStaff;
import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;

public class Parser {

    public static final int ADD_MODULE = 11;
    public static final int DEL_MODULE = 12;
    public static final int LIST_MODULE = 13;
    public static final int ENTER_MODULE = 14;
    public static final int PRINT_HELP = 15;
    public static final int EXIT_PROGRAM = 16;

    public static final int IN_MODULE_HELP = 21;
    public static final int CLOSE_MODULE = 22;
    public static final int SHOW_MODULE_INFO = 23;
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
     * OUTER COMMANDS
     * Before user has selected module.
     * -----------------------------------------------------------------------------------------------------------------
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

    private boolean startsWith(String input, String command) {
        return input.toUpperCase().startsWith(command.toUpperCase());
    }


    /**
     * INNER COMMANDS
     * After user has selected module.
     * -----------------------------------------------------------------------------------------------------------------
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
            Task newTask = parseNewTaskDetails(input);
            command = new AddLesson(newTask);
            break;
        case DEL_TASK:
            command = new DeleteTask();
            break;
        default:
            throw new UnknownCommandException();
        }
        return command;
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
        for (int i = 0; i < details.length && i < allDetails.length; i++) {
            allDetails[i] = details[i].trim();
        }

        // Creating Lesson Object
        String type = allDetails[0].toUpperCase();
        // throws "illegal argument exception" if enum value is wrong
        LessonType TYPE = LessonType.valueOf(type);
        String timeAndDay = allDetails[1];
        String link = allDetails[2];
        String teacherName = allDetails[3];
        String email = allDetails[4];

        TeachingStaff teacher = new TeachingStaff(teacherName, email);

        return new Lesson(TYPE, timeAndDay, link, teacher);
    }

    private Task parseNewTaskDetails(String input) {

        // initialize an array of empty strings to store task details
        String[] allDetails = new String[5];
        Arrays.fill(allDetails, "");

        // to remove only the first two words "add task"
        String[] taskDetails = input.trim().split(" ", 3);

        // split the details field using DELIMITER to get the individual detail fields
        String[] details = taskDetails[2].split("\\s+;;\\s+");

        // store detail fields that have been filled by the user into an array
        // if user did not enter that field, it will remain as an empty string
        for (int i = 0; i < details.length && i < allDetails.length; i++) {
            allDetails[i] = details[i].trim();
        }

        // Creating Task object
        String description = allDetails[0];
        String deadlineString = allDetails[1];
        LocalDate deadline = convertToDate(deadlineString);
        String remarks = allDetails[2];

        return new Task(description, deadline, remarks);
    }

    private LocalDate convertToDate(String string) throws DateTimeParseException {
        // specifies the format that user has to follow
        DateTimeFormatter parseFormat = DateTimeFormatter.ofPattern("d-M-yyyy");

        return LocalDate.parse(string, parseFormat);
    }


    /**
     * Second stage input checking.
     */
    public static ArrayList<Integer> checkIndices(String input, int max) throws NumberFormatException {
        ArrayList<Integer> rawIndices = new ArrayList<>();
        int index;

        String[] words = input.trim().split(" ");

        for (String word : words) {
            index = Integer.parseInt(word);
            rawIndices.add(index);
        }
        
        // check duplicates
        ArrayList<Integer> indices = new ArrayList<>();

        for (int number : rawIndices) {
            if (!indices.contains(number)) {
                indices.add(number);
            }
        }
        
        // remove out of bounds/ invalid index
        for (int number : indices) {
            if (number > max || number < 1) {
                indices.remove(number);
            }
        }

        return indices;
    }
}
