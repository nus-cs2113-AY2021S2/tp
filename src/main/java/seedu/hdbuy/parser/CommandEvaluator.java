package seedu.hdbuy.parser;

import java.util.Arrays;
import java.util.logging.Logger;

import seedu.hdbuy.common.CommandKey;
import seedu.hdbuy.common.exception.InvalidParameterException;

public class CommandEvaluator {

    public static CommandKey extractInfo(String fullLine) throws InvalidParameterException {
        String[] lineParts;
        lineParts = fullLine.split(" ");
        Logger.getLogger("Parser").info(Arrays.toString(lineParts));
        String keyCommand = lineParts[0];
        switch (keyCommand) {
            case CommandType.FILTER:
                if (lineParts.length < 3) {
                    throw new InvalidParameterException(keyCommand);
                } else {
                    String criteria = lineParts[1];
                    String value = String.join(" ", Arrays.asList(lineParts).subList(2, lineParts.length));
                    return new CommandKey(criteria, value, keyCommand);
                }
            case CommandType.REMOVE:
            case CommandType.SAVE:
                if (lineParts.length != 2) {
                    throw new InvalidParameterException(keyCommand);
                } else {
                    String value = lineParts[1];
                    return new CommandKey(keyCommand, value);
                }
            default:
                // any other commands
                if (lineParts.length != 1) {
                    throw new InvalidParameterException(keyCommand);
                }
        }
        return new CommandKey(keyCommand);
    }
}
