package seedu.duke.commands;

import seedu.duke.exceptions.CommandException;
import seedu.duke.lesson.Lesson;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static seedu.duke.commands.DeleteLessonCommand.getLessonName;
import static seedu.duke.common.Constants.NEWLINE;

public class ModuleInfoCommand extends Command {

    public static final String MESSAGES_LESSONS_INFO_FORMAT = "%s - %s" + NEWLINE;
    public static final String UNDONE_TASK = "Undone tasks:" + NEWLINE;
    public static final String MESSAGES_MODULE_INFO_FORMAT = "<%s>" + NEWLINE;
    public static final String MESSAGES_TASK_INFO_FORMAT = "%d. %s" + NEWLINE;

    public ModuleInfoCommand() {
        Module module = ModuleList.getSelectedModule();
        String moduleCode = module.getModuleCode();
        System.out.print(String.format(MESSAGES_MODULE_INFO_FORMAT, moduleCode));
    }

    @Override
    public void execute(UI ui) throws CommandException {
        Module module = ModuleList.getSelectedModule();
        ArrayList<Lesson> lessonList = module.getLessonList();
        printLessonsFromList(lessonList);
        System.out.print(NEWLINE);
        System.out.print(UNDONE_TASK);
        ArrayList<Task> tasksList = module.getTaskList();
        printTasksFromList(tasksList);
    }

    public static void printLessonsFromList(ArrayList<Lesson> lessonList) {
        for (Lesson lesson : lessonList) {
            String lessonName = getLessonName(lesson);
            String lessonTime = lesson.getTime();
            System.out.print(String.format(MESSAGES_LESSONS_INFO_FORMAT, lessonName, lessonTime));
        }
    }

    public static void printTasksFromList(ArrayList<Task> tasksList) {
        int counter = 1;
        for (Task task : tasksList) {
            System.out.print(String.format(MESSAGES_TASK_INFO_FORMAT, counter, task.getDescription()));
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
