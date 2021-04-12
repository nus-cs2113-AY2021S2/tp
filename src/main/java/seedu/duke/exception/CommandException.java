package seedu.duke.exception;

/**
 * Represents an error for a {@code Command} or from the {@code CommandHandler}.
 * @see seedu.duke.command.CommandHandler
 */
public class CommandException extends Exception {
    /**
     * @param message should contain relevant information on the failed constraint(s).
     */
    public CommandException(String message) {
        super(message);
    }

    /**
     * @param message should contain relevant information on the failed constraint(s).
     * @param command the name of the {@code Command} that error occurred in.
     */
    public CommandException(String message, String command) {
        this(command + " Command - " + message);
    }
}
