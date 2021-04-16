package seedu.easylog.commands.orderscommands;

import seedu.easylog.model.OrderManager;

public class OrdersListCommand extends OrdersCommand {

    /**
     * Prints the list of orders.
     */
    public void execute(OrderManager orderManager) {

        String rawOrderListOutput = orderManager.getOrderListPrintFormat(orderManager.getOrderList());
        ui.showOrderList(rawOrderListOutput);
    }
}
