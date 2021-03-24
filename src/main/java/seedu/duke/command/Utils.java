package seedu.duke.command;

import org.apache.commons.lang3.StringUtils;
import seedu.duke.common.ArgumentType;
import seedu.duke.exception.CommandException;

import org.apache.commons.lang3.ArrayUtils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Provides common validation methods for {@code Command} validation.
 */
public class Utils {
    private static final String ERROR_MISSING_OPTION = "missing option: ";
    private static final String ERROR_INVALID_OPTION = "invalid option: ";
    private static final String ERROR_MISSING_OPTION_VALUE = "value of option %s is missing.";
    private static final String ERROR_MISSING_ARGUMENT_VALUE = "missing argument value.";
    private static final String ERROR_MISSING_VALUE = "missing value after command.";
    private static final String ERROR_DUPLICATE_OPTION = "duplicate option: ";
    private static final String ERROR_CONFLICT_OPTION = "conflict with options: ";
    private static final String ERROR_TOO_MANY_ARGUMENTS = "too many arguments.";
    private static final String ERROR_TOO_FEW_ARGUMENTS = "not enough arguments.";
    private static final String ERROR_INVALID_ORDER = "invalid command order, ";
    private static final String ERROR_INVALID_INPUT = "invalid input: ";
    private static final String REGEX_OPTION = "^-[a-zA-Z]$";
    private static final String ERROR_WRONG_HELP_TYPE = "invalid help type: ";
    private static final int VALUE_INDEX = 1;
    private static final long MAX_CREDIT_SCORE = 100;
    private static final long MIN_CREDIT_SCORE = 0;
    private static final long RETURN_REWARD_FIRST_WEEK = 5;
    private static final long RETURN_PENALTY_SECOND_WEEK = -10;
    private static final long RETURN_PENALTY_FORTH_WEEK = -20;
    private static final long RETURN_PENALTY_FORTH_WEEK_ONWARDS = -50;
    private static final long FIRST_WEEK = 7;
    private static final long SECOND_WEEK = 14;
    private static final long FORTH_WEEK = 28;

    /**
     * Checks {@code value} to see if it is not {@code null} and not empty.
     *
     * @param value        the String to check.
     * @param errorMessage the exception message to print.
     * @throws CommandException if {@code value} is {@code null} or empty.
     */
    private static void validateNotEmpty(String value, String errorMessage) throws CommandException {
        if (value == null || value.length() == 0) {
            throw new CommandException(errorMessage);
        }
    }

    /**
     * Checks {@code value} to see if it is not {@code null} and not empty,
     * and returns it if {@code true}.
     *
     * @param value   the {@code String} to check.
     * @param command the name of the {@code Command} calling it.
     * @param option  the name of the {@code option} pertaining to the {@code value}.
     * @return the {@code value} if not empty
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

    /**
     * Extracts the {@code option}'s {@code value} from {@code arguments} {@code ArrayList}.<br>
     * Example: {@code ["return", "-i", "2"], option = "-i", value = "2"}.<br>
     *
     * @param arguments an {@code ArrayList} containing {@code Command} arguments.
     * @param command   the name of the {@code Command} calling it.
     * @param option    the name of the {@code option} pertaining to the {@code value}.
     * @return the {@code option}'s {@code value}
     * @throws CommandException if {@code option} does not exist, or {@code value} is missing or empty.
     * @see #validateNotEmpty(String, String, String)
     */
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
        // Below return results in an ERROR_MISSING_OPTION_VALUE exception thrown.
        return validateNotEmpty("", command, option);
    }

    /**
     * Gets the value of the second argument from {@code arguments}.
     *
     * @param arguments an {@code ArrayList} containing {@code Command} arguments.
     * @param command   the name of the {@code Command} calling it.
     * @return the non-empty value.
     * @throws CommandException if value is missing or empty.
     */
    public static String getValue(ArrayList<String> arguments, String command)
            throws CommandException {
        assert arguments != null : "arguments is null!";
        boolean isValuable = (arguments.size() > VALUE_INDEX)
                && (arguments.get(VALUE_INDEX).length() != 0);
        if (isValuable) {
            return arguments.get(VALUE_INDEX);
        }
        throw new CommandException(ERROR_MISSING_VALUE, command);
    }

    // This hasOption method is only meant to improve readability.
    public static boolean hasOption(ArrayList<String> arguments, String option) {
        assert arguments != null : "arguments is null!";
        return arguments.contains(option);
    }

    /**
     * Checks {@code arguments} for invalid, duplicate and conflict options.
     *
     * @param arguments    an {@code ArrayList} containing {@code Command} arguments.
     * @param command      the name of the {@code Command} calling it.
     * @param validOptions a {@code String} array containing valid options pertaining to {@code command}.
     * @param orOptions    a {@code String} array containing conflict options pertaining to {@code command}.
     * @throws CommandException if {@code arguments} contains invalid/duplicate options and conflict options.
     * @see #checkInvalidOptions(ArrayList, String, String...)
     * @see #checkOptionConflict(ArrayList, String, String...)
     */
    public static void validateOptions(ArrayList<String> arguments, String command,
                                       String[] validOptions, String[] orOptions) throws CommandException {
        assert arguments != null : "arguments is null!";
        checkInvalidOptions(arguments, command, validOptions);
        checkOptionConflict(arguments, command, orOptions);
    }

    /**
     * Checks {@code arguments} for invalid/duplicate options.
     *
     * @param arguments    an {@code ArrayList} containing {@code Command} arguments.
     * @param command      the name of the {@code Command} calling it.
     * @param validOptions valid options pertaining to {@code command}.
     * @throws CommandException if {@code arguments} contains an invalid or a duplicate option.
     */
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

    /**
     * Checks {@code arguments} for conflict options.
     *
     * @param arguments an {@code ArrayList} containing {@code Command} arguments.
     * @param command   the name of the {@code Command} calling it.
     * @param orOptions conflict options pertaining to {@code command}.
     * @throws CommandException if {@code arguments} contains a conflict option.
     */
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

    /**
     * Checks the {@code Command}'s {@code arguments} ordering based on the {@code argumentTypeOrder}.<br>
     * Recommended for {@code Command}s with strict argument order.<br>
     * This method should be used only when:<br>
     * <ul>
     *     <li>{@link #validateOptions(ArrayList, String, String[], String[])} has been called, or</li>
     *     <li>{@code Command} does not require option validation.</li>
     * </ul>
     *
     * @param arguments         an {@code ArrayList} containing {@code Command} arguments.
     * @param argumentTypeOrder an Enumeration array of type {@code ArgumentType} containing the argument
     *                          type order.
     * @param command           the name of the {@code Command} calling it.
     * @throws CommandException if there is a violation to the argument type order.
     * @see ArgumentType
     * @see #validateArgument(String, ArgumentType, String)
     */
    public static void validateArguments(ArrayList<String> arguments, ArgumentType[] argumentTypeOrder,
                                         String command) throws CommandException {
        assert arguments != null : "arguments is null!";
        assert argumentTypeOrder != null : "argumentTypeOrder is null!";
        if (arguments.size() > argumentTypeOrder.length) {
            throw new CommandException(ERROR_TOO_MANY_ARGUMENTS, command);
        } else if (arguments.size() < argumentTypeOrder.length) {
            throw new CommandException(ERROR_TOO_FEW_ARGUMENTS, command);
        }
        for (int i = 0; i < arguments.size(); i++) {
            validateArgument(arguments.get(i), argumentTypeOrder[i], command);
        }
    }

    /**
     * Checks {@code argument}'s type matches {@code argumentType}.
     *
     * @param argument     a portion of the {@code Command}'s arguments.
     * @param argumentType an Enumeration of ArgumentType to match with.
     * @param command      the name of the {@code Command} calling it.
     * @throws CommandException if {@code argument}'s type does not match {@code argumentType}.
     * @see ArgumentType
     */
    private static void validateArgument(String argument, ArgumentType argumentType, String command)
            throws CommandException {
        switch (argumentType) {
        case VALUE:
            validateNotEmpty(argument, ERROR_MISSING_ARGUMENT_VALUE);
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

    protected static String validateHelpType(ArrayList<String> argument, String command)
            throws CommandException {
        String helpType = argument.get(1);
        if (StringUtils.equalsAny(helpType, "all", "add", "creditscore", "exit",
            "list", "remove", "return", "view")) {
            return helpType;
        } else {
            throw new CommandException(ERROR_WRONG_HELP_TYPE + helpType, command);
        }
    }

    /**
     * Checks if {@code argument} is an option.<br>
     * An option can be in the form {@code "-L"}, where {@code L} is a letter of any case.
     *
     * @param argument a {@code String} to be checked.
     * @return {@code true} if {@code argument} matches the {@link #REGEX_OPTION} {@code Pattern}.
     */
    public static boolean isOption(String argument) {
        assert argument != null : "argument is null!";
        return Pattern.matches(REGEX_OPTION, argument);
    }

    // NOTE: To be committed by Jason
    public static long getDaysDifference(LocalDate issueDate, LocalDate returnDate) {
        return 10;
    }

    public static int computeCreditScore(long daysDifference, int currentCreditScore, boolean isReturn) {
        long computedCreditScore = currentCreditScore;
        if (daysDifference < FIRST_WEEK) {
            if (isReturn) {
                computedCreditScore += RETURN_REWARD_FIRST_WEEK;
            }
        } else if (daysDifference <= SECOND_WEEK) {
            computedCreditScore += RETURN_PENALTY_SECOND_WEEK;
        } else if (daysDifference <= FORTH_WEEK) {
            computedCreditScore += RETURN_PENALTY_FORTH_WEEK;
        } else {
            computedCreditScore += RETURN_PENALTY_FORTH_WEEK_ONWARDS;
        }

        if (computedCreditScore > MAX_CREDIT_SCORE) {
            computedCreditScore = MAX_CREDIT_SCORE;
        } else if (computedCreditScore < MIN_CREDIT_SCORE) {
            computedCreditScore = MIN_CREDIT_SCORE;
        }
        return (int) computedCreditScore;
    }
}
