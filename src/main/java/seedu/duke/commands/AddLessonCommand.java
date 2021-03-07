package seedu.duke.commands;

import seedu.duke.lesson.Lesson;
import seedu.duke.lesson.LessonType;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

public class AddLessonCommand extends Command{
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
        //Will need to add this to UI during merging(Delete comment)
        System.out.println(String.format("Added %s", getLessonTypeString(newLessonForModule.getLessonType())));
    }

    private String getLessonTypeString(LessonType lessonType) {
        switch (lessonType) {
        case LECTURE: {
            return "LECTURE";
        }
        case TUTORIAL: {
            return "TUTORIAL";
        }
        default: {
            return "TYPE_LAB";
        }
        }
    }

}
