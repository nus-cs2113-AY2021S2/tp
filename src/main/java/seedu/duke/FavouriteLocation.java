package seedu.duke;

import java.util.ArrayList;
import java.util.Map;

public class FavouriteLocation {

    private static ArrayList<String> favouriteLocations;

    public FavouriteLocation() {
        this.favouriteLocations = new ArrayList<String>();
    }

    public ArrayList<String> getFavouriteLocations() {
        return favouriteLocations;
    }

    public void addFavouriteLocation(String venue, Map nusMap) {
        if (nusMap.containsKey(venue)) {
            favouriteLocations.add(venue);
        } else {
            System.out.println("Invalid venue!");
        }
    }

    public void removeFavouriteLocation(int index) {
        try {
            favouriteLocations.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        }
    }
}
