package seedu.duke.ui;

import seedu.duke.features.capsimulator.HelpGraduation;
import seedu.duke.features.link.LinkInfo;
import seedu.duke.features.link.ZoomLinkInfo;
import seedu.duke.features.moduleinfo.ModuleInfo;
import seedu.duke.features.task.tasktypes.Assignment;
import seedu.duke.features.task.tasktypes.FinalExam;
import seedu.duke.features.task.tasktypes.Midterm;
import seedu.duke.features.task.tasktypes.Task;
import seedu.duke.features.task.TaskManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Deals with all interactions with the user.
 */
public class Ui {

    private static final String longHorizontalLine = "--------------------------------------------";
    private static final String shortHorizontalLine = "----------------------";

    public static void printWelcomeMessage() {
        System.out.println("Welcome to\n"
                + "  _   _               _      _____                                _\n"
                + " | | | |   _ _       (_)    |_   _|     _ _    __ _      __      | |__     ___       _ _\n"
                + " | |_| |  | ' \\      | |      | |      | '_|  / _` |    / _|     | / /    / -_)     | '_|\n"
                + "  \\___/   |_||_|    _|_|_    _|_|_    _|_|_   \\__,_|    \\__|_    |_\\_\\    \\___|    _|_|_\n"
                + "_|\"\"\"\"\"| _|\"\"\"\"\"| _|\"\"\"\"\"| _|\"\"\"\"\"| _|\"\"\"\"\"| _|\"\"\"\"\"| _|\"\"\"\"\"| _|"
                + "\"\"\"\"\"| _|\"\"\"\"\"| _|\"\"\"\"\"|\n"
                + "\"`-0-0-' \"`-0-0-' \"`-0-0-' \"`-0-0-' \"`-0-0-' "
                + "\"`-0-0-' \"`-0-0-' \"`-0-0-' \"`-0-0-' \"`-0-0-'\n");
    }

    public static void printHorizontalLine() {
        System.out.println(longHorizontalLine);
    }

    public static void printShortHorizontalLine() {
        System.out.println(shortHorizontalLine);
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printMainMenu() {
        System.out.println("\nMain Menu:\n"
                + "[1] Module Information\n"
                + "[2] CAP Simulator/Calculator\n"
                + "[3] Task Manager\n"
                + "[4] External Links\n"
                + "[5] Exit Program");
    }

    public static void printLinksMessage() {
        System.out.println("Welcome to the links menu ^~^\n"
                + "Please choose which action you would like to do and enter the number:\n"
                + "[1] --- External links menu\n"
                + "[2] --- Add Zoom links\n"
                + "[3] --- Delete Zoom links\n"
                + "[4] --- View Zoom links\n"
                + "[5] --- Exit to main menu");
    }

    public static void printLinkToDelete() {
        System.out
                .println("Please choose which link you would like to delete and enter the number");
    }

    public static void printModuleInfoMessage() {
        System.out.println("Welcome to the module information menu ^~^\n"
                + "Please choose which action you would like to do and enter the number:\n"
                + shortHorizontalLine + "\n"
                + "[1]  --- Add New Module\n"
                + "[2]  --- View a Module\n"
                + "[3]  --- View All Modules\n"
                + "[4]  --- Delete Module\n"
                + shortHorizontalLine + "\n"
                + "[5]  --- Add/View Components and Their Weightages\n"
                + "[6]  --- Add Module's Modular Credits (MC)\n"
                + "[7]  --- Add Module Grade\n"
                + shortHorizontalLine + "\n"
                + "[8]  --- Add a Review\n"
                + "[9]  --- View All Reviews\n"
                + "[10] --- Delete Review\n"
                + shortHorizontalLine + "\n"
                + "[11] --- Add New Task\n"
                + "[12] --- Delete Task\n"
                + shortHorizontalLine + "\n"
                + "[13] --- Add Zoom Link\n"
                + "[14] --- Delete Zoom Link\n"
                + shortHorizontalLine + "\n"
                + "[15] --- Exit to main menu\n"
                + shortHorizontalLine);
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
                + "[1] --- Normal Task\n"
                + "[2] --- Assignment\n"
                + "[3] --- Midterm\n"
                + "[4] --- Final Exam");
    }

    public static void printMarkTaskMenu() {
        System.out.println("Please choose which type of task you would like to mark/unmark as done"
                + " and enter the number:\n"
                + "[1] --- Normal Task\n"
                + "[2] --- Assignment\n"
                + "[3] --- Midterm\n"
                + "[4] --- Final Exam");
    }

    public static void printDeleteTaskMenu() {
        System.out.println("Please choose which type of task you would like to delete"
                + " and enter the number:\n"
                + "[1] --- Normal Task\n"
                + "[2] --- Assignment\n"
                + "[3] --- Midterm\n"
                + "[4] --- Final Exam");
    }

    public static void printPinTaskMenu() {
        System.out.println("Please choose which type of task you would like to pin"
                + " and enter the number:\n"
                + "[1] --- Normal Task\n"
                + "[2] --- Assignment\n"
                + "[3] --- Midterm\n"
                + "[4] --- Final Exam");
    }

    public static void printAddTaskModuleMessage(int taskType) {
        if (taskType == 1) {
            System.out.println("What is the module of the task you want to add? Enter the number:");
        } else if (taskType == 2) {
            System.out.println(
                    "What is the module of the assignment you want to add? Enter the number:");
        } else if (taskType == 3) {
            System.out.println(
                    "What is the module of the midterm you want to add? Enter the number:");
        } else {
            System.out.println(
                    "What is the module of the final exam you want to add? Enter the number:");
        }
        printEmptyLine();
    }

    public static void printNoModulesMessage() {
        System.out.println("There are no modules! Would you like to add a module? [Y/N]");
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
            System.out.println(
                    "What is the date of the assignment you want to add? Format of date is YYYY-MM-DD");
        } else if (taskType == 3) {
            System.out.println(
                    "What is the date of the midterm you want to add? Format of date is YYYY-MM-DD");
        } else {
            System.out.println(
                    "What is the date of the final exam you want to add? Format of date is YYYY-MM-DD");
        }
    }

    public static void printAddTaskTimeMessage(int taskType) {
        if (taskType == 2) {
            System.out.println(
                    "What is the time of the assignment you want to add? Format of time is HH:MM");
        } else if (taskType == 3) {
            System.out.println(
                    "What is the time of the midterm you want to add? Format of time is HH:MM");
        } else {
            System.out.println(
                    "What is the time of the final exam you want to add? Format of time is HH:MM");
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

    public static void printTaskAlreadyExistsMessage(Task task) {
        System.out.println("This task has already been added: " + task.toString());
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
        System.out.println("You've marked this as done: " + task.toString());
        System.out.println("NOTE: " + task.getMessage());
        System.out.println("Returning back to TaskManager menu now!");
        printHorizontalLine();
    }

    public static void printUnmarkedTaskMessage(Task task) {
        System.out.println("You've marked this as not done: " + task.toString());
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
                + "Returning back to the menu now...");
        printHorizontalLine();
    }

    public static void printInvalidInputMessage() {
        System.out.println("Invalid input!");
    }

    public static void printRepeatInputUntilValidMessage() {
        System.out.println("Invalid input! Please enter a valid integer from the list.");
    }

    public static void printInvalidTimeFormat() {
        System.out.println("Please enter a valid time format.");
    }

    public static void printInvalidDateFormat() {
        System.out.println("Please enter a valid date format.");
    }

    public static String readCommand() {
        String command;
        Scanner input = new Scanner(System.in);
        while (true) {
            command = input.nextLine().trim();
            if (command.contains(" ~~ ")) {
                System.out.println("Restricted character present in input. PLease try again.");
                printHorizontalLine();
            } else {
                break;
            }
        }
        printHorizontalLine();
        return command;
    }

    public static int readCommandToInt() {
        int command;
        Scanner input = new Scanner(System.in);
        try {
            command = Integer.parseInt(input.nextLine().trim());
        } catch (NumberFormatException e) {
            printHorizontalLine();
            return -1;
        }
        printHorizontalLine();
        return command;
    }

    public static String readReviewLine() {
        String reviewLine;
        Scanner input = new Scanner(System.in);
        reviewLine = input.nextLine().trim();
        return reviewLine;
    }

    public static boolean userCommandIsEmpty(String command) {
        if (command.equals("")) {
            return true;
        }
        return false;
    }

    public static void printLinks(ArrayList<LinkInfo> linksList) {
        int sizeOfList = 1;
        System.out.println("These are the links you have added --->");
        for (LinkInfo link : linksList) {
            System.out.println("[" + (sizeOfList++) + "] --- " + link.getLink());
        }
        System.out.println();
    }

    public static void printExternalLinksMessage() {
        System.out.println("Welcome to the external links menu!\n"
                + "Please choose which action you would like to do and enter the number:\n"
                + "[1] --- Add link\n"
                + "[2] --- Remove link\n"
                + "[3] --- View links\n"
                + "[4] --- Exit to links menu");
    }

    public static void printAddLinkMessage(String description) {
        System.out.println("Alright! I have added the following link ---  " + description);
    }

    public static void printEnterLinkMessage() {
        System.out.println("Please enter the link in this format:\n"
                + "<scheme>://www.<domain name>.<TLD>\n"
                + "Supported schemes: https, http only\n"
                + "Supported TLD: .com, .org, .sg, .edu, .gov\n");
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

    public static void printReturnToHelpGraduationMenuMessage() {
        System.out.println("Returning to CAP simulator/calculator menu...");
        System.out.println();
    }

    public static void printReturnToTaskManagerMenuMessage() {
        System.out.println("Returning to task manager menu...");
        System.out.println();
    }

    public static void printReturnToLinkMenuMessage() {
        System.out.println("Returning to links menu...");
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
        System.out.println("Which action would you like to proceed with? Key in 1 or 2.");
        System.out.println("[" + 1 + "] --- Add Component");
        System.out.println("[" + 2 + "] --- View Component");

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
        System.out.println("Please enter the zoom link below");
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
        System.out.println("");
    }

    public static void printNoInputDetected() {
        System.out.println("Sorry! I didn't catch that. Please try again");
    }

    public static void printZoomLinksAdded(String zoomLink, String moduleCode) {
        System.out.println("Woohoo~ Zoom link added:");
        System.out.println(zoomLink + " for " + moduleCode + "\n");
    }

    public static void printTaskList(ArrayList<Task> tasks) {
        int taskNumber = 1;
        System.out.println("This is the list of your normal tasks:");
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
        int taskNumber = 1;
        for (Map.Entry<String, ArrayList<Task>> item : pinnedTasks.entrySet()) {
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
            printTaskList(TaskManager.tasks);
            break;
        case 2:
            printAssignmentList(TaskManager.assignments);
            break;
        case 3:
            printMidtermList(TaskManager.midterms);
            break;
        case 4:
            printFinalExamList(TaskManager.finalExams);
            break;
        default:
            printInvalidInputMessage();
        }
        printSelectTaskNumberToMarkOrUnmarkMessage();
    }

    public static void printSelectTaskNumberToDelete(int taskNumber) {
        switch (taskNumber) {
        case 1:
            printTaskList(TaskManager.tasks);
            break;
        case 2:
            printAssignmentList(TaskManager.assignments);
            break;
        case 3:
            printMidtermList(TaskManager.midterms);
            break;
        case 4:
            printFinalExamList(TaskManager.finalExams);
            break;
        default:
            printInvalidInputMessage();
        }
        printSelectTaskNumberToDeleteMessage();
    }

    public static void printSelectTaskNumberToPin(int taskNumber) {
        switch (taskNumber) {
        case 1:
            printTaskList(TaskManager.tasks);
            break;
        case 2:
            printAssignmentList(TaskManager.assignments);
            break;
        case 3:
            printMidtermList(TaskManager.midterms);
            break;
        case 4:
            printFinalExamList(TaskManager.finalExams);
            break;
        default:
            printInvalidInputMessage();
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
        System.out.println("Welcome to CAP Simulator Version 2!\n"
                + "You have chosen to simulate CAP base on your input.");
        System.out.println("THINGS TO NOTE: ");
        System.out.println("You may key in 'q' to quit and 'ok' after finishing your inputs.");
        System.out.println("You may key in your letter grades "
                + "follow by MCs associated with the letter grade "
                + "after each prompt. \n");


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
                + "[4] --- Exit");
    }

    public static void getCurrentCapPrompt() {
        System.out.println("Please key in your current CAP: [e.g. 4.33]");
    }

    public static void getNumberOfGradedMCsTakenPrompt() {
        System.out.println("Please key in the number of MCs graded you have taken so far: ");
    }

    public static void printRegisteredCapAndMCsTakenMessage() {
        System.out.println("Current CAP: " + HelpGraduation.getCurrentCap() + " (rounded to 2dp)");
        System.out.println("Number of Graded MCs Taken: "
                + HelpGraduation.getNumberOfGradedMCsTaken());
    }

    public static void printInvalidGradeMessage() {
        System.out.println("Please enter a valid grade.");
    }

    public static void printZoomLinkDeleted(ZoomLinkInfo zoomLink) {
        System.out.println("You have deleted --- " + zoomLink.getDescription());
    }

    public static void printModuleNumberDoesNotExistMessage() {
        System.out.println("No such module! Would you like to add a module? [Y/N]");
    }

    public static void printModuleList() {
        System.out.println("This is the list of modules:");
        for (int i = 1; i <= ModuleInfo.modules.size(); ++i) {
            System.out.println("[" + i + "] " + ModuleInfo.modules.get(i - 1).getName());
        }
    }

    public static void printDuplicateMessage() {
        System.out.println("Duplicate detected! You have already entered this link before");
        System.out.println("Please enter another link...");
    }

    /**
     * Prints message containing two choices of simulating CAP score. First choice calculates CAP
     * score base on the MCs and Grades from existing module. Second choice calculates CAP score
     * base on user input.
     */
    public static void printCapSimulatorSetting() {
        System.out.println("Welcome to CAP Simulator!");
        System.out.println("Note: CAP Simulated takes your current CAP "
                + "and total number of MCs taken into account.");
        System.out.println("If you intend to calculate your CAP solely on new entries, \n"
                + "please go back to the HelpGraduation menu"
                + " and set existing CAP and MCs taken to be 0.\n");
        System.out.println("Key in 1 to simulate your cap base on the grades you have"
                + " entered before for each module."
                + "\nKey in 2 to simulate cap base on your own input.");
    }

    public static void printInvalidModularCreditMessage() {
        System.out.println("Invalid modular credit. "
                + "Please key in module grade for this module again, \n"
                + "follow by a VALID modular credit.");
    }

    public static void printEraseSimulationEntriesMessage() {
        System.out.println("Erasing current simulation entries...\n");
    }

    public static void printFilesCouldNotBeSavedMessage() {
        System.out.println("UniTracker Data could not be auto-saved:(");
    }

    public static void printConfirmComponentsMessage() {
        System.out.println("Are you sure you have keyed in the correct name and weightage?");
        System.out.println(
                "Note: you may only change this by deleting the module associated with it.");
        System.out.println("[1] --- Yes, I confirm my inputs.\n"
                + "[2] --- No, I wish to key in my inputs again.");
    }

    public static void printInvalidInputForYOrNMessage() {
        System.out.println("Invalid input! Please input Y or N.");
    }

    public static void printChooseModule() {
        System.out.println("Please enter the number of the module you wish to add");
    }

    public static void printModuleAlreadyHasZoomLink() {
        System.out.println(
                "The module you specified already has a zoom link! Bringing you back to the links menu...");
    }
}
