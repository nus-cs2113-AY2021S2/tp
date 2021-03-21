package seedu.duke;

import seedu.duke.link.Links;
import seedu.duke.task.TaskList;
import seedu.duke.task.TaskManager;

import java.io.IOException;

public class Duke {

    /**
     * Main entry-point for the java.duke.Duke application.
     *
     * @param args initialise main
     */
    public static void main(String[] args) {
        Ui.printWelcomeMessage();
        runMainMenu();
    }

    public static void runMainMenu() {
        StorageModuleInfo.loadModuleInfoFile();
        TaskList taskList = new TaskList();
        while (true) {
            Ui.printMainMenu();
            String command = Ui.readCommand();
            try {
                int commandInt = Integer.parseInt(command);

                if (commandInt == 5) {
                    try {
                        StorageModuleInfo.modulesFileSaver();
                    } catch (IOException e) {
                        System.out.println("modules.txt file could not be saved:(");
                    }
                    break;
                }

                switch (commandInt) {
                case 1:
                    //moduleInfo
                    ModuleInfo.moduleInfoMenu();
                    break;
                case 2:
                    //helpGraduation
                    HelpGraduationManager.execute();
                    break;
                case 3:
                    //manageTask
                    TaskManager.execute();
                    break;
                case 4:
                    //externalLinks
                    int linkCommandNumber;
                    Ui.printLinksMessage();
                    linkCommandNumber = Ui.readCommandToInt();
                    Links link = new Links(linkCommandNumber);
                    link.execute();
                    break;
                default:
                    Ui.printInvalidIntegerMessage();
                }

            } catch (NumberFormatException n) {
                Ui.printInvalidIntegerMessage();
            }
        }
    }
}
