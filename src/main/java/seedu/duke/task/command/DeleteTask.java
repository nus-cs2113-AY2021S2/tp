package seedu.duke.task.command;

import seedu.duke.Ui;
import seedu.duke.task.*;

public class DeleteTask {
    public static void deleteTask(int taskTypeNumber) {
        if (TaskList.taskListIsEmpty(taskTypeNumber)) {
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
        Task deletedTask = TaskList.tasks.get(taskNumber - 1);
        TaskList.tasks.remove(deletedTask);
        boolean typeTaskIsPinned = TaskList.pinnedTasks.containsKey("[Task]");
        if (typeTaskIsPinned) {
            assert TaskList.pinnedTasks.containsKey("[Task]") : "Pinned task list for task should exist";
            if (TaskList.pinnedTasks.get("[Task]").contains((deletedTask))) {
                assert !TaskList.pinnedTasks.get("[Task]").isEmpty() : "Pinned task list should not be empty";
                TaskList.pinnedTasks.get("[Task]").remove(deletedTask);
            }
        }
        Ui.printDeletedTaskMessage(deletedTask);
    }

    public static void findAndDeleteAssigment(int taskNumber) {
        Assignment deletedAssignment = TaskList.assignments.get(taskNumber - 1);
        TaskList.assignments.remove(deletedAssignment);
        boolean typeAssignmentIsPinned = TaskList.pinnedTasks.containsKey("[Assignment]");
        if (typeAssignmentIsPinned) {
            assert TaskList.pinnedTasks.containsKey("[Assignment]") : "Pinned task list for assignment should exist";
            if (TaskList.pinnedTasks.get("[Assignment]").contains((deletedAssignment))) {
                assert !TaskList.pinnedTasks.get("[Assignment]").isEmpty() : "Pinned task list should not be empty";
                TaskList.pinnedTasks.get("[Assignment]").remove(deletedAssignment);
            }
        }
        Ui.printDeletedTaskMessage(deletedAssignment);
    }

    public static void findAndDeleteMidterm(int taskNumber) {
        Midterm deletedMidterm = TaskList.midterms.get(taskNumber - 1);
        TaskList.midterms.remove(deletedMidterm);
        boolean typeMidtermIsPinned = TaskList.pinnedTasks.containsKey("[Midterm]");
        if (typeMidtermIsPinned) {
            assert TaskList.pinnedTasks.containsKey("[Midterm]") : "Pinned task list for midterm should exist";
            if (TaskList.pinnedTasks.get("[Midterm]").contains((deletedMidterm))) {
                assert !TaskList.pinnedTasks.get("[Midterm]").isEmpty() : "Pinned task list should not be empty";
                TaskList.pinnedTasks.get("[Midterm]").remove(deletedMidterm);
            }
        }
        Ui.printDeletedTaskMessage(deletedMidterm);
    }

    public static void findAndDeleteFinalExam(int taskNumber) {
        FinalExam deletedFinalExam = TaskList.finalExams.get(taskNumber - 1);
        TaskList.finalExams.remove(deletedFinalExam);
        boolean typeFinalExamIsPinned = TaskList.pinnedTasks.containsKey("[Final Exam]");
        if (typeFinalExamIsPinned) {
            assert TaskList.pinnedTasks.containsKey("[Final Exam]") : "Pinned task list for final exam should exist";
            if (TaskList.pinnedTasks.get("[Final Exam]").contains((deletedFinalExam))) {
                assert !TaskList.pinnedTasks.get("[Final Exam]").isEmpty() : "Pinned task list should not be empty";
                TaskList.pinnedTasks.get("[Final Exam]").remove(deletedFinalExam);
            }
        }
        Ui.printDeletedTaskMessage(deletedFinalExam);
    }
}
