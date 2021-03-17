package seedu.duke.commands;

import seedu.duke.exception.CommandException;
import seedu.duke.lesson.Lesson;
import seedu.duke.lesson.LessonType;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static seedu.duke.commands.ListLessonsCommand.printLessons;
import static seedu.duke.common.Messages.MESSAGE_SORT_LESSON_LIST;

/**
 * Represents the command used to sort the lessons on the list of lessons.
 */
public class SortLessonsCommand extends Command {

    @Override
    public void execute(UI ui) throws CommandException {
        ui.printMessage(MESSAGE_SORT_LESSON_LIST);
        Module module = ModuleList.getSelectedModule();
        ArrayList<Lesson> lessonList = module.getLessonList();
        sortLessonList(ui, lessonList);
    }

    /**
     * Sorts lessons based on their lesson type.
     *
     * @param ui         Instance of UI.
     * @param lessonList ArrayList of lessons.
     */
    private void sortLessonList(UI ui, ArrayList<Lesson> lessonList) {
        ArrayList<Lesson> sortedLessonList = new ArrayList<>();
        filterByLessonType(lessonList, sortedLessonList, LessonType.LECTURE);
        filterByLessonType(lessonList, sortedLessonList, LessonType.TUTORIAL);
        filterByLessonType(lessonList, sortedLessonList, LessonType.LAB);
        lessonList = sortedLessonList;
        printLessons(lessonList, ui);
    }

    /**
     * Filters lessons of a particular type and add them to a new list.
     *
     * @param lessonList       ArrayList of lessons.
     * @param sortedLessonList Sorted arrayList of lessons.
     * @param lecture          Type of Lecture
     */
    public void filterByLessonType(ArrayList<Lesson> lessonList, ArrayList<Lesson> sortedLessonList,
                                   LessonType lecture) {
        for (Lesson lesson : lessonList) {
            if (lesson.getLessonType().equals(lecture)) {
                sortedLessonList.add(lesson);
            }
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
