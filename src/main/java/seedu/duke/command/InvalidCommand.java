package seedu.duke.command;

import seedu.duke.account.FitCenter;
import seedu.duke.common.Messages;

/**
 * Represents an invalid command whose format is invalid.
 */
public class InvalidCommand extends Command {

    public InvalidCommand(String errorMessage) {
        feedback = errorMessage;
    }

    public InvalidCommand(CommandType commandType) {
        switch (commandType) {
        case ADD:
            feedback = Messages.MESSAGE_INVALID_COMMAND_SYNTAX + Messages.MESSAGE_SYNTAX_ADD_COMMAND;
            break;
        case VIEW:
            feedback = Messages.MESSAGE_INVALID_COMMAND_SYNTAX + Messages.MESSAGE_SYNTAX_VIEW_COMMAND;
            break;
        case DELETE:
            feedback = Messages.MESSAGE_INVALID_COMMAND_SYNTAX + Messages.MESSAGE_SYNTAX_DELETE_COMMAND;
            break;
        case SET:
            feedback = Messages.MESSAGE_INVALID_COMMAND_SYNTAX + Messages.MESSAGE_SYNTAX_SET_COMMAND;
            break;
        case CHECK:
            feedback = Messages.MESSAGE_INVALID_COMMAND_SYNTAX + Messages.MESSAGE_SYNTAX_CHECK_COMMAND;
            break;
        case CANCEL:
            feedback = Messages.MESSAGE_INVALID_COMMAND_SYNTAX + Messages.MESSAGE_SYNTAX_CANCEL_COMMAND;
            break;
        default:
            feedback = Messages.MESSAGE_SYSTEM_ERROR;
        }
    }

    /**
     * Gets the error message for the command.
     *
     * @param fitCenter the fitCenter interface for current user.
     * @return the error messages.
     */
    @Override
    public CommandResult execute(FitCenter fitCenter) {
        return new CommandResult(feedback);
    }
}
