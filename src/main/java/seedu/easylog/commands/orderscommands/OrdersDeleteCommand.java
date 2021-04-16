package seedu.easylog.commands.orderscommands;

import seedu.easylog.common.Constants;
import seedu.easylog.exceptions.EmptyOrderIndexException;
import seedu.easylog.exceptions.InvalidOrderIndexException;
import seedu.easylog.exceptions.EmptyOrderListException;

import seedu.easylog.model.ItemManager;
import seedu.easylog.model.OrderManager;
import seedu.easylog.model.Item;

public class OrdersDeleteCommand extends OrdersCommand {

    /**
     * Deletes a single order from the list of orders.
     */
    public void execute(String ordersArg, ItemManager itemManager, OrderManager orderManager)
            throws EmptyOrderIndexException, InvalidOrderIndexException, EmptyOrderListException {
        if (ordersArg.equals("")) {
            throw new EmptyOrderIndexException();
        }
        int ordersListSize = orderManager.getSize();
        if (ordersListSize == 0) {
            throw new EmptyOrderListException();
        }
        try {
            double orderIndexInDouble = Double.parseDouble(ordersArg) - Constants.ARRAY_OFFSET;
            int size = orderManager.getSize();
            if ((orderIndexInDouble < 0) || (orderIndexInDouble >= size)) {
                throw new InvalidOrderIndexException();
            }
            int orderIndex = Integer.parseInt(ordersArg) - Constants.ARRAY_OFFSET;
            addBackItemsAndRemoveItemSales(orderIndex, itemManager, orderManager);
            ui.showOrderDeleted(orderManager.getOrder(orderIndex));
            orderManager.deleteOrder(orderIndex);
        } catch (NumberFormatException e) {
            ui.showNonIntegerOrNonNumericOrderIndex();
        }
    }

    /**
     * Return item stocks to inventory and decrement item sales when unfulfilled order is deleted.
     * @param orderIndex order index of the order to obtain the order details to return the stocks and decrease sales.
     * @param itemManager manipulates inventory.
     * @param orderManager manipulates orders.
     */
    public void addBackItemsAndRemoveItemSales(int orderIndex, ItemManager itemManager, OrderManager orderManager) {
        //@@author e00426142
        if (!orderManager.getOrder(orderIndex).getStatus()) {
            // return item stock to inventory if order is not complete.
            int itemIndex = 0;
            for (Item item : orderManager.getItemsInOrder(orderIndex)) {
                if (itemManager.getItemList().contains(item)) {
                    int itemCurrentStock = item.getItemStock();
                    int itemsStockInOrder = orderManager.getOrder(orderIndex).getStockCounts().get(itemIndex);
                    int itemUpdateStock = itemCurrentStock + itemsStockInOrder;
                    item.setItemStock(itemUpdateStock);
                    //@@author Cocokkkk
                    int itemCurrentSales = item.getItemSales();
                    int itemSalesInOrder = orderManager.getOrder(orderIndex).getStockCounts().get(itemIndex);
                    int itemUpdateSales = itemCurrentSales - itemSalesInOrder;
                    item.setItemSales(itemUpdateSales);
                    ++itemIndex;
                }
            }
        }
    }
}

