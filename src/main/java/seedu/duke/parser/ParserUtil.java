package seedu.duke.parser;

import seedu.duke.exception.ParserException;
import seedu.duke.lesson.Lesson;
import seedu.duke.lesson.LessonType;
import seedu.duke.lesson.TeachingStaff;
import seedu.duke.module.Module;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static seedu.duke.common.Constants.ADD;
import static seedu.duke.common.Constants.DELETE_COMMAND;
import static seedu.duke.common.Constants.DELIM;
import static seedu.duke.common.Constants.EDIT;
import static seedu.duke.common.Constants.EMPTY_STRING;
import static seedu.duke.common.Constants.ENTRY_LESSON_MAX_PARSER;
import static seedu.duke.common.Constants.ENTRY_TASK_MAX_PARSER;
import static seedu.duke.common.Constants.FORMAT_COMMAND_WORD_AND_ARGS;
import static seedu.duke.common.Constants.FORMAT_DATE_IO;
import static seedu.duke.common.Constants.FORMAT_TWO_COMMAND_WORD_AND_ARGS;
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
import static seedu.duke.common.Messages.MESSAGE_NON_INTEGER_INDEX;
import static seedu.duke.common.Messages.MESSAGE_NON_INTEGER_INDICES;
import static seedu.duke.common.Messages.MESSAGE_OUT_OF_BOUNDS_INDEX;
import static seedu.duke.common.Messages.MESSAGE_OUT_OF_BOUNDS_INDICES;
import static seedu.duke.common.Messages.MESSAGE_TASK_DESCRIPTION_EMPTY;
import static seedu.duke.common.Messages.MESSAGE_TASK_FIELDS_EMPTY;

public class ParserUtil {

    //@@author ivanchongzhien
    /**
     * Parses details of lesson from user arguments.
     *
     * @param input command arguments from user input
     * @return a Lesson object with the details entered by the user. Fields not found will be left as an empty string.
     */
    public static Lesson parseLesson(String input) throws ParserException {
        if (input.isEmpty()) {
            throw new ParserException(MESSAGE_LESSON_FIELDS_EMPTY);
        }
        // initialize an array of empty strings to store lesson details
        String[] lessonDetails = new String[ENTRY_LESSON_MAX_PARSER];
        Arrays.fill(lessonDetails, EMPTY_STRING);
        fillLessonDetails(input, lessonDetails);

        LessonType lessonType = LessonType.getLessonTypeFromString(lessonDetails[INDEX_TYPE]);
        String timeAndDay = lessonDetails[INDEX_DAY_TIME];
        String link = lessonDetails[INDEX_LINK];
        String teacherName = lessonDetails[INDEX_TEACHER_NAME];
        String email = lessonDetails[INDEX_TEACHER_EMAIL];

        if (lessonType == null) {
            throw new ParserException(MESSAGE_INVALID_LESSON_TYPE);
        }
        if (!Lesson.isValidLink(link) && !link.equals(EMPTY_STRING)) {
            throw new ParserException(MESSAGE_INVALID_LESSON_LINK);
        }

        TeachingStaff teacher = parseTeachingStaff(teacherName, email);
        return new Lesson(lessonType, timeAndDay, link, teacher);
    }

    /**
     * Parses details of teaching staff from given arguments.
     *
     * @param teacherName name of teaching staff
     * @param email email address of teaching staff
     * @return a TeachingStaff object
     * @throws ParserException if the email address is invalid
     */
    private static TeachingStaff parseTeachingStaff(String teacherName, String email) throws ParserException {
        if (!TeachingStaff.isValidEmail(email) && !email.equals(EMPTY_STRING)) {
            throw new ParserException(MESSAGE_INVALID_LESSON_EMAIL);
        }
        return new TeachingStaff(teacherName, email);
    }

    /**
     * Splits input string into its respective fields and stores each substring in an array.
     *  @param inputString user input containing new lesson details
     * @param lessonDetails  array storing parsed details
     */
    private static void fillLessonDetails(String inputString, String[] lessonDetails) {
        // split the details field using delimiter to get the individual detail fields
        String[] splitDetails = inputString.split(DELIM);

        // store detail fields that have been filled by the user into an array
        // if user did not enter that field, it will remain as an empty string
        for (int i = 0; i < splitDetails.length && i < ENTRY_LESSON_MAX_PARSER; i++) {
            lessonDetails[i] = splitDetails[i].trim();
        }
    }

    /**
     * Parses details of new task from command arguments.
     *
     * @param input command arguments
     * @return a Task object with the details entered by the user. Fields not found will be left as an empty string.
     * @throws ParserException if user does not enter any details
     */
    public static Task parseTask(String input) throws ParserException {
        // user does not enter any parameters.
        if (input.isEmpty()) {
            throw new ParserException(MESSAGE_TASK_FIELDS_EMPTY);
        }
        // initialize an array of empty strings to store task details
        String[] taskDetails = new String[ENTRY_TASK_MAX_PARSER];
        Arrays.fill(taskDetails, EMPTY_STRING);
        fillTaskDetails(input, taskDetails);

        // user does not enter a task description
        if (taskDetails[0].isEmpty()) {
            throw new ParserException(MESSAGE_TASK_DESCRIPTION_EMPTY);
        }

        String description = taskDetails[INDEX_DESCRIPTION];
        LocalDate deadline = convertToDate(taskDetails[INDEX_DEADLINE]);
        String remarks = taskDetails[INDEX_REMARKS_PARSER];

        return new Task(description, deadline, remarks);
    }

    /**
     * Splits input string into its respective fields and stores each substring in an array.
     *
     * @param inputString user input containing new task details
     * @param allDetails  array storing parsed details
     */
    private static void fillTaskDetails(String inputString, String[] allDetails) {
        // split the details field using DELIMITER to get the individual detail fields
        String[] details = inputString.split(DELIM);

        // store detail fields that have been filled by the user into an array
        // if user did not enter that field, it will remain as an empty string
        for (int i = 0; i < details.length && i < allDetails.length; i++) {
            allDetails[i] = details[i].trim();
        }
    }

    /**
     * Converts given string to LocalDate object.
     *
     * @param string string to be converted
     * @return LocalDate object of the date represented by the string
     * @throws DateTimeParseException if invalid input format / invalid date given
     */
    private static LocalDate convertToDate(String string) throws ParserException {
        DateTimeFormatter parseFormat = DateTimeFormatter.ofPattern(FORMAT_DATE_IO);
        LocalDate date;
        try {
            date = LocalDate.parse(string, parseFormat);
        } catch (DateTimeParseException e) {
            throw new ParserException(MESSAGE_INVALID_TASK_DEADLINE);
        }
        return date;
    }

    //@@author isaharon
    /**
     * Gets the single command word and arguments from user input.
     *
     * @param input full user input
     * @return string array of command word and arguments
     * @throws ParserException if invalid word is given
     */
    public static String[] getCommandWordAndArgs(String input) throws ParserException {
        Pattern commandWordAndArgsPattern = Pattern.compile(FORMAT_COMMAND_WORD_AND_ARGS);
        Matcher matcher = commandWordAndArgsPattern.matcher(input.trim());
        if (!matcher.matches()) {
            throw new ParserException(MESSAGE_INVALID_COMMAND);
        }
        String[] commandWordAndArgs = {matcher.group(1), matcher.group(2)};
        return commandWordAndArgs;
    }

    /**
     * Enhanced version of getCommandWordAndArgs for module commands.
     *
     * @param input full user input
     * @return string array of command word and arguments
     * @throws ParserException if invalid word given
     */
    public static String[] getModuleCommandWordAndArgs(String input) throws ParserException {
        String[] commandWordAndArgs = getCommandWordAndArgs(input);
        // command is more than 1 word
        if (commandWordAndArgs[INDEX_COMMAND_WORD].equalsIgnoreCase(ADD)
                || commandWordAndArgs[INDEX_COMMAND_WORD].equalsIgnoreCase(DELETE_COMMAND)
                || commandWordAndArgs[INDEX_COMMAND_WORD].equalsIgnoreCase(EDIT)) {
            commandWordAndArgs = getTwoCommandWordAndArgs(input);
        }
        return commandWordAndArgs;
    }

    /**
     * Gets two command word and arguments from user input.
     * Only called when first command word is "add" or "delete" or "edit".
     *
     * @param input full user input
     * @return string array of two command words and arguments
     * @throws ParserException if insufficient number of words given
     */
    private static String[] getTwoCommandWordAndArgs(String input) throws ParserException {
        Pattern twoCommandWordAndArgsPattern = Pattern.compile(FORMAT_TWO_COMMAND_WORD_AND_ARGS);
        Matcher matcher = twoCommandWordAndArgsPattern.matcher(input.trim());
        if (!matcher.matches()) {
            throw new ParserException(MESSAGE_INVALID_COMMAND);
        }
        String[] commandWordsAndArgs = {matcher.group(1), matcher.group(2)};
        return commandWordsAndArgs;
    }

    //@@author ivanchongzhien
    /**
     * Parses module code from user input.
     *
     * @param input full user input string
     * @return module code string
     * @throws ParserException if empty/invalid module code given
     */
    public static String parseModuleCode(String input) throws ParserException {
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
     * Parses given input string to integer, ensuring that parsed index is not out of bounds.
     *
     * @param input user input string
     * @return index parsed from input string
     */
    public static int checkIndex(String input, int max) throws ParserException {
        int index = 0;
        try {
            index = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new ParserException(MESSAGE_NON_INTEGER_INDEX);
        }

        if (index < 1 || index > max) {
            throw new ParserException(MESSAGE_OUT_OF_BOUNDS_INDEX);
        }

        return index;
    }

    /**
     * Converts given input string to an array list of integers.
     * Removes duplicates and indices which are out of bounds.
     *
     * @param input full user input string
     * @param max   the maximum accepted index
     * @return a sorted integer arraylist with valid indices
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

        // Sorts array list
        Collections.sort(indices);
        return indices;
    }

    /**
     * Converts input string into integers and stores them in given array list. Non-integer inputs are stored in
     * a different array list.
     *
     * @param indices integer array list used to store parsed integers
     * @param input   input string to be converted
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
     * @param max       the upper bound limit
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
