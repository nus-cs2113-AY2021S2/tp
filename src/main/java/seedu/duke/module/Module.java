package seedu.duke.module;

import seedu.duke.lesson.Lesson;
import seedu.duke.task.Task;

import java.util.ArrayList;

public class Module {

    private final String MODULE_CODE;
    private final ArrayList<Lesson> lessonList = new ArrayList<>();
    private final ArrayList<Task> taskList = new ArrayList<>();

    public Module(String moduleCode) {
        MODULE_CODE = moduleCode;
    }

    public String getModuleCode() {
        return MODULE_CODE;
    }

    public ArrayList<Lesson> getLessonList() {
        return lessonList;
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void addLesson(Lesson lesson) {
        lessonList.add(lesson);
    }

    public void addTask(Task task) {
        taskList.add(task);
    }
}
