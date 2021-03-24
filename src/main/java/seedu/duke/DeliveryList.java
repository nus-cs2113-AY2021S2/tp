package seedu.duke;

import java.util.ArrayList;

public class DeliveryList {
    private static Deliveryman deliveryman = DataManager.loadProfile();
    private static int combinedWeight = 0;

    public static ArrayList<Delivery> deliveries = new ArrayList<>();

    /**
     * Constructor to load static list of deliveries from a .txt file
     */
    public static void load() {
        deliveries = DataManager.loadDeliveryList();
        calculateCombinedWeight();
        checkWeight();
    }

    public static void calculateCombinedWeight() {
        int weight = 0;
        for (Delivery delivery : deliveries) {
            weight += delivery.getWeight();
        }
        combinedWeight = weight;
    }

    public static void checkWeight() {
        int deliveryManMaxWeight = deliveryman.getMaxWeight();
        while (combinedWeight > deliveryManMaxWeight) {
            deliveries.remove(deliveries.size()-1); // remove the last delivery that causes the weight to exceed
            calculateCombinedWeight();
        }
    }
}
