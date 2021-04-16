package seedu.easylog.model;

import seedu.easylog.common.Constants;
import seedu.easylog.common.Messages;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Manage order list manipulation commands.
 */
public class OrderManager {

    protected ArrayList<Order> orderList;

    protected ArrayList<Order> foundOrderList = new ArrayList<>();

    public OrderManager() {
        this.orderList = new ArrayList<>();
    }

    /**
     * Adds an order to the order list.
     *
     * @param order name of order to be added
     */
    public void addOrder(Order order) {
        orderList.add(order);
    }

    /**
     * Deletes an order from this list of orders.
     *
     * @param index the number of the order to be deleted.
     */
    public void deleteOrder(int index) {
        orderList.remove(index);
    }

    /**
     * Gets the item list under a specific order.
     *
     * @param index the number of this order
     * @return a item list
     */
    public Order getOrder(int index) {
        return orderList.get(index);
    }

    /**
     * Gets the number of orders in the system.
     *
     * @return the size of order list
     */
    public int getSize() {
        return orderList.size();
    }

    /**
     * Gets the list of orders.
     *
     * @return the list of orders
     */
    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    /**
     * Gets the customer's name specified by the index
     * of the order given.
     *
     * @param index index of the order given
     * @return customer's name specified by the index of the order given
     */
    public String getCustomerName(int index) {
        return getOrder(index).getCustomerName();
    }

    /**
     * Gets the customer's items specified by the index
     * of the order given.
     *
     * @param index index of the order given
     * @return customer's items specified by the index of the order given
     */
    public ArrayList<Item> getItemsInOrder(int index) {
        return getOrder(index).getItemsInOrder();
    }

    /**
     * Clears all orders in the system.
     */
    public void clearOrderList() {
        orderList.clear();
    }

    /**
     * Get latest order added to the order list.
     *
     * @return Latest order added to the order list.
     */
    public Order getLatestOrderAdded() {
        int index = getSize() - Constants.ARRAY_OFFSET;
        return getOrder(index);
    }

    /**
     * Prints the order for each order name.
     *
     * @param order the order to be printed
     * @return the print out order of the selected order
     */
    public String getIndividualOrderPrintFormat(Order order) {
        String customersItemList = "";
        int itemAndStockIndex = 0;
        for (Item item : order.getItemsInOrder()) {
            customersItemList += Messages.MESSAGE_INDENTATION + (itemAndStockIndex + 1) + ". "
                    + item.getItemName() + Constants.ITEM_NAME_AND_PRICE_SEPARATOR
                    + item.getItemPrice() + Constants.ITEM_PRICE_AND_STOCK_SEPARATOR
                    + order.getStockCounts().get(itemAndStockIndex) + "\n";
            ++itemAndStockIndex;
        }
        BigDecimal totalPrice = order.getOrderTotalPrice(order.getItemsInOrder());
        return customersItemList + Messages.MESSAGE_INDENTATION + Constants.TOTAL_PRICE_FORMAT
                + totalPrice + "\n" + Messages.MESSAGE_LINE;
    }

    /**
     * Gets the format of the list of orders to be printed.
     *
     * @param orderListToBePrinted list of orders to be printed.
     * @return the formatted order list to be printed by Ui.
     */
    public String getOrderListPrintFormat(ArrayList<Order> orderListToBePrinted) {
        String rawOrderListOutput = "";
        int orderIndex = 1;
        for (Order order : orderListToBePrinted) {
            String customerName = order.getCustomerName();
            String individualOrderOutput = getIndividualOrderPrintFormat(order);
            rawOrderListOutput += orderIndex + "." + customerName + "\n" + individualOrderOutput;
            ++orderIndex;
        }
        return rawOrderListOutput;
    }

    /**
     * Finds relevant orders by customer's name.
     *
     * @param name name to be searched
     */
    public void findOrder(String name) {
        for (int i = 0; i < getSize(); i++) {
            if (getCustomerName(i).contains(name)) {
                foundOrderList.add(getOrder(i));
            }
        }
    }

    public ArrayList<Order> getFoundOrderList() {
        return foundOrderList;
    }

    /**
     * Checks if any relevant orders found.
     *
     * @return the presence of valid order in foundItemList
     */
    public boolean foundOrderEmpty() {
        if (foundOrderList.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Clears the existing orders in foundItemList.
     */
    public void clearFoundList() {
        foundOrderList.clear();
    }

}
