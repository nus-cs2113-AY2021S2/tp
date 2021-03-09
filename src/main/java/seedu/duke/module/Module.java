package seedu.duke.module;

import seedu.duke.lesson.Lesson;
import seedu.duke.task.Task;

import java.util.ArrayList;

public class Module {

    private final String moduleCode;
    private final ArrayList<Lesson> lessonList = new ArrayList<>();
    private final ArrayList<Task> taskList = new ArrayList<>();

    public Module(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void addLessonToList(Lesson newLesson) {
        lessonList.add(newLesson);
    }

    public void deleteLessonFromList(ArrayList<Lesson> lessonList, int index) {
        lessonList.remove(index);
    }

    public ArrayList<Lesson> getLessonList() {
        return lessonList;
    }


    public ArrayList<Lesson> getLessonList() {
        return lessonList;
    }

    public void addLesson(Lesson lesson) {
        lessonList.add(lesson);
    }

    //Task
    public ArrayList<Task> getTaskList() {
        return taskList;
    }
  
    public void addTask(Task task) {
        taskList.add(task);
    }

    public Task getTaskAtIndex(int index) {
        return taskList.get(index - 1);
    }

    public void addTaskToList(Task task) {
        taskList.add(task);
    }

    public void deleteTaskFromList(Task task) {
        taskList.remove(task);
    }

    public void markTaskInList(Task task) {
        task.setDone(true);
    }

    public void unmarkTaskInList(Task task) {
        task.setDone(false);
    }
}
