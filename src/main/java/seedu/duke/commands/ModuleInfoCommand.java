package seedu.duke.commands;

import seedu.duke.exception.CommandException;
import seedu.duke.lesson.Lesson;
import seedu.duke.lesson.LessonType;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static seedu.duke.common.Constants.EMPTY_STRING;
import static seedu.duke.common.Messages.FORMAT_ITEM_TIME;
import static seedu.duke.common.Messages.FORMAT_MODULE_INFO;

/**
 * Represents the command used to print the module overview.
 */
public class ModuleInfoCommand extends Command {

    //@@author H-horizon
    /**
     * prints module overview.
     *
     * @param ui Instance of UI.
     * @throws CommandException if command was not constructed properly.
     */
    @Override
    public void execute(UI ui) throws CommandException {
        Module module = ModuleList.getSelectedModule();
        String moduleCode = module.getModuleCode();
        ui.printMessage(String.format(FORMAT_MODULE_INFO, moduleCode));
        ArrayList<Lesson> lessonList = module.getLessonList();
        printLessonsFromList(lessonList, ui);
        ui.printMessage(EMPTY_STRING);
        ListTasksCommand.printFilteredTasks(ui, module, false, true);
    }

    /**
     * prints lessons info for module overview.
     *
     * @param lessonList is the list of lessons.
     */
    public static void printLessonsFromList(ArrayList<Lesson> lessonList, UI ui) {
        for (Lesson lesson : lessonList) {
            String lessonName = LessonType.getLessonTypeString(lesson.getLessonType());
            String lessonTime = lesson.getTime();
            ui.printMessage(String.format(FORMAT_ITEM_TIME, lessonName, lessonTime));
        }
    }
}
