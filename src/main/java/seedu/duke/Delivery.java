package seedu.duke;

import java.util.ArrayList;

public class Delivery {
    
    private String deliveryID;
    private String address; // todo implement enums?
    private String recipient; // contains name of receipient
    private int weight; // weight of the delivery
    private ArrayList<Item> items;
    private boolean isComplete;

    public Delivery(String deliveryID, String address, String recipient, ArrayList<Item> items) {
        this.deliveryID = deliveryID;
        this.address = address;
        this. recipient = recipient;
        this.items = items;
        this.isComplete = false;
        for (Item item : items) {
            this.weight += item.getItemWeight();
        }
    }

    public String getDeliveryID() {
        return deliveryID;
    }


    public String getAddress() {
        return address;
    }


    public String getRecipient() {
        return recipient;
    }

    public int getWeight() {
        return weight;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setDeliveryAsComplete() {
        this.isComplete = true;
    }

    public String getDeliveryStatusSymbol() {
        if (this.isComplete) {
            return "[Y]";
        }
        else {
            return "[N]";
        }
    }

    /**
     * @return formatted line used in Ui.java methods
     */
    @Override
    public String toString() {
        return this.getDeliveryID() + " "
                + this.getDeliveryStatusSymbol() + " "
                + this.getAddress() + " "
                + this.getRecipient();
    }



}
