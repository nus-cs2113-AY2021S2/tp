package seedu.duke;

import java.util.ArrayList;

public class Route {
    private final String location;
    private final double deliveryFee;
    private final int distance;
    public static ArrayList<Route> routes;

    public Route(String location, double deliveryFee, int distance) {
        this.location = location;
        this.deliveryFee = deliveryFee;
        this.distance = distance;
    }

    public String getLocation() {
        return location;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public int getDistance() {
        return distance;
    }

    public static void loadRoutes() {
        routes = DataManager.loadRoutes();
    }

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
