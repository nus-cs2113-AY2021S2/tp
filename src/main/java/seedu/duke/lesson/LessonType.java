package seedu.duke.lesson;

import static seedu.duke.common.Constants.LAB_STRING;
import static seedu.duke.common.Constants.LECTURE_STRING;
import static seedu.duke.common.Constants.TUTORIAL_STRING;

public enum LessonType {
    LECTURE, LAB, TUTORIAL;

    //@@author 8kdesign
    /**
     * Returns string of lesson type.
     *
     * @param lessonType Lesson type to convert.
     * @return String of lesson type.
     */
    public static String getLessonTypeString(LessonType lessonType) {
        switch (lessonType) {
        case LECTURE:
            return LECTURE_STRING;
        case TUTORIAL:
            return TUTORIAL_STRING;
        default:
            return LAB_STRING;
        }
    }

    /**
     * Returns lesson type if valid, null if invalid.
     *
     * @param input String of type.
     * @return Lesson type specified.
     */
    public static LessonType getLessonTypeFromString(String input) {
        switch (input.toLowerCase()) {
        case LECTURE_STRING:
            return LessonType.LECTURE;
        case TUTORIAL_STRING:
            return LessonType.TUTORIAL;
        case LAB_STRING:
            return LessonType.LAB;
        default:
            return null;
        }
    }
}
