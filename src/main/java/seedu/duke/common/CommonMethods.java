package seedu.duke.common;

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

import static seedu.duke.common.Constants.LOGGER_NAME;
import static seedu.duke.common.Constants.LOGGER_PATH;
import static seedu.duke.common.Constants.NO_STRING;
import static seedu.duke.common.Constants.YES_STRING;
import static seedu.duke.common.Messages.MESSAGE_TASK_CHECK_GRADED_INFO;

public class CommonMethods {

    
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
        ArrayList<Integer> indices = ui.getIndicesFromUser(taskList.size());
        //Store the tasks chosen by user to new array list
        ArrayList<Task> selectedTasks = new ArrayList<>();
        for (Integer index : indices) {
            selectedTasks.add(taskList.get(index - 1));
        }
        return selectedTasks;
    }

    /**
     * Asks user if the task to be added is a graded one.
     *
     * @param ui Instance of UI.
     * @return Boolean of whether new task is graded.
     */
    public static boolean isTaskGraded(UI ui) {
        String userInput = ui.readUserInput();
        while (!userInput.equalsIgnoreCase(YES_STRING)
                && !userInput.equalsIgnoreCase(NO_STRING)) {
            ui.printMessage(MESSAGE_TASK_CHECK_GRADED_INFO);
            userInput = ui.readUserInput();
        }
        return userInput.equalsIgnoreCase(YES_STRING);
    }
}
