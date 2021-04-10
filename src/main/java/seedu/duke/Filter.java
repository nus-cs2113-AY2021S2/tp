package seedu.duke;

import java.util.ArrayList;

public class Filter {
    public ArrayList<Delivery> uncompletedDeliveriesFilter(ArrayList<Delivery> deliveries) {
        ArrayList<Delivery> uncompletedDeliveries = new ArrayList<>();
        Delivery delivery = null;
        for (int i = 0; i < deliveries.size(); i++) {
            delivery = deliveries.get(i);
            if (!delivery.getIsComplete()) {
                uncompletedDeliveries.add(delivery);
            }
        }
        assert uncompletedDeliveries != null : "List of uncompleted deliveries is null";
        return uncompletedDeliveries;
    }
}
