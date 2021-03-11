package seedu.duke.ui;

import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import static seedu.duke.common.Constants.FORMAT_DATE_NORMAL;
import static seedu.duke.common.Constants.NO_STRING;
import static seedu.duke.common.Constants.YES_STRING;
import static seedu.duke.common.Messages.FORMAT_INDEX_ITEM;
import static seedu.duke.common.Messages.FORMAT_PRINT_TASK;
import static seedu.duke.common.Messages.HEADER_DONE;
import static seedu.duke.common.Messages.HEADER_UNDONE;
import static seedu.duke.common.Messages.MESSAGE_EXIT;
import static seedu.duke.common.Messages.MESSAGE_GRADED;
import static seedu.duke.common.Messages.MESSAGE_TASKS_TO_LIST;
import static seedu.duke.common.Messages.MESSAGE_TASK_SELECT_INFO;
import static seedu.duke.common.Messages.MESSAGE_TASK_SET_GRADED;
import static seedu.duke.common.Messages.MESSAGE_TASK_SET_GRADED_INFO;
import static seedu.duke.common.Messages.MESSAGE_WELCOME;
import static seedu.duke.common.Messages.NEWLINE;
import static seedu.duke.common.Messages.TAG_GULIO;
import static seedu.duke.common.Messages.TAG_MODULE;

public class UI {
  
    private final Scanner in;

    public UI() {
        in = new Scanner(System.in);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printWelcome() {
        System.out.println(TAG_GULIO + MESSAGE_WELCOME);
    }

    public void printBye() {
        System.out.println(MESSAGE_EXIT);
    }

    public String readCommand() {
        return in.nextLine();
    }

    public void printModuleIndicator() {
        if (ModuleList.getSelectedModule() == null) {
            System.out.print(TAG_GULIO);
        } else {
            String moduleCode = ModuleList.getSelectedModule().getModuleCode();
            System.out.printf(TAG_MODULE, moduleCode);
        }
    }

    public boolean getIsTaskGraded() {
        printMessage(MESSAGE_TASK_SET_GRADED);
        String userInput = readCommand();
        while (!userInput.equals(YES_STRING) && !userInput.equals(NO_STRING)) {
            printMessage(MESSAGE_TASK_SET_GRADED_INFO);
            userInput = readCommand();
        }
        return userInput.equals(YES_STRING);
    }

    public void printGetChosenTasksPrompt(String message, String commandVerb, ArrayList<Task> taskList) {
        printMessage(message);
        printSummarisedTasks(taskList);
        printTaskInstructions(commandVerb);
    }

    // Prints only descriptions of all tasks in the task list.
    public void printSummarisedTasks(ArrayList<Task> taskList) {
        int tasksCount = 0;
        for (Task task : taskList) {
            tasksCount++;
            String taskListItem = String.format(FORMAT_INDEX_ITEM, tasksCount, task.getDescription());
            printMessage(taskListItem);
        }
    }

    public void printTaskInstructions(String commandVerb) {
        String instructions = String.format(MESSAGE_TASK_SELECT_INFO, commandVerb);
        printMessage(instructions);
    }

    // Prints all tasks in the task list.
    public void printAllTasks(String moduleCode, ArrayList<Task> taskList) {
        printMessage(String.format(MESSAGE_TASKS_TO_LIST, moduleCode));
        printTasks(taskList, false);
        printTasks(taskList, true);
    }

    // Used by previous method.
    // Prints identified tasks in the task list with matching "done" status.
    public void printTasks(ArrayList<Task> taskList, Boolean isDone) {
        if (isDone) {
            printMessage(HEADER_DONE);
        } else {
            printMessage(HEADER_UNDONE);
        }
        int tasksCount = 0;
        for (Task task : taskList) {
            if (task.getDone() == isDone) {
                tasksCount++;
                String description = task.getDescription();
                String gradedStatus = task.getGraded() ? MESSAGE_GRADED : "";
                String deadline = task.getDeadline().format(DateTimeFormatter.ofPattern(FORMAT_DATE_NORMAL));
                String listItem = String.format(FORMAT_PRINT_TASK, tasksCount, description, gradedStatus, deadline);
                printMessage(listItem);
                printRemarks(task);
            }
        }
    }

    public void printRemarks(Task task) {
        if (!task.getRemarks().equals("")) {
            System.out.print("\t" + task.getRemarks() + NEWLINE);
        }
    }


    public ArrayList<Integer> readIntegers() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> listOfIntegers = new ArrayList<>();
        while (scanner.hasNextInt()) {
            listOfIntegers.add(scanner.nextInt());
        }
        return listOfIntegers;
    }
}
