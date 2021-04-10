package seedu.duke;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class calculating shortest route of uncompleted deliveries for deliveryman.
 */
public class Map {
    public ArrayList<Delivery> shortestPathGenerator(ArrayList<Delivery> uncompletedDeliveries) {
        ArrayList<Delivery> sortedDeliveryList = null;
        sortedDeliveryList = (ArrayList<Delivery>) uncompletedDeliveries.clone();
        assert sortedDeliveryList != null : "List of uncompleted Deliveries not cloned properly";
        Collections.sort(sortedDeliveryList);
        assert sortedDeliveryList != null : "Sorted Delivery List is null";
        return sortedDeliveryList;
    }
}
