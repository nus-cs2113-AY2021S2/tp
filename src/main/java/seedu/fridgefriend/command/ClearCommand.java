package seedu.fridgefriend.command;

import seedu.fridgefriend.utilities.LoggingHandler;
import seedu.fridgefriend.utilities.Ui;

//@@author Vinci-Hu
/**
 * Clear the fridge.
 * For the purpose of text-ui-text.
 */
public class ClearCommand extends Command {
    @Override
    public void execute() {
        LoggingHandler.logInfo("Re-initializing the fridge...");
        fridge.clearFridge();
        Ui.printMessage("Fridge has been cleared!");
    }
}
