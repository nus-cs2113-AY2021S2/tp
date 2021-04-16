package seedu.easylog.commands.orderscommands;

import seedu.easylog.common.Constants;
import seedu.easylog.model.Item;
import seedu.easylog.model.ItemManager;
import seedu.easylog.model.Order;
import seedu.easylog.model.OrderManager;

import java.util.ArrayList;

public class OrdersAddFromFileCommand extends OrdersCommand {

    /**
     * Execute the required actions to add file input relating to order into the order manager.
     * @param orderFileInput Item details from file relating to the order.
     * @param itemManager Manipulates inventory.
     * @param orderManager Manipulates orders.
     */
    public void execute(String orderFileInput, ItemManager itemManager, OrderManager orderManager) {
        String[] rawOrderFileInput = orderFileInput.split(" ");
        String customerName = rawOrderFileInput[0];
        logging.writeInfoLevelLog("Adding " + customerName
                + " order details into the system from save file.");
        ArrayList<Item> itemsInOrder = new ArrayList<>();
        ArrayList<Integer> quantifyOfItemsInOrder = new ArrayList<>();
        int sizeOfRawOrderFileInput = rawOrderFileInput.length;
        boolean inputIsItemIndex = true;
        boolean inputIsItemQuantity = false;
        int itemIndex;
        int quantityOfItem;
        for (int i = 1; i < (sizeOfRawOrderFileInput); ++i) {
            if (rawOrderFileInput[i].equals("itemQuantity")) {
                inputIsItemIndex = false;
                inputIsItemQuantity = true;
            } else if (inputIsItemIndex) {
                itemIndex = Integer.parseInt(rawOrderFileInput[i]) - Constants.ARRAY_OFFSET;
                itemsInOrder.add(itemManager.getItem(itemIndex));
            } else if (inputIsItemQuantity) {
                quantityOfItem = Integer.parseInt(rawOrderFileInput[i]);
                quantifyOfItemsInOrder.add(quantityOfItem);
            }
        }
        Order orderToBeAddedFromFile = new Order(customerName, itemsInOrder, quantifyOfItemsInOrder);
        orderManager.addOrder(orderToBeAddedFromFile);
        logging.writeInfoLevelLog("Order details for " + customerName + " has been added to the system from"
                + " the save file");
    }
}
