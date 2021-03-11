package seedu.duke.module;

import seedu.duke.lesson.Lesson;
import seedu.duke.task.Task;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static seedu.duke.common.Messages.COMMAND_VERB_MARK;
import static seedu.duke.common.Messages.MESSAGE_TASKS_TO_MARK;

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

    public void addLessonToList(Lesson newLesson) {
        lessonList.add(newLesson);
    }

    public void deleteLessonFromList(ArrayList<Lesson> lessonList, int index) {
        lessonList.remove(index);
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

    public ArrayList<Task> getTasksToDelete(UI ui, String message, String commandVerb) {
        ui.printGetChosenTasksPrompt(message, commandVerb, taskList);
        return getChosenTasks(ui, taskList);
    }

    public ArrayList<Task> getTasksToMarkOrUnmark(UI ui, String message, String commandVerb, boolean isDone) {
        ArrayList<Task> tasksToModify = getFilteredTasks(isDone);
        ui.printGetChosenTasksPrompt(message, commandVerb, tasksToModify);
        return getChosenTasks(ui, tasksToModify);
    }

    public ArrayList<Task> getFilteredTasks(boolean isDone) {
        ArrayList<Task> filteredTasks = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getDone() == isDone) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }

    public ArrayList<Task> getChosenTasks(UI ui, ArrayList<Task> tasks) {
        // simulating the parser's checkIndex() method
        ArrayList<Integer> indices = new ArrayList<>();
        String input = ui.readCommand();
        String[] tokens = input.split(" ");
        for (String token : tokens) {
            indices.add(Integer.parseInt(token));
        }
        // store the tasks chosen by user to be deleted/marked/unmarked in a new array list
        ArrayList<Task> chosenTasks = new ArrayList<>();
        for (Integer index : indices) {
            chosenTasks.add(tasks.get(index - 1));
        }
        return chosenTasks;
        // return Parser.checkIndex(readCommand(), taskList.size());
    }
}
