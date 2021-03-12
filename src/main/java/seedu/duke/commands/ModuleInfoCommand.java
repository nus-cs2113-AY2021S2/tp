package seedu.duke.commands;

import seedu.duke.exception.CommandException;
import seedu.duke.lesson.Lesson;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static seedu.duke.common.CommonMethods.getLessonTypeString;
import static seedu.duke.common.Messages.FORMAT_LESSONS_INFO;
import static seedu.duke.common.Messages.FORMAT_MODULE_INFO;
import static seedu.duke.common.Messages.FORMAT_TASK_INFO;
import static seedu.duke.common.Messages.NEWLINE;
import static seedu.duke.common.Messages.UNDONE_TASK;

public class ModuleInfoCommand extends Command {

    public ModuleInfoCommand() {
        Module module = ModuleList.getSelectedModule();
        String moduleCode = module.getModuleCode();
        System.out.print(String.format(FORMAT_MODULE_INFO, moduleCode));
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
            String lessonName = getLessonTypeString(lesson.getLessonType());
            String lessonTime = lesson.getTime();
            System.out.print(String.format(FORMAT_LESSONS_INFO, lessonName, lessonTime));
        }
    }

    public static void printTasksFromList(ArrayList<Task> tasksList) {
        int counter = 1;
        for (Task task : tasksList) {
            System.out.print(String.format(FORMAT_TASK_INFO, counter, task.getDescription()));
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
