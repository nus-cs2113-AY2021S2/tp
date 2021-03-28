package seedu.duke;

import java.util.ArrayList;

public class FavouriteLocation {

    public ArrayList<String> favouriteLocations;

    public FavouriteLocation() {
        this.favouriteLocations = new ArrayList<String>();
    }

    public ArrayList<String> getFavouriteLocations() {
        return favouriteLocations;
    }

    public void addFavouriteLocation(String venue, seedu.duke.Map nusMap) {
        try {
            if (nusMap.getBlock(venue) == null) {
                throw new NullPointerException();
            }
            favouriteLocations.add(venue);
            System.out.println("Favourite location has been added!");
        } catch (NullPointerException e) {
            System.out.println("Invalid venue!");
        }
    }

    public void removeFavouriteLocation(int index) {
        try {
            favouriteLocations.remove(index);
            System.out.println("Favourite location has been removed.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        }
    }
}
