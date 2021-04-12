package seedu.duke.command;

import org.apache.commons.lang3.StringUtils;
import seedu.duke.common.ArgumentType;
import seedu.duke.exception.CommandException;

import org.apache.commons.lang3.ArrayUtils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import static seedu.duke.common.Constant.MAX_CREDIT_SCORE;
import static seedu.duke.common.Constant.MIN_CREDIT_SCORE;

/**
 * Provides common validation methods for {@code Command} validation.
 */
public class Utils {
    private static final String[] HELP_TYPES = {
        AddCommand.COMMAND_ADD, CreditScoreCommand.COMMAND_CREDIT_SCORE,
        ExitCommand.COMMAND_EXIT, ListCommand.COMMAND_LIST, RemoveCommand.COMMAND_REMOVE,
        ReturnCommand.COMMAND_RETURN, ViewCommand.COMMAND_VIEW, "all"
    };
    private static final String ERROR_MISSING_OPTION = "missing option: ";
    private static final String ERROR_INVALID_OPTION = "invalid option: ";
    private static final String ERROR_MISSING_OPTION_VALUE = "value of option %s is missing.";
    private static final String ERROR_MISSING_ARGUMENT_VALUE = "missing argument value.";
    private static final String ERROR_MISSING_VALUE = "missing value after command.";
    private static final String ERROR_DUPLICATE_OPTION = "duplicate option: ";
    private static final String ERROR_CONFLICT_OPTION = "conflict with options: ";
    private static final String ERROR_TOO_MANY_ARGUMENTS = "too many arguments.";
    private static final String ERROR_TOO_FEW_ARGUMENTS = "not enough arguments.";
    private static final String ERROR_EXPECTED_A_VALUE = "expected a value, not an option.";
    private static final String ERROR_INVALID_ORDER = "invalid command order, ";
    private static final String ERROR_INVALID_ORDER_OPTION = ERROR_INVALID_ORDER
            + "expected an option instead of ";
    private static final String ERROR_INVALID_ORDER_COMMAND = ERROR_INVALID_ORDER
            + "expected command word.";
    private static final String ERROR_INVALID_INPUT = "invalid input: ";
    private static final String REGEX_OPTION = "^-[a-zA-Z]$";
    private static final String ERROR_WRONG_HELP_TYPE = "invalid help type: ";
    private static final int VALUE_INDEX = 1;
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
     * @param value   the String to check.
     * @param command the name of the {@code Command} calling it.
     * @throws CommandException if {@code value} is {@code null} or empty.
     */
    private static void validateNotEmpty(String value, String command) throws CommandException {
        if (value == null || value.length() == 0) {
            throw new CommandException(ERROR_MISSING_ARGUMENT_VALUE, command);
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
        if (!isValuable) {
            throw new CommandException(ERROR_MISSING_VALUE, command);
        }
        String value = arguments.get(VALUE_INDEX);
        if (isOption(value)) {
            throw new CommandException(ERROR_EXPECTED_A_VALUE, command);
        }
        return arguments.get(VALUE_INDEX);
    }

    public static void validateNoOptions(ArrayList<String> arguments, String command)
            throws CommandException {
        assert arguments != null : "arguments is null!";
        for (String arg : arguments) {
            if (isOption(arg)) {
                throw new CommandException(ERROR_EXPECTED_A_VALUE, command);
            }
        }
    }

    // This hasOption method is only meant to improve readability.
    /**
     * Checks if the {@code arguments} contains the {@code option}.
     *
     * @param arguments an {@code ArrayList} containing {@code Command} arguments.
     * @param option    the option String to find in {@code arguments}.
     * @return {@code true}  if {@code arguments} contains the {@code option}, false otherwise.
     */
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
    private static void checkInvalidOptions(ArrayList<String> arguments, String command,
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
    private static void checkOptionConflict(ArrayList<String> arguments, String command,
                                            String... orOptions) throws CommandException {
        String option = null;
        for (String arg : arguments) {
            if (!isOption(arg)) {
                continue;
            }
            if (!ArrayUtils.contains(orOptions, arg)) {
                continue;
            }
            if (option != null) {
                throw new CommandException(ERROR_CONFLICT_OPTION + option + ", " + arg, command);
            }
            option = arg;
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
        assert argumentType != null : "argumentType is null!";
        switch (argumentType) {
        case VALUE:
            validateNotEmpty(argument, command);
            break;
        case OPTION:
            if (!isOption(argument)) {
                throw new CommandException(ERROR_INVALID_ORDER_OPTION + argument, command);
            }
            break;
        case COMMAND:
            if (!argument.equals(command)) {
                throw new CommandException(ERROR_INVALID_ORDER_COMMAND, command);
            }
            break;
        case EMPTY_VALUE:
            // Fallthrough
        default:
            if (argument.length() > 0) {
                throw new CommandException(ERROR_INVALID_INPUT + argument, command);
            }
        }
    }

    /**
     * Checks and returns a valid {@code helpType} in the {@code HelpCommand arguments}.
     *
     * @param arguments an {@code ArrayList} containing {@code Command} arguments.
     * @param command   the name of the {@code Command} calling it.
     * @return the {@code helpType} String.
     * @throws CommandException if {@code helpType} is invalid.
     */
    protected static String validateHelpType(ArrayList<String> arguments, String command)
            throws CommandException {
        assert arguments != null : "argument is null!";
        String helpType = getValue(arguments, command);
        if (!StringUtils.equalsAny(helpType, HELP_TYPES)) {
            throw new CommandException(ERROR_WRONG_HELP_TYPE + helpType, command);
        }
        return helpType;
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

    /**
     * Computes the difference in days between two {@code LocalDate} objects.
     *
     * @param issueDate the date of issue.
     * @param returnDate the date of return.
     * @return the day difference.
     */
    public static long getDaysDifference(LocalDate issueDate, LocalDate returnDate) {
        LocalDate toDate;
        if (returnDate == null) {
            toDate = LocalDate.now();
        } else {
            toDate = returnDate;
        }
        return ChronoUnit.DAYS.between(issueDate, toDate);
    }

    /**
     * Computes the new credit score based on the {code daysDifference}, {code currentCreditScore}
     * and whether the loan was returned in the first week.
     *
     * @param daysDifference the day difference from the loan's issue and return.
     * @param currentCreditScore the current credit score of a borrower.
     * @param isReturn a check if current loan is returned.
     * @return the new credit score.
     */
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
