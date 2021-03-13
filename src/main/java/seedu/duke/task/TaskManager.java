package seedu.duke.task;

import seedu.duke.Ui;

public class TaskManager {

    public static void execute() {
        while (true) {
            Ui.printTaskManagerMenu();
            String command = Ui.readCommand();
            Ui.printHorizontalLine();
            try {
                int taskNumber = Integer.parseInt(command);
                switch (taskNumber) {
                case 1:
                    addNewTask();
                    break;
                case 2:
                    deleteTask();
                    break;
                case 3:
                    viewAllTasks();
                    break;
                case 4:
                    pinTask();
                    break;
                case 5:
                    return;
                default:
                    Ui.printInvalidIntegerMessage();
                }
            } catch (NumberFormatException e) {
                Ui.printInvalidIntegerMessage();
                Ui.printHorizontalLine();
            }
        }
    }

    private static void addNewTask() {
        String dateAndTime = "";

        Ui.printAddTaskMenu();
        int taskNumber = TaskList.getTaskNumber();
        Ui.printHorizontalLine();
        Ui.printAddTaskModuleMessage(taskNumber);
        String module = Ui.readCommand();
        Ui.printHorizontalLine();
        Ui.printAddTaskDescriptionMessage(taskNumber);
        String description = Ui.readCommand();
        Ui.printHorizontalLine();
        if (taskNumber != 1) {
            dateAndTime = TaskList.getDate(taskNumber) + ", " + TaskList.getTime(taskNumber);
        }
        Ui.printAddMessageAfterCompletedTask();
        String message = Ui.readCommand();


        switch (taskNumber) {
        case 1:
            TaskList.addTask(module, description, message);
            break;
        case 2:
            TaskList.addAssignment(module, description, message, dateAndTime);
            break;
        case 3:
            TaskList.addMidterm(module, description, message, dateAndTime);
            break;
        case 4:
            TaskList.addFinal(module, description, message, dateAndTime);
            break;
        default:
            Ui.printInvalidIntegerMessage();
        }
    }

    private static void viewAllTasks() {
        Ui.printPinnedTaskList(TaskList.pinnedTasks);
        Ui.printEmptyLine();
        Ui.printTaskList(TaskList.tasks);
        Ui.printEmptyLine();
        Ui.printAssignmentList(TaskList.assignments);
        Ui.printEmptyLine();
        Ui.printMidtermList(TaskList.midterms);
        Ui.printEmptyLine();
        Ui.printFinalExamList(TaskList.finalExams);
        Ui.printEmptyLine();
        Ui.printHorizontalLine();
    }

    private static void pinTask() {
        Ui.printPinTaskMenu();
        int taskTypeNumber = TaskList.getTaskNumber();
        Ui.printHorizontalLine();

        TaskList.pinTask(taskTypeNumber);
    }

    private static void deleteTask() {
        Ui.printDeleteTaskMenu();
        int taskTypeNumber = TaskList.getTaskNumber();
        Ui.printHorizontalLine();

        TaskList.deleteTask(taskTypeNumber);
    }
}
