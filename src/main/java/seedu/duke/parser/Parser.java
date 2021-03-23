package seedu.duke.parser;

import seedu.duke.commands.AddCheatSheetCommand;
import seedu.duke.commands.AddLessonCommand;
import seedu.duke.commands.AddModuleCommand;
import seedu.duke.commands.AddTaskCommand;
import seedu.duke.commands.Command;
import seedu.duke.commands.DeleteCheatSheetCommand;
import seedu.duke.commands.DeleteLessonCommand;
import seedu.duke.commands.DeleteModuleCommand;
import seedu.duke.commands.DeleteTaskCommand;
import seedu.duke.commands.EditCheatSheetCommand;
import seedu.duke.commands.EnterModuleCommand;
import seedu.duke.commands.ExitModuleCommand;
import seedu.duke.commands.ExitProgramCommand;
import seedu.duke.commands.ListCheatSheetCommand;
import seedu.duke.commands.ListLessonsCommand;
import seedu.duke.commands.ListModulesCommand;
import seedu.duke.commands.ListTasksCommand;
import seedu.duke.commands.MarkAsDoneCommand;
import seedu.duke.commands.MarkAsUndoneCommand;
import seedu.duke.commands.ModuleInfoCommand;
import seedu.duke.commands.OpenLessonLinkCommand;
import seedu.duke.commands.PrintHelpCommand;
import seedu.duke.commands.ViewTeachingStaffCommand;
import seedu.duke.common.DashboardCommands;
import seedu.duke.common.ModuleCommands;
import seedu.duke.exception.CommandException;
import seedu.duke.exception.DukeException;
import seedu.duke.exception.ParserException;
import seedu.duke.lesson.Lesson;
import seedu.duke.lesson.LessonType;
import seedu.duke.lesson.TeachingStaff;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static seedu.duke.common.Constants.ADD;
import static seedu.duke.common.Constants.DELETE;
import static seedu.duke.common.Constants.DELIM;
import static seedu.duke.common.Constants.EDIT;
import static seedu.duke.common.Constants.EMPTY_STRING;
import static seedu.duke.common.Constants.ENTRY_LESSON_MAX_PARSER;
import static seedu.duke.common.Constants.ENTRY_TASK_MAX_PARSER;
import static seedu.duke.common.Constants.FORMAT_COMMAND_WORD_AND_ARGS;
import static seedu.duke.common.Constants.FORMAT_DATE_IO;
import static seedu.duke.common.Constants.FORMAT_TWO_COMMAND_WORD_AND_ARGS;
import static seedu.duke.common.Constants.INDEX_COMMAND_ARGS;
import static seedu.duke.common.Constants.INDEX_COMMAND_WORD;
import static seedu.duke.common.Constants.INDEX_DAY_TIME;
import static seedu.duke.common.Constants.INDEX_DEADLINE;
import static seedu.duke.common.Constants.INDEX_DESCRIPTION;
import static seedu.duke.common.Constants.INDEX_LINK;
import static seedu.duke.common.Constants.INDEX_REMARKS_PARSER;
import static seedu.duke.common.Constants.INDEX_TEACHER_EMAIL;
import static seedu.duke.common.Constants.INDEX_TEACHER_NAME;
import static seedu.duke.common.Constants.INDEX_TYPE;
import static seedu.duke.common.Constants.WHITESPACE;
import static seedu.duke.common.Messages.MESSAGE_INVALID_COMMAND;
import static seedu.duke.common.Messages.MESSAGE_INVALID_LESSON_EMAIL;
import static seedu.duke.common.Messages.MESSAGE_INVALID_LESSON_LINK;
import static seedu.duke.common.Messages.MESSAGE_INVALID_LESSON_TYPE;
import static seedu.duke.common.Messages.MESSAGE_INVALID_MODULE_CODE;
import static seedu.duke.common.Messages.MESSAGE_INVALID_TASK_DEADLINE;
import static seedu.duke.common.Messages.MESSAGE_LESSON_FIELDS_EMPTY;
import static seedu.duke.common.Messages.MESSAGE_MODULE_CODE_EMPTY;
import static seedu.duke.common.Messages.MESSAGE_NON_INTEGER_INDICES;
import static seedu.duke.common.Messages.MESSAGE_OUT_OF_BOUNDS_INDICES;
import static seedu.duke.common.Messages.MESSAGE_TASK_FIELDS_EMPTY;
import static seedu.duke.common.Messages.MESSAGE_UNKNOWN_COMMAND;

public class Parser {

    //@@author ivanchongzhien

    /**
     * Calls the appropriate parser method depending on whether user is at dashboard or has selected
     * a module.
     *
     * @param input full user input string
     * @return command object based on user input
     * @throws ParserException if valid command cannot be parsed from user input
     */
    public Command parse(String input) throws CommandException, ParserException {
        Command parsedCommand;

        if (moduleIsSelected()) {
            parsedCommand = parseInModule(input);
        } else {
            parsedCommand = parseAtDashboard(input);
        }
        return parsedCommand;
    }

    /**
     * Parses dashboard commands from user input.
     * User is yet to select a module.
     *
     * @param input full user input string
     * @return dashboard command object based on user input
     * @throws ParserException if valid command cannot be parsed from user input
     */
    private Command parseAtDashboard(String input) throws ParserException {
        String[] commandWordAndArgs = getCommandWordAndArgs(input);
        String commandWord = commandWordAndArgs[INDEX_COMMAND_WORD];
        String commandArgs = commandWordAndArgs[INDEX_COMMAND_ARGS].trim();

        DashboardCommands command = DashboardCommands.getDashboardCommandFromString(commandWord);
        if (command == null) {
            throw new ParserException(MESSAGE_INVALID_COMMAND);
        }

        switch (command) {
        case ADD:
            String moduleCodeToAdd = parseModuleCode(commandArgs);
            return new AddModuleCommand(moduleCodeToAdd);
        case DELETE:
            return new DeleteModuleCommand();
        case MODULES:
            return new ListModulesCommand();
        case OPEN:
            String moduleCodeToOpen = parseModuleCode(commandArgs);
            return new EnterModuleCommand(moduleCodeToOpen);
        case HELP:
            return new PrintHelpCommand();
        case EXIT:
            return new ExitProgramCommand();
        default:
            throw new ParserException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

    /**
     * Parses in-module commands from user input.
     * User has selected a module and is currently in the module.
     *
     * @param input full user input string
     * @return in-module command object based on user input
     * @throws ParserException if valid command cannot be parsed from user input
     */
    private Command parseInModule(String input) throws CommandException, ParserException {
        String[] commandWordAndArgs = getModuleCommandWordAndArgs(input);
        String commandWord = commandWordAndArgs[INDEX_COMMAND_WORD];
        String commandArgs = commandWordAndArgs[INDEX_COMMAND_ARGS].trim();

        ModuleCommands command = ModuleCommands.getModuleCommandsFromString(commandWord);
        if (command == null) {
            throw new ParserException(MESSAGE_INVALID_COMMAND);
        }

        switch (command) {
        case HELP:
            return new PrintHelpCommand();
        case CLOSE:
            return new ExitModuleCommand();
        case INFO:
            return new ModuleInfoCommand();
        case LESSONS:
            return new ListLessonsCommand();
        case LINK:
            return new OpenLessonLinkCommand();
        case TASKS:
            return new ListTasksCommand();
        case MARK:
            return new MarkAsDoneCommand();
        case UNMARK:
            return new MarkAsUndoneCommand();
        case TEACHER:
            return new ViewTeachingStaffCommand();
        case ADD_LESSON:
            Lesson newLesson = parseNewLessonDetails(input);
            return new AddLessonCommand(newLesson);
        case DELETE_LESSON:
            return new DeleteLessonCommand();
        case ADD_TASK:
            Task newTask = parseNewTaskDetails(input);
            return new AddTaskCommand(newTask);
        case DELETE_TASK:
            return new DeleteTaskCommand();
        case ADD_CHEAT_SHEET:
            return new AddCheatSheetCommand(commandArgs);
        case DELETE_CHEAT_SHEET:
            return new DeleteCheatSheetCommand(commandArgs);
        case EDIT_CHEAT_SHEET:
            return new EditCheatSheetCommand(commandArgs);
        case LIST_CHEAT_SHEET:
            return new ListCheatSheetCommand();
        default:
            throw new ParserException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

    /**
     * Gets the single command word and arguments from user input.
     *
     * @param input full user input
     * @return string array of command word and arguments
     * @throws ParserException if invalid word is given
     */
    private String[] getCommandWordAndArgs(String input) throws ParserException {
        Pattern commandWordAndArgsPattern = Pattern.compile(FORMAT_COMMAND_WORD_AND_ARGS);
        Matcher matcher = commandWordAndArgsPattern.matcher(input.trim());
        if (!matcher.matches()) {
            throw new ParserException(MESSAGE_INVALID_COMMAND);
        }
        String[] commandWordAndArgs = {matcher.group(1), matcher.group(2)};
        return commandWordAndArgs;
    }

    /**
     * Enchanced version of getCommandWordAndArgs for module commands.
     *
     * @param input full user input
     * @return string array of command word and arguments
     * @throws ParserException if invalid word given
     */
    private String[] getModuleCommandWordAndArgs(String input) throws ParserException {
        String[] commandWordAndArgs = getCommandWordAndArgs(input);
        // command is more than 1 word
        if (commandWordAndArgs[INDEX_COMMAND_WORD].equalsIgnoreCase(ADD)
                || commandWordAndArgs[INDEX_COMMAND_WORD].equalsIgnoreCase(DELETE)
                || commandWordAndArgs[INDEX_COMMAND_WORD].equalsIgnoreCase(EDIT)) {
            commandWordAndArgs = getTwoCommandWordAndArgs(input);
        }
        return commandWordAndArgs;
    }

    /**
     * Gets two command word and arguments from user input.
     * Only called when first command word is "add" or "delete".
     *
     * @param input full user input
     * @return string array of two command words and arguments
     * @throws ParserException if insufficient number of words given
     */
    private String[] getTwoCommandWordAndArgs(String input) throws ParserException {
        Pattern twoCommandWordAndArgsPattern = Pattern.compile(FORMAT_TWO_COMMAND_WORD_AND_ARGS);
        Matcher matcher = twoCommandWordAndArgsPattern.matcher(input.trim());
        if (!matcher.matches()) {
            throw new ParserException(MESSAGE_INVALID_COMMAND);
        }
        String[] commandWordsAndArgs = {matcher.group(1), matcher.group(2)};
        return commandWordsAndArgs;
    }

    /**
     * Parses module code from user input.
     *
     * @param input full user input string
     * @return module code string
     * @throws ParserException if empty/invalid module code given
     */
    private String parseModuleCode(String input) throws ParserException {
        if (input.isEmpty()) {
            throw new ParserException(MESSAGE_MODULE_CODE_EMPTY);
        }

        String moduleCode = input.toUpperCase();
        if (!Module.isValidModuleCode(moduleCode)) {
            throw new ParserException(MESSAGE_INVALID_MODULE_CODE);
        }

        return moduleCode;
    }

    /**
     * Checks if user is at dashboard or has already entered a module.
     *
     * @return true if user has already entered a module, false otherwise
     */
    private boolean moduleIsSelected() {
        return ModuleList.getSelectedModule() != null;
    }

    /**
     * Parses details of new lesson from user input string.
     *
     * @param input full user input string
     * @return a Lesson object with the details entered by the user. Fields not found will be left as an empty string.
     */
    private Lesson parseNewLessonDetails(String input) throws CommandException {

        // initialize an array of empty strings to store lesson details
        String[] allDetails = new String[ENTRY_LESSON_MAX_PARSER];
        Arrays.fill(allDetails, EMPTY_STRING);

        // to remove only the first two words "add lesson"
        String[] lessonDetails = input.trim().split(WHITESPACE, 3);
        // assumption that the "add lesson" will always be present in input
        assert (lessonDetails.length >= 2);

        // ERROR - User does not enter any parameters.
        if (lessonDetails.length < 3) {
            throw new CommandException(MESSAGE_LESSON_FIELDS_EMPTY);
        }

        // split the details field using DELIMITER to get the individual detail fields
        String[] details = lessonDetails[2].split(DELIM);

        // store detail fields that have been filled by the user into an array
        // if user did not enter that field, it will remain as an empty string
        for (int i = 0; i < details.length && i < allDetails.length; i++) {
            allDetails[i] = details[i].trim();
        }

        // Creating Lesson Object
        String type = allDetails[INDEX_TYPE].toUpperCase();
        LessonType lessonType;
        try {
            lessonType = LessonType.valueOf(type);
        } catch (IllegalArgumentException e) {
            throw new CommandException(MESSAGE_INVALID_LESSON_TYPE);
        }

        String timeAndDay = allDetails[INDEX_DAY_TIME];

        String link = allDetails[INDEX_LINK];
        if (!Lesson.isValidLink(link) && !link.equals(EMPTY_STRING)) {
            throw new CommandException(MESSAGE_INVALID_LESSON_LINK);
        }

        String teacherName = allDetails[INDEX_TEACHER_NAME];

        String email = allDetails[INDEX_TEACHER_EMAIL];
        if (!TeachingStaff.isValidEmail(email) && !email.equals(EMPTY_STRING)) {
            throw new CommandException(MESSAGE_INVALID_LESSON_EMAIL);
        }

        TeachingStaff teacher = new TeachingStaff(teacherName, email);

        return new Lesson(lessonType, timeAndDay, link, teacher);
    }

    /**
     * Parses details of new task from user input string.
     *
     * @param input full user input string
     * @return a Task object with the details entered by the user. Fields not found will be left as an empty string.
     */
    private Task parseNewTaskDetails(String input) throws CommandException {

        // initialize an array of empty strings to store task details
        String[] allDetails = new String[ENTRY_TASK_MAX_PARSER];
        Arrays.fill(allDetails, EMPTY_STRING);

        // to remove only the first two words "add task"
        String[] taskDetails = input.trim().split(WHITESPACE, 3);
        // assumption that the "add task" will always be present in input
        assert (taskDetails.length >= 2);

        // ERROR - User does not enter any parameters.
        if (taskDetails.length < 3) {
            throw new CommandException(MESSAGE_TASK_FIELDS_EMPTY);
        }

        // split the details field using DELIMITER to get the individual detail fields
        String[] details = taskDetails[2].split(DELIM);

        // store detail fields that have been filled by the user into an array
        // if user did not enter that field, it will remain as an empty string
        for (int i = 0; i < details.length && i < allDetails.length; i++) {
            allDetails[i] = details[i].trim();
        }

        // Creating Task object
        String description = allDetails[INDEX_DESCRIPTION];

        String deadlineString = allDetails[INDEX_DEADLINE];
        LocalDate deadline;
        try {
            deadline = convertToDate(deadlineString);
        } catch (DateTimeParseException e) {
            throw new CommandException(MESSAGE_INVALID_TASK_DEADLINE);
        }

        String remarks = allDetails[INDEX_REMARKS_PARSER];

        return new Task(description, deadline, remarks);
    }

    /**
     * Converts given string to LocalDate object.
     *
     * @param string string to be converted
     * @return LocalDate object of the date represented by the string
     * @throws DateTimeParseException if invalid input format / invalid date given
     */
    private LocalDate convertToDate(String string) throws DateTimeParseException {
        DateTimeFormatter parseFormat = DateTimeFormatter.ofPattern(FORMAT_DATE_IO);

        return LocalDate.parse(string, parseFormat);
    }
    
    /**
     * Parses given input string to integer, ensuring that parsed index is not out of bounds.
     * TODO : print proper warning, can consider throwing ParserException and handling
     * in EditLessonsCommand.
     *
     * @param input user input string
     * @return index parsed from input string
     */
    public static int checkIndex(String input, int max) throws DukeException {
        int index = 0;
        try {
            index = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new DukeException("Invalid non-integer input");
        }

        if (index < 1 || index > max) {
            throw new DukeException("Index given is out of bounds.");
        }

        return index;
    }

    /**
     * Converts given input string to an array list of integers.
     * Removes duplicates and indices which are out of bounds.
     *
     * @param input full user input string
     * @param max   the maximum accepted index
     * @return an integer arraylist with valid indices
     * @throws NumberFormatException if non-integer value is present in the input
     */
    public static ArrayList<Integer> checkIndices(String input, int max) {
        UI ui = new UI();
        ArrayList<Integer> rawIndices = new ArrayList<>();
        
        // assumption that input is non-null
        assert (input != null);
        ArrayList<String> nonIntegers = parseIndicesFromString(rawIndices, input);
        if (nonIntegers.size() != 0) {
            printNonIntegerWarning(nonIntegers, ui);
        }
        // remove duplicates
        ArrayList<Integer> indices = removeDuplicateIndex(rawIndices);
        
        // remove out of bounds
        ArrayList<Integer> removed = removeOutOfBoundIndex(indices, max);
        if (removed.size() != 0) {
            printOutOfBoundsWarning(removed, ui);
        }
        return indices;
    }

    /**
     * Converts input string into integers and stores them in given array list. Non-integer inputs are stored in
     * a different array list.
     * 
     * @param indices integer array list used to store parsed integers
     * @param input input string to be converted
     * @return a new array list of non-integers that were removed
     */
    private static ArrayList<String> parseIndicesFromString(ArrayList<Integer> indices, String input) {
        int index;
        ArrayList<String> nonIntegers = new ArrayList<>();
        String[] words = input.trim().split(WHITESPACE);
        
        for (String word : words) {
            try {
                index = Integer.parseInt(word);
                indices.add(index);
            } catch (NumberFormatException e) {
                // Non-integer inputs will not be added to the indices array list
                nonIntegers.add(word);
            }
        }
        return nonIntegers;
    }

    /**
     * Removes duplicates from an array list of indices.
     * 
     * @param indexList array list of indices to be checked
     * @return a copy of the original array list without duplicates
     */
    private static ArrayList<Integer> removeDuplicateIndex(ArrayList<Integer> indexList) {
        // Remove duplicates
        ArrayList<Integer> noDuplicates = new ArrayList<>();

        for (int number : indexList) {
            if (!noDuplicates.contains(number)) {
                noDuplicates.add(number);
            }
        }
     return noDuplicates;
    }

    /**
     * Removes indices that are out of bounds from given array list.
     * 
     * @param indexList array list indices to be checked
     * @param max the upper bound limit
     * @return a new array list containing indices which were out of bounds
     */
    private static ArrayList<Integer> removeOutOfBoundIndex(ArrayList<Integer> indexList, int max) {
        ArrayList<Integer> removed = new ArrayList<>();
        
        for (int i = 0; i < indexList.size(); i++) {
            if (indexList.get(i) > max || indexList.get(i) <= 0) {
                int removedIndex = indexList.remove(i);
                removed.add(removedIndex);
                i--;
            }
        }
        return removed;
    }

    /**
     * Prints warning to inform user that some inputs were out of bounds and removed.
     * Prints the integers that were removed.
     *
     * @param removed array list of integers that were out of bounds and have been removed
     * @param ui      UI object for printing
     */
    private static void printOutOfBoundsWarning(ArrayList<Integer> removed, UI ui) {
        ui.printMessage(String.format(MESSAGE_OUT_OF_BOUNDS_INDICES, removed));
    }

    /**
     * Prints warning to inform user that some inputs were not integers.
     * Prints the strings that were removed.
     *
     * @param removed array list of strings that were invalid and have been removed
     * @param ui      UI object for printing
     */
    private static void printNonIntegerWarning(ArrayList<String> removed, UI ui) {
        ui.printMessage(String.format(MESSAGE_NON_INTEGER_INDICES, removed));
    }
}
