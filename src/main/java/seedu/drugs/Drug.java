package seedu.drugs;

public class Drug {
    protected String name;
    protected Double price;
    protected String quantity;

    public Drug(String name, Double price, String quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }

    public String getName() {
        return this.name;
    }

    public Double getPrice() {
        return this.price;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public String stringToSave() {
        return getName() + " | " + getPrice() + " | " + getQuantity();
    }
}
