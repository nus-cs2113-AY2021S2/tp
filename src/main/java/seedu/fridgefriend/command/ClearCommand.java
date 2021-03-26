package seedu.fridgefriend.command;

import seedu.fridgefriend.utilities.LoggingHandler;

/**
 * Clear the fridge.
 * For the purpose of text-ui-text.
 */
public class ClearCommand extends Command {
    @Override
    public void execute() {
        LoggingHandler.logInfo("Re-initializing the fridge...");
        fridge.clearFridge();
    }
}
