package seedu.easylog.model;

import seedu.easylog.common.Constants;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Handles orders related information.
 */
public class Order {

    protected String customerName;
    protected ArrayList<Item> itemsInOrder;
    protected ArrayList<Integer> itemsStockCount;
    protected boolean isDone;

    /**
     * Order constructor.
     *
     * @param customerName    input String of the name of customers
     * @param itemsInOrder    input ArrayList of the item to be added to order
     * @param itemsStockCount input ArrayList of the number of items to be added to order
     */
    public Order(String customerName, ArrayList<Item> itemsInOrder, ArrayList<Integer> itemsStockCount) {
        this.customerName = customerName;
        this.itemsInOrder = itemsInOrder;
        this.itemsStockCount = itemsStockCount;
        this.isDone = false;
        assert customerName != null;
        assert itemsInOrder != null;
    }

    /**
     * Gets the name of the customer.
     *
     * @return the name of customer
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Gets list of items in the order.
     *
     * @return the list of items in the order
     */
    public ArrayList<Item> getItemsInOrder() {
        return itemsInOrder;
    }

    /**
     * Gets the list of stock count for all items in the order.
     *
     * @return list of stock count for all items in the order.
     */
    public ArrayList<Integer> getStockCounts() {
        return itemsStockCount;
    }

    /**
     * Gets the order added message.
     *
     * @return order added message
     */
    public String getAddOrderMessage() {
        return "Got it! The order for customer [" + customerName + "] is added.";
    }

    /**
     * Gets the order delete message.
     *
     * @return order delete message
     */
    public String getDeleteOrderMessage() {
        return "Got it! The order for customer [" + customerName + "] is deleted.";
    }

    /**
     * Gets the total price of items in order.
     *
     * @param itemsInOrder the list of items in order
     * @return the total price of all items in order
     */
    public BigDecimal getOrderTotalPrice(ArrayList<Item> itemsInOrder) {
        BigDecimal totalPrice = new BigDecimal(0);
        int stockIndex = 0;
        for (Item item : itemsInOrder) {
            totalPrice = totalPrice.add(item.getItemPrice().multiply(new BigDecimal(itemsStockCount.get(stockIndex))));
            ++stockIndex;
        }
        return totalPrice;
    }

    /**
     * Gets the total price in order message.
     *
     * @param order the order to be selected for total price calculation
     * @return the message for the total price of order
     */
    public String getOrderTotalPriceMessage(Order order) {
        return "The total price for customer [" + customerName + "]'s order is S$"
                + order.getOrderTotalPrice(itemsInOrder) + ".";
    }

    /**
     * Gets the status of the order.
     *
     * @return boolean flag of the status of order
     */
    public boolean getStatus() {
        return isDone;
    }

    /**
     * To mark an order as done.
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Gets the status of order message.
     *
     * @return the status of order message
     */
    public String getOrderStatusMessage() {
        return "Got it! The order for customer [" + customerName + "] is completed.";
    }

    /**
     * Convert order attributes to a string to save in save file.
     *
     * @param itemManager manipulates item inventory.
     * @return 1 line string that contains details regarding the order.
     */
    public String saveToFileFormat(ItemManager itemManager) {
        String itemIndexes = "";
        String itemQuantities = "itemQuantity ";
        for (Item item : itemsInOrder) {
            itemIndexes += (itemManager.getItemIndex(item.getItemName()) + Constants.ARRAY_OFFSET) + " ";
        }
        for (int quantity : itemsStockCount) {
            itemQuantities += quantity + " ";
        }
        return customerName + " " + itemIndexes + itemQuantities;
    }
}
