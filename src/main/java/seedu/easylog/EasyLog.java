package seedu.easylog;

import seedu.easylog.model.ItemManager;
import seedu.easylog.model.OrderManager;
import seedu.easylog.parser.Parser;
import seedu.easylog.storage.Logging;
import seedu.easylog.storage.SaveData;
import seedu.easylog.ui.Ui;
import java.io.FileNotFoundException;


public class EasyLog {

    private static final Ui UI = new Ui();
    private static final Parser PARSER = new Parser();
    private static final ItemManager ITEM_MANAGER = new ItemManager();
    private static final OrderManager ORDER_MANAGER = new OrderManager();
    private static final SaveData SAVE_DATA = new SaveData();
    private static final Logging LOGGING = new Logging();

    /**
     * Main entry-point for the easyLog application.
     */
    public static void main(String[] args) {
        UI.showGreeting();
        try {
            LOGGING.writeInfoLevelLog("Starting load file sequence.");
            SAVE_DATA.loadFile(ITEM_MANAGER, ORDER_MANAGER);
        } catch (FileNotFoundException e) {
            UI.showNoSaveDataFound();
        }
        LOGGING.setUpLogger();
        try {
            while (true) {
                String userInput = UI.askForUserInput();
                LOGGING.writeInfoLevelLog("Asking for user input.");
                PARSER.processUserInput(userInput, ITEM_MANAGER, ORDER_MANAGER);
                LOGGING.writeInfoLevelLog("User input processed and executed");
            }
        } catch (Exception e) {
            UI.showUnknownErrorOccurred();
            LOGGING.writeInfoLevelLog("Unknown error has occurred.");
        }
    }
}