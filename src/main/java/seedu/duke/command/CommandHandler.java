package seedu.duke.command;

import seedu.duke.exception.CommandException;

import java.util.ArrayList;

public class CommandHandler {
    private static final String ERROR_INVALID_COMMAND = "invalid command: ";
    private static final String COMMAND_HELP = "help";
    private static final String COMMAND_LIST = "list";
    private static final String COMMAND_ADD = "add";
    private static final String COMMAND_EXIT = "exit";
    private static final String COMMAND_REMOVE = "remove";
    private static final String COMMAND_VIEW = "view";

    public static Command createCommand(ArrayList<String> parsedArguments) throws CommandException {
        String commandWord = parsedArguments.remove(0);

        switch (commandWord) {
        case COMMAND_LIST:
            return new ListCommand(parsedArguments);
        case COMMAND_ADD:
            return new AddCommand(parsedArguments);
        case COMMAND_REMOVE:
            return new RemoveCommand(parsedArguments);
        case COMMAND_VIEW:
            return new ViewCommand(parsedArguments);
        case COMMAND_HELP:
            return new HelpCommand();
        case COMMAND_EXIT:
            return new ExitCommand();
        default:
            throw new CommandException(ERROR_INVALID_COMMAND + commandWord);
        }
    }
}
