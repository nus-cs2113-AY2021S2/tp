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
