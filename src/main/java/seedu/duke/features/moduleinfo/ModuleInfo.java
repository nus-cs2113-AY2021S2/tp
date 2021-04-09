package seedu.duke.features.moduleinfo;

import seedu.duke.features.link.ZoomLinkInfo;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;
import seedu.duke.features.capsimulator.ModuleGradeEnum;
import seedu.duke.features.link.Links;
import seedu.duke.features.task.tasktypes.Assignment;
import seedu.duke.features.task.tasktypes.FinalExam;
import seedu.duke.features.task.tasktypes.Midterm;
import seedu.duke.features.task.tasktypes.Task;
import seedu.duke.features.task.TaskManager;
import seedu.duke.features.task.command.DeleteTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModuleInfo {

    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static ArrayList<Module> modules = new ArrayList<>();
    private static final String EMPTY_REVIEW_MESSAGE = "You have not reviewed this module yet.";

    private static final String TASK_TYPE = "[Task]";
    private static final String ASSIGNMENT_TYPE = "[Assignment]";
    private static final String MIDTERM_TYPE = "[Midterm]";
    private static final String FINAL_EXAM_TYPE = "[Final Exam]";

    public ModuleInfo() {
    }

    public static void moduleInfoMenu() {
        while (true) {
            Ui.printModuleInfoMessage();
            int command = Ui.readCommandToInt();
            if (command == 15) {
                Ui.printReturnToMainMenuMessage();
                break; // exit to Main Menu
            }
            switch (command) {
            case 1:
                addNewModule();
                break;
            case 2:
                viewAModule();
                break;
            case 3:
                viewAllModules();
                break;
            case 4:
                deleteModule();
                break;
            case 5:
                getComponents();
                break;
            case 6:
                addModuleMC();
                break;
            case 7:
                addModuleGrade();
                break;
            case 8:
                addReview();
                break;
            case 9:
                viewAllReviews();
                break;
            case 10:
                deleteReview();
                break;
            case 11:
                TaskManager.addNewTask();
                break;
            case 12:
                TaskManager.deleteTask();
                break;
            case 13:
                Links.add();
                break;
            case 14:
                Links.delete();
                break;
            default:
                Ui.printInvalidInputMessage();
            }

            try {
                Storage.saveAllFiles();
            } catch (IOException e) {
                Ui.printFilesCouldNotBeSavedMessage();
            }

            Ui.printReturnToModuleInfoMenuMessage();
        }
    }

    private static void addModuleGrade() {
        if (modules.isEmpty()) {
            System.out.println("You have not added any modules.");
            return;
        }
        viewAllModules();
        System.out.println("Please choose which module you would like to assign a grade"
                + " and enter the number:");
        int moduleNumberInt = Ui.readCommandToInt();
        if (moduleNumberInt >= 1 && moduleNumberInt <= modules.size()) {
            moduleNumberInt--;
            System.out.println("Enter the grade for this module: ");
            String moduleGrade = Ui.readCommand();
            if (ModuleGradeEnum.checkGradeExist(moduleGrade)) {
                modules.get(moduleNumberInt).setGrade(moduleGrade.toUpperCase());
            } else {
                System.out.println("Module grade does not exist. ");
            }
        } else {
            Ui.printInvalidInputMessage();
        }
    }

    private static void addModuleMC() {
        if (modules.isEmpty()) {
            System.out.println("You have not added any modules.");
            return;
        }
        viewAllModules();
        System.out.println(
                "Please choose which module you would like to allocate modular credits (MCs)"
                        + " and enter the number:");
        int moduleNumberInt = Ui.readCommandToInt();
        if (moduleNumberInt >= 1 && moduleNumberInt <= modules.size()) {
            moduleNumberInt--;
            System.out.println("Enter the number of MCs for this module: ");
            int moduleCredits = Ui.readCommandToInt();
            modules.get(moduleNumberInt).setMc(moduleCredits);
        } else {
            Ui.printInvalidInputMessage();
        }
    }

    public static void addNewModule() {
        while (true) {
            System.out.println("Enter name of the new module:");
            String moduleName = Ui.readCommand();
            moduleName = moduleName.trim().toUpperCase();
            if (!Ui.userCommandIsEmpty(moduleName)) {
                if (!isAlphaNumeric(moduleName)) {
                    continue;
                }
                if (checkIfModuleExists(moduleName)) {
                    return;
                }
                System.out.println("Enter module description:");
                String moduleDescription = Ui.readCommand();
                if (!Ui.userCommandIsEmpty(moduleDescription)) {
                    modules.add(new Module(moduleName, moduleDescription));
                    System.out.println("New module added:\n" + moduleName + ":\n" + moduleDescription);
                    Ui.printHorizontalLine();
                    return;
                }
            }

            System.out.println("Module name/description cannot be empty! Please try again.");
        }

    }

    private static boolean checkIfModuleExists(String moduleName) {
        for (Module module : modules) {
            if (module.getName().trim().equalsIgnoreCase(moduleName)) {
                System.out.println("Hey, you have already added this module!");
                return true;
            }
        }
        return false;
    }

    private static boolean isAlphaNumeric(String moduleName) {
        if (!moduleNameIsAlphaNumeric(moduleName)) {
            int yesOrNo = 2;
            while (yesOrNo == 2) {
                System.out.println("Does your module name require "
                        + "non-alphanumeric characters (e.g. @,#,/,-,!) ? [Y/N]");
                yesOrNo = readYN(Ui.readCommand());
                if (yesOrNo == 0) { //if no (non-alphanumeric characters allowed by user)
                    System.out.println("Please enter valid alphanumeric "
                            + "characters for the module name (e.g. CS2113T).");
                    return false;
                }
            }
        }
        return true; //if yes (non-alphanumeric characters allowed by user)
    }

    //Solution below reused from https://www.techiedelight.com/check-string-contains-alphanumeric-characters-java/
    public static boolean moduleNameIsAlphaNumeric(String s) {
        return s != null && s.matches("^[a-zA-Z0-9]*$");
    }
    
    public static void viewAModule() {
        boolean listIsNotEmpty = viewAllModules();
        while (true) {
            if (listIsNotEmpty) {
                System.out.println("Which module would you like to view?");
                int moduleNumberInt = Ui.readCommandToInt();
                boolean isValidModuleNumber = (moduleNumberInt >= 1 && moduleNumberInt <= modules.size());
                if (isValidModuleNumber) {
                    moduleNumberInt--;
                    Module module = modules.get(moduleNumberInt);
                    System.out.println(module.toString()); //name, description, review, MCs, grade are printed
                    printModuleTaskList(module.getName());
                    // add other methods to print other features of a module
                    Ui.printHorizontalLine();
                    break;
                } else {
                    Ui.printInvalidInputMessage();
                }

                Ui.printHorizontalLine();
            }
        }
    }

    public static void printModuleTaskList(String module) {
        int taskNumber = 1;
        boolean taskExists = false;
        System.out.println("\nThese are your tasks: ");
        for (Task task : TaskManager.tasks) {
            if (!task.getModule().equals(module)) {
                continue;
            }
            System.out.println(taskNumber + ". " + task.getTaskType() + task.toString());
            taskNumber++;
            taskExists = true;
        }
        for (Assignment assignment : TaskManager.assignments) {
            if (!assignment.getModule().equals(module)) {
                continue;
            }
            System.out.println(taskNumber + ". " + assignment.getTaskType() + assignment.toString());
            taskNumber++;
            taskExists = true;
        }
        for (Midterm midterm : TaskManager.midterms) {
            if (!midterm.getModule().equals(module)) {
                continue;
            }
            System.out.println(taskNumber + ". " + midterm.getTaskType() + midterm.toString());
            taskNumber++;
            taskExists = true;
        }
        for (FinalExam finalExam : TaskManager.finalExams) {
            if (!finalExam.getModule().equals(module)) {
                continue;
            }
            System.out.println(taskNumber + ". " + finalExam.getTaskType() + finalExam.toString());
            taskNumber++;
            taskExists = true;
        }
        if (!taskExists) {
            System.out.println("No tasks found!");
        }
    }


    public static int readYN(String command) {
        if (command.trim().equalsIgnoreCase("N")) {
            return 0;
        } else if (!command.trim().equalsIgnoreCase("Y")) {
            System.out.println("You did not enter a valid letter:(");
            return 2;
        }
        return 1;
    }

    public static boolean viewAllModules() {
        if (modules.isEmpty()) {
            System.out.println("You have not added any modules.");
            return false;
        }
        System.out.println("Here are the modules in your Modules List:");
        Ui.printHorizontalLine();
        for (int i = 1; i <= modules.size(); ++i) {
            System.out.println("[" + i + "] --- " + modules.get(i - 1).getName());
        }
        Ui.printHorizontalLine();
        return true;
    }

    public static void addReview() {
        if (modules.isEmpty()) {
            System.out.println("You have not added any modules.");
            return;
        }
        viewAllModules();
        while (true) {
            System.out.println("Please choose which module you would like to review"
                    + " and enter the number:");
            int moduleNumberInt = Ui.readCommandToInt();
            moduleNumberInt--;
            boolean isValidInt = checkIfIndexIsWithinBounds(moduleNumberInt);
            if (isValidInt) {
                String review = printAlreadyAddedReviewMessage(modules.get(moduleNumberInt));
                modules.get(moduleNumberInt).setReview(review);
                break;
            } else {
                Ui.printInvalidInputMessage();
            }
        }
    }

    public static String printAlreadyAddedReviewMessage(Module module) {
        if (!module.getReview().equals(EMPTY_REVIEW_MESSAGE)) {
            System.out.println("You already have added a review:");
            System.out.println(module.getReview());
            logger.log(Level.WARNING, "This will delete your old review. This cannot be undone.");
            int yesOrNo = 2;
            while (yesOrNo == 2) {
                System.out.println("Would you like to replace this with another review? [Y/N]");
                System.out.println("This will delete your old review. This cannot be undone.");
                String command = Ui.readCommand();
                yesOrNo = readYN(command);
                if (yesOrNo == 0) {
                    System.out.println("Okay:) You still have the same review!");
                    return module.getReview();
                }
                assert yesOrNo == 1 : "yesOrNo should be 1 here";
            }
        }
        System.out.println("Type '/end' to finish reviewing.");
        System.out.println("Enter your review for " + module.getName() + " below: ");
        return readReview();
    }

    public static String readReview() {
        StringBuilder review = new StringBuilder();
        while (true) {
            String input = Ui.readReviewLine();
            review.append(input);
            review.append("\n");
            if (input.contains("/end")) {
                break;
            }
        }
        //drop everything after "/end"
        String reviewString = review.toString().split("/end")[0];
        if (!reviewString.trim().isEmpty()) {
            printReviewAddedMessage(reviewString.trim());
            return reviewString.trim();
        } else {
            System.out.println("You entered an empty review.");
            return EMPTY_REVIEW_MESSAGE;
        }
    }

    public static void printReviewAddedMessage(String review) {
        System.out.println("Woohoo~ Review added:");
        System.out.println(review);
    }

    public static void viewAllReviews() {
        if (modules.isEmpty()) {
            System.out.println("You have not added any modules.");
            return;
        }
        for (Module module : modules) {
            System.out.println("For " + module.getName() + ":");
            System.out.println(module.getReview());
            Ui.printHorizontalLine();
        }
    }

    public static void deleteModule() {
        if (modules.isEmpty()) {
            System.out.println("You have not added any modules.");
            return;
        }
        viewAllModules();
        while (true) {
            int moduleNumberInt = readModuleNumberToBeDeleted("module");
            boolean isValidInt = checkIfIndexIsWithinBounds(moduleNumberInt);
            if (isValidInt) {
                while (true) {
                    System.out.println("Are you sure you want to delete "
                            + modules.get(moduleNumberInt).getName()
                            + "? [Y/N]");
                    String command = Ui.readCommand();
                    int yesOrNo = readYN(command);
                    if (yesOrNo == 1) {
                        printDeletedModuleMessage(modules.get(moduleNumberInt));
                        deleteTasksforModule(modules.get(moduleNumberInt).getName());
                        testDeleteModule(moduleNumberInt);
                        break;
                    } else if (yesOrNo == 0) {
                        System.out.println("Ok. I did not delete "
                                + modules.get(moduleNumberInt).getName());
                        break;
                    }
                }
                break;
            } else {
                logger.log(Level.INFO, "You did not enter a valid module number to delete.");
                Ui.printInvalidInputMessage();
            }
        }
    }

    public static boolean checkIfIndexIsWithinBounds(int index) {
        return index >= 0 && index < modules.size();
    }

    public static boolean testDeleteModule(int index) {
        modules.remove(index);
        return true;
    }

    public static int readModuleNumberToBeDeleted(String moduleOrReview) {
        if (moduleOrReview.equals("module")) {
            Ui.printSelectModuleToDeleteMessage();
        } else if (moduleOrReview.equals("review")) {
            Ui.printSelectReviewToDeleteMessage();
        }
        int moduleNumberInt = Ui.readCommandToInt();
        moduleNumberInt--;
        return moduleNumberInt;
    }

    public static void printDeletedModuleMessage(Module module) {
        System.out.println("You've deleted this: " + module.getName());
        System.out.println("NOTE: You are deleting your module description\n"
                + module.getDescription());
        if (!module.getReview().trim().equals(EMPTY_REVIEW_MESSAGE)) {
            System.out.println("NOTE: You are deleting your review\n"
                    + module.getReview());
        }
        Ui.printHorizontalLine();
    }

    private static void deleteTasksforModule(String module) {
        for (int i = 0; i < TaskManager.tasks.size(); i++) {
            Task task = TaskManager.tasks.get(i);
            if (task.getModule().equals(module)) {
                Task pinnedTask = task;
                DeleteTask.deleteTask(TASK_TYPE, task);
                DeleteTask.findAndDeletePinnedTask(TASK_TYPE, pinnedTask);
                i--;
            }
        }
        for (int i = 0; i < TaskManager.assignments.size(); i++) {
            Assignment assignment = TaskManager.assignments.get(i);
            if (assignment.getModule().equals(module)) {
                Assignment pinnedTask = assignment;
                DeleteTask.deleteTask(ASSIGNMENT_TYPE, assignment);
                DeleteTask.findAndDeletePinnedTask(ASSIGNMENT_TYPE, pinnedTask);
                i--;
            }
        }
        for (int i = 0; i < TaskManager.midterms.size(); i++) {
            Midterm midterm = TaskManager.midterms.get(i);
            if (midterm.getModule().equals(module)) {
                Midterm pinnedTask = midterm;
                DeleteTask.deleteTask(MIDTERM_TYPE, midterm);
                DeleteTask.findAndDeletePinnedTask(MIDTERM_TYPE, pinnedTask);
                i--;
            }
        }
        for (int i = 0; i < TaskManager.finalExams.size(); i++) {
            FinalExam finalExam = TaskManager.finalExams.get(i);
            if (finalExam.getModule().equals(module)) {
                FinalExam pinnedTask = finalExam;
                DeleteTask.deleteTask(FINAL_EXAM_TYPE, finalExam);
                DeleteTask.findAndDeletePinnedTask(FINAL_EXAM_TYPE, pinnedTask);
                i--;
            }
        }
        // changes the module code attribute of the zoom link object when you delete a module
        ZoomLinkInfo.deleteModuleCode(module);
    }

    private static void getComponents() {
        // prompts user for view or add instruction
        Ui.printModulePrompt();
        int addView = Ui.readCommandToInt();
        if (addView == 1) {
            Component.addComponent(modules);
        } else if (addView == 2) {
            Component.viewComponent(modules);
        } else {
            Ui.printInvalidInputMessage();
        }


    }

    /**
     * This method read in module name and decipher if module exists. If module exists, module
     * description previously added is printed. Else, method prompts user to enter module
     * description and creates a new Module object. This method returns to module information menu.
     */
    private static void getModuleDescriptions() {
        Ui.printModuleNameToModifyPrompt();
        String moduleName = Ui.readCommand(); // read in module name, i.e. CS2113T
        boolean isModuleExist = false;
        for (Module module : modules) {
            if (module.getName().equals(moduleName)) {
                Ui.printModuleExistMessage();
                isModuleExist = true;
                System.out.println(module.getDescription() + "\n");
                //Safety break in cases of more than 1 same module name present.
                //In fact, two same module should not be present.
                break;
            }
        }
        if (!isModuleExist) {
            Ui.printModuleDoesNotExistMessage();
            String userInput;
            userInput = Ui.readCommand(); //read in [Y/N]
            if (userInput.equals("Y")) {
                Ui.printModuleDescriptionPrompt(moduleName);
                String moduleDescription = Ui.readCommand(); //read in description
                Module module = new Module(moduleName, moduleDescription);
                modules.add(module);
                Ui.printModuleDescriptionAddedMessage(moduleName,
                        module.getDescription());
            }
        }

    }

    public static Module getModule(String description) {
        for (Module module : modules) {
            if (module.getName().equals(description)) {
                return module;
            }
        }
        return null;
    }

    public static void deleteReview() {
        if (modules.isEmpty()) {
            System.out.println("You have not added any modules.");
            return;
        }
        viewAllModules();
        while (true) {
            int moduleNumberInt = readModuleNumberToBeDeleted("review");
            boolean isValidInt = checkIfIndexIsWithinBounds(moduleNumberInt);
            if (isValidInt) {
                Module module = modules.get(moduleNumberInt);
                if (module.getReview().equals(EMPTY_REVIEW_MESSAGE)) {
                    System.out.println(EMPTY_REVIEW_MESSAGE);
                    return;
                }
                while (true) {
                    logger.log(Level.WARNING, "You are deleting a review. This cannot be undone.");
                    System.out.println("Are you sure you want to delete this review? [Y/N]\n"
                            + "For " + module.getName() + ":\n"
                            + "Review:\n" + module.getReview());
                    String command = Ui.readCommand();
                    int yesOrNo = readYN(command);
                    if (yesOrNo == 1) {
                        printDeletedReviewMessage(module);
                        modules.get(moduleNumberInt).removeReview();
                        break;
                    } else if (yesOrNo == 0) {
                        System.out.println("Ok. I did not delete this review:\n"
                                + "For " + module.getName() + ":\n"
                                + "Review:\n" + module.getReview());
                        break;
                    }
                }
                break;
            } else {
                logger.log(Level.INFO, "You did not enter a valid module number to delete.");
                Ui.printInvalidInputMessage();
            }
        }
    }

    public static void printDeletedReviewMessage(Module module) {
        System.out.println("For this module: " + module.getName()
                + " -\nYou've deleted this review: " + module.getReview());
        Ui.printHorizontalLine();
    }

}
