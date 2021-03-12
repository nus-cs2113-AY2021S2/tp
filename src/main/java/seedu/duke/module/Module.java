package seedu.duke.module;

import seedu.duke.lesson.Lesson;
import seedu.duke.task.Task;

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

    //Lesson
    public ArrayList<Lesson> getLessonList() {
        return lessonList;
    }

    public void addLesson(Lesson lesson) {
        lessonList.add(lesson);
    }

    public void removeLesson(int index) {
        lessonList.remove(index);
    }

    //Task
    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void removeTask(Task task) {
        taskList.remove(task);
    }

    public void markTask(Task task) {
        task.setDone(true);
    }

    public void unmarkTask(Task task) {
        task.setDone(false);
    }

    public ArrayList<Task> getDoneOrUndoneTasks(boolean isDone) {
        ArrayList<Task> filteredTasks = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getDone() == isDone) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }
}
