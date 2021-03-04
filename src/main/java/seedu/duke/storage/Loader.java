package seedu.duke.storage;

import seedu.duke.common.Constants;
import seedu.duke.lesson.Lesson;
import seedu.duke.lesson.LessonType;
import seedu.duke.lesson.TeachingStaff;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Loader {

    /**
     * Searches directory for module files.
     * Stores names (excluding ".txt") in ModuleList.
     */
    public void loadModuleNames() {
        File directory = new File(Constants.FOLDER_PATH);
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            String name = file.getName();
            if (name.endsWith(Constants.FILE_FORMAT)) {
                ModuleList.insertModule(name.replace(Constants.FILE_FORMAT, ""));
            }
        }
    }


    /**
     * Loads data from the selected module file.
     *
     * @param name Module name, excluding ".txt".
     * @return Loaded module.
     */
    public Module loadModule(String name) {
        String fileName = name + Constants.FILE_FORMAT;
        Module module = new Module(name);
        File path = new File(Constants.FOLDER_PATH + "/" + fileName);
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
            if (input.startsWith(Constants.STOP_LINE)) {
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
            if (input.startsWith(Constants.KEYWORD_LESSON)) {
                readLessonData(input, module);
            } else if (input.startsWith(Constants.KEYWORD_TASK)) {
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
        String[] fields = input.split(Constants.DIVIDER_READ);
        if (!Constants.ENTRY_SIZE_LESSON.contains(fields.length)) {
            //Invalid format
            return;
        }
        LessonType lessonType = getLessonType(fields[Constants.INDEX_TYPE].trim());
        if (lessonType == null) {
            //Invalid lesson type
            return;
        }
        String time = fields[Constants.INDEX_DAY_TIME].trim();
        String link = "";
        if (fields.length >= Constants.ENTRY_LESSON_MEDIUM) {
            link = fields[Constants.INDEX_LINK].trim();
        }
        TeachingStaff teachingStaff = new TeachingStaff("","");
        if (fields.length == Constants.ENTRY_LESSON_LONG) {
            teachingStaff.setName(fields[Constants.INDEX_TEACHER_NAME].trim());
            teachingStaff.setEmail(fields[Constants.INDEX_TEACHER_EMAIL].trim());
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
        case Constants.TYPE_LECTURE: {
            return LessonType.LECTURE;
        }
        case Constants.TYPE_TUTORIAL: {
            return LessonType.TUTORIAL;
        }
        case Constants.TYPE_LAB: {
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
        String[] fields = input.split(Constants.DIVIDER_READ);
        if (!Constants.ENTRY_SIZE_TASK.contains(fields.length)) {
            //Invalid format
            return;
        }
        String description = fields[Constants.INDEX_DESCRIPTION].trim();
        LocalDate deadline = getDeadline(fields[Constants.INDEX_DEADLINE].trim());
        if (deadline == null) {
            //Invalid deadline
            return;
        }
        boolean isDone = getTrueFalse(fields[Constants.INDEX_IS_DONE].trim());
        boolean isGraded = getTrueFalse(fields[Constants.INDEX_IS_GRADED].trim());
        String remarks = "";
        if (fields.length == Constants.ENTRY_TASK_LONG) {
            remarks = fields[Constants.INDEX_REMARKS].trim();
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
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_IO_FORMAT);
            LocalDate deadline = LocalDate.parse(input, formatter);
            return deadline;
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
