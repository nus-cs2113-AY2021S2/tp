package seedu.duke;

import java.util.ArrayList;

public class FavouriteLocation {

    private static ArrayList<String> favouriteLocations;

    public FavouriteLocation() {
        this.favouriteLocations = new ArrayList<String>();
    }

    public ArrayList<String> getFavouriteLocations() {
        return favouriteLocations;
    }

    public void addFavouriteLocation(String venue, seedu.duke.Map nusMap) {
        try {
            if (nusMap.getBlock(venue)==null) {
                throw new NullPointerException();
            };
            favouriteLocations.add(venue);
        } catch (NullPointerException e) {
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

    public void showFavouriteLocations() {
        if (favouriteLocations.size() == 0) {
            System.out.println("There are no favourite locations.");
        } else {
            for (int i = 0; i != favouriteLocations.size(); i += 1) {
                System.out.println((i + 1) + ". " + favouriteLocations.get(i));
            }
        }
    }
}
