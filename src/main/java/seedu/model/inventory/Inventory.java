package seedu.model.inventory;

import java.text.DecimalFormat;

/**
 * Inventory class contains the information of a Item in the inventory.
 */
public class Inventory {
    protected String name;
    protected Double price;
    protected int quantity;

    /**
     * Constructor for Inventory object.
     *
     * @param name Item name.
     * @param price Price of Item.
     * @param quantity Quantity of Item.
     */
    public Inventory(String name, Double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }

    /**
     * Increases and updates Quantity of Item.
     *
     * @param input Quantity to increase by.
     */
    public void addQuantity(int input) {
        this.quantity += input;
    }

    /**
     * Decreases and updates Quantity of Item.
     *
     * @param input Quantity to decrease by.
     */
    public void removeQuantity(int input) {
        this.quantity -= input;
    }

    /**
     * Returns name of Inventory object.
     *
     * @return name of Inventory object.
     */
    public String getItemName() {
        return this.name;
    }

    /**
     * Returns double type of the Price.
     *
     * @return double type of Price.
     */
    public Double getDoublePrice() {
        return this.price;
    }

    /**
     * Returns string type of Price.
     *
     * @return string type of Price.
     */
    public String getStringPrice() {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(price);
    }

    /**
     * Returns Quantity of Item.
     *
     * @return Quantity of Item.
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Returns format to be used for saving data in .txt file.
     *
     * @return format to be used for saving data in .txt file.
     */
    public String toSaveFormat() {
        return name + "|" + price
                + "|" + quantity;
    }
}