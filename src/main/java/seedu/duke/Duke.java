package seedu.duke;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import seedu.duke.capsimulator.HelpGraduationManager;
import seedu.duke.link.Links;
import seedu.duke.task.TaskManager;

import java.io.IOException;

public class Duke {

    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * Main entry-point for the java.duke.Duke application.
     *
     * @param args initialise main
     */
    public static void main(String[] args) {
        initialiseLogger();
        Ui.printWelcomeMessage();
        runMainMenu();
    }

    public static void runMainMenu() {
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
    }

    public static void initialiseLogger() {
        LogManager.getLogManager().reset();
        logger.setLevel(Level.ALL);
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.SEVERE);
        logger.addHandler(ch);

        try {
            FileHandler fh = new FileHandler("logging.txt");
            fh.setLevel(Level.FINE);
            logger.addHandler(fh);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Logging has failed", e);
        }
    }
}
