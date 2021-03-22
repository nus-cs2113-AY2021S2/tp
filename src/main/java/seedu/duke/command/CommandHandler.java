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
import static seedu.duke.command.CreditScoreCommand.COMMAND_CREDIT_SCORE;

import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

public class CommandHandler {
    private static final String ERROR_INVALID_COMMAND = "Invalid command: ";
    private static final int INDEX_OF_COMMAND = 0;
    private static final Logger LOGGER = Logger.getLogger("CommandLogger");

    public static Command createCommand(ArrayList<String> parsedArguments, RecordList recordList)
            throws CommandException {
        String commandWord = parsedArguments.get(INDEX_OF_COMMAND);

        switch (commandWord) {
        case COMMAND_LIST:
            return new ListCommand(parsedArguments);
        case COMMAND_ADD:
            return new AddCommand(parsedArguments);
        case COMMAND_RETURN:
            return new ReturnCommand(parsedArguments, recordList);
        case COMMAND_REMOVE:
            return new RemoveCommand(parsedArguments, recordList);
        case COMMAND_VIEW:
            return new ViewCommand(parsedArguments);
        case COMMAND_HELP:
            return new HelpCommand(parsedArguments);
        case COMMAND_EXIT:
            return new ExitCommand(parsedArguments);
        case COMMAND_CREDIT_SCORE:
            return new CreditScoreCommand(parsedArguments);
        case "":
            return null;
        default:
            throw new CommandException(ERROR_INVALID_COMMAND + commandWord);
        }
    }

    public static Command parseCommand(ArrayList<String> parsedString, RecordList records) {
        try {
            Command command = CommandHandler.createCommand(parsedString, records);
            //LOGGER.log(Level.INFO, "command object successfully created.");
            return command;
        } catch (CommandException e) {
            System.out.println(e.getMessage());
            //LOGGER.log(Level.WARNING, e.getMessage());
            return null;
        }
    }
}
