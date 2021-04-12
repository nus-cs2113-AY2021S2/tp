package seedu.duke.common;

import java.util.ArrayList;

/**
 * Indicates what argument type to expect.
 * {@code ArgumentType} is used mainly for strict order validation of arguments in
 * the {@code ArrayList<String> arguments} during {@code Command} validation.
 *
 * {@code COMMAND} indicates a command word or {@code Command} name.
 * {@code OPTION} indicates an option. E.g. {@code -i}, {@code -a}, etc.
 * {@code VALUE} indicates a non-empty string.
 * {@code EMPTY_VALUE} indicates an empty string, produced by the {@code ParserHandler}.
 *
 * @see seedu.duke.command.Utils#validateArguments(ArrayList, ArgumentType[], String)
 */
public enum ArgumentType {
    COMMAND, OPTION, VALUE, EMPTY_VALUE
}
