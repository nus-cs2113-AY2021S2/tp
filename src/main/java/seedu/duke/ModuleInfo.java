package seedu.duke;

import java.util.ArrayList;

public class ModuleInfo {
    public ModuleInfo() {
    }

    public static ArrayList<Module> modules = new ArrayList<>();

    public static void moduleInfoMenu() {

        while (true) {
            Ui.printModuleInfoMessage();
            String command = Ui.readCommand();
            try {
                int taskNumber = Integer.parseInt(command);
                if (taskNumber == 7) {
                    Ui.printReturnToMainMenuMessage();
                    break; // exit to Main Menu
                }
                switch (taskNumber) {
                case 1:
                    getModuleDescriptions();
                    break;
                case 2:
                    getComponents();
                    break;
                case 3:
                    viewAllModules();
                    break;
                case 4:
                    addReview();
                    break;
                case 5:
                    viewAllReviews();
                    break;
                case 6:
                    deleteModule();
                    break;
                default:
                    Ui.printInvalidIntegerMessage();
                }
            } catch (NumberFormatException n) {
                Ui.printInvalidIntegerMessage();
            }
        }
    }

    private static void deleteModule() {
        Ui.readModuleNumberToBeDeleted(modules);
    }

    public static void viewAllReviews() {
        Ui.printAllReviews(modules);
        Ui.printReturnToModuleInfoMenuMessage();
    }

    public static void addReview() {
        Ui.printReviewMenu(modules);
    }

    public static void viewAllModules() {
        Ui.printAllModulesIfNotEmpty(modules);
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
                Module module = new Module(moduleName, moduleDescription, "");
                modules.add(module);
                Ui.printModuleDescriptionAddedMessage(moduleName,
                        module.getDescription());
                Ui.printReturnToModuleInfoMenuMessage();
            } else if (userInput.equals("N")) {
                Ui.printReturnToModuleInfoMenuMessage();
            }
        }

    }

}
