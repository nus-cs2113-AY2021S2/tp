package seedu.duke.commands;

import seedu.duke.exception.CommandException;
import seedu.duke.lesson.Lesson;
import seedu.duke.lesson.LessonType;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static seedu.duke.commands.ListLessonsCommand.printLessons;


public class SortLessonsCommand extends Command {

    @Override
    public void execute(UI ui) throws CommandException {
        ui.printMessage("Sorting list of lessons based on lesson type...");
        Module module = ModuleList.getSelectedModule();
        ArrayList<Lesson> lessonList = module.getLessonList();
        sortLessonList(ui, lessonList);
    }

    private void sortLessonList(UI ui, ArrayList<Lesson> lessonList) {
        ArrayList<Lesson> sortedLessonList = new ArrayList<>();
        sortByLessonType(lessonList, sortedLessonList, LessonType.LECTURE);
        sortByLessonType(lessonList, sortedLessonList, LessonType.TUTORIAL);
        sortByLessonType(lessonList, sortedLessonList, LessonType.LAB);
        lessonList = sortedLessonList;
        printLessons(lessonList, ui);
    }

    public void sortByLessonType(ArrayList<Lesson> lessonList, ArrayList<Lesson> sortedLessonList, LessonType lecture) {
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
