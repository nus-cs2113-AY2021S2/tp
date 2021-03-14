package seedu.duke;

import seedu.duke.module.Module;
import seedu.duke.task.Task;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static seedu.duke.common.Constants.FOLDER_PATH;
import static seedu.duke.common.Messages.HEADER_UNDONE;
import static seedu.duke.common.Messages.MESSAGE_TASKS_DONE;
import static seedu.duke.common.Messages.NEWLINE;

public class TestUtilAndConstants {

    public static final String EXPECTED_ADD_LESSON = "Added tutorial to lesson list." + NEWLINE;
    public static final String EXPECTED_ADD_TASK = "Added iP submission to task list.";
    public static final String EXPECTED_DELETE_LESSON = "Removed tutorial from the lesson list." + NEWLINE
            + "Removed lab from the lesson list." + NEWLINE;
    public static final String EXPECTED_OPEN_LINK = "Opening tutorial link in browser." + NEWLINE
            + "Opening lab link in browser." + NEWLINE;
    public static final String EXPECTED_MODULE_OVERVIEW = "<Overview for CS3235>" + NEWLINE
            + "tutorial - Wednesday 9 am - 10am" + NEWLINE + "lab - Wednesday 9 pm - 10 pm"
            + NEWLINE + NEWLINE + HEADER_UNDONE + NEWLINE + "1. iP submission (graded) - 3 Mar 2021" + NEWLINE
            + "\tremember to attach JAR file" + NEWLINE;
    public static final String EXPECTED_ENTER_MODULE = "Opening module CS2106." + NEWLINE + NEWLINE
            + "<Overview for CS2106>" + NEWLINE + NEWLINE + HEADER_UNDONE + NEWLINE
            + MESSAGE_TASKS_DONE + NEWLINE;

    public static final String MESSAGE_MODULE_ERROR = "There was a problem with getting selected module." + NEWLINE;

    public static final String MODULE_CODE_1 = "CS2113T";
    public static final String MODULE_CODE_2 = "CS2106";
    public static final String MODULE_CODE_3 = "CS2105";
    public static final String MODULE_CODE_4 = "CS2101";

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d-M-yyyy");


    //@@author 8kdesign
    public static void removeFiles() {
        File directory = new File(FOLDER_PATH);
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            file.delete();
        }
        directory.delete();
    }

    //@@author aliciatay-zls
    /**
     * Creates task list for testing MarkAsDoneCommand and MarkAsUndoneCommand.
     * Contains mix of undone tasks (by default) and done tasks (explicitly set here).
     * @param module Selected module.
     * @return Array list of selected module.
     */
    public static ArrayList<Task> initialiseTaskList(Module module) {
        LocalDate deadline = LocalDate.parse("3-3-2021", FORMATTER);

        Task task1 = new Task("weekly exercise", deadline, "");
        module.addTask(task1);

        Task task2 = new Task("lecture quiz", deadline, "complete before next lecture");
        module.addTask(task2);

        Task task3 = new Task("iP increments", deadline, "remember to attach JAR file");
        task3.setDone(true);
        module.addTask(task3);

        Task task4 = new Task("read up notes", deadline, "complete before lecture");
        module.addTask(task4);

        Task task5 = new Task("tP milestone", deadline, "meet with team before merging");
        task5.setDone(true);
        module.addTask(task5);

        Task task6 = new Task("watch video snippets", deadline, "complete before lecture");
        task6.setDone(true);
        module.addTask(task6);

        return module.getTaskList();
    }
}
