package seedu.duke.parser;

import seedu.duke.commands.AddCheatSheetCommand;
import seedu.duke.commands.AddLessonCommand;
import seedu.duke.commands.AddModuleCommand;
import seedu.duke.commands.AddTaskCommand;
import seedu.duke.commands.Command;
import seedu.duke.commands.DeleteCheatSheetCommand;
import seedu.duke.commands.DeleteLessonCommand;
import seedu.duke.commands.DeleteModuleCommand;
import seedu.duke.commands.DeleteTaskCommand;
import seedu.duke.commands.EditCheatSheetCommand;
import seedu.duke.commands.EditLessonCommand;
import seedu.duke.commands.EditTaskCommand;
import seedu.duke.commands.EnterModuleCommand;
import seedu.duke.commands.ExitModuleCommand;
import seedu.duke.commands.ExitProgramCommand;
import seedu.duke.commands.ListCheatSheetsCommand;
import seedu.duke.commands.ListLessonsCommand;
import seedu.duke.commands.ListModulesCommand;
import seedu.duke.commands.ListTasksCommand;
import seedu.duke.commands.MarkAsDoneCommand;
import seedu.duke.commands.MarkAsUndoneCommand;
import seedu.duke.commands.ModuleInfoCommand;
import seedu.duke.commands.OpenLessonLinkCommand;
import seedu.duke.commands.PrintHelpCommand;
import seedu.duke.commands.ViewTeachingStaffCommand;
import seedu.duke.common.DashboardCommands;
import seedu.duke.common.ModuleCommands;
import seedu.duke.exception.ParserException;
import seedu.duke.lesson.Lesson;
import seedu.duke.module.ModuleList;
import seedu.duke.task.Task;

import static seedu.duke.common.Constants.INDEX_COMMAND_ARGS;
import static seedu.duke.common.Constants.INDEX_COMMAND_WORD;
import static seedu.duke.common.Messages.MESSAGE_INVALID_COMMAND;
import static seedu.duke.common.Messages.MESSAGE_UNKNOWN_COMMAND;

public class Parser {

    //@@author ivanchongzhien

    /**
     * Calls the appropriate parser method depending on whether user is at dashboard or has selected
     * a module.
     *
     * @param input full user input string
     * @return command object based on user input
     * @throws ParserException if valid command cannot be parsed from user input
     */
    public Command parse(String input) throws ParserException {
        Command parsedCommand;

        if (ModuleList.hasSelectedModule()) {
            parsedCommand = parseInModule(input);
        } else {
            parsedCommand = parseAtDashboard(input);
        }
        return parsedCommand;
    }

    /**
     * Parses dashboard commands from user input.
     * User is yet to select a module.
     *
     * @param input full user input string
     * @return dashboard command object based on user input
     * @throws ParserException if valid command cannot be parsed from user input
     */
    private Command parseAtDashboard(String input) throws ParserException {
        String[] commandWordAndArgs = ParserUtil.getCommandWordAndArgs(input);
        String commandWord = commandWordAndArgs[INDEX_COMMAND_WORD];
        String commandArgs = commandWordAndArgs[INDEX_COMMAND_ARGS].trim();

        DashboardCommands command = DashboardCommands.getDashboardCommandFromString(commandWord);
        if (command == null) {
            throw new ParserException(MESSAGE_INVALID_COMMAND);
        }

        // commands which require arguments
        switch (command) {
        case ADD:
            String moduleCodeToAdd = ParserUtil.parseModuleCode(commandArgs);
            return new AddModuleCommand(moduleCodeToAdd);
        case OPEN:
            String moduleCodeToOpen = ParserUtil.parseModuleCode(commandArgs);
            return new EnterModuleCommand(moduleCodeToOpen);
        default:
            // Fallthrough
        }
        
        // Commands which do not require arguments
        if (!commandArgs.isEmpty()) {
            throw new ParserException(MESSAGE_UNKNOWN_COMMAND);
        }
        
        switch (command) {
        case HELP:
            return new PrintHelpCommand();
        case EXIT:
            return new ExitProgramCommand();
        case DELETE:
            return new DeleteModuleCommand();
        case MODULES:
            return new ListModulesCommand();
        default:
            throw new ParserException(MESSAGE_UNKNOWN_COMMAND);
        }
        
    }

    /**
     * Parses in-module commands from user input.
     * User has selected a module and is currently in the module.
     *
     * @param input full user input string
     * @return in-module command object based on user input
     * @throws ParserException if valid command cannot be parsed from user input
     */
    private Command parseInModule(String input) throws ParserException {
        String[] commandWordAndArgs = ParserUtil.getModuleCommandWordAndArgs(input);
        String commandWord = commandWordAndArgs[INDEX_COMMAND_WORD];
        String commandArgs = commandWordAndArgs[INDEX_COMMAND_ARGS].trim();

        ModuleCommands command = ModuleCommands.getModuleCommandsFromString(commandWord);
        if (command == null) {
            throw new ParserException(MESSAGE_INVALID_COMMAND);
        }

        switch (command) {
        case ADD_LESSON:
            Lesson lesson = ParserUtil.parseLesson(commandArgs);
            return new AddLessonCommand(lesson);
        case ADD_TASK:
            Task task = ParserUtil.parseTask(commandArgs);
            return new AddTaskCommand(task);
        case ADD_CHEAT_SHEET:
            return new AddCheatSheetCommand(commandArgs);
        case DELETE_CHEAT_SHEET:
            return new DeleteCheatSheetCommand(commandArgs);
        case EDIT_CHEAT_SHEET:
            return new EditCheatSheetCommand(commandArgs);
        default:
            // Fallthrough
        }

        // Commands which do not require arguments
        if (!commandArgs.isEmpty()) {
            throw new ParserException(MESSAGE_UNKNOWN_COMMAND);
        }

        switch (command) {
        case HELP:
            return new PrintHelpCommand();
        case CLOSE:
            return new ExitModuleCommand();
        case INFO:
            return new ModuleInfoCommand();
        case LESSONS:
            return new ListLessonsCommand();
        case LINK:
            return new OpenLessonLinkCommand();
        case TASKS:
            return new ListTasksCommand();
        case MARK:
            return new MarkAsDoneCommand();
        case UNMARK:
            return new MarkAsUndoneCommand();
        case TEACHER:
            return new ViewTeachingStaffCommand();
        case DELETE_LESSON:
            return new DeleteLessonCommand();
        case DELETE_TASK:
            return new DeleteTaskCommand();
        case LIST_CHEAT_SHEET:
            return new ListCheatSheetsCommand();
        case EDIT_TASK:
            return new EditTaskCommand();
        case EDIT_LESSON:
            return new EditLessonCommand();
        default:
            throw new ParserException(MESSAGE_UNKNOWN_COMMAND);
        }
    }
}
