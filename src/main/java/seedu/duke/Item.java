package seedu.duke;

public class Item {
    private int itemNumber;
    private int itemWeight;

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

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public void setItemWeight(int itemWeight) {
        this.itemWeight = itemWeight;
    }
}
