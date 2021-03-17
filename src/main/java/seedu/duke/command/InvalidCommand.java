package seedu.duke.command;

import seedu.duke.common.Messages;
import seedu.duke.ui.UI;

public class InvalidCommand extends Command {
    private String feedback;

    public InvalidCommand(String errorMessage) {
        feedback = errorMessage;
    }

    public InvalidCommand(CommandType commandType) {
        switch (commandType) {
        case ADD:
            feedback = Messages.MESSAGE_INVALID_COMMAND_SYNTAX + Messages.MESSAGE_INVALID_ADD_COMMAND;
            break;
        case VIEW:
            feedback = Messages.MESSAGE_INVALID_COMMAND_SYNTAX + Messages.MESSAGE_INVALID_VIEW_COMMAND;
            break;
        default:
            UI.printMessage(Messages.MESSAGE_SYSTEM_ERROR);
        }
        UI.printMessage(feedback);
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(feedback);
    }
}
