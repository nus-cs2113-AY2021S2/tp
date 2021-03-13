package seedu.duke;

import seedu.duke.link.Links;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;
import seedu.duke.task.TaskManager;

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
        while (true) {
            Ui.printMainMenu();
            String command = Ui.readCommand();
            try {
                int commandInt = Integer.parseInt(command);

                if (commandInt == 5) {
                    break;
                }

                switch (commandInt) {
                case 1:
                    //moduleInfo
                    ModuleInfo.moduleInfoMenu();
                    break;
                case 2:
                    //helpGraduation
                    break;
                case 3:
                    //manageTask
                    TaskList taskList = new TaskList();
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
