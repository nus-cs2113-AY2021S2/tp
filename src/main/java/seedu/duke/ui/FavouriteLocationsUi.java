package seedu.duke.ui;

import seedu.duke.FavouriteLocation;

public class FavouriteLocationsUi extends Ui {

    public FavouriteLocationsUi() {
    }

    public static void addFavouriteLocations(FavouriteLocation favouriteLocation,
                                             String location, seedu.duke.Map nusMap) {
        if (favouriteLocation.getFavouriteLocations().contains(location)) {
            System.out.println("This location is already in favourites.");
        } else {
            favouriteLocation.addFavouriteLocation(location, nusMap);
        }
    }

    public void showFavouriteLocations(FavouriteLocation favouriteLocation) {
        if (favouriteLocation.getFavouriteLocations().size() == 0) {
            System.out.println("There are no favourite locations.");
        } else {
            for (int i = 0; i != favouriteLocation.getFavouriteLocations().size(); i += 1) {
                System.out.println((i + 1) + ". " + favouriteLocation.getFavouriteLocations().get(i));
            }
        }
    }

    public void deleteFavouriteLocation(FavouriteLocation favouriteLocation, int index) {
        favouriteLocation.removeFavouriteLocation(index);
    }
}
