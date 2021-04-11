package seedu.duke.module;

import seedu.duke.lesson.Lesson;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

import java.time.LocalDate;
import java.util.ArrayList;

import static seedu.duke.common.Messages.MESSAGE_DUPLICATE_TASK;
import static seedu.duke.common.Messages.MESSAGE_SAME_DESCRIPTION_TASK;
import static seedu.duke.common.Constants.FORMAT_MODULE_CODE;

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

    //@@author aliciatay-zls
    /**
     * Returns array list of done/undone tasks.
     *
     * @param isDone Boolean to filter done or undone.
     * @return Array list of filtered tasks.
     */
    public ArrayList<Task> getDoneOrUndoneTasks(boolean isDone) {
        ArrayList<Task> filteredTasks = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getDone() == isDone) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }

    /**
     * Prevents task from being added once a duplicate (same task description and deadline) 
     * is found in the list. If same task description but different deadline, suggest 
     * editing task fields instead.
     * 
     * @param ui Instance of UI
     * @param targetTask Task the user is trying to add to the list
     * @return true when no task with same description is found.
     */
    public boolean isAddTaskAllowed(UI ui, Task targetTask) {
        String targetDescription = targetTask.getDescription().toUpperCase();
        LocalDate targetDeadline = targetTask.getDeadline();
        for (Task task : taskList) {
            if (targetDescription.equals(task.getDescription().toUpperCase())) {
                if (targetDeadline.equals(task.getDeadline())) {
                    ui.printMessage(MESSAGE_DUPLICATE_TASK);
                    return false;
                }
                ui.printMessage(MESSAGE_SAME_DESCRIPTION_TASK);
                return false;
            }
        }
        return true;
    }

    //@@author ivanchongzhien
    /**
     * Checks if given string is a valid module name.
     *
     * @param moduleCode string to be validated
     * @return true if string is a valid module name
     */
    public static boolean isValidModuleCode(String moduleCode) {
        moduleCode = moduleCode.trim();

        // check that input matches the convention of a standard NUS module code.
        return (moduleCode.matches(FORMAT_MODULE_CODE));
    }
}
