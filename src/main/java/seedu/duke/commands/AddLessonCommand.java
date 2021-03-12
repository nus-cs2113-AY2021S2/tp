package seedu.duke.commands;

import seedu.duke.lesson.Lesson;
import seedu.duke.lesson.LessonType;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;


import static seedu.duke.common.CommonMethods.getLessonTypeString;
import static seedu.duke.common.Messages.MESSAGE_ADDED_LESSON;


public class AddLessonCommand extends Command {

    private final Lesson lesson;

    public AddLessonCommand(Lesson lesson) {
        this.lesson = lesson;
    }

    /**
     * Adds new lesson to selected module.
     *
     * @param ui Instance of UI.
     */
    @Override
    public void execute(UI ui) {
        Module module = ModuleList.getSelectedModule();
        module.addLesson(lesson);
        LessonType lessonType = lesson.getLessonType();
        String lessonTypeString = getLessonTypeString(lessonType);
        ui.printMessage(String.format(MESSAGE_ADDED_LESSON, lessonTypeString));
        ModuleList.writeModule();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
