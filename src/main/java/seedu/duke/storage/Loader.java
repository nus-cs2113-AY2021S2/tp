package seedu.duke.storage;

import seedu.duke.lesson.Lesson;
import seedu.duke.lesson.LessonType;
import seedu.duke.lesson.TeachingStaff;
import seedu.duke.module.Module;
import seedu.duke.task.Task;

import static seedu.duke.storage.StorageConstants.DATE_IO_FORMAT;
import static seedu.duke.storage.StorageConstants.DIVIDER_READ;
import static seedu.duke.storage.StorageConstants.ENTRY_LESSON_EXTRA_LONG;
import static seedu.duke.storage.StorageConstants.ENTRY_LESSON_LONG;
import static seedu.duke.storage.StorageConstants.ENTRY_LESSON_MEDIUM;
import static seedu.duke.storage.StorageConstants.ENTRY_SIZE_LESSON;
import static seedu.duke.storage.StorageConstants.ENTRY_SIZE_TASK;
import static seedu.duke.storage.StorageConstants.ENTRY_TASK_LONG;
import static seedu.duke.storage.StorageConstants.FOLDER_PATH;
import static seedu.duke.storage.StorageConstants.INDEX_DAY_TIME;
import static seedu.duke.storage.StorageConstants.INDEX_DEADLINE;
import static seedu.duke.storage.StorageConstants.INDEX_DESCRIPTION;
import static seedu.duke.storage.StorageConstants.INDEX_IS_DONE;
import static seedu.duke.storage.StorageConstants.INDEX_IS_GRADED;
import static seedu.duke.storage.StorageConstants.INDEX_LINK;
import static seedu.duke.storage.StorageConstants.INDEX_REMARKS;
import static seedu.duke.storage.StorageConstants.INDEX_TEACHER_EMAIL;
import static seedu.duke.storage.StorageConstants.INDEX_TEACHER_NAME;
import static seedu.duke.storage.StorageConstants.INDEX_TYPE;
import static seedu.duke.storage.StorageConstants.KEYWORD_LESSON;
import static seedu.duke.storage.StorageConstants.KEYWORD_TASK;
import static seedu.duke.storage.StorageConstants.STOP_LINE;
import static seedu.duke.storage.StorageConstants.TXT_FORMAT;
import static seedu.duke.storage.StorageConstants.TYPE_LAB;
import static seedu.duke.storage.StorageConstants.TYPE_LECTURE;
import static seedu.duke.storage.StorageConstants.TYPE_TUTORIAL;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Loader {

    /**
     * Searches directory for module files.
     * Returns ArrayList of names (excluding ".txt").
     */
    public ArrayList<String> getModuleNames() {
        ArrayList<String> names = new ArrayList<>();
        File directory = new File(FOLDER_PATH);
        File[] files = directory.listFiles();
        if (files == null) {
            return names;
        }
        for (File file : files) {
            String name = file.getName();
            if (name.endsWith(TXT_FORMAT)) {
                names.add(name.replace(TXT_FORMAT, ""));
            }
        }
        return names;
    }


    /**
     * Loads data from the selected module file.
     *
     * @param name Module name, excluding ".txt".
     * @return Loaded module.
     */
    public Module loadModule(String name) {
        String fileName = name + TXT_FORMAT;
        Module module = new Module(name);
        File path = new File(FOLDER_PATH + "/" + fileName);
        try {
            Scanner scanner = new Scanner(path);
            readTillLine(scanner);
            readData(scanner, module);
            scanner.close();
        } catch (FileNotFoundException e) {
            //Unable to find file, return null
            return null;
        }
        return module;
    }


    /**
     * Skips to first line of data.
     *
     * @param scanner Scanner for module file.
     */
    private void readTillLine(Scanner scanner) {
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.startsWith(STOP_LINE)) {
                return;
            }
        }
    }


    /**
     * Identifies data type and calls methods to handle them.
     * Runs through all data.
     *
     * @param scanner Scanner for module file.
     * @param module Module to add data to.
     */
    private void readData(Scanner scanner, Module module) {
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.startsWith(KEYWORD_LESSON)) {
                readLessonData(input, module);
            } else if (input.startsWith(KEYWORD_TASK)) {
                readTaskData(input, module);
            }
        }
    }


    /**
     * Reads data for lesson.
     * Adds lesson to lesson list in module.
     *
     * @param module Module to add data to.
     */
    private void readLessonData(String input, Module module) {
        String[] fields = input.split(DIVIDER_READ);
        if (!ENTRY_SIZE_LESSON.contains(fields.length)) {
            //Invalid format
            return;
        }
        LessonType lessonType = getLessonType(fields[INDEX_TYPE].trim());
        if (lessonType == null) {
            //Invalid lesson type
            return;
        }
        String time = fields[INDEX_DAY_TIME].trim();
        String link = "";
        TeachingStaff teachingStaff = new TeachingStaff("","");

        switch (fields.length) {
        case ENTRY_LESSON_EXTRA_LONG:
            teachingStaff.setEmail(fields[INDEX_TEACHER_EMAIL].trim());
            // fallthrough
        case ENTRY_LESSON_LONG:
            teachingStaff.setName(fields[INDEX_TEACHER_NAME].trim());
            // fallthrough
        case ENTRY_LESSON_MEDIUM:
            link = fields[INDEX_LINK].trim();
            // fallthrough
        default:
        }
        Lesson lesson = new Lesson(lessonType, time, link, teachingStaff);
        module.addLesson(lesson);
    }


    /**
     * Returns lesson type if valid, null if invalid.
     *
     * @param input String of type.
     * @return Lesson type specified.
     */
    private LessonType getLessonType(String input) {
        switch (input.toLowerCase()) {
        case TYPE_LECTURE: {
            return LessonType.LECTURE;
        }
        case TYPE_TUTORIAL: {
            return LessonType.TUTORIAL;
        }
        case TYPE_LAB: {
            return LessonType.LAB;
        }
        default: {
            return null;
        }
        }
    }


    /**
     * Reads data for task.
     * Adds task to task list in module.
     *
     * @param module Module to add data to.
     */
    private void readTaskData(String input, Module module) {
        String[] fields = input.split(DIVIDER_READ);
        if (!ENTRY_SIZE_TASK.contains(fields.length)) {
            //Invalid format
            return;
        }
        String description = fields[INDEX_DESCRIPTION].trim();
        LocalDate deadline = getDeadline(fields[INDEX_DEADLINE].trim());
        if (deadline == null) {
            //Invalid deadline
            return;
        }
        boolean isDone = getTrueFalse(fields[INDEX_IS_DONE].trim());
        boolean isGraded = getTrueFalse(fields[INDEX_IS_GRADED].trim());
        String remarks = "";
        if (fields.length == ENTRY_TASK_LONG) {
            remarks = fields[INDEX_REMARKS].trim();
        }
        Task task = new Task(description, remarks, deadline, isDone, isGraded);
        module.addTask(task);
    }


    /**
     * Returns deadline of task.
     *
     * @param input String of deadline.
     * @return Deadline in LocalDateTime.
     */
    private LocalDate getDeadline(String input) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_IO_FORMAT);
            return LocalDate.parse(input, formatter);
        } catch (DateTimeParseException e) {
            //invalid deadline
            return null;
        }
    }


    /**
     * Returns true if "T" and false if "F".
     * Returns false if invalid.
     *
     * @param input "T" for true or "F" for false.
     * @return Boolean of input.
     */
    private boolean getTrueFalse(String input) {
        //Default is false
        return input.equalsIgnoreCase("T");
    }

}
