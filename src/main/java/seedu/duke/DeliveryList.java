package seedu.duke;

import java.util.ArrayList;

public class DeliveryList {

    public static ArrayList<Delivery> deliveries = new ArrayList<>();

    /**
     * Constructor to load static list of deliveries from a .txt file
     */
    public static void load() {
        deliveries = DataManager.loadDeliveryList();
    }
}
