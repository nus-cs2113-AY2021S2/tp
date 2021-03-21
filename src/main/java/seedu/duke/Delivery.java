package seedu.duke;

import java.util.ArrayList;

public class Delivery {
    
    private final String deliveryID;
    private final String address; // todo implement enums?
    private final String recipient; // contains name of receipient
    private int weight; // weight of the delivery
    private double deliveryFee;
    private int distance;
    private final ArrayList<Item> items;
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
        ArrayList<Object> matchedData = Route.getMatchingRouteData(address);
        this.deliveryFee = (double) matchedData.get(0);
        this.distance = (int) matchedData.get(1);
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

    public double getDeliveryFee() {
        return this.deliveryFee;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getDeliveryStatusSymbol() {
        if (this.isComplete) {
            return "[Y]";
        }
        else {
            return "[N]";
        }
    }

    public static void completeDelivery(Deliveryman deliveryman, int deliveryNumber) {
        Delivery delivery = DeliveryList.deliveries.get(deliveryNumber);
        deliveryman.completeDelivery(delivery);
        delivery.setDeliveryAsComplete();
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
