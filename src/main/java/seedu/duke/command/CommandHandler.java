package seedu.duke.command;

import seedu.duke.exception.InvalidCommandException;

import java.util.ArrayList;

public class CommandHandler {
    private static final int INDEX_COMMAND_TYPE = 0;
    private static final String PREFIX_COST = "-c";
    private static final String PREFIX_DATE = "-d";
    private static final String PREFIX_EXPENSE = "-e";
    private static final String PREFIX_LOAN = "-l";
    private static final String PREFIX_SALARY = "-s";
    private static final String MESSAGE_INVALID_COMMAND = "Invalid command provided!";

    public static Command handle(ArrayList<String> parsedString) throws InvalidCommandException {
        String commandType = parsedString.get(INDEX_COMMAND_TYPE);
        int costIndex = parsedString.indexOf(PREFIX_COST);

        switch (commandType) {
        case ExitCommand.KEY_EXIT:
            return new ExitCommand();
        case AddCommand.KEY_ADD:
            //return new AddCommand(commandType);
        default:
            throw new InvalidCommandException(MESSAGE_INVALID_COMMAND);
        }
    }
}