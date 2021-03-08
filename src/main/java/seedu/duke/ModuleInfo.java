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
    }

    private static void viewAllReviews() {
    }

    private static void addReview() {
    }

    private static void addNewTask() {
        String dateAndTime = "";

        Ui.printAddTaskMenu();
        int taskNumber = TaskList.getTaskNumber();
        Ui.printHorizontalLine();
        Ui.printAddTaskModuleMessage(taskNumber);
        String module = Ui.readCommand();
        Ui.printHorizontalLine();
        Ui.printAddTaskDescriptionMessage(taskNumber);
        String description = Ui.readCommand();
        Ui.printHorizontalLine();
        if (taskNumber != 1) {
            dateAndTime = TaskList.getDate(taskNumber) + ", " + TaskList.getTime(taskNumber);
        }

        switch (taskNumber) {
        case 1:
            TaskList.addTask(module, description);
            break;
        case 2:
            TaskList.addAssignment(module, description, dateAndTime);
            break;
        case 3:
            TaskList.addMidterm(module, description, dateAndTime);
            break;
        case 4:
            TaskList.addFinal(module, description, dateAndTime);
        }

    }

    private static void addZoomLinks() {
    }

    private static void getComponents() {
    }

    private static void getModuleDescriptions() {
    }

}
