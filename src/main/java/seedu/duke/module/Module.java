package seedu.duke.module;

import seedu.duke.lesson.Lesson;
import seedu.duke.task.Task;

import java.util.ArrayList;

public class Module {

    private final String MODULE_CODE;
    public final ArrayList<Lesson> lessonList = new ArrayList<>();
    public final ArrayList<Task> taskList = new ArrayList<>();

    public Module(String moduleCode) {
        MODULE_CODE = moduleCode;
    }

    public String getModuleCode() {
        return MODULE_CODE;
    }
}
