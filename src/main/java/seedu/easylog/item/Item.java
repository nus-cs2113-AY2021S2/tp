package seedu.easylog.item;

/**
 * Handles Item related information.
 */
public class Item {

    protected String itemName;
    protected String itemPrice;

    public Item(String itemName, String price) {
        this.itemName = itemName;
        this.itemPrice = price;
        assert itemName != null;
    }

    public String getItemName() {
        return itemName;
    }

    /**
     * Returns the item price of a particular item.
     *
     * @return item price
     */
    public String getItemPrice() {
        return itemPrice;
    }

    public String getAddItemMessage() {
        return "Got it! The item [" + itemName + "] is added.";
    }

    public String getDeleteItemMessage() {
        return "Got it! The item [" + itemName + "] is deleted.";
    }

    /**
     * Sets item price.
     */
    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }
}
