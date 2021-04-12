package seedu.duke.command;

import seedu.duke.account.FitCenter;
import seedu.duke.common.Messages;

/**
 * Terminates the application from running.
 */
public class ExitCommand extends Command {
    @Override
    public CommandResult execute(FitCenter fitCenter) {
        return new CommandResult(Messages.MESSAGE_EXIT);
    }

    public static boolean isExitCommand(Command command) {
        return command instanceof ExitCommand;
    }
}
