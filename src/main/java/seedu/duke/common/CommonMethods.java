package seedu.duke.common;

import seedu.duke.lesson.LessonType;
import seedu.duke.parser.Parser;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static seedu.duke.common.Constants.LAB_STRING;
import static seedu.duke.common.Constants.LECTURE_STRING;
import static seedu.duke.common.Constants.LOGGER_NAME;
import static seedu.duke.common.Constants.LOGGER_PATH;
import static seedu.duke.common.Constants.NO_STRING;
import static seedu.duke.common.Constants.TUTORIAL_STRING;
import static seedu.duke.common.Constants.YES_STRING;
import static seedu.duke.common.Messages.MESSAGE_TASK_CHECK_GRADED;
import static seedu.duke.common.Messages.MESSAGE_TASK_CHECK_GRADED_INFO;

public class CommonMethods {
    
    /**
     * Returns string of lesson type.
     *
     * @param lessonType Lesson type to convert.
     * @return String of lesson type.
     */
    public static String getLessonTypeString(LessonType lessonType) {
        switch (lessonType) {
        case LECTURE: {
            return LECTURE_STRING;
        }
        case TUTORIAL: {
            return TUTORIAL_STRING;
        }
        default: {
            return LAB_STRING;
        }
        }
    }

    //@@author 8kdesign
    /**
     * Returns lesson type if valid, null if invalid.
     *
     * @param input String of type.
     * @return Lesson type specified.
     */
    public static LessonType getLessonType(String input) {
        switch (input.toLowerCase()) {
        case LECTURE_STRING: {
            return LessonType.LECTURE;
        }
        case TUTORIAL_STRING: {
            return LessonType.TUTORIAL;
        }
        case LAB_STRING: {
            return LessonType.LAB;
        }
        default: {
            return null;
        }
        }
    }
    
    /**
     * Writes specified message to log.
     * 
     * @param message Message to save to log.
     */
    public static void writeLog(String message) {
        try {
            Logger logger = Logger.getLogger(LOGGER_NAME);
            logger.setLevel(Level.ALL);
            FileHandler fileHandler = new FileHandler(LOGGER_PATH, true);
            fileHandler.setLevel(Level.ALL);
            logger.addHandler(fileHandler);
            
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.SEVERE);
            logger.addHandler(consoleHandler);
            
            logger.log(Level.FINE, message);
        } catch (IOException e) {
            //Failed to write to log
        }
    }

    /**
     * Calculates difference in specified date with current date.
     * 
     * @param dueDate LocalDate of task due date.
     * @return Long of difference in days.
     */
    public static long getDaysRemaining(LocalDate dueDate) {
        LocalDate currentDate = LocalDate.now();
        return ChronoUnit.DAYS.between(currentDate, dueDate);
    }
    
    //@@author aliciatay-zls
    /**
     * Requests for list of indices.
     * Returns tasks corresponding to indices specified.
     *
     * @param ui Instance of UI.
     * @param taskList Array list of undone tasks.
     * @return Array list of selected tasks.
     */
    public static ArrayList<Task> getSpecifiedTasks(UI ui, ArrayList<Task> taskList) {
        ArrayList<Integer> indices = getSpecifiedIndices(ui, taskList.size());
        //Store the tasks chosen by user to new array list
        ArrayList<Task> selectedTasks = new ArrayList<>();
        for (Integer index : indices) {
            selectedTasks.add(taskList.get(index - 1));
        }
        return selectedTasks;
    }
    
    public static ArrayList<Integer> getSpecifiedIndices(UI ui, int maxIndex) {
        String line = ui.readCommand();
        return Parser.checkIndices(line, maxIndex);
    }

    /**
     * Asks user if the task to be added is a graded one.
     *
     * @param ui Instance of UI.
     * @return Boolean of whether new task is graded.
     */
    public static boolean getIsTaskGraded(UI ui) {
        ui.printMessage(MESSAGE_TASK_CHECK_GRADED);
        String userInput = ui.readCommand();
        while (!userInput.equalsIgnoreCase(YES_STRING)
                && !userInput.equalsIgnoreCase(NO_STRING)) {
            ui.printMessage(MESSAGE_TASK_CHECK_GRADED_INFO);
            userInput = ui.readCommand();
        }
        return userInput.equalsIgnoreCase(YES_STRING);
    }
}
