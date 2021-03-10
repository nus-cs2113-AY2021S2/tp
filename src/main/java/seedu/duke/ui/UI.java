package seedu.duke.ui;

import seedu.duke.task.Task;
import seedu.duke.common.Messages;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import static seedu.duke.common.Constants.NEWLINE;

public class UI {
  
    private final Scanner in;

    public UI() {
        in = new Scanner(System.in);
    }
  
    public void printWelcome() {
        System.out.println(Messages.MESSAGE_WELCOME);
    }

    public void printBye() {
        System.out.println(Messages.MESSAGE_EXIT);
    }

    public String readCommand() {
        return in.nextLine();
    }

    public boolean getIsTaskGraded() {
        System.out.print("Is this task graded? (Y / N)" + NEWLINE);
        String userInput = readCommand();
        while (!userInput.equals("Y") && !userInput.equals("N")) {
            System.out.print("Please enter \"Y\" or \"N\"" + NEWLINE);
            userInput = readCommand();
        }
        return userInput.equals("Y");
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
            String index = tasksCount + ". ";
            String taskListItem = index + task.getDescription();
            printMessage(taskListItem);
        }
    }

    public void printTaskInstructions(String commandVerb) {
        String instructions = NEWLINE
                + "Please enter the indices of the tasks you would like to " + commandVerb + "." + NEWLINE
                + "Separate indices with a blank space." + NEWLINE;
        printMessage(instructions);
    }

    // Prints all tasks in the task list.
    public void printTasks(String moduleCode, ArrayList<Task> taskList) {
        String titleAndHeader = "Tasks for " + moduleCode + ":" + NEWLINE
                + "[Undone]";
        printTasks(titleAndHeader, taskList, false);
        String header = "[Done]";
        printTasks(header, taskList, true);
    }

    // Used by previous method.
    // Prints identified tasks in the task list with matching "done" status.
    public void printTasks(String openingStatement, ArrayList<Task> taskList, Boolean isDone) {
        printMessage(openingStatement);
        int tasksCount = 0;
        for (Task task : taskList) {
            if (task.getDone() == isDone) {
                tasksCount++;
                String index = tasksCount + ". ";
                String gradedStatus = task.getGraded() ? " (graded)" : "";
                String deadline = " - " + task.getDeadline().format(DateTimeFormatter.ofPattern("d MMM yyyy"));
                String listItem = index + task.getDescription() + gradedStatus + deadline;
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

    public void printMessage(String message) {
        System.out.println(message);
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
