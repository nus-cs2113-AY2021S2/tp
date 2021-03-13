package seedu.duke.common;

import seedu.duke.lesson.LessonType;
import seedu.duke.parser.Parser;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static seedu.duke.common.Constants.LAB_STRING;
import static seedu.duke.common.Constants.LECTURE_STRING;
import static seedu.duke.common.Constants.TUTORIAL_STRING;

public class CommonMethods {

    /**
     * Returns string of lesson type.
     *
     * @param lessonType Lesson type to convert.
     * @return String of lesson type.
     */
    public static String getLessonTypeString(LessonType lessonType) {
        switch (lessonType) {
        case LECTURE: {
            return LECTURE_STRING;
        }
        case TUTORIAL: {
            return TUTORIAL_STRING;
        }
        default: {
            return LAB_STRING;
        }
        }
    }

    //@@author 8kdesign
    /**
     * Returns lesson type if valid, null if invalid.
     *
     * @param input String of type.
     * @return Lesson type specified.
     */
    public static LessonType getLessonType(String input) {
        switch (input.toLowerCase()) {
        case LECTURE_STRING: {
            return LessonType.LECTURE;
        }
        case TUTORIAL_STRING: {
            return LessonType.TUTORIAL;
        }
        case LAB_STRING: {
            return LessonType.LAB;
        }
        default: {
            return null;
        }
        }
    }

    //@@author aliciatay-zls
    /**
     * Requests for list of indices.
     * Returns tasks corresponding to indices specified.
     *
     * @param ui Instance of UI.
     * @param taskList Array list of undone tasks.
     * @return Array list of selected tasks.
     */
    public static ArrayList<Task> getSpecifiedTasks(UI ui, ArrayList<Task> taskList) {
        String line = ui.readCommand();
        ArrayList<Integer> indices = Parser.checkIndices(line, taskList.size());
        //Store the tasks chosen by user to new array list
        ArrayList<Task> selectedTasks = new ArrayList<>();
        for (Integer index : indices) {
            selectedTasks.add(taskList.get(index - 1));
        }
        return selectedTasks;
    }
}
