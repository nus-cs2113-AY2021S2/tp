package seedu.duke;

public class Item {
    private int itemNumber, itemWeight;

    public Item(int itemNumber, int itemWeight) {
        this.itemNumber = itemNumber;
        this.itemWeight = itemWeight;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public int getItemWeight() {
        return itemWeight;
    }
}
