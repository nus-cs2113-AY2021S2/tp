package seedu.duke;

import java.util.ArrayList;

/**
 * Class containing delivery fees and relative distance for unique delivery locations.
 * Information here is connected via left outer join to their respective deliveries.
 *
 * @author Manika Hennedige
 * @version 1.0
 * @since 21-03-2021
 */
public class Route {
    public static ArrayList<Route> routes;
    private final String location;
    private final double deliveryFee;
    private final int distance;

    /**
     * Constructor of Route object.
     *
     * @param location    the address of the Route
     * @param deliveryFee the delivery fee from completing a delivery at this location
     * @param distance    the distance from the deliveryman
     */
    public Route(String location, double deliveryFee, int distance) {
        this.location = location;
        this.deliveryFee = deliveryFee;
        this.distance = distance;
    }

    /**
     * Loads routes from routes.txt file
     */
    public static void loadRoutes() {
        routes = DataManager.loadRoutes();
    }

    /**
     * Method to match a queried location of a delivery with a Route.
     *
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

    /**
     * Method to get location of delivery.
     *
     * @return location/address of the particular route
     */
    public String getLocation() {
        return location;
    }

    /**
     *  Method to get delivery fee paid to the deliveryman.
     *
     * @return delivery fee paid to the deliveryman
     */
    public double getDeliveryFee() {
        return deliveryFee;
    }

    /**
     *  Method to get distance of location from the deliveryman.
     *
     * @return distance of location from the deliveryman
     */
    public int getDistance() {
        return distance;
    }

    /**
     * This method converts a Route object into save format.
     *
     * @return a String containing the format which the Routes are saved in the database
     */
    public String saveFormat() {
        return getLocation()
            + " | "
            + getDeliveryFee()
            + " | "
            + getDistance()
            + " | ";
    }
}
