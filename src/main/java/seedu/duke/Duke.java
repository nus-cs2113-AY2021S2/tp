package seedu.duke;

import seedu.duke.features.capsimulator.HelpGraduationManager;
import seedu.duke.features.link.Links;
import seedu.duke.features.moduleInfo.ModuleInfo;
import seedu.duke.features.task.TaskManager;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

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
        try {
            TaskManager taskManager = new TaskManager();
            Storage.loadAllFiles();
            while (true) {
                Ui.printPinnedTaskList(TaskManager.pinnedTasks);
                Ui.printMainMenu();
                String command = Ui.readCommand();
                try {
                    int commandInt = Integer.parseInt(command);

                    if (commandInt == 5) {
                        try {
                            Storage.saveAllFiles();
                        } catch (IOException e) {
                            Ui.printFilesCouldNotBeSavedMessage();
                        }
                        break;
                    }

                    switch (commandInt) {
                        case 1:
                            // moduleInfo
                            ModuleInfo.moduleInfoMenu();
                            break;
                        case 2:
                            // helpGraduation
                            HelpGraduationManager.execute();
                            break;
                        case 3:
                            // manageTask
                            TaskManager.execute();
                            break;
                        case 4:
                            // externalLinks
                            int linkCommandNumber;
                            Ui.printLinksMessage();
                            linkCommandNumber = Ui.readCommandToInt();
                            Links link = new Links(linkCommandNumber);
                            link.execute();
                            break;
                        default:
                            Ui.printInvalidInputMessage();
                    }

                } catch (NumberFormatException n) {
                    Ui.printInvalidInputMessage();
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("UniTracker Error. Please delete UniTracker Data and restart program.");
        }
    }

}
