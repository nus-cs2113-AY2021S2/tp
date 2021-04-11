package seedu.duke.ui;

import seedu.duke.exception.DukeException;
import seedu.duke.module.ModuleList;
import seedu.duke.parser.ParserUtil;
import seedu.duke.task.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static seedu.duke.common.CommonMethods.getDaysRemaining;
import static seedu.duke.common.Messages.FORMAT_DAYS_REMAINING;
import static seedu.duke.common.Messages.FORMAT_DAY_REMAINING;
import static seedu.duke.common.Messages.FORMAT_DUE_TODAY;
import static seedu.duke.common.Messages.FORMAT_INDEX_ITEM;
import static seedu.duke.common.Messages.FORMAT_OVERDUE;
import static seedu.duke.common.Messages.HEADER_DONE;
import static seedu.duke.common.Messages.HEADER_UNDONE;
import static seedu.duke.common.Messages.MESSAGE_TASKS_TO_LIST_UNDONE;
import static seedu.duke.common.Messages.TAG_GULIO;
import static seedu.duke.common.Messages.TAG_MODULE;

public class UI {
  
    private final Scanner scanner;

    //@@author aliciatay-zls
    public UI() {
        scanner = new Scanner(System.in);
    }

    /**
     * Prints specified message.
     *
     * @param message String to print.
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Prints error message of an exception within the program.
     * @param e Exception to be printed
     */
    public void printError(DukeException e) {
        System.out.println(e.getMessage());
    }
    
    /**
     * Reads input from user.
     *
     * @return String of input.
     */
    public String readUserInput() {
        return scanner.nextLine();
    }

    //@@author 8kdesign
    /**
     * Prints module indicator for user input.
     */
    public void printModuleIndicator() {
        if (!ModuleList.hasSelectedModule()) {
            System.out.print(TAG_GULIO);
        } else {
            String moduleCode = ModuleList.getSelectedModuleCode();
            System.out.printf(TAG_MODULE, moduleCode);
        }
    }

    //@@author aliciatay-zls
    /**
     * Prints the heading seen before a task list is displayed.
     */
    public void printTaskListHeader(boolean isDone, boolean isOverview) {
        if (isDone) {
            printMessage(HEADER_DONE);
        } else if (isOverview) {
            printMessage(MESSAGE_TASKS_TO_LIST_UNDONE);
        } else {
            printMessage(HEADER_UNDONE);
        }
    }

    /**
     * Prints either only the description or the overview of each task in the task list.
     *
     * @param taskList Array list of tasks to print.
     */
    public void printTasks(ArrayList<Task> taskList, boolean isDescriptionOnly) {
        int tasksCount = 0;
        for (Task task : taskList) {
            tasksCount++;
            if (isDescriptionOnly) {
                printMessage(String.format(FORMAT_INDEX_ITEM, tasksCount, task.getDescription()));
                continue;
            }
            printMessage(String.format(FORMAT_INDEX_ITEM, tasksCount, task.getTaskString()));
        }
    }
    
    //@@author 8kdesign
    /**
     * Returns message for days remaining.
     * 
     * @param dueDate LocalDate of task deadline.
     * @return Message for days remaining.
     */
    public String getDaysRemainingMessage(LocalDate dueDate) {
        long daysRemaining = getDaysRemaining(dueDate);
        if (daysRemaining < 0) {
            return String.format(FORMAT_OVERDUE, -daysRemaining);
        } else if (daysRemaining == 0) {
            return FORMAT_DUE_TODAY;
        } else if (daysRemaining == 1) {
            return FORMAT_DAY_REMAINING;
        } else {
            return String.format(FORMAT_DAYS_REMAINING, daysRemaining);
        }
    }

    //@@author isaharon
    /**
     * Read input from user and returns list of indices.
     * @param max the maximum accepted index
     * @return an integer arraylist with valid indices
     */
    public ArrayList<Integer> getIndicesFromUser(int max) {
        String userInput = readUserInput();
        return ParserUtil.checkIndices(userInput, max);
    }
}
