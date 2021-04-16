package seedu.easylog.commands.orderscommands;

import seedu.easylog.exceptions.OrderListAlreadyClearedException;
import seedu.easylog.exceptions.WrongOrdersClearCommandException;
import seedu.easylog.model.ItemManager;
import seedu.easylog.model.Order;
import seedu.easylog.model.OrderManager;

import java.util.ArrayList;

public class OrdersClearCommand extends OrdersCommand {

    /**
     * Clears all orders in the system.
     */
    public void execute(String extraDescription, ItemManager itemManager, OrderManager orderManager) throws
            OrderListAlreadyClearedException, WrongOrdersClearCommandException {
        if (!extraDescription.isEmpty()) {
            throw new WrongOrdersClearCommandException();
        }
        if (orderManager.getSize() == 0) {
            throw new OrderListAlreadyClearedException();
        }

        assert ui != null : "ui should not be null";

        ArrayList<Order> orderList = orderManager.getOrderList();
        int orderListSize = orderList.size();
        OrdersDeleteCommand ordersDeleteCommand = new OrdersDeleteCommand();

        for (int itemIndex = 0; itemIndex < orderListSize; itemIndex++) {
            ordersDeleteCommand.addBackItemsAndRemoveItemSales(itemIndex, itemManager, orderManager);
        }

        orderManager.clearOrderList();
        logging.writeInfoLevelLog("All orders are cleared.");
        ui.showClearedOrderList();
    }
}
