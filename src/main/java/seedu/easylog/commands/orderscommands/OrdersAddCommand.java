package seedu.easylog.commands.orderscommands;

import seedu.easylog.commands.itemscommands.ItemsListCommand;
import seedu.easylog.common.Constants;
import seedu.easylog.exceptions.CustomerNameTooLongException;
import seedu.easylog.exceptions.EmptyItemListException;
import seedu.easylog.exceptions.EmptyNameException;

import seedu.easylog.exceptions.InvalidInventoryException;
import seedu.easylog.model.Item;
import seedu.easylog.model.ItemManager;
import seedu.easylog.model.Order;
import seedu.easylog.model.OrderManager;

/**
 * Adds orders to the system.
 */
public class OrdersAddCommand extends OrdersCommand {

    public void execute(String customerName, ItemManager itemManager, OrderManager orderManager)
            throws EmptyNameException, EmptyItemListException, CustomerNameTooLongException, InvalidInventoryException {
        if (customerName.equals("")) {
            throw new EmptyNameException();
        }
        if (customerName.length() > Constants.CUSTOMER_NAME_LENGTH_LIMIT) {
            throw new CustomerNameTooLongException();
        }
        if (itemManager.getItemList().isEmpty()) {
            throw new EmptyItemListException();
        }
        int itemWithStockCountZeroCounter = 0;
        for (Item item: itemManager.getItemList()) {
            if (item.getItemStock() == 0) {
                ++itemWithStockCountZeroCounter;
            }
        }
        if (itemWithStockCountZeroCounter == itemManager.getSize()) {
            throw new InvalidInventoryException();
        }

        logging.writeInfoLevelLog("Showing user inventory list.");
        ItemsListCommand itemsListCommand = new ItemsListCommand();
        itemsListCommand.execute(itemManager); // to show available items and item stock
        ui.showAddItemsToOrder();
        logging.writeInfoLevelLog("Asking for user to input item_index and item_quantity into the order.");
        String addItemsToOrderInput = ui.askForUserInput();
        Order order = ordersParser.processItemsAddedToOrder(customerName, addItemsToOrderInput, itemManager);
        orderManager.addOrder(order);
        logging.writeInfoLevelLog("Order details has been added to OrderManager.");
        assert orderManager.getLatestOrderAdded().equals(order);
        ui.showOrderAdded(order);
    }


}