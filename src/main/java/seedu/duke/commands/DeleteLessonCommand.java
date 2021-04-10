package seedu.duke.commands;

import seedu.duke.lesson.Lesson;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.parser.ParserUtil;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static seedu.duke.common.Constants.DELETE;
import static seedu.duke.common.Constants.TYPE_LESSON;
import static seedu.duke.common.Messages.FORMAT_INDEX_ITEM;
import static seedu.duke.common.Messages.FORMAT_INDEX_LESSON_DETAILS;
import static seedu.duke.common.Messages.MESSAGE_ENTER_INDICES;
import static seedu.duke.common.Messages.MESSAGE_LESSONS_LIST_EMPTY;
import static seedu.duke.common.Messages.MESSAGE_LESSONS_TO_DELETE;
import static seedu.duke.common.Messages.MESSAGE_REMOVED_LESSON;

/**
 * Represents the command used to delete a lesson from the list of lessons.
 */
public class DeleteLessonCommand extends Command {

    //@@author H-horizon

    /**
     * Deletes all lessons corresponding to specified indices.
     *
     * @param ui Instance of UI.
     */
    @Override
    public void execute(UI ui) {
        Module module = ModuleList.getSelectedModule();
        ArrayList<Lesson> lessonList = module.getLessonList();
        verifyLessonsToDelete(lessonList, ui);
        ModuleList.sortLessons();
    }

    /**
     * Validates lessons to delete from list.
     *
     * @param ui         Instance of UI.
     * @param lessonList ArrayList of lessons in specified module.
     */
    private void verifyLessonsToDelete(ArrayList<Lesson> lessonList, UI ui) {
        if (lessonList.size() == 0) {
            ui.printMessage(MESSAGE_LESSONS_LIST_EMPTY);
        } else {
            ui.printMessage(MESSAGE_LESSONS_TO_DELETE);
            printLessons(lessonList, ui);
            ui.printMessage(String.format(MESSAGE_ENTER_INDICES, TYPE_LESSON, DELETE));
            String line = ui.readUserInput();
            ArrayList<Integer> indices = ParserUtil.checkIndices(line, lessonList.size());
            deleteLessonsFromList(lessonList, indices, ui);
            ModuleList.writeModule();
        }
    }

    /**
     * Prints list of lessons in specified module. 
     * For each lesson, prints lesson type and exactly one detail (a field that was successfully added) 
     * to differentiate same lesson types (e.g. multiple tutorials).
     * Does not print any detail for the lesson if none of its fields have been filled yet.
     *
     * @param lessonList ArrayList of lessons in specified module.
     * @param ui         Instance of UI.
     */
    private static void printLessons(ArrayList<Lesson> lessonList, UI ui) {
        int counter = 1;
        for (Lesson lesson : lessonList) {
            String lessonType = lesson.getLessonTypeString();
            if (lesson.getDetailsStringIfAny() != null) {
                String appendString = lesson.getDetailsStringIfAny();
                ui.printMessage(String.format(FORMAT_INDEX_LESSON_DETAILS, counter, lessonType, appendString));
            } else {
                ui.printMessage(String.format(FORMAT_INDEX_ITEM, counter, lessonType));
            }
            counter++;
        }
    }

    /**
     * Removes lessons corresponding to the indices from the specified module.
     *
     * @param lessonList ArrayList of lessons in specified module.
     * @param indices    Indices of lessons to delete.
     * @param ui         Instance of UI.
     */
    public static void deleteLessonsFromList(ArrayList<Lesson> lessonList, ArrayList<Integer> indices, UI ui) {
        int pointer = 1;
        for (int index : indices) {
            int modifiedIndex = index - pointer;
            Lesson lesson = lessonList.get(modifiedIndex);
            String lessonType = lesson.getLessonTypeString();
            ui.printMessage(String.format(MESSAGE_REMOVED_LESSON, lessonType));
            ModuleList.getSelectedModule().removeLesson(modifiedIndex);
            pointer++;
        }
    }
}
