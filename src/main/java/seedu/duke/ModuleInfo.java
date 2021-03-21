package seedu.duke;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModuleInfo {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static ArrayList<Module> modules = new ArrayList<>();

    public ModuleInfo() {
    }

    public static void moduleInfoMenu() {
        while (true) {
            Ui.printModuleInfoMessage();
            String command = Ui.readCommand();
            try {
                int taskNumber = Integer.parseInt(command);
                if (taskNumber == 15) {
                    Ui.printReturnToMainMenuMessage();
                    break; // exit to Main Menu
                }
                switch (taskNumber) {
                case 1:
                    //addNewModule method;
                    break;
                case 2:
                    getModuleDescriptions(); //becomes viewAModule method
                    break;
                case 3:
                    getComponents();
                    break;
                case 4:
                    //addModuleMC method;
                    break;
                case 5:
                    //addModuleGrade method;
                    break;
                case 6:
                    viewAllModules(true);
                    break;
                case 7:
                    //addNewTask method
                    break;
                case 8:
                    //addZoomLink method
                    break;
                case 9:
                    addReview();
                    break;
                case 10:
                    viewAllReviews();
                    break;
                case 11:
                    deleteModule();
                    break;
                case 12:
                    //deleteTask method
                    break;
                case 13:
                    //deleteZoomLink method
                    break;
                case 14:
                    //deleteReview method;
                    break;
                default:
                    Ui.printInvalidIntegerMessage();
                }
            } catch (NumberFormatException n) {
                Ui.printInvalidIntegerMessage();
            }
            try {
                StorageModuleInfo.modulesFileSaver();
            } catch (IOException e) {
                System.out.println("modules.txt file could not be auto-saved:(");
            }

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

    public static boolean viewAllModules(boolean onlyPrinting) {
        if (modules.isEmpty()) {
            logger.log(Level.INFO, "You have not added any modules.");
            Ui.printReturnToModuleInfoMenuMessage();
            return false;
        }
        System.out.println("Here are the modules in your Modules List:");
        Ui.printHorizontalLine();
        for (int i = 1; i <= modules.size(); ++i) {
            System.out.println("[" + i + "] --- " + modules.get(i - 1).getName());
        }
        Ui.printHorizontalLine();
        if (onlyPrinting) {
            Ui.printReturnToModuleInfoMenuMessage();
        }
        return true;
    }

    public static void addReview() {
        if (modules.isEmpty()) {
            logger.log(Level.INFO, "You have not added any modules.");
            Ui.printReturnToModuleInfoMenuMessage();
            return;
        }
        viewAllModules(false);
        System.out.println("Please choose which module you would like to review"
                + " and enter the number:\n");
        int moduleNumberInt = Ui.readCommandToInt();
        if (moduleNumberInt >= 1 && moduleNumberInt <= modules.size()) {
            moduleNumberInt--;
            String review = printAlreadyAddedReviewMessage(modules.get(moduleNumberInt));
            modules.get(moduleNumberInt).setReview(review);
        } else {
            Ui.printInvalidIntegerMessage();
        }
    }

    public static String printAlreadyAddedReviewMessage(Module module) {
        if (!module.getReview().equals("You have not reviewed this module yet.")) {
            System.out.println("You already have added a review:");
            System.out.println(module.getReview());
            System.out.println("Would you like to replace this with another review? [Y/N]");
            logger.log(Level.WARNING, "You will delete your old review. This cannot be undone.");
            String command = Ui.readCommand();
            if (readYN(command) == 0) {
                System.out.println("Okay:) You still have the same review!");
                Ui.printReturnToModuleInfoMenuMessage();
                return module.getReview();
            } else if (readYN(command) == 2) {
                Ui.printReturnToModuleInfoMenuMessage();
                return module.getReview();
            }
            assert readYN(command) == 1 : "readYN(command) should be 1 here";
        }
        System.out.println("After you finish your review, "
                + "type '/end' to finish reviewing.");
        System.out.println("Enter your review for " + module.getName() + " below: ");
        return readReview();
    }

    public static String readReview() {
        StringBuilder review = new StringBuilder();
        while (true) {
            String input = Ui.readCommand();
            review.append(input);
            review.append("\n");
            if (input.contains("/end")) {
                break;
            }
        }
        //drop everything after "/end"
        String reviewString = review.toString().split("/end")[0];

        printReviewAddedMessage(reviewString);
        return reviewString.trim();
    }

    public static void printReviewAddedMessage(String review) {
        System.out.println("Woohoo~ Review added:");
        System.out.println(review);
        Ui.printReturnToModuleInfoMenuMessage();
    }

    public static void viewAllReviews() {
        if (modules.isEmpty()) {
            logger.log(Level.INFO, "You have not added any modules.");
            Ui.printReturnToModuleInfoMenuMessage();
            return;
        }
        Ui.printHorizontalLine();
        for (Module module : modules) {
            System.out.println("For " + module.getName() + ":");
            System.out.println(module.getReview());
            Ui.printHorizontalLine();
        }
        Ui.printReturnToModuleInfoMenuMessage();
    }

    public static void deleteModule() {
        if (modules.isEmpty()) {
            logger.log(Level.INFO, "You have not added any modules.");
            Ui.printReturnToModuleInfoMenuMessage();
            return;
        }
        viewAllModules(false);
        int moduleNumberInt = readModuleNumberToBeDeleted();
        if (moduleNumberInt >= 0 && moduleNumberInt < modules.size()) {
            logger.log(Level.WARNING, "You are making a change that cannot be undone.");
            System.out.println("Are you sure you want to delete "
                    + modules.get(moduleNumberInt).getName()
                    + "? [Y/N]");
            String command = Ui.readCommand();
            if (readYN(command) == 1) {
                printDeletedModuleMessage(modules.get(moduleNumberInt));
                modules.remove(modules.get(moduleNumberInt));
            } else if (readYN(command) == 0) {
                System.out.println("Ok. I did not delete "
                        + modules.get(moduleNumberInt).getName());
            }
        } else {
            logger.log(Level.INFO, "You did not enter a valid integer.");
            Ui.printInvalidIntegerMessage();
        }
        Ui.printReturnToModuleInfoMenuMessage();
    }

    public static int readModuleNumberToBeDeleted() {
        Ui.printSelectModuleToDeleteMessage();
        int moduleNumberInt = Ui.readCommandToInt();
        moduleNumberInt--;
        return moduleNumberInt;
    }

    public static void printDeletedModuleMessage(Module module) {
        System.out.println("You've deleted this: " + module.getName());
        System.out.println("NOTE: You are deleting your module description\n"
                + module.getDescription());
        if (!module.getReview().trim().equals("You have not reviewed this module yet.")) {
            System.out.println("NOTE: You are deleting your review\n"
                    + module.getReview());
        }
        Ui.printHorizontalLine();
    }

    private static void getComponents() {
        Ui.printModulePrompt(); // prompts user for view or add instruction
        String addView = Ui.readCommand().trim();
        if (Integer.parseInt(addView) == 1) {
            Component.addComponent(modules);
        } else if (Integer.parseInt(addView) == 2) {
            Component.viewComponent(modules);
        } else {
            Ui.printReturnToModuleInfoMenuMessage();
        }

    }

    /**
     * This method read in module name and decipher if module exists.
     * If module exists, module description previously added is printed.
     * Else, method prompts user to enter module description and creates a new Module object.
     * This method returns to module information menu.
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
                Ui.printReturnToModuleInfoMenuMessage();
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
                Ui.printReturnToModuleInfoMenuMessage();
            } else if (userInput.equals("N")) {
                Ui.printReturnToModuleInfoMenuMessage();
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

}
