package seedu.duke;

import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static seedu.duke.common.Constants.FOLDER_PATH;
import static seedu.duke.common.Messages.INDENTATION;
import static seedu.duke.common.Messages.MESSAGE_TASKS_DONE;
import static seedu.duke.common.Messages.MESSAGE_TASKS_TO_LIST_UNDONE;
import static seedu.duke.common.Messages.NEWLINE;
import static seedu.duke.storage.Writer.recursivelyRemoveFiles;

public class TestUtilAndConstants {

    //@@author H-horizon
    public static final String INPUT_ADD_TASK_DESCRIPTION = "iP submission";
    public static final String INPUT_ADD_TASK_REMARKS = "Remember to attach the jar file.";
    public static final String INPUT_INVALID_IS_GRADED = "no";

    public static final String EXPECTED_ADD_LESSON = "Added Tutorial to lesson list." + NEWLINE;
    public static final String EXPECTED_ADD_TASK = "Added iP submission to task list.";
    public static final String EXPECTED_DELETE_LESSON = "Removed Lab." + NEWLINE
            + "Removed Tutorial." + NEWLINE;
    public static final String EXPECTED_OPEN_LINK = "Opening lab link in browser." + NEWLINE
            + "Opening tutorial link in browser." + NEWLINE;
    public static final String EXPECTED_MODULE_OVERVIEW = "<Overview for CS3235>" + NEWLINE
            + "Lab - Wednesday 9 pm - 10 pm" + NEWLINE + "Tutorial - Wednesday 9 am - 10am"
            + NEWLINE + NEWLINE + MESSAGE_TASKS_TO_LIST_UNDONE + NEWLINE 
            + "1. iP submission (graded) - 3 Mar 2021%s"
            + NEWLINE + INDENTATION + "remember to attach JAR file" + NEWLINE;
    public static final String EXPECTED_ENTER_MODULE = "Opening CS2106." + NEWLINE + NEWLINE
            + "<Overview for CS2106>" + NEWLINE + NEWLINE + MESSAGE_TASKS_TO_LIST_UNDONE + NEWLINE
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
        recursivelyRemoveFiles(directory);
    }

    //@@author aliciatay-zls
    /**
     * Creates task list for use by all tests on task commands.
     * @return pre-populated task list
     */
    public static ArrayList<Task> initialiseTaskList() {
        Module module = ModuleList.getSelectedModule();
        
        LocalDate deadline1 = LocalDate.parse("23-2-2021", FORMATTER);
        Task task1 = new Task("weekly exercise", deadline1, "Do before 2359.");
        task1.setGraded(true);
        module.addTask(task1);

        LocalDate deadline3 = LocalDate.parse("26-2-2021", FORMATTER);
        Task task2 = new Task("lecture quiz", deadline3, "Complete before next lecture.");
        module.addTask(task2);
        
        Task task3 = new Task("read up notes", deadline3, "");
        module.addTask(task3);
        
        LocalDate deadline4 = LocalDate.parse("3-3-2021", FORMATTER);
        Task task4 = new Task("iP submission", deadline4, "Remember to attach the jar file.");
        task4.setGraded(true);
        task4.setDone(true);
        module.addTask(task4);
        
        LocalDate deadline2 = LocalDate.parse("25-2-2021", FORMATTER);
        Task task5 = new Task("watch video snippets", deadline2, "");
        task5.setDone(true);
        module.addTask(task5);

        ModuleList.sortTasks();

        return module.getTaskList();
    }
    
    public static void initialiseModuleList() {
        TestUtilAndConstants.removeFiles();
        ModuleList.loadModuleCodes();
        ModuleList.addModule(MODULE_CODE_1);
        ModuleList.setSelectedModule(MODULE_CODE_1);
    }

    //@@author ivanchongzhien

    /**
     * Empties the modules in the list that were used for testing.
     */
    public static void emptyModuleList() {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 1; i <= ModuleList.getModules().size(); i++) {
            indices.add(i);
        }
        ModuleList.deleteModules(indices);
    }
}
