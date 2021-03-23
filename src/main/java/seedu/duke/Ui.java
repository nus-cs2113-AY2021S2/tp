package seedu.duke;

import seedu.duke.link.LinkInfo;
import seedu.duke.link.ZoomLinkInfo;
import seedu.duke.task.Assignment;
import seedu.duke.task.FinalExam;
import seedu.duke.task.Midterm;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Deals with all interactions with the user.
 */
public class Ui {

    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void printWelcomeMessage() {
        System.out.println("Welcome to\n"
                + "  _   _               _      _____                                _\n"
                + " | | | |   _ _       (_)    |_   _|     _ _    __ _      __      | |__     ___       _ _\n"
                + " | |_| |  | ' \\      | |      | |      | '_|  / _` |    / _|     | / /    / -_)     | '_|\n"
                + "  \\___/   |_||_|    _|_|_    _|_|_    _|_|_   \\__,_|    \\__|_    |_\\_\\    \\___|    _|_|_\n"
                + "_|\"\"\"\"\"| _|\"\"\"\"\"| _|\"\"\"\"\"| _|\"\"\"\"\"| _|\"\"\"\"\"| _|\"\"\"\"\"| _|\"\"\"\"\"| _|"
                + "\"\"\"\"\"| _|\"\"\"\"\"| _|\"\"\"\"\"|\n"
                + "\"`-0-0-' \"`-0-0-' \"`-0-0-' \"`-0-0-' \"`-0-0-' \"`-0-0-' \"`-0-0-' \"`-0-0-' \"`-0-0-' \"`-0-0-'\n");
    }

    public static void printHorizontalLine() {
        System.out.println("--------------------------------------------");
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printMainMenu() {
        System.out.println("Main Menu:\n"
                + "[1] Module Information\n"
                + "[2] CAP Simulator/Calculator\n"
                + "[3] Task Manager\n"
                + "[4] External Links\n"
                + "[5] Exit Program");
    }

    public static void printLinksMessage() {
        printHorizontalLine();
        System.out.println("Welcome to the links menu ^~^\n"
                + "Please choose which action you would like to do and enter the number:\n"
                + "[1] --- External links menu\n"
                + "[2] --- Add Zoom links\n"
                + "[3] --- Delete Zoom links\n"
                + "[4] --- View Zoom links\n"
                + "[5] --- Exit to main menu");
        printHorizontalLine();
    }

    public static void printLinkToDelete() {
        System.out
                .println("Please choose which link you would like to delete and enter the number");
    }

    public static void printModuleInfoMessage() {
        System.out.println("Welcome to the module information menu ^~^\n"
                + "Please choose which action you would like to do and enter the number:\n"
                + "[1]  --- Add New Module\n"
                + "[2]  --- View a Module\n"
                + "[3]  --- Add/View Components and Their Weightages\n"
                + "[4]  --- Add Module's Modular Credits (MC)\n"
                + "[5]  --- Add Module Grade\n"
                + "[6]  --- View All Modules\n"
                + "[7]  --- Add New Task\n"
                + "[8]  --- Add Zoom Link\n"
                + "[9]  --- Add a Review\n"
                + "[10] --- View All Reviews\n"
                + "[11] --- Delete Module\n"
                + "[12] --- Delete Task\n"
                + "[13] --- Delete Zoom Link\n"
                + "[14] --- Delete Review\n"
                + "[15] --- Exit to main menu\n");
    }

    public static void printTaskManagerMenu() {
        System.out.println("Welcome to the Task Manager menu ^o^\n"
                + "Please choose which action you would like to do and enter the number:\n"
                + "[1] --- Add New Task\n"
                + "[2] --- Mark/Unmark a Task as Done\n"
                + "[3] --- Delete a Task\n"
                + "[4] --- View All Tasks\n"
                + "[5] --- Pin a Task\n"
                + "[6] --- Exit");
    }

    public static void printAddTaskMenu() {
        System.out.println("Please choose which type of task you would like to add"
                + " and enter the number:\n"
                + "[1] --- Task\n"
                + "[2] --- Assignment\n"
                + "[3] --- Midterm\n"
                + "[4] --- Final Exam");
    }

    public static void printMarkTaskMenu() {
        System.out.println("Please choose which type of task you would like to mark/unmark as done"
                + " and enter the number:\n"
                + "[1] --- Task\n"
                + "[2] --- Assignment\n"
                + "[3] --- Midterm\n"
                + "[4] --- Final Exam");
    }

    public static void printDeleteTaskMenu() {
        System.out.println("Please choose which type of task you would like to delete"
                + " and enter the number:\n"
                + "[1] --- Task\n"
                + "[2] --- Assignment\n"
                + "[3] --- Midterm\n"
                + "[4] --- Final Exam");
    }

    public static void printPinTaskMenu() {
        System.out.println("Please choose which type of task you would like to pin"
                + " and enter the number:\n"
                + "[1] --- Task\n"
                + "[2] --- Assignment\n"
                + "[3] --- Midterm\n"
                + "[4] --- Final Exam");
    }

    public static void printAddTaskModuleMessage(int taskType) {
        if (taskType == 1) {
            System.out.println("What is the module of the task you want to add? Enter the number:");
        } else if (taskType == 2) {
            System.out
                    .println(
                            "What is the module of the assignment you want to add? Enter the number:");
        } else if (taskType == 3) {
            System.out
                    .println(
                            "What is the module of the midterm you want to add? Enter the number:");
        } else {
            System.out
                    .println(
                            "What is the module of the final exam you want to add? Enter the number:");
        }
    }

    public static void printNoModulesMessage() {
        System.out.println("There are no modules! Please head to the ModuleInfo menu to add them!");
    }

    public static void printAddTaskDescriptionMessage(int taskType) {
        if (taskType == 1) {
            System.out.println("What is the description of the task you want to add?");
        } else if (taskType == 2) {
            System.out.println("What is the description of the assignment you want to add?");
        } else if (taskType == 3) {
            System.out.println("What is the description of the midterm you want to add?");
        } else {
            System.out.println("What is the description of the final exam you want to add?");
        }
    }

    public static void printAddTaskDateMessage(int taskType) {
        if (taskType == 2) {
            System.out.println("What is the date of the assignment you want to add?");
        } else if (taskType == 3) {
            System.out.println("What is the date of the midterm you want to add?");
        } else {
            System.out.println("What is the date of the final exam you want to add?");
        }
    }

    public static void printAddTaskTimeMessage(int taskType) {
        if (taskType == 2) {
            System.out.println("What is the time of the assignment you want to add?");
        } else if (taskType == 3) {
            System.out.println("What is the time of the midterm you want to add?");
        } else {
            System.out.println("What is the time of the final exam you want to add?");
        }
    }

    public static void printAddMessageAfterCompletedTask() {
        System.out.println("What is the message you would like to see after completing this?");
    }

    public static void printAddedTaskMessage(Task task) {
        System.out.println("You've added this: " + task.toString());
        System.out.println("Returning back to the menu now!");
        printHorizontalLine();
    }

    public static void printTaskisDoneMessage() {
        System.out.println("This task is marked as done. Would you like to unmark it? [Y/N]");
    }

    public static void printTaskisNotDoneMessage() {
        System.out.println("This task is not marked as done. Would you like to mark it? [Y/N]");
    }

    public static void printMarkedTaskMessage(Task task) {
        System.out.println("You've mark this as done: " + task.toString());
        System.out.println("NOTE: " + task.getMessage());
        System.out.println("Returning back to TaskManager menu now!");
        printHorizontalLine();
    }

    public static void printUnmarkedTaskMessage(Task task) {
        System.out.println("You've mark this as not done: " + task.toString());
        System.out.println("Returning back to TaskManager menu now!");
        printHorizontalLine();
    }

    public static void printDeletedTaskMessage(Task task) {
        System.out.println("You've deleted this: " + task.toString());
        System.out.println("Returning back to the menu now!");
        printHorizontalLine();
    }

    public static void printSelectModuleToDeleteMessage() {
        System.out.println("Enter the module number to be deleted:");
    }

    public static void printSelectReviewToDeleteMessage() {
        System.out.println("Enter the module number to delete review:");
    }

    public static void printSelectTaskNumberToMarkOrUnmarkMessage() {
        System.out.println("\nWhat is the number of the task you want to mark/unmark?");
    }

    public static void printSelectTaskNumberToDeleteMessage() {
        System.out.println("\nWhat is the number of the task you want to delete?");
    }

    public static void printSelectTaskNumberToPinMessage() {
        System.out.println("\nWhat is the number of the task you want to pin?");
    }

    public static void printPinnedTaskMessage(Task task) {
        System.out.println("You've pinned this: " + task.toString());
        System.out.println("Returning back to TaskManager menu now!");
        printHorizontalLine();
    }

    public static void printTaskAlreadyPinnedMessage() {
        System.out.println("This task is already pinned!");
        printHorizontalLine();
    }

    public static void printTaskListIsEmptyMessage() {
        System.out.println("Task list is empty!\n"
                + "Returning back to TaskManager menu now!");
        printHorizontalLine();
    }

    public static void printInvalidIntegerMessage() {
        System.out.println("Please enter a valid integer from the menu.");
    }

    public static void printInvalidTimeFormat() {
        System.out.println("Please enter a valid time format.");
    }

    public static void printInvalidDateFormat() {
        System.out.println("Please enter a valid date format.");
    }

    public static void printInvalidTaskNumberMessage() {
        System.out.println("Please input a valid task number.");
    }

    public static String readCommand() {
        String command;
        Scanner input = new Scanner(System.in);
        command = input.nextLine();
        return command;
    }

    public static void printLinks(ArrayList<LinkInfo> linksList) {
        int sizeOfList = 1;
        System.out.println("These are the links you have added --->");
        for (LinkInfo link : linksList) {
            System.out.println("[" + (sizeOfList++) + "] --- " + link.getLink());
        }
    }

    public static void printExternalLinksMessage() {
        printHorizontalLine();
        System.out.println("Welcome to the external links menu!\n"
                + "Please choose which action you would like to do and enter the number:\n"
                + "[1] --- add link\n"
                + "[2] --- remove link\n"
                + "[3] --- view links\n"
                + "[4] --- exit to links menu");
        printHorizontalLine();
    }

    public static int readCommandToInt() {
        int command;
        Scanner input = new Scanner(System.in);
        try {
            command = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
        return command;

    }

    public static void printAddLinkMessage(String description) {
        System.out.println("Alright! I have added the following link ---  " + description);
    }

    public static void printEnterLinkMessage() {
        System.out.println("Please enter the link in this format:\n"
                + "<scheme>www.<domain name>.<TLD>/<path name>\n"
                + "supported schemes: https, http for now... Sorry!\n"
                + "supported TLD: .com, .org for now... we will work on it!");
        printHorizontalLine();
    }

    public static void printInvalidLinkMessage() {
        System.out.println("Oh no... That was an invalid link *sobs...*\n"
                + "Please enter a valid one!");
    }

    public static void printListIsEmpty() {
        System.out.println("No links have been added... Please add one!");
    }

    public static void printModuleNameToModifyPrompt() {
        System.out.println("What module would you like to modify? [moduleName e.g. CS2113T]");
    }

    public static void printModuleExistMessage() {
        System.out.println("Module exist! ");
        System.out.println("Here is a description of the module you have added previously");
        System.out.println();
    }

    public static void printModuleDoesNotExistMessage() {
        System.out.println("This module does not exist, would you like to add it? [Y/N]");
    }

    public static void printReturnToMainMenuMessage() {
        System.out.println("Returning to main menu...");
        System.out.println();
    }

    public static void printReturnToModuleInfoMenuMessage() {
        System.out.println("Returning to module information menu...");
        System.out.println();
    }

    public static void printModuleDescriptionPrompt(String moduleName) {
        System.out.println("Key in the module description for " + moduleName + ":");
    }

    public static void printModuleDescriptionAddedMessage(String moduleName,
            String moduleDescription) {
        System.out.println("Module description for " + moduleName + " added: ");
        System.out.println(moduleDescription);
    }

    public static void printModulePrompt() {
        System.out.println("Would you like to add/view component(s) to a module? [Y/N]");
        String yesNo = Ui.readCommand();
        if (yesNo.trim().equalsIgnoreCase("Y")) {
            System.out.println("Key in 1 to add component and 2 to view component");
        }
        //for (Module module : ModuleInfo.modules) {
        //System.out.println(module.getName());
        //}

    }

    public static void printModuleComponentPrompt() {
        System.out.println("Please key in your component and percentage of the component. ");
        System.out.println("Leave space between component and percentage only.");
        System.out.println("Example: FinalExam 20");
    }

    public static void printEnterZoomLinkMessage() {
        System.out.println("Please enter the zoom link and the module it is for in this format:\n"
                + "<zoom link> <module code>");
        printHorizontalLine();
    }

    public static void printZoomLinks(ArrayList<ZoomLinkInfo> zoomLinksList) {
        System.out.println("Here are your zoom links!\n");
        int sizeOfList = 1;
        for (int i = 0; i < zoomLinksList.size(); ++i) {
            ZoomLinkInfo zoomLink = zoomLinksList.get(i);
            System.out.println(
                    "[" + (sizeOfList++) + "] --- " + zoomLink.getDescription() + " " + zoomLink
                            .getModuleCode() + " " + zoomLink.getPassword());
        }
    }

    public static void printNoInputDetected() {
        System.out.println("Sorry! I didn't catch that. Please try again");
    }

    public static void printZoomLinksAdded(String zoomLink, String moduleCode) {
        printHorizontalLine();
        System.out.println("Woohoo~ Zoom link added:");
        System.out.println(zoomLink + " for " + moduleCode);
    }

    public static void printTaskList(ArrayList<Task> tasks) {
        int taskNumber = 1;
        System.out.println("This is the list of your tasks:");
        for (Task task : tasks) {
            System.out.println(taskNumber + ". " + task.toString());
            taskNumber++;
        }
    }

    public static void printAssignmentList(ArrayList<Assignment> assignments) {
        int taskNumber = 1;
        System.out.println("This is the list of your assignments:");
        for (Assignment assignment : assignments) {
            System.out.println(taskNumber + ". " + assignment.toString());
            taskNumber++;
        }
    }

    public static void printMidtermList(ArrayList<Midterm> midterms) {
        int taskNumber = 1;
        System.out.println("This is the list of your midterms:");
        for (Midterm midterm : midterms) {
            System.out.println(taskNumber + ". " + midterm.toString());
            taskNumber++;
        }
    }

    public static void printFinalExamList(ArrayList<FinalExam> finalExams) {
        int taskNumber = 1;
        System.out.println("This is the list of your final exams:");
        for (FinalExam finalExam : finalExams) {
            System.out.println(taskNumber + ". " + finalExam.toString());
            taskNumber++;
        }
    }

    public static void printPinnedTaskList(HashMap<String, ArrayList<Task>> pinnedTasks) {
        System.out.println("This is the list of your pinned tasks:");
        for (Map.Entry<String, ArrayList<Task>> item : pinnedTasks.entrySet()) {
            int taskNumber = 1;
            String taskType = item.getKey();
            ArrayList<Task> tasks = item.getValue();
            for (Task task : tasks) {
                System.out.println(taskNumber + ". " + taskType + task.toString());
                taskNumber++;
            }
        }
    }

    public static void printSelectTaskNumberToMarkOrUnmark(int taskNumber) {
        switch (taskNumber) {
        case 1:
            printTaskList(TaskList.tasks);
            break;
        case 2:
            printAssignmentList(TaskList.assignments);
            break;
        case 3:
            printMidtermList(TaskList.midterms);
            break;
        case 4:
            printFinalExamList(TaskList.finalExams);
            break;
        default:
            printInvalidIntegerMessage();
        }
        printSelectTaskNumberToMarkOrUnmarkMessage();
    }

    public static void printSelectTaskNumberToDelete(int taskNumber) {
        switch (taskNumber) {
        case 1:
            printTaskList(TaskList.tasks);
            break;
        case 2:
            printAssignmentList(TaskList.assignments);
            break;
        case 3:
            printMidtermList(TaskList.midterms);
            break;
        case 4:
            printFinalExamList(TaskList.finalExams);
            break;
        default:
            printInvalidIntegerMessage();
        }
        printSelectTaskNumberToDeleteMessage();
    }

    public static void printSelectTaskNumberToPin(int taskNumber) {
        switch (taskNumber) {
        case 1:
            printTaskList(TaskList.tasks);
            break;
        case 2:
            printAssignmentList(TaskList.assignments);
            break;
        case 3:
            printMidtermList(TaskList.midterms);
            break;
        case 4:
            printFinalExamList(TaskList.finalExams);
            break;
        default:
            printInvalidIntegerMessage();
        }
        printSelectTaskNumberToPinMessage();
    }

    public static String printEnterRequirePassword() {
        System.out.println("Does your meeting have password which you would like to add? [Y/N]");
        String password = Ui.readCommand().toLowerCase();
        while (!password.equals("y") && !password.equals("n")) {
            Ui.printEnterValidPasswordMessage();
            password = Ui.readCommand().toLowerCase();
        }
        return password;
    }

    private static void printEnterValidPasswordMessage() {
        System.out.println("Please enter either Y or N!");
    }

    public static String printEnterPassword() {
        System.out.println("Please enter your password below!");
        String password = Ui.readCommand();
        while (password.isEmpty()) {
            System.out.println("Your password is currently empty! Please enter something");
            password = Ui.readCommand();
        }
        return password;
    }

    public static void printLinkDeleted(LinkInfo deletedLink) {
        System.out.println("You have deleted --- " + deletedLink.getLink());
    }

    public static void printCapSimulatorPrompt() {
        System.out.println("You may key in your letter grades "
                + "and MCs associated with the letter grade.");
    }

    public static void printMCsPerModulePrompt() {
        System.out.println("Key in MCs for the associated module: ");
    }

    public static void printGradePerModulePrompt() {
        System.out.println("Key in a grade: [e.g. A+, B, B-]");
    }

    public static void printHelpGraduationMenu() {
        System.out.println("Please choose which action you would like to do"
                + " and enter the number:\n"
                + "[1] --- Add CAP and Number of MCs graded taken\n"
                + "[2] --- View CAP and Number of MCs graded taken\n"
                + "[3] --- Simulate future CAP\n"
                + "[4] --- Exit\n");
    }

    public static void getCurrentCapPrompt() {
        System.out.println("Please key in your current CAP: [e.g. 4.33]");
    }

    public static void getNumberOfGradedMCsTakenPrompt() {
        System.out.println("Please key in the number of MCs graded you have taken so far: ");
    }

    public static void printRegisteredCapAndMCsTakenMessage() {
        System.out.println("Current CAP: " + HelpGraduation.getCurrentCap());
        System.out.println("Number of Graded MCs Taken: "
                + HelpGraduation.getNumberOfGradedMCsTaken());
    }

    public static void printInvalidGradeMessage() {
        System.out.println("Please enter a valid grade.");
    }

    public static void printZoomLinkDeleted(ZoomLinkInfo zoomLink) {
        System.out.println("You have deleted --- " + zoomLink.getDescription());
    }
}
