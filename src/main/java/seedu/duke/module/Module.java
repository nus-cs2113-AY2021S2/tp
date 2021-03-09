package seedu.duke.module;

import seedu.duke.lesson.Lesson;
import seedu.duke.task.Task;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Module {

    private final String moduleCode;
    private final ArrayList<Lesson> lessonList;
    private final ArrayList<Task> taskList;

    public Module(String moduleCode) {
        this.moduleCode = moduleCode;
        this.lessonList = new ArrayList<>();
        this.taskList = new ArrayList<>();
    }

    public String getModuleCode() {
        return moduleCode;
    }
}
