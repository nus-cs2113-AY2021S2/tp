package seedu.easylog.commands;

import seedu.easylog.model.ItemManager;
import seedu.easylog.model.OrderManager;

import java.io.IOException;

/**
 * Command to exit the program.
 */
public class ExitCommand extends Command {

    public void execute(ItemManager itemManager, OrderManager orderManager) throws IOException {
        try {
            logging.writeInfoLevelLog("Starting save file sequence.");
            saveData.saveFile(itemManager, orderManager);
        } catch (IOException e) {
            logging.writeWarningLevelLog("Error while trying to save data.");
            ui.showErrorWhileSaving();
        }
        ui.showExit();
        logging.writeInfoLevelLog("Exiting app now.");
        System.exit(0);
    }
}
