package seedu.duke.command;

import seedu.duke.exception.CommandException;
import seedu.duke.record.RecordList;

import static seedu.duke.command.ListCommand.COMMAND_LIST;
import static seedu.duke.command.AddCommand.COMMAND_ADD;
import static seedu.duke.command.ReturnCommand.COMMAND_RETURN;
import static seedu.duke.command.RemoveCommand.COMMAND_REMOVE;
import static seedu.duke.command.ViewCommand.COMMAND_VIEW;
import static seedu.duke.command.HelpCommand.COMMAND_HELP;
import static seedu.duke.command.ExitCommand.COMMAND_EXIT;

import java.util.ArrayList;

public class CommandHandler {
    private static final String ERROR_INVALID_COMMAND = "Invalid command: ";
    private static final int INDEX_OF_COMMAND = 0;

    public static Command createCommand(ArrayList<String> parsedArguments, RecordList records) throws CommandException {
        String commandWord = parsedArguments.get(INDEX_OF_COMMAND);

        switch (commandWord) {
        case COMMAND_LIST:
            return new ListCommand(parsedArguments);
        case COMMAND_ADD:
            return new AddCommand(parsedArguments);
        case COMMAND_RETURN:
            return new ReturnCommand(parsedArguments, records);
        case COMMAND_REMOVE:
            return new RemoveCommand(parsedArguments, records);
        case COMMAND_VIEW:
            return new ViewCommand(parsedArguments);
        case COMMAND_HELP:
            return new HelpCommand(parsedArguments);
        case COMMAND_EXIT:
            return new ExitCommand(parsedArguments);
        default:
            throw new CommandException(ERROR_INVALID_COMMAND + commandWord);
        }
    }

    public static Command parseCommand(ArrayList<String> parsedString, RecordList records) {
        try {
            return CommandHandler.createCommand(parsedString, records);
        } catch (CommandException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
