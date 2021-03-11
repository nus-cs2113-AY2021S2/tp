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
        Ui.printDeleteTaskMenu();
        int taskTypeNumber = TaskList.getTaskNumber();
        Ui.printHorizontalLine();

        TaskList.deleteTask(taskTypeNumber);
    }

    private static void deleteModule() {
        Ui.printSelectModuleToDeleteMessage();
        String moduleNumberString = Ui.readCommand();
        try {
            checkValidModuleToDelete(moduleNumberString);
        } catch (NumberFormatException | IndexOutOfBoundsException n) {
            Ui.printInvalidIntegerMessage();
        }
    }

    public static void checkValidModuleToDelete(String moduleNumberString)
            throws NumberFormatException, IndexOutOfBoundsException {
        int moduleNumberInteger = Integer.parseInt(moduleNumberString);
        Ui.printDeletedModuleMessage(modules.get(moduleNumberInteger));
        modules.remove(modules.get(moduleNumberInteger));
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
        Ui.printAddMessageAfterCompletedTask();
        String message = Ui.readCommand();


        switch (taskNumber) {
        case 1:
            TaskList.addTask(module, description, message);
            break;
        case 2:
            TaskList.addAssignment(module, description, message, dateAndTime);
            break;
        case 3:
            TaskList.addMidterm(module, description, message, dateAndTime);
            break;
        case 4:
            TaskList.addFinal(module, description, message, dateAndTime);
            break;
        default:
            Ui.printInvalidIntegerMessage();
        }
    }

    private static void addZoomLinks() {
    }

    private static void getComponents() {
    }

    private static void getModuleDescriptions() {
    }

}
