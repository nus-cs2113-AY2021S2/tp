package seedu.easylog.commands.itemscommands;

import seedu.easylog.model.Item;
import seedu.easylog.model.ItemManager;

import java.math.BigDecimal;

public class ItemsAddFromFileCommand extends ItemsCommand {

    /**
     * Execute the required actions to add file input related to item into the inventory.
     * @param itemFileInput Item details from file to be added into the inventory.
     * @param itemManager Manipulates inventory.
     */
    public void execute(String itemFileInput, ItemManager itemManager) {
        String[] rawItemFileInput = itemFileInput.split(" ", 4);
        BigDecimal itemPrice = new BigDecimal(rawItemFileInput[0]);
        int itemStock = Integer.parseInt(rawItemFileInput[1]);
        int itemSales = Integer.parseInt(rawItemFileInput[2]);
        String itemName = rawItemFileInput[3];
        logging.writeInfoLevelLog("Adding " + itemName + " into inventory from save file.");
        Item itemToBeAddedFromFile = new Item(itemName, itemPrice, itemStock);
        itemToBeAddedFromFile.setItemSales(itemSales);
        itemManager.addItem(itemToBeAddedFromFile);
        logging.writeInfoLevelLog(itemName + " has been added into the inventory from save file.");
    }
}
