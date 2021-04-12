package seedu.duke.command;

import seedu.duke.exception.WrongInputFormatException;
import seedu.duke.project.Project;
import seedu.duke.exception.InvalidArgumentException;
import seedu.duke.exception.NoProjectNameException;
import seedu.duke.exception.ProjectNotFoundException;
import seedu.duke.parser.CommandParser;
import seedu.duke.parser.InputParser;
import seedu.duke.project.ProjectManager;
import seedu.duke.resource.ResourceManager;
import seedu.duke.storage.Storage;
import seedu.duke.ui.MainUi;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.logging.Level;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class CommandHandler {
    //@@author jovanhuang
    private static final String ADD_COMMAND = "add";
    private static final String DELETE_COMMAND = "delete";
    private static final String EXIT_COMMAND = "exit";
    private static final String LIST_ALL_COMMAND = "list-all";
    private static final String HELP_COMMAND = "help";
    private static final String LIST_ONE_PROJECT_COMMAND = "list";
    private static final String FIND_COMMAND = "find";
    private static final String EDIT_COMMAND = "edit";
    private static final String SAVE_COMMAND = "save";
    private static final String LOAD_COMMAND = "load";
    public static final String NEW_LINE = "\n";
    public static final String DIVIDER = "--------------------------------------------------------";
    private static Logger logger = null;

    //@@author NgManSing
    String command;
    String[] infoFragments;

    public CommandHandler(InputParser userInput) {
        initializeParameters(userInput);
        initializeLogger();
    }

    //@@Author NgManSing
    private static void initializeLogger() {
        if (logger == null) {
            logger = Logger.getLogger(CommandHandler.class.getName());
            LogManager.getLogManager().reset();
            logger.setLevel(Level.ALL);
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.SEVERE);
            logger.addHandler(consoleHandler);
            try {
                FileHandler fh = new FileHandler("log.txt");
                fh.setLevel(Level.ALL);
                logger.addHandler(fh);
                SimpleFormatter formatter = new SimpleFormatter();
                fh.setFormatter(formatter);
            } catch (SecurityException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void initializeParameters(InputParser userInput) {
        this.command = userInput.getCommand();
        this.infoFragments = userInput.getInfoFragments();
    }

    public String[] getInfoFragments() {
        return infoFragments;
    }

    //@@author NgManSing

    /**
     * Process the command given by the user if it is not null. A boolean value is returned to indicate whether to
     * continue looping, which is based on what command is executed. If command is null, the method returns true.
     *
     * @return Whether to continue looping
     */
    public boolean processCommand() {
        boolean isLoop;
        if (isCommandNull()) {
            promptUserInvalidInput();
            return true;
        }

        isLoop = switchCommand();
        return isLoop;
    }

    //@@author NgManSing
    private boolean switchCommand() {
        boolean isLoop = true;
        switch (this.command) {
        case ADD_COMMAND:
            processInputBeforeAdding();
            break;
        case DELETE_COMMAND:
            processInputBeforeDeleting();
            break;
        case EXIT_COMMAND:
            MainUi.showExitMessage();
            isLoop = false;
            break;
        case LIST_ALL_COMMAND:
            ProjectManager.printResourceListForAllProjects();
            break;
        case LIST_ONE_PROJECT_COMMAND:
            listAProjectResource();
            break;
        case EDIT_COMMAND:
            processInputBeforeEditing();
            break;
        case FIND_COMMAND:
            processInputBeforeFinding();
            break;
        case HELP_COMMAND:
            listAllCommands();
            break;
        case SAVE_COMMAND:
            Storage.updateStorage(ProjectManager.getProjects());
            break;
        case LOAD_COMMAND:
            ProjectManager.setProjects(Storage.readFromStorage());
            break;
        default:
            promptUserInvalidInput();
            break;
        }
        return isLoop;
    }

    //@@author NgManSing
    private boolean isCommandNull() {
        return command == null;
    }

    //@@author jovanhuang

    /**
     * This method calls helper methods to print resources for a project.
     */
    private void listAProjectResource() {
        try {
            ProjectManager.printResourceListForAProject(getInfoFragments());
        } catch (NoProjectNameException e) {
            logger.log(Level.WARNING, "Couldn't detect project name from user inputs.");
            System.out.print(e.getErrorMsg());
        } catch (ProjectNotFoundException e) {
            logger.log(Level.WARNING, "Project couldn't be found.");
            System.out.print(e.getErrorMsg());
        } catch (WrongInputFormatException e) {
            logger.log(Level.WARNING, "Wrong format for commands");
            System.out.print(e.getErrorMsg());
        }
    }

    //@@author NgManSing
    private void processInputBeforeAdding() {
        String[] keywords = {"p/", "url/", "d/", "c/"};
        int firstOptionalKeyword = 2;
        String[] projectInfo;
        try {
            projectInfo = CommandParser.decodeInfoFragments(infoFragments, keywords, firstOptionalKeyword);
            ResourceManager.addResource(projectInfo);
        } catch (InvalidArgumentException e) {
            String errorMsg = "Resource failed to be added. (Reason: " + e.getErrorMsg() + ")";
            logger.log(Level.WARNING, errorMsg);
            printErrorMsg(errorMsg);
        }
    }

    //@@author s-t-e-f

    /**
     * Process user's command for deleting resource(s).
     * Check if all the mandatory keywords are present in the correct order.
     */
    private void processInputBeforeDeleting() {
        String[] keywords = {"p/", "i/"};
        int firstOptionalKeyword = 1;
        String[] projectInfo;
        try {
            projectInfo = CommandParser.decodeInfoFragments(infoFragments, keywords, firstOptionalKeyword);
        } catch (InvalidArgumentException e) {
            printErrorMsg("Resource failed to be deleted. (Reason: " + e.getErrorMsg() + ")");
            return;
        }

        ResourceManager.deleteResource(projectInfo);
    }

    //@@author s-t-e-f

    /**
     * Process user's command for editing a resource.
     * Check if all the mandatory keywords are present in the correct order.
     */
    private void processInputBeforeEditing() {
        String[] keywords = {"p/", "i/", "url/", "d/"};
        int firstOptionalKeyword = 2;
        String[] projectInfo;
        try {
            projectInfo = CommandParser.decodeInfoFragments(infoFragments, keywords, firstOptionalKeyword);
        } catch (InvalidArgumentException e) {
            printErrorMsg("Resource failed to be edited. (Reason: " + e.getErrorMsg() + ")");
            return;
        }
        ResourceManager.editResource(projectInfo);
    }

    //@@author jovanhuang

    /**
     * This method will print divider.
     */
    public static void printDivider() {
        System.out.print(DIVIDER + NEW_LINE);
    }

    //@@author
    public void listAllCommands() {
        MainUi.listAllCommands();
    }

    //@@author yyixue
    private void processInputBeforeFinding() {
        String[] keywords = {"k/", "p/"};
        int firstOptionalKeyword = 1;
        String[] keywordInfo;
        try {
            keywordInfo = CommandParser.decodeInfoFragments(infoFragments, keywords, firstOptionalKeyword);
        } catch (InvalidArgumentException e) {
            printErrorMsg("Resource failed to be found. (Reason: " + e.getErrorMsg() + ")");
            return;
        }

        findResources(keywordInfo);
    }

    //@@author yyixue
    private void findResources(String[] keywordInfo) {
        if (keywordInfo[1] == null) {
            String keyword = keywordInfo[0];
            System.out.print("Here is the list of all project(s) and its resource(s) matching the keyword!" + NEW_LINE);
            printDivider();
            ProjectManager.getAllProjectsAndResourcesMatchingKeyword(keyword);
            printDivider();
        } else {
            String keyword = keywordInfo[0];
            String projectName = keywordInfo[1];
            int projectIndex = ProjectManager.searchExistingProjectIndex(projectName);
            printDivider();
            if (projectIndex != -1) {
                System.out.print("Project: " + projectName + NEW_LINE);
                Project targetProj = ProjectManager.getProjByProjIndex(projectIndex);
                ResourceManager.printResourcesMatchingKeyword(targetProj.getResources(), keyword);
            } else {
                System.out.print("Project cannot be found! Please enter a valid project name!" + NEW_LINE);
            }
            printDivider();
        }
    }

    private void printErrorMsg(String errorMsg) {
        System.out.print("Error: " + errorMsg + "\n");
    }

    private void promptUserInvalidInput() {
        System.out.print("Invalid input! Please type \"help\" for more details." + NEW_LINE);
    }

}
