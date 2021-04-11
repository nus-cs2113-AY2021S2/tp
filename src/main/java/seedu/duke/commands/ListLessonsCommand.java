package seedu.duke.commands;

import seedu.duke.lesson.Lesson;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static seedu.duke.common.Messages.FORMAT_INDEX_ITEM_DETAILS;
import static seedu.duke.common.Messages.INDENTATION;
import static seedu.duke.common.Messages.MESSAGE_LESSONS_LIST_EMPTY;
import static seedu.duke.common.Messages.MESSAGE_LESSONS_TO_LIST;

/**
 * Represents the command used to print the list of lessons.
 */
public class ListLessonsCommand extends Command {

    //@@author H-horizon

    /**
     * Prints list of lessons in selected module.
     *
     * @param ui Instance of UI.
     */
    @Override
    public void execute(UI ui) {
        Module module = ModuleList.getSelectedModule();
        String moduleCode = module.getModuleCode();

        if (module.getLessonList().size() > 0) {
            ui.printMessage(String.format(MESSAGE_LESSONS_TO_LIST, moduleCode));
            printLessons(module.getLessonList(), ui);
        } else {
            ui.printMessage(MESSAGE_LESSONS_LIST_EMPTY);
        }
    }

    /**
     * Prints list of lessons.
     *
     * @param lessonList ArrayList of lessons.
     * @param ui         Instance of lessons.
     */
    public static void printLessons(ArrayList<Lesson> lessonList, UI ui) {
        int counter = 1;
        for (Lesson lesson : lessonList) {
            String lessonType = lesson.getLessonTypeString();
            String lessonTime = lesson.getTime();
            ui.printMessage(String.format(FORMAT_INDEX_ITEM_DETAILS, counter, lessonType, lessonTime));
            String lessonOnlineLink = lesson.getOnlineLink();
            if (!lessonOnlineLink.isEmpty()) {
                ui.printMessage(INDENTATION + lessonOnlineLink);
            }
            String teacherName = lesson.getTeachingStaffName();
            if (!teacherName.isEmpty()) {
                ui.printMessage(INDENTATION + teacherName);
            }
            String teacherEmail = lesson.getTeachingStaffEmail();
            if (!teacherEmail.isEmpty()) {
                ui.printMessage(INDENTATION + teacherEmail);
            }
            counter++;
        }
    }
}
