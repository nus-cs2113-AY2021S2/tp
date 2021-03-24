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
}
