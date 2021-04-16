package seedu.easylog.storage;

import seedu.easylog.exceptions.InvalidFileInputException;
import seedu.easylog.model.Item;
import seedu.easylog.model.ItemManager;
import seedu.easylog.model.Order;
import seedu.easylog.model.OrderManager;
import seedu.easylog.parser.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Deals with save files.
 */
public class SaveData extends Storage {

    /**
     * Load save file if any.
     * @param itemManager manipulates item inventory
     * @param orderManager manipulates orders
     * @throws FileNotFoundException when no save file found.
     */
    public void loadFile(ItemManager itemManager, OrderManager orderManager) throws FileNotFoundException {
        ui.showLookingForSaveData();
        File saveData = new File("easyLog.txt");
        logging.writeInfoLevelLog("Looking for existence of save file.");
        if (saveData.exists()) {
            ui.showSaveDataLoading();
            logging.writeInfoLevelLog("Save file exists, beginning to load save file.");
        }
        Scanner s = new Scanner(saveData);
        int fileLine = 1;
        while (s.hasNext()) {
            String fileInput = s.nextLine();
            String[] splitCommandTypeAndArgs = Parser.splitCommandWordAndArgs(fileInput);
            String commandType = splitCommandTypeAndArgs[0];
            String commandArgs = splitCommandTypeAndArgs[1];
            try {
                parser.processFileInput(commandType, commandArgs, itemManager, orderManager);
            } catch (InvalidFileInputException | NumberFormatException | IndexOutOfBoundsException e) {
                logging.writeWarningLevelLog("Error occurred when processing " + fileLine + " in save file.");
                ui.showInvalidFileInputLine(fileLine);
            }
            ++fileLine;
        }
        ui.showSaveDataLoaded();
        logging.writeInfoLevelLog("Save file has been loaded.");
    }

    /**
     * Save data to save file.
     * @param itemManager manipulates item inventory
     * @param orderManager manipulates orders
     * @throws IOException when there is an error during the saving of the file.
     */
    public void saveFile(ItemManager itemManager, OrderManager orderManager) throws IOException {
        File saveData = new File("easyLog.txt");
        if (saveData.createNewFile()) {
            logging.writeInfoLevelLog("Create save file as it currently does not exist.");
            ui.showSaveDataCreated();
        }
        FileWriter fw = new FileWriter("easyLog.txt");
        logging.writeInfoLevelLog("Starting to write inventory, order and other details into save file.");
        for (Item item: itemManager.getItemList()) {
            fw.write("items " + item.saveToFileFormat() + "\n");
        }
        for (Order order: orderManager.getOrderList()) {
            fw.write("orders " + order.saveToFileFormat(itemManager) + "\n");
        }
        fw.write("ReceiptCounter " + Receipt.receiptCounter);
        fw.close();
        logging.writeInfoLevelLog("Saving of details complete.");
        ui.showSaveDataSaved();
    }
}
