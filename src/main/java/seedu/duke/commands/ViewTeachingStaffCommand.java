package seedu.duke.commands;

import seedu.duke.lesson.Lesson;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.util.ArrayList;

public class ViewTeachingStaffCommand extends Command{

    public static final String PRINT_LESSONS_FORMAT = "%d. %s - %s";

    public ViewTeachingStaffCommand() {
        Module module = ModuleList.getSelectedModule();
        System.out.println(String.format("Teaching staff for %s:", module.getModuleCode()));
    }

    @Override
    public void execute(ModuleList moduleList, UI ui) {
        Module module = ModuleList.getSelectedModule();
        ArrayList<Lesson> lessonList = module.getLessonList();
        int counter = 1;
        for (Lesson lesson : lessonList) {
            System.out.println(String.format(PRINT_LESSONS_FORMAT, counter, lesson.getTeachingStaff().getName(),
                    lesson.getTeachingStaff().getEmail()));
            counter++;
        }

    }
}
