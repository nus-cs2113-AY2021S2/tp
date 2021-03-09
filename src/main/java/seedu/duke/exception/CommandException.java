package seedu.duke.exception;

public class CommandException extends Exception {
    public CommandException(String message) {
        super(message);
    }

    public CommandException(String message, String command) {
        this(command + " Command - " + message);
    }
}
