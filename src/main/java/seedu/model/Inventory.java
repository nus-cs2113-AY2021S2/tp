package seedu.model;

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

    /*public Double getPrice() {
        return this.price;
    }*/

    /*public int getQuantity() {
        return this.quantity;
    }*/

    public String getDrugDetails() {
        return ("Name: " + name + "\n" +
                "Price: $" + price + "\n" +
                "Quantity: " + quantity + "\n");
    }
    public String toSaveFormat() {
        return name + "|" + price + "|" + quantity;
    }
}
