package menus;

public class Menu {

    private String itemName;
    private double price;

    public Menu(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    @Override
    public String toString() {
        return itemName + " ($" + String.valueOf(price) + ")";
    }
}
