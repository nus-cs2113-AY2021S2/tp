package seedu.duke;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class calculating shortest route of uncompleted deliveries for deliveryman
 */
public class Map {
	public ArrayList<Delivery> shortestPathGenerator(ArrayList<Delivery> uncompletedDeliveries){
		ArrayList<Delivery> sortedDeliveryList;
		sortedDeliveryList = (ArrayList<Delivery>) uncompletedDeliveries.clone();
		Collections.sort(sortedDeliveryList);
		return sortedDeliveryList;
	}
}
