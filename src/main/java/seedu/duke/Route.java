package seedu.duke;

import java.util.ArrayList;

/**
 * Class containing delivery fees and relative distance for unique delivery locations
 * Information here is connected via left outer join to their respective deliveries
 *
 *
 * @author Manika Hennedige
 * @version 1.0
 * @since 21-03-2021
 */
public class Route {
    private final String location;
    private final double deliveryFee;
    private final int distance;
    public static ArrayList<Route> routes;

    /**
     * @param location the address of the Route
     * @param deliveryFee the delivery fee from completing a delivery at this location
     * @param distance the distance from the deliveryman
     */
    public Route(String location, double deliveryFee, int distance) {
        this.location = location;
        this.deliveryFee = deliveryFee;
        this.distance = distance;
    }

    /**
     * @return location/address of the particular route
     */
    public String getLocation() {
        return location;
    }

    /**
     * @return delivery fee paid to the deliveryman
     */
    public double getDeliveryFee() {
        return deliveryFee;
    }

    /**
     * @return distance of location from the deliveryman
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Loads routes from routes.txt file
     */
    public static void loadRoutes() {
        routes = DataManager.loadRoutes();
    }

    /**
     * Method to match a queried location of a delivery with a Route
     * @param location address of the delivery in question
     * @return an ArrayList containing both the delivery fee as well as the distance
     */
    public static ArrayList<Object> getMatchingRouteData(String location) {
        ArrayList<Object> match = new ArrayList<>();
        for (Route route : routes) {
            if (route.getLocation().equals(location)) {
                match.add(route.getDeliveryFee());
                match.add(route.getDistance());
            }
        }
        return match;
    }
}
