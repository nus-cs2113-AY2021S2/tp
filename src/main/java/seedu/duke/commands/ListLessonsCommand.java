package seedu.duke.commands;

import seedu.duke.exception.CommandException;
import seedu.duke.lesson.Lesson;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static seedu.duke.commands.DeleteLessonCommand.getLessonName;
import static seedu.duke.common.Messages.FORMAT_PRINT_LESSON;
import static seedu.duke.common.Messages.MESSAGE_LESSONS_TO_LIST;

public class ListLessonsCommand extends Command {

    public ListLessonsCommand() {

    }

    @Override
    public void execute(UI ui) throws CommandException {
        Module module = ModuleList.getSelectedModule();
        String moduleCode = module.getModuleCode();
        ui.printMessage(String.format(MESSAGE_LESSONS_TO_LIST, moduleCode));
        ArrayList<Lesson> lessonList = module.getLessonList();
        printLessonsFromList(lessonList, ui);
    }

    @Override
    public boolean isExit() {
        return false;
    }

    public static void printLessonsFromList(ArrayList<Lesson> lessonList, UI ui) {
        int counter = 1;
        for (Lesson lesson : lessonList) {
            String lessonName = getLessonName(lesson);
            String lessonTime = lesson.getTime();
            String lessonOnlineLink = lesson.getOnlineLink();
            String teacherName = lesson.getTeachingStaff().getName();
            String teacherEmail = lesson.getTeachingStaff().getEmail();
            ui.printMessage(String.format(FORMAT_PRINT_LESSON, counter, lessonName, lessonTime, lessonOnlineLink,
                    teacherName, teacherEmail));
            counter++;
        }
    }
}
