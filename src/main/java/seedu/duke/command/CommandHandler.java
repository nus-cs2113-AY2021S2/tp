package seedu.duke.command;


import seedu.duke.exception.InvalidCommandException;
import seedu.duke.exception.CommandException;

import static seedu.duke.command.ListCommand.COMMAND_LIST;
import static seedu.duke.command.AddCommand.COMMAND_ADD;
import static seedu.duke.command.RemoveCommand.COMMAND_REMOVE;
import static seedu.duke.command.ViewCommand.COMMAND_VIEW;
import static seedu.duke.command.HelpCommand.COMMAND_HELP;
import static seedu.duke.command.ExitCommand.COMMAND_EXIT;

import java.util.ArrayList;

public class CommandHandler {
    private static final String ERROR_INVALID_COMMAND = "Invalid command: ";

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
