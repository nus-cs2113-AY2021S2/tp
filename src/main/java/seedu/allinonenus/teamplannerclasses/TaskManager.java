package seedu.allinonenus.teamplannerclasses;

import java.util.ArrayList;

public class TaskManager {
    private ArrayList<ArrayList<Task>> taskList;
    private int taskCount = 0;

    public TaskManager() {
        this.taskList = new ArrayList<ArrayList<Task>>();
        taskList.add(new ArrayList<Task>());
        taskList.add(new ArrayList<Task>());
        taskList.add(new ArrayList<Task>());
    }

    public void addTask(Task task) {
        if (task.getPriority() == 1) { //High Priority
            taskList.get(0).add(task);
        } else if (task.getPriority() == 2) { //Medium Priority
            taskList.get(1).add(task);
        } else if (task.getPriority() == 3) { //Low Priority
            taskList.get(2).add(task);
        }
        taskCount++;
    }

    public void deleteTask(int taskNum, int taskIndex, int priorityGroup) {
            System.out.println(taskList.get(priorityGroup).get(taskIndex) + " has been removed");
            taskList.get(priorityGroup).remove(taskIndex);
            taskCount--;
    }

    public int getTaskCount() {
        return taskCount;
    }

    public Task getTask(int index) {
        int priorityGroup = 0;
        int taskIndex = index;
        if (taskList.get(priorityGroup).isEmpty() || taskIndex >= taskList.get(priorityGroup).size()) {
            taskIndex -= taskList.get(priorityGroup).size();
            priorityGroup = 1;
        }
        if (taskList.get(priorityGroup).isEmpty() || taskIndex >= taskList.get(priorityGroup).size()) {
            taskIndex -= taskList.get(priorityGroup).size();
            priorityGroup = 2;
        }
        return taskList.get(priorityGroup).get(taskIndex);
    }

    public int getTaskIndex(int index) {
        int priorityGroup = 0;
        int taskIndex = index;
        if (taskList.get(priorityGroup).isEmpty() || taskIndex >= taskList.get(priorityGroup).size()) {
            taskIndex -= taskList.get(priorityGroup).size();
            priorityGroup = 1;
        }
        if (taskList.get(priorityGroup).isEmpty() || taskIndex >= taskList.get(priorityGroup).size()) {
            taskIndex -= taskList.get(priorityGroup).size();
            priorityGroup = 2;
        }
        return taskIndex;
    }

    public int getTaskPriority(int index) {
        int priorityGroup = 0;
        int taskIndex = index;
        if (taskList.get(priorityGroup).isEmpty() || taskIndex >= taskList.get(priorityGroup).size()) {
            taskIndex -= taskList.get(priorityGroup).size();
            priorityGroup = 1;
        }
        if (taskList.get(priorityGroup).isEmpty() || taskIndex >= taskList.get(priorityGroup).size()) {
            taskIndex -= taskList.get(priorityGroup).size();
            priorityGroup = 2;
        }
        return priorityGroup;
    }

    public void clearTask() {
        taskList.clear();
    }

}
