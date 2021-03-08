package seedu.duke.commands;

import seedu.duke.lesson.Lesson;
import seedu.duke.lesson.LessonType;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

public class AddLessonCommand extends Command {
    public static final String MESSAGE_ADDED_LESSON = "Added %s";
    public static final String LECTURE_STRING = "LECTURE";
    public static final String TUTORIAL_STRING = "TUTORIAL";
    public static final String LAB_STRING = "LAB";
    private Lesson newLessonForModule;

    public AddLessonCommand(Lesson newLesson) {
        setNewLessonForModule(newLesson);
    }

    private void setNewLessonForModule(Lesson newLesson) {
        newLessonForModule = newLesson;
    }

    private Lesson getNewLessonForModule() {
        return newLessonForModule;
    }

    @Override
    public void execute(ModuleList moduleList, UI ui) {
        Module module = ModuleList.getSelectedModule();
        module.addLessonToList(getNewLessonForModule());
        LessonType newLessonType = getNewLessonForModule().getLessonType();
        String lessonName = getLessonTypeName(newLessonType);
        System.out.println(String.format(MESSAGE_ADDED_LESSON, lessonName));
    }

    //To be added in common class(DELETE AFTER DONE)
    public static String getLessonTypeName(LessonType lessonType) {
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

}
