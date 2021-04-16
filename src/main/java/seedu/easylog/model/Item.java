package seedu.easylog.model;

import seedu.easylog.common.Messages;

import java.math.BigDecimal;

/**
 * Handles Item related information.
 */
public class Item {

    protected String itemName;
    protected BigDecimal itemPrice;
    protected int itemStock;
    protected int itemSales;

    /**
     * Item constructor.
     *
     * @param itemName  input string of the name of item
     * @param itemPrice input string of the price of item
     * @param itemStock input string of the stock number of item
     */
    public Item(String itemName, BigDecimal itemPrice, int itemStock) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemStock = itemStock;
        this.itemSales = 0;
        assert itemName != null;
    }

    /**
     * Gets the name of the item.
     *
     * @return the name of the item
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Returns the item price of a particular item.
     *
     * @return item price
     */
    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    /**
     * Returns the item stock of a particular item.
     *
     * @return item stock
     */
    public int getItemStock() {
        return itemStock;
    }

    /**
     * Returns a message to show the item has been added successfully.
     *
     * @return item added message
     */
    public String getAddItemMessage() {
        return "Got it! The item [" + itemName + "] is added.";
    }

    /**
     * Returns a message to show the item has been deleted successfully.
     *
     * @return item deleted message
     */
    public String getDeleteItemMessage() {
        return Messages.MESSAGE_LINE
                + "Got it! The item [" + itemName + "] is deleted.";
    }

    /**
     * Returns a message to show the item price has been updated successfully.
     *
     * @return item price updated message
     */
    public String getUpdatedPriceMessage() {
        return "Done! I just updated the item price ["
                + itemPrice
                + "] for you.\n";
    }

    /**
     * Returns a message to show the item stock has been updated successfully.
     *
     * @return item stock updated message
     */
    public String getUpdatedStockMessage() {
        return "Done! I just updated the item stock ["
                + itemStock
                + "] for you.\n";
    }

    /**
     * Sets the price of an item of interest.
     *
     * @param itemPrice price of the item in BigDecimal.
     */
    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * Sets the stock of an item of interest.
     *
     * @param itemStock amount of stock of the item in integer.
     */
    public void setItemStock(int itemStock) {
        this.itemStock = itemStock;
    }

    /**
     * Sets the total item sales of an item of interest.
     *
     * @param itemSales new number of item sales (number of items added to an order).
     */
    public void setItemSales(int itemSales) {
        this.itemSales = itemSales;
    }

    /**
     * Gets the total item sales of an item of interest.
     *
     * @return item sales
     */
    public int getItemSales() {
        return itemSales;
    }

    /**
     * Convert item attributes to a string to save in save file.
     *
     * @return 1 line string that contains details regarding the item.
     */
    public String saveToFileFormat() {
        return itemPrice.toPlainString() + " " + itemStock + " " + itemSales + " " + itemName;
    }
}
