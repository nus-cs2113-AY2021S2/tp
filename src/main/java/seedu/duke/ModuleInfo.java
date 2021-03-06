package seedu.duke;

import java.util.Scanner;

public class ModuleInfo {
    public ModuleInfo() {
    }

    public static void moduleInfoMenu() {
        Scanner input = new Scanner(System.in);
        while (true) {
            String command = input.nextLine();
            try {
                int taskNumber = Integer.parseInt(command);
                if (taskNumber == 1) {
                    break;
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
                case 9:
                    break;
                default:
                    System.out.println("Please enter a valid integer from the list.");
                }
            } catch (NumberFormatException n) {
                System.out.println("Error! Enter an integer.");
            }
        }

    }

    private static void deleteTask() {
    }

    private static void deleteModule() {
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
