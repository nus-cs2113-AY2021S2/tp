package seedu.easylog.model;

import java.math.BigDecimal;

/**
 * Handles Item related information.
 */
public class Item {

    protected String itemName;
    protected BigDecimal itemPrice;
    protected int itemStock;

    /**
     * Item constructor.
     * @param itemName input string of the name of item
     * @param price input string of the price of item
     * @param stock input string of the stock number of item
     */
    public Item(String itemName, BigDecimal price, int stock) {
        this.itemName = itemName;
        this.itemPrice = price;
        this.itemStock = stock;
        assert itemName != null;
    }

    /**
     * Gets the name of the item.
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

    public String getAddItemMessage() {
        return "Got it! The item [" + itemName + "] is added.";
    }

    public String getDeleteItemMessage() {
        return "Got it! The item [" + itemName + "] is deleted.";
    }

    /**
     * Sets the price of an item of interest.
     * @param itemPrice price of the item in BigDecimal.
     */
    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * Sets the stock of an item of interest.
     * @param itemStock amount of stock of the item in integer.
     */
    public void setItemStock(int itemStock) {
        this.itemStock = itemStock;
    }

    /**
     * Convert item attributes to a string to save in save file.
     * @return 1 line string that contains details regarding the item.
     */
    public String saveToFileFormat() {
        return itemName + " " + itemPrice.toPlainString() + " " + itemStock;
    }
}
