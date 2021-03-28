package seedu.duke.task.command;

import seedu.duke.Ui;
import seedu.duke.task.*;

public class DeleteTask {
    public static void deleteTask(int taskTypeNumber) {
        if (TaskManager.taskListIsEmpty(taskTypeNumber)) {
            Ui.printTaskListIsEmptyMessage();
            return;
        }
        Ui.printSelectTaskNumberToDelete(taskTypeNumber);
        while (true) {
            try {
                int taskNumber = Integer.parseInt(Ui.readCommand());
                Ui.printHorizontalLine();
                switch (taskTypeNumber) {
                case 1:
                    findAndDeleteTask(taskNumber);
                    break;
                case 2:
                    findAndDeleteAssigment(taskNumber);
                    break;
                case 3:
                    findAndDeleteMidterm(taskNumber);
                    break;
                case 4:
                    findAndDeleteFinalExam(taskNumber);
                    break;
                default:
                    Ui.printInvalidIntegerMessage();
                }
                return;
            } catch (NumberFormatException e) {
                Ui.printInvalidIntegerMessage();
            } catch (IndexOutOfBoundsException e) {
                Ui.printInvalidTaskNumberMessage();
            }
        }
    }

    public static void findAndDeleteTask(int taskNumber) {
        Task deletedTask = TaskManager.tasks.get(taskNumber - 1);
        TaskManager.tasks.remove(deletedTask);
        boolean typeTaskIsPinned = TaskManager.pinnedTasks.containsKey("[Task]");
        if (typeTaskIsPinned) {
            assert TaskManager.pinnedTasks.containsKey("[Task]") : "Pinned task list for task should exist";
            if (TaskManager.pinnedTasks.get("[Task]").contains((deletedTask))) {
                assert !TaskManager.pinnedTasks.get("[Task]").isEmpty() : "Pinned task list should not be empty";
                TaskManager.pinnedTasks.get("[Task]").remove(deletedTask);
            }
        }
        Ui.printDeletedTaskMessage(deletedTask);
    }

    public static void findAndDeleteAssigment(int taskNumber) {
        Assignment deletedAssignment = TaskManager.assignments.get(taskNumber - 1);
        TaskManager.assignments.remove(deletedAssignment);
        boolean typeAssignmentIsPinned = TaskManager.pinnedTasks.containsKey("[Assignment]");
        if (typeAssignmentIsPinned) {
            assert TaskManager.pinnedTasks.containsKey("[Assignment]") : "Pinned task list for assignment should exist";
            if (TaskManager.pinnedTasks.get("[Assignment]").contains((deletedAssignment))) {
                assert !TaskManager.pinnedTasks.get("[Assignment]").isEmpty() : "Pinned task list should not be empty";
                TaskManager.pinnedTasks.get("[Assignment]").remove(deletedAssignment);
            }
        }
        Ui.printDeletedTaskMessage(deletedAssignment);
    }

    public static void findAndDeleteMidterm(int taskNumber) {
        Midterm deletedMidterm = TaskManager.midterms.get(taskNumber - 1);
        TaskManager.midterms.remove(deletedMidterm);
        boolean typeMidtermIsPinned = TaskManager.pinnedTasks.containsKey("[Midterm]");
        if (typeMidtermIsPinned) {
            assert TaskManager.pinnedTasks.containsKey("[Midterm]") : "Pinned task list for midterm should exist";
            if (TaskManager.pinnedTasks.get("[Midterm]").contains((deletedMidterm))) {
                assert !TaskManager.pinnedTasks.get("[Midterm]").isEmpty() : "Pinned task list should not be empty";
                TaskManager.pinnedTasks.get("[Midterm]").remove(deletedMidterm);
            }
        }
        Ui.printDeletedTaskMessage(deletedMidterm);
    }

    public static void findAndDeleteFinalExam(int taskNumber) {
        FinalExam deletedFinalExam = TaskManager.finalExams.get(taskNumber - 1);
        TaskManager.finalExams.remove(deletedFinalExam);
        boolean typeFinalExamIsPinned = TaskManager.pinnedTasks.containsKey("[Final Exam]");
        if (typeFinalExamIsPinned) {
            assert TaskManager.pinnedTasks.containsKey("[Final Exam]") : "Pinned task list for final exam should exist";
            if (TaskManager.pinnedTasks.get("[Final Exam]").contains((deletedFinalExam))) {
                assert !TaskManager.pinnedTasks.get("[Final Exam]").isEmpty() : "Pinned task list should not be empty";
                TaskManager.pinnedTasks.get("[Final Exam]").remove(deletedFinalExam);
            }
        }
        Ui.printDeletedTaskMessage(deletedFinalExam);
    }
}
