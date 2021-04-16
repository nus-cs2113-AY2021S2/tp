package seedu.easylog.commands.orderscommands;

import seedu.easylog.common.Constants;
import seedu.easylog.exceptions.EmptyNumberException;
import seedu.easylog.exceptions.InvalidNumberException;
import seedu.easylog.model.OrderManager;

import java.io.IOException;

public class OrdersDoneCommand extends OrdersCommand {

    /**
     * Updating the status of the specific order.
     */
    public void execute(String ordersArg, OrderManager orderManager)
            throws EmptyNumberException, InvalidNumberException {
        if (ordersArg.equals("")) {
            throw new EmptyNumberException();
        }
        int orderIndex = Integer.parseInt(ordersArg) - Constants.ARRAY_OFFSET;
        int size = orderManager.getSize();
        if ((orderIndex < 0) || (orderIndex >= size)) {
            throw new InvalidNumberException();
        }
        ui.showOrderStatus(orderManager.getOrder(orderIndex));
        orderManager.getOrder(orderIndex).markAsDone();
        logging.writeInfoLevelLog("Order has been marked as done.");
        try {
            logging.writeInfoLevelLog("Generating receipt for order marked as done.");
            receipt.generateReceipt(orderIndex, orderManager);
        } catch (IOException e) {
            logging.writeWarningLevelLog("Error occurred while attempting to generate receipt, generating"
                    + " receipt sequence terminated.");
            ui.showErrorGeneratingReceipt(orderManager.getOrder(orderIndex).getCustomerName());
        }
        orderManager.deleteOrder(orderIndex); // delete order once receipt is generated
        logging.writeInfoLevelLog("Order has been deleted as order has been marked as done.");
    }
}
