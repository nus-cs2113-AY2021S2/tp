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
    private static final String ERROR_CONFLICT_OPTION = "conflict with options: ";
    private static final String REGEX_OPTION = "^-\\w$";

    public static String getOptionValue(ArrayList<String> arguments, String command,
                                        String option) throws CommandException {
        if (!hasOption(arguments, option)) {
            throw new CommandException(ERROR_MISSING_OPTION + option, command);
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

    public static void checkInvalidOptions(ArrayList<String> arguments, String command,
                                           String... validOptions) throws CommandException {
        Set<String> nonDuplicates = new HashSet<>();
        for (String arg : arguments) {
            if (!isOption(arg)) {
                continue;
            }
            if (!ArrayUtils.contains(validOptions, arg)) {
                throw new CommandException(ERROR_INVALID_OPTION + arg, command);
            }
            if (!nonDuplicates.add(arg)) {
                throw new CommandException(ERROR_DUPLICATE_OPTION + arg, command);
            }
        }
    }

    public static void checkOptionConflict(ArrayList<String> arguments, String command,
                                           String... orOptions) throws CommandException {
        String option = null;
        for (String arg : arguments) {
            if (!isOption(arg)) {
                continue;
            }
            if (!ArrayUtils.contains(orOptions, arg)) {
                continue;
            }
            if (option == null) {
                option = arg;
            } else {
                throw new CommandException(ERROR_CONFLICT_OPTION + option + ", " + arg, command);
            }
        }
    }

    public static boolean isOption(String arg) {
        return Pattern.matches(REGEX_OPTION, arg);
    }
}
