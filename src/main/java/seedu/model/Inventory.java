package seedu.model;

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

    public String getDrugName() {
        return this.name;
    }

    public String getPrice() {
        DecimalFormat df = new DecimalFormat("0.00");
        //price = Math.round(price*100.0)/100.0;
        //return String.valueOf(price);
        return df.format(price);
    }

    public int getQuantity() {
        return this.quantity;
    }
    public String getDrugDetails() {
        return ("Name: " + name + "\n" +
                "Price: $" + price + "\n" +
                "Quantity: " + quantity + "\n");
    }
    public String toSaveFormat() {
        return name + "|" + price + "|" + quantity;
    }
}
