package seedu.duke.command;

import seedu.duke.exception.CommandException;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Utils {
    private static final String ERROR_MISSING_OPTION = "missing option: ";
    private static final String ERROR_INVALID_OPTION = "invalid option: ";
    private static final String ERROR_DUPLICATE_OPTION = "duplicate option: ";
    private static final String REGEX_OPTION = "^-\\w$";

    public static String getOptionValue(ArrayList<String> arguments, String option) throws CommandException {
        if (!hasOption(arguments, option)) {
            throw new CommandException(ERROR_MISSING_OPTION + option);
        }
        int index = arguments.indexOf(option);
        if (index < arguments.size() - 1) {
            return arguments.get(index + 1);
        }
        return null;
    }

    public static boolean hasOption(ArrayList<String> arguments, String option) {
        return arguments.contains(option);
    }

    public static void checkInvalidOptions(ArrayList<String> arguments, String... validOptions)
            throws CommandException {
        Set<String> nonDuplicates = new HashSet<>();
        for (String arg : arguments) {
            if (!isOption(arg)) {
                continue;
            }
            if (!ArrayUtils.contains(validOptions, arg)) {
                throw new CommandException(ERROR_INVALID_OPTION + arg);
            }
            if (!nonDuplicates.add(arg)) {
                throw new CommandException(ERROR_DUPLICATE_OPTION + arg);
            }
        }
    }

    private static void checkDuplicateOptions(ArrayList<String> arguments) throws CommandException {
        Set<String> nonDuplicates = new HashSet<>();
        for (String arg : arguments) {
            if (nonDuplicates.add(arg)) {
                continue;
            }
            if (isOption(arg)) {
                throw new CommandException(ERROR_DUPLICATE_OPTION + arg);
            }
        }
    }

    public static boolean isOption(String arg) {
        return Pattern.matches(REGEX_OPTION, arg);
    }

}
