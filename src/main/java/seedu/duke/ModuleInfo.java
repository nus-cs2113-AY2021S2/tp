package seedu.duke;

import java.util.ArrayList;
import java.util.Scanner;

public class ModuleInfo {
    public ModuleInfo() {
    }

    public static ArrayList<Module> modules = new ArrayList<>();

    public static void moduleInfoMenu() {
        Scanner input = new Scanner(System.in);
        while (true) {
            String command = input.nextLine();
            Ui.printModuleInfoMessage();
            try {
                int taskNumber = Integer.parseInt(command);
                if (taskNumber == 9) {
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
                    addZoomLinks();
                    break;
                case 4:
                    addNewTask();
                    break;
                case 5:
                    addReview();
                    break;
                case 6:
                    viewAllReviews();
                    break;
                case 7:
                    deleteModule();
                    break;
                case 8:
                    deleteTask();
                    break;
                default:
                    Ui.printInvalidIntegerMessage();
                }
            } catch (NumberFormatException n) {
                Ui.printInvalidIntegerMessage();
            }
        }

    }

    private static void deleteTask() {
    }

    private static void deleteModule() {
        System.out.println("Enter the module number to be deleted:");
        Scanner input = new Scanner(System.in);
        try {
            String moduleNumberString = input.nextLine();
            int moduleNumberInteger = Integer.parseInt(moduleNumberString);
            modules.remove(modules.get(moduleNumberInteger));
        } catch (NumberFormatException n) {
            Ui.printInvalidIntegerMessage();
        }
    }

    private static void viewAllReviews() {
    }

    private static void addReview() {
    }

    private static void addNewTask() {
    }

    private static void addZoomLinks() {
    }

    private static void getComponents() {
    }

    private static void getModuleDescriptions() {
    }

}
