package seedu.fridgefriend.command;

import seedu.fridgefriend.utilities.LoggingHandler;
import seedu.fridgefriend.utilities.Storage;
import seedu.fridgefriend.utilities.Ui;

/**
 * Represents a command to read the history data from the history textfile
 * History textfile is stored by default in data/historyData.txt.
 * Food data is automatically added into history textfile
 * after every AddCommand is called.
 * History can also be cleared
 * using command "history clear".
 *
 */
public class HistoryCommand extends Command {

    private final String description;

    public HistoryCommand(String description) {
        LoggingHandler.logInfo("History command initialized with parameter: " + description);
        this.description = description.toLowerCase();
    }

    @Override
    public void execute() {
        if (isClearHistory()) {
            LoggingHandler.logInfo("Proceeding to clear history file.");
            clearHistory();
        } else {
            LoggingHandler.logInfo("Keyword 'clear' not found. Proceeding to print history:");
            printHistory();
        }
    }

    private boolean isClearHistory() {
        return description.contains("clear");
    }

    private void printHistory() {
        String message = getHistoryMessage();
        Ui.printMessage(message);
    }

    public static void clearHistory() {
        Storage.clearHistoryData();
        Ui.printMessage("History successfully cleared!");
    }

    public static String getHistoryMessage() {
        StringBuilder message = new StringBuilder("This is the full history of items you've added in the fridge:");
        message.append(Storage.loadHistoryData());

        assert message != null : "message string should not be null";
        return message.toString();
    }

}
