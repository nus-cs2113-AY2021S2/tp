package seedu.allinonenus.teamplannerclasses;

public class TeamMember {
    protected String name;
    protected boolean isTeamLeader;
    protected TaskManager tasks;

    public TeamMember(String name, boolean isTeamLeader) {
        this.name = name;
        this.isTeamLeader = isTeamLeader;
        this.tasks = new TaskManager();
    }

    public String getName() {
        return name;
    }

    public boolean isTeamLeader() {
        return isTeamLeader;
    }

    public void addTask(Task task) {
        tasks.addTask(task);
    }

    public void deleteTask(int taskNum) {
        int taskIndex = tasks.getTaskIndex(taskNum);
        int priorityGroup = tasks.getTaskPriority(taskNum);
        tasks.deleteTask(taskNum, taskIndex, priorityGroup);
    }

    public void markTaskAsDone(int taskNum) {
        (tasks.getTask(taskNum)).markAsDone();
    }

    public int getTaskCount() {
        return tasks.getTaskCount();
    }

    public Task getTask(int taskNum) {
        return tasks.getTask(taskNum);
    }

    @Override
    public String toString() {
        if (isTeamLeader) {
            return "[L] " + name;
        } else {
            return "[M] " + name;
        }
    }
}