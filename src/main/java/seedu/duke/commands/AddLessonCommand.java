package seedu.duke.commands;

import seedu.duke.lesson.Lesson;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import static seedu.duke.common.Messages.MESSAGE_ADDED_LESSON;

/**
 * Represents the command used to add a new lesson to the list of lessons.
 */
public class AddLessonCommand extends Command {

    private final Lesson lesson;

    //@@author H-horizon
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
        String lessonTypeString = lesson.getLessonTypeString();
        ui.printMessage(String.format(MESSAGE_ADDED_LESSON, lessonTypeString));
        ModuleList.writeModule();
        ModuleList.sortLessons();
    }
}
