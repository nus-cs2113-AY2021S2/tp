package seedu.duke.command;

import seedu.duke.common.ArgumentType;
import seedu.duke.exception.CommandException;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Utils {
    private static final String ERROR_MISSING_OPTION = "missing option: ";
    private static final String ERROR_INVALID_OPTION = "invalid option: ";
    private static final String ERROR_MISSING_OPTION_VALUE = "value of option %s is missing.";
    private static final String ERROR_MISSING_ARGUMENT_VALUE = "missing argument value.";
    private static final String ERROR_DUPLICATE_OPTION = "duplicate option: ";
    private static final String ERROR_CONFLICT_OPTION = "conflict with options: ";
    private static final String ERROR_TOO_MANY_ARGUMENTS = "too many arguments.";
    private static final String ERROR_TOO_FEW_ARGUMENTS = "not enough arguments.";
    private static final String ERROR_INVALID_ORDER = "invalid command order, ";
    private static final String ERROR_INVALID_INPUT = "invalid input: ";
    private static final String REGEX_OPTION = "^-[a-zA-Z]$";

    /**
     * Checks if value is not null and not empty.
     *
     * @param value the String to check.
     * @throws CommandException if {@code value} is null or empty.
     */
    private static void validateNotEmpty(String value) throws CommandException {
        if (value == null || value.length() == 0) {
            throw new CommandException(ERROR_MISSING_ARGUMENT_VALUE);
        }
    }

    /**
     * Checks if value is not null and not empty, and returns it if {@code true}.
     *
     * @param value the String to check.
     * @param command the name of the {@code Command} calling it.
     * @param option the name of the option pertaining to the value.
     * @return the value if not empty
     * @throws CommandException if {@code value} is null or empty.
     */
    private static String validateNotEmpty(String value, String command, String option)
            throws CommandException {
        if (value != null && value.length() > 0) {
            return value;
        }
        String errorMessage = String.format(ERROR_MISSING_OPTION_VALUE, option);
        throw new CommandException(errorMessage, command);
    }

    public static String getOptionValue(ArrayList<String> arguments, String command,
                                        String option) throws CommandException {
        if (!hasOption(arguments, option)) {
            throw new CommandException(ERROR_MISSING_OPTION + option, command);
        }
        int index = arguments.indexOf(option);
        if (index < arguments.size() - 1) {
            String value = arguments.get(index + 1);
            return validateNotEmpty(value, command, option);
        }
        // Throw ERROR_MISSING_OPTION_VALUE error.
        return validateNotEmpty("", command, option);
    }

    public static boolean hasOption(ArrayList<String> arguments, String option) {
        return arguments.contains(option);
    }

    public static void validateOptions(ArrayList<String> arguments, String command,
                                       String[] validOptions, String[] orOptions) throws CommandException {
        checkInvalidOptions(arguments, command, validOptions);
        checkOptionConflict(arguments, command, orOptions);
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

    public static void validateArguments(ArrayList<String> arguments, ArgumentType[] argumentTypeOrder,
                                         String command) throws CommandException {
        if (arguments.size() > argumentTypeOrder.length) {
            throw new CommandException(ERROR_TOO_MANY_ARGUMENTS, command);
        } else if (arguments.size() < argumentTypeOrder.length) {
            throw new CommandException(ERROR_TOO_FEW_ARGUMENTS, command);
        }
        for (int i = 0; i < arguments.size(); i++) {
            validateArgument(arguments.get(i), argumentTypeOrder[i], command);
        }
    }

    private static void validateArgument(String argument, ArgumentType argumentType, String command)
            throws CommandException {
        switch (argumentType) {
        case VALUE:
            validateNotEmpty(argument);
            break;
        case OPTION:
            if (isOption(argument)) {
                break;
            }
            throw new CommandException(ERROR_INVALID_ORDER + "expected an option instead of " + argument,
                    command);
        case COMMAND:
            if (argument.equals(command)) {
                break;
            }
            throw new CommandException(ERROR_INVALID_ORDER + "expected command word.");
        case EMPTY_VALUE:
            // Fallthrough
        default:
            if (argument.length() > 0) {
                throw new CommandException(ERROR_INVALID_INPUT + argument, command);
            }
        }
    }

    public static boolean isOption(String arg) {
        return Pattern.matches(REGEX_OPTION, arg);
    }
}
