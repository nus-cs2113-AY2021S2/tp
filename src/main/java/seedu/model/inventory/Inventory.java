package seedu.model.inventory;

import java.text.DecimalFormat;

public class Inventory {
    protected String name;
    protected Double price;
    protected int quantity;

    public Inventory(String name, Double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }

    public void addQuantity(int input) {
        this.quantity += input;
    }

    public void removeQuantity(int input) {
        this.quantity -= input;
    }

    public String getDrugName() {
        return this.name;
    }

    public Double getDoublePrice() {
        return this.price;
    }

    public String getStringPrice() {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(price);
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String toSaveFormat() {
        return name + "|" + price
                + "|" + quantity;
    }
}